package mwlprojects.ikeacomp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testProcessOrder() throws Exception {
        // Create a sample order JSON payload
        String orderJson = "{\"orderNumber\": 1, \"customerNumber\": 1, \"furniture\": [1999, \"Table\", 1, \"10 kg\", 1], \"textiles\": [], \"hotdogs\": []}";

        // Send a POST request to the endpoint with the order JSON payload
        mockMvc.perform(MockMvcRequestBuilders.post("/api/create-order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orderJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Received"));
    }

    @Test
    public void testSayHello() throws Exception {
        // Send a GET request to the endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, world!"));
    }
}