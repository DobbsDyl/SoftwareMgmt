package ca.sheridan;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private double discount;

    //Constructor
    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price >= 0 ? price : 0;
        this.quantity = quantity >= 0 ? quantity : 0;
        this.discount = discount >= 0 && discount <= 100 ? discount : 0;
    }
}
