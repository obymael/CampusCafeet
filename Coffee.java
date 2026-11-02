public class Coffee extends Product implements Preparable {

    @Override
    public void prepare() {
        System.out.println("Preparing coffee...");
    }
    
}
