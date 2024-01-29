package mwlprojects.ikeacomp;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api")
public class OrderController {

    private final ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/create-order")
    public Order processOrder(@RequestBody Order order) {
        // Load the products and customers from the JSON files
        List<Furniture> furnitureList = loadFurniture();
        List<Textile> textileList = loadTextiles();
        List<HotDog> hotdogList = loadHotdogs();
        List<Customer> customerList = loadCustomers();

        // Update order status
        order.setStatus("Received");

        // Validate the order...
        // Check that the customer exists
        boolean customerExists = false;
        for (Customer customer : customerList) {
            if (customer.getCustomerNumber() == order.getCustomerNumber()) {
                customerExists = true;
                break;
            }
        }

        if (!customerExists) {
            throw new CustomerNotFoundException("Customer not found");
        }

        // Check that the products exist
        // Checking every product in the order against every product in the list is NOT EFFICIENT
        // Furniture
        for (Furniture furniture : order.getFurniture()) {
            boolean productExists = false;
            for (Furniture furnitureFromList : furnitureList) {
                if (furnitureFromList.getItemNumber() == furniture.getItemNumber()) {
                    productExists = true;
                    break;
                }
            }

            if (!productExists) {
                throw new ProductNotFoundException("Product not found");
            }
        }

        // Textiles
        for (Textile textile : order.getTextiles()) {
            boolean productExists = false;
            for (Textile textileFromList : textileList) {
                if (textileFromList.getItemNumber() == textile.getItemNumber()) {
                    productExists = true;
                    break;
                }
            }

            if (!productExists) {
                throw new ProductNotFoundException("Product not found");
            }
        }

        // Hotdogs
        for (HotDog hotdog : order.getHotdogs()) {
            boolean productExists = false;
            for (HotDog hotdogFromList : hotdogList) {
                if (hotdogFromList.getDescription() == hotdog.getDescription()) {
                    productExists = true;
                    break;
                }
            }

            if (!productExists) {
                throw new ProductNotFoundException("Product not found");
            }
        }

        //check if there are enough products in stock
        // Checking every product in the order against every product in the list is NOT EFFICIENT
        // Furniture
        for (Furniture furniture : order.getFurniture()) {
            for (Furniture furnitureFromList : furnitureList) {
                if (furnitureFromList.getItemNumber() == furniture.getItemNumber()) {
                    if (furnitureFromList.getQuantity() < furniture.getQuantity()) {
                        throw new ProductNotFoundException("Not enough products in stock");
                    }
                }
            }
        }

        // Textiles
        for (Textile textile : order.getTextiles()) {
            for (Textile textileFromList : textileList) {
                if (textileFromList.getItemNumber() == textile.getItemNumber()) {
                    if (textileFromList.getQuantity() < textile.getQuantity()) {
                        throw new ProductNotFoundException("Not enough products in stock");
                    }
                }
            }
        }

        // Hotdogs
        for (HotDog hotdog : order.getHotdogs()) {
            for (HotDog hotdogFromList : hotdogList) {
                if (hotdogFromList.getDescription() == hotdog.getDescription()) {
                    if (hotdogFromList.getQuantity() < hotdog.getQuantity()) {
                        throw new ProductNotFoundException("Not enough products in stock");
                    }
                }
            }
        }

        // Process the order...
        // Update the stock
        // Furniture
        for (Furniture furniture : order.getFurniture()) {
            for (Furniture furnitureFromList : furnitureList) {
                if (furnitureFromList.getItemNumber() == furniture.getItemNumber()) {
                    furnitureFromList.setQuantity(furnitureFromList.getQuantity() - furniture.getQuantity());
                }
            }
        }

        // Textiles
        for (Textile textile : order.getTextiles()) {
            for (Textile textileFromList : textileList) {
                if (textileFromList.getItemNumber() == textile.getItemNumber()) {
                    textileFromList.setQuantity(textileFromList.getQuantity() - textile.getQuantity());
                }
            }
        }

        // Hotdogs
        for (HotDog hotdog : order.getHotdogs()) {
            for (HotDog hotdogFromList : hotdogList) {
                if (hotdogFromList.getDescription() == hotdog.getDescription()) {
                    hotdogFromList.setQuantity(hotdogFromList.getQuantity() - hotdog.getQuantity());
                }
            }
        }

        // Calculate the total price
        

        // Write the updated lists to the JSON files
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("furniture.json"), furnitureList);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("textile.json"), textileList);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("hotdog.json"), hotdogList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write the updated order to the JSON file
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("order.json"), order);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the status
        order.setStatus("Processing");
        // Return the processed order
        return order;
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(CustomerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    private List<Furniture> loadFurniture() {
        try {
            return mapper.readValue(new File("furniture.json"), new TypeReference<List<Furniture>>(){});
        } catch (IOException e) {
            throw new RuntimeException("Failed to load furniture", e);
        }
    }

    private List<Textile> loadTextiles() {
        try {
            return mapper.readValue(new File("textile.json"), new TypeReference<List<Textile>>(){});
        } catch (IOException e) {
            throw new RuntimeException("Failed to load textiles", e);
        }
    }

    private List<HotDog> loadHotdogs() {
        try {
            return mapper.readValue(new File("hotdog.json"), new TypeReference<List<HotDog>>(){});
        } catch (IOException e) {
            throw new RuntimeException("Failed to load hotdogs", e);
        }
    }

    private List<Customer> loadCustomers() {
        try {
            return mapper.readValue(new File("customer.json"), new TypeReference<List<Customer>>(){});
        } catch (IOException e) {
            throw new RuntimeException("Failed to load customers", e);
        }
    }
}