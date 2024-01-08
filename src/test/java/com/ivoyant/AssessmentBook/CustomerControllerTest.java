package com.ivoyant.AssessmentBook;

import com.ivoyant.AssessmentBook.Controller.CustomerController;
import com.ivoyant.AssessmentBook.Model.Customer;
import com.ivoyant.AssessmentBook.Model.Inventory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerControllerTest {

    @Autowired
    private CustomerController customerController;

    @Test
    public void testCustomerController(){
        Customer customer=new Customer();
        customer.setId(33);
        customer.setName("Hello");
        customer.setAddress("poiupo");
        customer.setEmail("yuhntgv");

        Customer result= customerController.addCustomer(customer.getId(),customer.getName(),customer, new Customer());

        assertEquals(null,result);
        assertEquals(2,customer.getId());
        assertEquals("Hello",customer.getName());
    }
}
