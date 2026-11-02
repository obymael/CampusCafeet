public class Sandwich extends Product implements Preparable {

    @Override
    public void prepare() {
        System.out.println("Preparing sandwich...");
    }
    
}