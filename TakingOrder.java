public class TakingOrder {

    private final int orderId;
    private final String customerName;
    private final Product product;
    private OrderStatus status;

    public TakingOrder(int orderId, String customerName, Product product) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        this.status = OrderStatus.PENDING;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Product getProduct() {
        return product;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
