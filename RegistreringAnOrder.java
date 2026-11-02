public class RegistreringAnOrder {
    
    public void orderReceipt(int orderId, String product, String customerName){
        System.out.println("Here is your receipt.");
        System.out.println("Customer: " + customerName);
        System.out.println("Order: " + product);
        System.out.println("Order ID: " + orderId);
    }

    public char confirmOrder(InputHandler readChar){
        System.out.println("Do you want to confirm your order? (J/N)");
        char confirmation = readChar.readChar();
        return confirmation;
    }


}


/*

Skriv metoder för att registrera en beställning och visa ett kvitto.
    Använd parametrar, `return`, `void` och en liten
    `static`-hjälpmetod. Överlagra gärna kvittometoden med två
    parameterlistor. Låt kunden bekräfta med tecknet J/N (`char`).

*/