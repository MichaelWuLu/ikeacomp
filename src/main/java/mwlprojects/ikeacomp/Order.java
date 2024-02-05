package mwlprojects.ikeacomp;

import java.util.List;

public class Order {
    private int orderNumber;
    private int customerNumber;
    private List<String> discount;
    private List<Furniture> furniture;
    private List<Textile> textiles;
    private List<HotDog> hotdogs;
    private String status;  // "Recived", "delivered"
    private int totalPrice;

    public Order() {
    }

    public Order(int orderNumber, int customerNumber, List<String> discount, List<Furniture> furniture, 
    List<Textile> textiles, List<HotDog> hotdogs) {
        this.customerNumber = customerNumber;
        this.discount = discount;
        this.furniture = furniture;
        this.textiles = textiles;
        this.hotdogs = hotdogs;
    }

    // getter for orderNumber
    public int getOrderNumber() {
        return this.orderNumber;
    }

    // setter for orderNumber
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    // getter for customerNumber
    public int getCustomerNumber() {
        return this.customerNumber;
    }

    // setter for customerNumber
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    // getter for discount
    public List<String> getDiscount() {
        return this.discount;
    }

    // setter for discount
    public void setDiscount(List<String> discount) {
        this.discount = discount;
    }

    // getter for furniture
    public List<Furniture> getFurniture() {
        return this.furniture;
    }

    // setter for furniture
    public void setFurniture(List<Furniture> furniture) {
        this.furniture = furniture;
    }

    // getter for textiles
    public List<Textile> getTextiles() {
        return this.textiles;
    }

    // setter for textiles
    public void setTextiles(List<Textile> textiles) {
        this.textiles = textiles;
    }

    // getter for hotdogs
    public List<HotDog> getHotdogs() {
        return this.hotdogs;
    }

    // setter for hotdogs
    public void setHotdogs(List<HotDog> hotdogs) {
        this.hotdogs = hotdogs;
    }

    // getter for status
    public String getStatus() {
        return this.status;
    }

    // setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // getter for totalPrice
    public int getTotalPrice() {
        return this.totalPrice;
    }

    // setter for totalPrice
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
