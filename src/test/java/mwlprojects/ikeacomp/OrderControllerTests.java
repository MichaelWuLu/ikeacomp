package mwlprojects.ikeacomp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringJUnitConfig
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTests {

    private final MockMvc mockMvc;

    public OrderControllerTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void testProcessOrder() throws Exception {
        // Create a sample order JSON payload
        String orderJson = "{\"customerNumber\": 123, \"products\": [\"chair\", \"table\"]}";

        // Send a POST request to the endpoint with the order JSON payload
        mockMvc.perform(MockMvcRequestBuilders.post("/create-order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orderJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Received"));
    }
}