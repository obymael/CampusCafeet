public abstract class Product {
    private final String name; // Adderat final så namnet inte kan tilldelas nytt värde efter skapandet
    private final float price; // Samma för priset

    // Konstruktor säkerställer att varje produkt som skapas har ett namn & pris
    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    // Behövs inte med tanke på konstruktorn
    /* public void setName(String name) {
        this.name = name;
    } */

    public float getPrice() {
        return price; 
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    } 
}