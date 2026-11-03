public class Coffee extends Product implements Preparable {
    public static final double COFFEE_PRICE = 34;

    public Coffee() {
        super("Coffee", COFFEE_PRICE);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing coffee...");
    }
    
}
