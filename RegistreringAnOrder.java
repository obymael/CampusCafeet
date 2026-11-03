public class RegistreringAnOrder {
    
    public void orderReceipt(){
        // needs to use the saved orderId, product, and customerName to print the receipt
        System.out.println("Here is your receipt.");
        System.out.println("Customer: " + customerName);
        System.out.println("Order: " + product);
        System.out.println("Order ID: " + orderId);
    }

    public char getReceiptConfirmation(InputHandler input){
        System.out.println("Do you want to a receipt? (J/N)");
        char confirmation = input.readChar();
        if (confirmation == 'J' || confirmation == 'j') {
            orderReceipt();
        } else if (confirmation == 'N' || confirmation == 'n') {
            System.out.println("No receipt will be printed.");
        } else {
            System.out.println("Invalid input. Please enter J or N.");
            return getReceiptConfirmation(input); // Recursively ask again
        }
        return confirmation;
    }

    public int receivingAnOrderId(InputHandler input){
        System.out.println("Please enter your order ID:");
        int orderId = input.readInt();
        return orderId;
    }

    public String receivingCustomerName(InputHandler input){
        System.out.println("Please enter your name:");
        String customerName = input.readString();
        return customerName;
    }
    
    public String insertName(InputHandler input) {
        System.out.print("Please enter your name: ");
        String name = input.readString();
        System.out.println("Welcome, " + name + "! Let's get caffeinated!");
        return name;    
    }

    public void showProducts() {
        System.out.println();
        System.out.println("=== Products and prices ===");
        System.out.println("1. Coffee - 34 kr");
        System.out.println("2. Sandwich - 47.50 kr");
        System.out.println("3. Bottled Water - 18.99 kr");
    }

    private Product getProductByChoice(int choice) {
        switch (choice) {
            case 1:
                return new Coffee();
            case 2:
                return new Sandwich();
            case 3:
                return new BottledWater();
            default:
                System.out.println("Invalid product number.");
                return null;
        }
    }

    public void placeOrder(InputHandler input, OrderManager orderManager) {
        System.out.println();
        System.out.println("=== Place an order ===");
        System.out.print("Customer name: ");
        String customerName = input.readString();

        showProducts();
        System.out.print("Choose a product (1-3): ");

        try {
            int productChoice = input.readInt();
            Product selectedProduct = getProductByChoice(productChoice);

            if (selectedProduct == null) {
                return;
            }

            int orderId = orderManager.getNextOrderId();
            TakingOrder order = new TakingOrder(orderId, customerName, selectedProduct);
            orderManager.addOrder(order);

            System.out.println("Order confirmed: #" + order.getOrderId());
            System.out.println("Customer: " + order.getCustomerName());
            System.out.println("Product: " + order.getProduct().getName());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid product number.");
        }
    }
}


/*

Skriv metoder för att registrera en beställning och visa ett kvitto.
    Använd parametrar, `return`, `void` och en liten
    `static`-hjälpmetod. Överlagra gärna kvittometoden med två
    parameterlistor. Låt kunden bekräfta med tecknet J/N (`char`).

*/