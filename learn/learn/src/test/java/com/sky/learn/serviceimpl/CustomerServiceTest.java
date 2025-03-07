package com.sky.learn.serviceimpl;

import com.sky.learn.entity.Customer;
import com.sky.learn.repository.CustomersRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomersRepository customersRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById_CustomerService() {
        //Arrange
        String id = "5ca4bbcea2dd94ee58162a68";
        ObjectId objectId = new ObjectId(id);
        Customer mockCustomer = new Customer();
        mockCustomer.set_id(objectId);
        mockCustomer.setUsername("fmiller");

        when(customersRepository.findById(objectId)).thenReturn(Optional.of(mockCustomer));

        //Act
        Customer result = customerService.findById(id);

        //Assert
        assertNotNull(result, "Customer Should not Be Null");
        assertEquals("fmiller", result.getUsername(), "Username should match");
        verify(customersRepository, times(1)).findById(objectId);

    }

    @Test
    void testFindById_CustomerNotFound() {
        //Arrange
        String id = "5ca4bbcea2dd94ee58162a67";
        ObjectId objectId = new ObjectId(id);

        when(customersRepository.findById(objectId)).thenReturn(Optional.empty());

        //Act
        Customer result = customerService.findById(id);

        //Assert
        assertNull(result, "Customer should be null when not found");
        verify(customersRepository, times(1)).findById(objectId);
    }

    @Test
    void testFindByEmail_CustomerService() {
        //Arrange
        String email = "bablusaivenkat@gmail.com";
        Customer mockCustomer = new Customer();
        mockCustomer.setEmail(email);
        mockCustomer.setUsername("Venkat");
        when(customersRepository.findByEmail(email)).thenReturn(Optional.of(mockCustomer));

        //Act
        Customer result = customerService.findByEmail(email);

        //Assert
        assertNotNull(result, "Customer should not be null");
        assertEquals(email, result.getEmail(), "Email should match");
        verify(customersRepository, times(1)).findByEmail(email);

    }

    @Test
    void testFindByEmail_CustomerNotFound() {
        //Arrange
        String email = "bablusaivenkat.kotla@gmail.com";
        when(customersRepository.findByEmail(email)).thenReturn(Optional.empty());

        //Customer result = customerService.findByEmail(email);

        // Act &&  Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> customerService.findByEmail(email));
        assertEquals("No Such Customer with email", exception.getMessage());
        verify(customersRepository, times(1)).findByEmail(email);
    }
}
