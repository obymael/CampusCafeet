import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/** OrderManager
 * denna klassen ansvarar för att lagra och hantera flera beställningar
 * 
 */
public class OrderManager {
    private int nextOrderId = 1;

    // Alla registrerade beställningar
    private final List<TakingOrder> orders = new ArrayList<>();

    // Beställningar som väntar på att tillagas (First In First Out)
    private final Queue<TakingOrder> orderQueue = new LinkedList<>();

    // Historik över de senast färdigställda beställningarna
    private final Deque<TakingOrder> completedOrders = new ArrayDeque<>();

    public int getNextOrderId() {
        return nextOrderId++;
    }

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

        // Lägg till den färdigställda beställningen först i historiken
        completedOrders.addFirst(order); // addFirst för att den senast färdigställda beställningen alltid ska hamna först

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

    // Metod för att räkna antalet sålda produkter
    /** Förklaring av vad en Map är
     * - en Map lagrar infromation som nyckel och värde (key-value)
     * - KEY: String kommer här vara produktens namn
     * - VALUE: Integer här för att visa hur många gånger produkten sålts
     * 
     * en List kan innehålla alla beställningar men håller inte automatiskt reda på
     * hur många gånger varje produkt förekommer, men med Map så får vi en direkt koppling
     */
    public void showProductSales() {
        Map<String, Integer> productSales = new HashMap<>();

        for (TakingOrder order : orders) {
            String productName = order.getProduct().getName();

            // put() sparar nya antalet under produktens namn
            // getOrDefault() kontrollerar om produkten redan finns i Map,
            // - om den finns, hämta nuvarande antal, om den inte finns använd 0, lägg till 1
            productSales.put(productName, productSales.getOrDefault(productName, 0) + 1);
        }

        if (productSales.isEmpty()) {
            System.out.println("No products sold yet.");
            return;
        }
    }

    // Metod för att sortera kundnamn alfabetiskt (sortera en kopia)
    public void showSortedCustomers() {
        // Skapa en lista med kundnamn
        List<String> customerNames = new ArrayList<>();

        // Hämta kundnamn från alla beställningar
        for (TakingOrder order : orders) {
            customerNames.add(order.getCustomerName());
        }

        // Kontrollera om listan är tom
        if (customerNames.isEmpty()) {
            System.out.println("No customers registered yet.");
            return;
        }

        // Skapa en kopia av listan 
        // - egentligen hade vi kunnat sortera orginallistan men det stod att vi skulle sortera en kopia
        List<String> sortedCustomers = new ArrayList<>(customerNames);

        // Sortera kopian alfabetiskt
        Collections.sort(sortedCustomers);

        // Skriv ut resultatet
        System.out.println("Customers in alphabetical order:");
        for (String customer : sortedCustomers) {
            System.out.println("- " + customer);
        }

    }

    // Metod för att se de tre senaste beställninganra som blivit FINISHED
    public void showRecentCompletedOrders() {
        if (completedOrders.isEmpty()) {
            System.out.println("No completed orders yet.");
            return;
        }

        // Skapa en räknare
        int count = 0;

        System.out.println("Last 3 completed orders:");
        for (TakingOrder order : completedOrders) {
            // När tre beställningar har skrivits ut
            if (count >= 3) {
                break; // avbryt loopen
            }

            // Hämta information från objektet
            System.out.println(
                "Order #" + order.getOrderId() +
                " | Customer: " + order.getCustomerName() +
                " | Product: " + order.getProduct().getName()
            );

            count++; // öka räkningen efter varje utskriven beställning
        }
    }    
}
