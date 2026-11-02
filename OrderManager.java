import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/** OrderManager
 * denna klassen ansvarar för att lagra och hantera flera beställningar
 * 
 */
import java.util.Queue;
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

}
