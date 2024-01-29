package mwlprojects.ikeacomp;

public class Customer {
    private int customerNumber;
    private String name;

    private Boolean isFurnitureMember;
    private Boolean isTextileMember;
    private Boolean isHotDogMember;

    public Customer() {
    }

    public Customer(int customerNumber, String name, Boolean isFurnitureMember, Boolean isTextileMember, Boolean isHotDogMember) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.isFurnitureMember = isFurnitureMember;
        this.isTextileMember = isTextileMember;
        this.isHotDogMember = isHotDogMember;
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

    // getter for isFurnitureMember
    public Boolean getIsFurnitureMember() {
        return this.isFurnitureMember;
    }

    // setter for isFurnitureMember
    public void setIsFurnitureMember(Boolean isFurnitureMember) {
        this.isFurnitureMember = isFurnitureMember;
    }

    // getter for isTextileMember
    public Boolean getIsTextileMember() {
        return this.isTextileMember;
    }

    // setter for isTextileMember
    public void setIsTextileMember(Boolean isTextileMember) {
        this.isTextileMember = isTextileMember;
    }

    // getter for isHotDogMember
    public Boolean getIsHotDogMember() {
        return this.isHotDogMember;
    }

    // setter for isHotDogMember
    public void setIsHotDogMember(Boolean isHotDogMember) {
        this.isHotDogMember = isHotDogMember;
    }
}
