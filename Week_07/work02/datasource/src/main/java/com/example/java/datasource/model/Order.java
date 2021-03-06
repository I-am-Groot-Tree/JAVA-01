package work02.datasource.src.main.java.com.example.java.datasource.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Long id;

    private String user_id;

    private String order_no;

    private Byte order_status;

    private Integer product_count;

    private BigDecimal product_price;

    private String pay_channel;

    private String pay_no;

    private BigDecimal total_amount;

    private String address;

    private Date create_time;

    private Date update_time;

    private Byte is_deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no == null ? null : order_no.trim();
    }

    public Byte getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Byte order_status) {
        this.order_status = order_status;
    }

    public Integer getProduct_count() {
        return product_count;
    }

    public void setProduct_count(Integer product_count) {
        this.product_count = product_count;
    }

    public BigDecimal getProduct_price() {
        return product_price;
    }

    public void setProduct_price(BigDecimal product_price) {
        this.product_price = product_price;
    }

    public String getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel) {
        this.pay_channel = pay_channel == null ? null : pay_channel.trim();
    }

    public String getPay_no() {
        return pay_no;
    }

    public void setPay_no(String pay_no) {
        this.pay_no = pay_no == null ? null : pay_no.trim();
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Byte getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Byte is_deleted) {
        this.is_deleted = is_deleted;
    }
}