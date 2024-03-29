package mwlprojects.ikeacomp;

public class Textile {
    private int price;
    private String description;

    private int itemNumber;
    private String color;

    private int quantity;

    public Textile() {
    }

    public Textile(int price, String description, int itemNumber, String color, int quantity) {
        this.price = price;
        this.description = description;
        this.itemNumber = itemNumber;
        this.color = color;
        this.quantity = quantity;
    }

    // getter for price
    public int getPrice() {
        return this.price;
    }

    // setter for price
    public void setPrice(int price) {
        this.price = price;
    }

    // getter for description
    public String getDescription() {
        return this.description;
    }

    // setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // getter for itemNumber
    public int getItemNumber() {
        return this.itemNumber;
    }

    // setter for itemNumber
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    // getter for color
    public String getColor() {
        return this.color;
    }

    // setter for color
    public void setColor(String color) {
        this.color = color;
    }

    // getter for quantity
    public int getQuantity() {
        return this.quantity;
    }

    // setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
