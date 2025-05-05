package com.sky.learn;

import com.sky.learn.entity.Customer;
import com.sky.learn.service.CustomerService;
import com.sky.learn.serviceimpl.AccountServiceImpl;
import com.sky.learn.serviceimpl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class LearnApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    void TestCustomer() throws Exception{
        String id = "5ca4bbcea2dd94ee58162a6a";
        Customer customer = new Customer("Venkat", "Sai Venkat" ,"venkat@kotla");

        //arrange
        when(customerService.findById(id)).thenReturn(customer);

        //act & assert
        mockMvc.perform(get("/customers")
                        .param("id", id))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) customer);
    }

}
