package mwlprojects.ikeacomp;

public class HotDog {
    private int price;
    private String description;

    private String Flavor;

    private int quantity;

    public HotDog() {
    }

    public HotDog(int price, String description, String Flavor, int quantity) {
        this.price = price;
        this.description = description;
        this.Flavor = Flavor;
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

    // getter for Flavor
    public String getFlavor() {
        return this.Flavor;
    }

    // setter for Flavor
    public void setFlavor(String Flavor) {
        this.Flavor = Flavor;
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
