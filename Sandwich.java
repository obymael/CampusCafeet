public class Sandwich extends Product implements Preparable {
    public static final double SANDWICH_PRICE = 47.50;

    public Sandwich() {
        super("Sandwich", SANDWICH_PRICE);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing sandwich...");
    }
    
}