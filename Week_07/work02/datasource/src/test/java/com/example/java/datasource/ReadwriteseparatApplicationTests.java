package work02.datasource.src.test.java.com.example.java.datasource;

import com.example.java.datasource.model.Order;
import com.example.java.datasource.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Slf4j
public class ReadwriteseparatApplicationTests {

    @Autowired
    private OrderService orderService;

    /**
     * 写库进行写入
     */
    @Test
    public void testWrite() {
        Order order = new Order();
        order.setUser_id("123123");
        orderService.insertSelective(order);
    }

    /**
     * 读库（otadb1和otadb2随机）进行读取
     */
    @Test
    public void testRead() {
        Order order = orderService.selectByPrimaryKey(1L);
        log.info(order.getUser_id());
    }
}
