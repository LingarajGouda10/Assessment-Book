package com.ivoyant.AssessmentBook.Controller;

import com.ivoyant.AssessmentBook.Model.Customer;
import com.ivoyant.AssessmentBook.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/addCustomer")
    public Customer addCustomer( @RequestBody Customer customer){
        return service.saveCustomer(customer);
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.upsert(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer() {
        return service.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return service.getCustomerById(id);
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteCustomer(id);
    }

    @GetMapping("/reports/customers")
    public void getAllCustomerDetails(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"customer.csv\"");
        service.writeCustomertocsv(servletResponse.getWriter());
    }



}
