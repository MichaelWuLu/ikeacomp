package mwlprojects.ikeacomp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateJSON {

    public static void main(String[] args) {
        //Create a list of furniture
        List<Furniture> furnitureList = new ArrayList<>();

        //Add furniture to the list
        furnitureList.add(new Furniture(1999, "Table", 1, "10 Kg", 1));
        furnitureList.add(new Furniture(999, "Chair", 2, "5 Kg", 4));
        furnitureList.add(new Furniture(3999, "Bed", 3, "20 Kg", 2));
        furnitureList.add(new Furniture(4999, "Couch", 4, "30 Kg", 1));
        furnitureList.add(new Furniture(5999, "TV", 5, "15 Kg", 3));

        //Create a list of textiles
        List<Textile> textileList = new ArrayList<>();
        
        //Add textiles to the list
        textileList.add(new Textile(99, "Towel", 1, "White", 10));
        textileList.add(new Textile(99, "Towel", 2, "Blue", 5));
        textileList.add(new Textile(99, "Towel", 3, "Red", 3));
        textileList.add(new Textile(199, "Blanket", 4, "Red", 2));
        textileList.add(new Textile(399, "Bed sheet", 5, "White", 4));
        textileList.add(new Textile(399, "Bed sheet", 6, "Blue", 2));

        //Create a list of hotdogs
        List<HotDog> hotdogList = new ArrayList<>();

        //Add hotdogs to the list
        hotdogList.add(new HotDog(24, "Plain Hotdog", "Plain", 20));
        hotdogList.add(new HotDog(29, "Hotdog with mustard", "Mustard", 10));
        hotdogList.add(new HotDog(29, "Hotdog with ketchup", "Ketchup", 10));
        hotdogList.add(new HotDog(34, "Hotdog with everything", "Mustard and Ketchup", 5));

        //Create a list of Customers
        List<Customer> customerList = new ArrayList<>();

        //Create a list of discounts
        List<String> discount0 = new ArrayList<>();
        List<String> discountfur = new ArrayList<>();
        discountfur.add("Furniture");
        List<String> discounttex = new ArrayList<>();
        discounttex.add("Textile");
        List<String> discounthot = new ArrayList<>();
        discounthot.add("Hotdog");
        List<String> discountall = new ArrayList<>();
        discountall.add("Furniture");
        discountall.add("Textile");
        discountall.add("Hotdog");

        //Add customers to the list
        customerList.add(new Customer(1, "John", discount0));
        customerList.add(new Customer(2, "Jane", discountfur));
        customerList.add(new Customer(3, "Jack", discounttex));
        customerList.add(new Customer(4, "Jill", discounthot));
        customerList.add(new Customer(5, "Joe", discountall));

        //Create a new ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        try {
            //write lists to a JSON file
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("furniture.json"), furnitureList);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("textile.json"), textileList);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("hotdog.json"), hotdogList);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("customer.json"), customerList);
        } catch (IOException e) {
            e.printStackTrace();
        }

		try {
            // Read JSON file into a list of Furniture objects
            List<Furniture> furnitureListFromFile = mapper.readValue(new File("furniture.json"), new TypeReference<List<Furniture>>(){});

            // Print the information from the Furniture list
            for (Furniture furniture : furnitureListFromFile) {
                System.out.println(furniture.getPrice() + furniture.getDescription() + 
                furniture.getItemNumber() + furniture.getWeight() + furniture.getQuantity() + "\n");
            }
		} catch (IOException e) {
			e.printStackTrace();
		}

        //create Order list
        List<Order> orderList = new ArrayList<>();
        List<Furniture> furnitureListOrder = new ArrayList<>();
        furnitureListOrder.add(new Furniture("Table", 1));
        List<Textile> textileListOrder = new ArrayList<>();
        List<HotDog> hotdogListOrder = new ArrayList<>();

        //Access the list of customers to find a customer and their discount
        int customerNumber = customerList.get(2).getCustomerNumber();
        List<String> customerdiscounts = customerList.get(2).getDiscount();
        //Add orders to the list
        orderList.add(new Order(1, customerNumber, customerdiscounts, furnitureListOrder, textileListOrder, hotdogListOrder));
        
        //Write the order to a JSON file
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("order.json"), orderList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
