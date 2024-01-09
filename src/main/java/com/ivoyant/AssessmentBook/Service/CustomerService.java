package com.ivoyant.AssessmentBook.Service;

import com.ivoyant.AssessmentBook.Model.Book;
import com.ivoyant.AssessmentBook.Model.Customer;
import com.ivoyant.AssessmentBook.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    @Autowired
    private  CustomerRepository customerRepository;

    public  Customer upsert(Customer customer){
        return customerRepository.save(customer);
    }

    public  Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public  List<Customer>getAllCustomers(){
        return customerRepository.findAll();
    }

    public  Customer getCustomerById(int id){
        return customerRepository.getById(id);
    }

    public  String deleteCustomer(int id){
        customerRepository.deleteById(id);
        return "Customer deleted !" + id;
    }

    public void writeCustomertocsv(PrintWriter writer) {
        List<Customer> customers = customerRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("ID", "Name", "Email", "Address");
            for (Customer customer : customers) {
                csvPrinter.printRecord(customer.getId(), customer.getName(), customer.getEmail(), customer.getAddress());
            }
        } catch (IOException e) {
            System.out.println("Error While Writing csv" + e);
        }
}
