package Spring.DemoCustometer.service;

import Spring.DemoCustometer.controller.ResourceNotFoundException;
import Spring.DemoCustometer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer(boolean isDeleted);
    void deleteCustomer(Long id) throws ResourceNotFoundException;
    Customer getCustomerById(Long id) throws Exception;
    Customer updateCustomerById(Long id,Customer customer) throws ResourceNotFoundException;
    Customer saveCustomer(Customer customer);
}
