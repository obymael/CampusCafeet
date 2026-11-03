import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/** OrderManager
 * denna klassen ansvarar för att lagra och hantera flera beställningar
 * 
 */
public class OrderManager {
    // Alla registrerade beställningar
    private final List<TakingOrder> orders = new ArrayList<>();

    // Beställningar som väntar på att tillagas (First In First Out)
    private final Queue<TakingOrder> orderQueue = new LinkedList<>();

    // Metod för att lägga till en ny beställning
    public void addOrder(TakingOrder order) {
        orders.add(order); // Sparar alla beställningar, även efter de är färdiga
        orderQueue.add(order); // innehåller bara beställningar som väntar på att behandlas
    }

    // Metod för att visa alla registrerade beställningar
    public void showAllOrders() {
        // Kontrollera om listan är tom
        if (orders.isEmpty()) {
            // Om den är det skriv ut meddelande:
            System.out.println("No orders registered yet.");
            // Avsluta metoden
            return;
        }

        // Enhanced for-loop för att gå igenom alla ordrar (objekt)
        for (TakingOrder order : orders) {
            // Hämta information från respektive objekt
            System.out.println(
                "Order #" + order.getOrderId() +
                " | Customer: " + order.getCustomerName() +
                " | Product: " + order.getProduct().getName() +
                " | Status: " + order.getStatus()
            );
        }
    }

}
