package mwlprojects.ikeacomp;

import java.util.List;

public class Customer {
    private int customerNumber;
    private String name;

    private List<String> discount;

    public Customer() {
    }

    public Customer(int customerNumber, String name, List<String> discount) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.discount = discount;
    }

    // getter for customerNumber
    public int getCustomerNumber() {
        return this.customerNumber;
    }

    // setter for customerNumber
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    // getter for name
    public String getName() {
        return this.name;
    }

    // setter for name
    public void setName(String name) {
        this.name = name;
    }

    // getter for discount
    public List<String> getDiscount() {
        return this.discount;
    }

    // setter for discount
    public void setDiscount(List<String> discount) {
        this.discount = discount;
    }
}
