import java.util.concurrent.ExecutionException;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */
public class Homework03_while {

    public volatile int result = 0;

    public static void main(String[] args) {

        Homework03_while homework03 = new Homework03_while();

        Thread t = new Thread(homework03::sum);

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        t.start();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + homework03.get());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    private Integer get() {
        while (true) {
            if (result != 0) {
                return result;
            }
        }
    }

    private void sum() {
        result = fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
