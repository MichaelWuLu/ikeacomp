package mwlprojects.ikeacomp;

public class Furniture {
    private int price;
    private String description;

    private int itemNumber;
    private String weight;

    private int quantity;

    public Furniture() {
    }

    public Furniture(int price, String description, int itemNumber, String weight, int quantity) {
        this.price = price;
        this.description = description;
        this.itemNumber = itemNumber;
        this.weight = weight;
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

    // getter for weight
    public String getWeight() {
        return this.weight;
    }

    // setter for weight
    public void setWeight(String weight) {
        this.weight = weight;
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
