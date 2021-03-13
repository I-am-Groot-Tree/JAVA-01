package homework01.datasource.src.test.java.com.example.java.datasource;

import com.example.java.datasource.model.Order;
import com.example.java.datasource.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SplitApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void testInsert() {
        Order order = new Order();
        order.setUserId("123123");
        orderService.insertSelective(order);
    }

    @Test
    void testUpdate() {
        Order order = new Order();
        order.setUserId("3333");
        orderService.updateSelective(order);
        log.info(order.getUserId());
    }

    @Test
    void testSelect() {
        Order order = orderService.selectByPrimaryKey(1L);
        log.info(order.getUserId());
    }

    @Test
    void testDelete() {
        orderService.deleteById(1L);
    }
}
