package homework01.datasource.src.main.java.com.example.java.datasource.service;

import com.example.java.datasource.mapper.OrderMapper;
import com.example.java.datasource.model.Order;
import com.example.java.datasource.model.OrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper mapper;

    public int insertSelective(Order order) {
        return mapper.insertSelective(order);
    }

    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public Order selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int updateSelective(Order order) {
        OrderExample example = new OrderExample();
        example.createCriteria().andIdEqualTo(order.getId());

        return mapper.updateByExampleSelective(order,example);
    }

    public Order getById(Long id) {
        //  有些读操作必须读主数据库
        //  比如，获取微信access_token，因为高峰时期主从同步可能延迟
        //  这种情况下就必须强制从主数据读
        return mapper.selectByPrimaryKey(id);
    }
}