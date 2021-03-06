package work01;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JdbcUtil {

    // 定义数据库的链接
    private static Connection conn;

    // 定义sql语句的执行对象
    private static PreparedStatement pstmt;

    // 定义查询返回的结果集合
    private static ResultSet rs;

    /**
     *
     * @Title:  获取数据库连接
     * @Description:
     *
     * @author: FLY
     * @date:2017年9月27日 下午5:11:01
     */
    public static void getConnection() {
        try {
            Driver driver  =  new com.mysql.cj.jdbc.Driver();

            String url = "jdbc:mysql://localhost:3306/amsdb?useSSL=false&serverTimezone=UTC";
            Properties info = new Properties();
            info.setProperty("user","root");
            info.setProperty("password","123456");
            conn = driver.connect(url, info);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static boolean executeBatch(String sql, Object... objs) {
        int n = 0;
        try {
            getConnection();
            // 那么对于每一条insert语句，都会产生一条log写入磁盘
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                pstmt.setObject(i + 1, objs[i]);

                // 1w条记录插入一次
                if (i % 10000 == 0){
                    pstmt.executeBatch();
                    conn.commit();
                }
            }


            // 最后插入不足1w条的数据
            int[] executeBatch = pstmt.executeBatch();
            conn.commit();
            //更新条数
            n= executeBatch.length;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }
        return n > 0 ? true : false;
    }


    /**
     * 执行数据库插入操作
     *
     * @param datas     插入数据表中key为列名和value为列对应的值的Map对象的List集合
     * @param tableName 要插入的数据库的表名
     * @return 影响的行数
     * @throws SQLException SQL异常
     */
    public static int executeBatchInsert(String tableName, List<Map<String, Object>> datas) throws SQLException {

        long startTime=System.currentTimeMillis();//记录开始时间
        /**影响的行数**/
        int affectRowCount = -1;
        try {
            /**从数据库连接池中获取数据库连接**/
            getConnection();
            /**设置不自动提交，以便于在出现异常的时候数据库回滚**/
            conn.setAutoCommit(false);
            Map<String, Object> valueMap = datas.get(0);
            /**获取数据库插入的Map的键值对的值**/
            Set<String> keySet = valueMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            /**要插入的字段sql，其实就是用key拼起来的**/
            StringBuilder columnSql = new StringBuilder();
            /**要插入的字段值，其实就是？**/
            StringBuilder unknownMarkSql = new StringBuilder();
            Object[] keys = new Object[valueMap.size()];
            // 要执行到数据库的SQL
            String sqlStr = "";
            int i = 0;
            while (iterator.hasNext()) {
                String key = iterator.next();
                keys[i] = key;
                columnSql.append(i == 0 ? "" : ",");
                columnSql.append(key);

                unknownMarkSql.append(i == 0 ? "" : ",");
                unknownMarkSql.append("?");
                i++;
            }
            /**开始拼插入的sql语句**/
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO ");
            sql.append(tableName);
            sql.append(" (");
            sql.append(columnSql);
            sql.append(" )  VALUES ");
            /*sql.append(" )  VALUES (");
            sql.append(unknownMarkSql);
            sql.append(" )");*/


            // jdbcLog.info("【批量插入】,数据表：" + tableName+" ,SQL："+sql.toString());
            // StringBuffer sql = new StringBuffer();
            int dataCount = datas.size();
            for (int j = 0; j < dataCount; j++) {
                for (int k = 0; k < keys.length; k++) {
                    // pstmt.setObject(k + 1, datas.get(j).get(keys[k]));
                   /*sql.append(" (");
                    sql.append(datas.get(j).get(keys[k]));*/

                    if(k == 0){
                        sql.append(" (");
                        sql.append("'").append(datas.get(j).get(keys[k])).append("'");
                        sql.append(" ,");
                    }else if(k == keys.length-1){
                        sql.append("'").append(datas.get(j).get(keys[k])).append("'");
                        sql.append(" ),");
                    }else{
                        sql.append("'").append(datas.get(j).get(keys[k])).append("'");
                        sql.append(" ,");
                    }
                }


                // 每1000个提交一次
                if ((j != 0 && j % 1000 == 0) || j == dataCount - 1) {

                    sqlStr = sql.substring(0, sql.length() - 1);
                    // jdbcLog.info("【批量插入】,数据表：" + tableName+" ,最终SQL："+sqlStr);

                    /**执行SQL预编译**/
                    pstmt = conn.prepareStatement("");
                    pstmt.addBatch(sqlStr);
                }


            }
            int[] arr = pstmt.executeBatch();
            conn.commit();
            long endTime=System.currentTimeMillis();//记录结束时间
            float excTime=(float)(endTime-startTime)/1000;
            affectRowCount = arr.length;

        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
            // throw e;
        } finally {
            close(conn, pstmt, rs);
        }
        return affectRowCount;
    }

    /**
     * 执行数据库插入操作
     *
     * @param datas     插入数据表中key为列名和value为列对应的值的Map对象的List集合
     * @param tableName 要插入的数据库的表名
     * @return 影响的行数
     * @throws SQLException SQL异常
     */
    public static int batchInsert(String tableName, List<Map<String, Object>> datas) throws SQLException {

        /**影响的行数**/
        int affectRowCount = -1;
        try {
            /**从数据库连接池中获取数据库连接**/
            getConnection();
            conn.setAutoCommit(false);
            Map<String, Object> valueMap = datas.get(0);
            /**获取数据库插入的Map的键值对的值**/
            Set<String> keySet = valueMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            /**要插入的字段sql，其实就是用key拼起来的**/
            StringBuilder columnSql = new StringBuilder();
            /**要插入的字段值，其实就是？**/
            StringBuilder unknownMarkSql = new StringBuilder();
            Object[] keys = new Object[valueMap.size()];
            int i = 0;
            while (iterator.hasNext()) {
                String key = iterator.next();
                keys[i] = key;
                columnSql.append(i == 0 ? "" : ",");
                columnSql.append(key);

                unknownMarkSql.append(i == 0 ? "" : ",");
                unknownMarkSql.append("?");
                i++;
            }
            /**开始拼插入的sql语句**/
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO ");
            sql.append(tableName);
            sql.append(" (");
            sql.append(columnSql);
            sql.append(" )  VALUES (");
            sql.append(unknownMarkSql);
            sql.append(" )");

            /**执行SQL预编译**/
            pstmt = conn.prepareStatement(sql.toString());
            /**设置不自动提交，以便于在出现异常的时候数据库回滚**/
            // conn.setAutoCommit(false);
            for (int j = 0; j < datas.size(); j++) {
                for (int k = 0; k < keys.length; k++) {
                    pstmt.setObject(k + 1, datas.get(j).get(keys[k]));
                }
                pstmt.addBatch();
            }
            int[] arr = pstmt.executeBatch();

            conn.commit();
            affectRowCount = arr.length;
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                conn.rollback();
            }
            // throw e;
        } finally {
            close(conn, pstmt, rs);
        }
        return affectRowCount;
    }

    /**
     *
     * @Title: 查询
     * @param sql
     * @param objs
     * @return int
     * @Description:
     *
     * @author: FLY
     * @date:2017年9月27日 下午4:44:57
     */
    public static int queryForInt(String sql, Object... objs) {
        try {
            getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                pstmt.setObject(i + 1, objs[i]);
            }
            rs = pstmt.executeQuery();
            if (rs.next())
                return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }
        return 0;
    }
    /**
     *
     * @Title: 释放数据库连接
     * @param conn
     * @param stmt
     * @param rs void
     * @Description:
     *
     * @author: FLY
     * @date:2017年9月27日 下午4:44:31
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void testInsert1() {
        PreparedStatement ps = null;
        try {

            long start = System.currentTimeMillis();

            getConnection();

            // 设置不允许自动提交数据
            conn.setAutoCommit(false);

            String sql = "insert into amsdb.order(user_id) values(?)";
            ps = conn.prepareStatement(sql);

            for(int i = 1 ; i <= 1000000 ; i++) { // 花费的时间为:23058
                ps.setString(1, "1");

                //1. "攒" sql
                ps.addBatch();

                if(i % 10000 == 0) {

                    //2.  攒够10000,执行一次batch
                    ps.executeBatch();

                    //3. 清空batch
                    ps.clearBatch();

                }
            }

            // 提交数据 (统一将所有数据都进行提交)
            conn.commit();

            long end = System.currentTimeMillis();

            System.out.println("花费的时间为:" + (end - start));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }

    }
}