import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
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

    // Metod som visar alla väntade bestälningar i rätt ordning
    public void showOrderQueue() {
        // Kolla om kön är tom
        if (orderQueue.isEmpty()) {
            // Om den är tom, skriv ut meddelande:
            System.out.println("No pending orders.");
            // Avsluta metoden
            return;
        }

        // Enhanced for-loop som går igenom alla ordrar i kön
        for (TakingOrder order : orderQueue) {
            // Hämta information från respektive objekt
            System.out.println(
                "Order #" + order.getOrderId() +
                " | Customer: " + order.getCustomerName() +
                " | Product: " + order.getProduct().getName() +
                " | Status: " + order.getStatus()
            );
        }
    }

    // Metod som färdigställer nästa beställning
    public void prepareNextOrder() {
        // Kontrollera om kön är tom
        if (orderQueue.isEmpty()) {
            // Om den är tom, skriv ut meddelande:
            System.out.println("No pending orders.");
            // Avsluta metoden
            return;
        }

        // Hämta och ta bort den äldsta beställningen
        TakingOrder order = orderQueue.poll(); // poll hämtar första objektet i kön o tar bort det

        // Hämta produkten från beställningen
        Product product = order.getProduct();

        // Kontrollera om produkten behöver tillagas 
        if (product instanceof Preparable preparable) {
            // om produkten implementerar Preparable så skapas variabeln preparable
            // och vi anropar då preparable()
            preparable.prepare();
        }

        // Uppdatera beställningens status
        order.setStatus(OrderStatus.FINISHED);

        System.out.println("Order # " + order.getOrderId() + " is ready!");
    }

    // Metod för att visa unika produkter
    /** förklaring skillnader mellan List och Set
     * - List tillåter dubletter medans Set tillåter det
     * - List behåller ordningen i en ArrayList medans HashSet inte garanterar ordningen
     * - List kan hämta element med index, Set har inget index
     */
    public void showUniqueProducts() {
        Set<String> uniqueProducts = new HashSet<>();

        for (TakingOrder order : orders) {
            // order.getProduct() hämtar produktobjektet från beställningen
            // getName() hämtar produkterns namn
            // .add() försöker lägga till namnet i vårt Set
            uniqueProducts.add(order.getProduct().getName());
        }

        if (uniqueProducts.isEmpty()) {
            System.out.println("No products ordered yet.");
            return;
        }

        System.out.println("Unique ordered products:");

        for (String productName : uniqueProducts) {
            System.out.println("- " + productName);
        }
    }

}
