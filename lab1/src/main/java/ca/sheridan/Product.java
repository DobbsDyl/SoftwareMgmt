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
    
        //Testing Methods
    public void sellProduct(int sellAmount) {
        if (quantity - sellAmount >= 0) 
            quantity -= sellAmount;
        else
            throw new RuntimeException();
    }

    public void buyProduct(int buyAmount) {
        if (buyAmount > 0) 
            quantity += buyAmount;
        else
            throw new RuntimeException();
    }

    public void applyDiscount(double discount) {
        if (discount >= 0 && discount <= 100) {
            this.discount = discount / 100;
            price = Math.abs(price - (price * this.discount));
        }
        else
            throw new RuntimeException();
        
    }

    public void removeDiscount() {
        price = price / (1-discount);
        discount = 0;
    }

    //Setters
    public void setPrice(double newPrice) {
        if (newPrice >= 0) 
            price = newPrice;
        else 
            throw new RuntimeException();
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }
    
}
