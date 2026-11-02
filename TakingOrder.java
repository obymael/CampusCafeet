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
    
    
    
    
    
    
    
    
    

//     private int orderId;
//     private String customerName;
//     private String productName; // ska hämtas från Product.java
//     private boolean status;


// public int getOrderId() {
//         return orderId;
//     }
//     public String getCustomerName() {
//         return customerName;
//     }
//     public String getProductName() { //save the product name with the order Id.
//         return productName;
//     }
//     public boolean isStatus() { //check if the order is completed or not
//         return status;
//     }

//     // public wrongOrder(int orderId){
//     //     if(/*scanner*/ >= /*Menu.lenght*/){
//     //         System.out.println("Invalid order, please try again");
//     //     } else if(/*scanner*/ < 0) {
//     //         System.out.println("Invalid order, please try again");
//     //     } else {
//     //         return orderId;
//     //     }
//     // }

    
//     public void takeOrder(int orderId, String customerName, String productName) {
//         this.orderId = orderId;
//         this.customerName = customerName;
//         this.productName = productName;
//     }


//     public boolean orderStatus(boolean status) {
//         if (status == true) {
//             System.out.println("Order completed");
//         } else {
//             System.out.println("Order not completed");
//         }
//         return status;
//     }

//     /*
//     import the menu
//     */

//     /* 
//     if (orderId < min || orderId > max) {
//            System.out.println("Invalid order, please try again");
//     }
//     */

    




