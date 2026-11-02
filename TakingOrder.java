public class TakingOrder {

    private int orderId;
    private String customerName;
    private Product product; // (ska hämtas från Product.java?)
    private OrderStatus status; // (ska hämtas från OrderStatus enum?)


    public TakingOrder(int orderId, String customerName, Product product) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        this.status = OrderStatus.PENDING; // Beställningen är inte färdig från början
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


}   
