public class TestPreparation {

    public static void main(String[] args) {

        Coffee coffee = new Coffee();
        Sandwich sandwich = new Sandwich();

        BottledWater bottledWater = new BottledWater(); 

        // Detta fungerar inte eftersom BottledWater saknar prepare():
        // bottledWater.prepare();

        coffee.prepare();
        sandwich.prepare();


    }
}