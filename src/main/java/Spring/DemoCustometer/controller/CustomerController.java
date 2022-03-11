package Spring.DemoCustometer.controller;
import Spring.DemoCustometer.model.Customer;
import Spring.DemoCustometer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("customer")
    public List<Customer> getCustomers(@RequestParam(value = "isDeleted",required = false,defaultValue = "false")boolean isDeleted) {
//        List<Customer> customers = customerService.getAllCustomer(isDeleted);
        return customerService.getAllCustomer(isDeleted);
    }
    @GetMapping("customer/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") Long id) throws Exception {
    return customerService.getCustomerById(id);
    }

    @DeleteMapping("customer/{id}")
    public String deleteCustomer(@PathVariable("id") Long id){
        try {
            customerService.deleteCustomer(id);
        } catch (ResourceNotFoundException e) {
            return "Customer not found is list";
        }
        return "Customer Deleted";
    }
    @PostMapping(value = "newCustomer")
    public String createCustomer(@Valid @RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return "Customer Created with ID :"+customer.getId();
    }

    @PutMapping(value = "/customer/{customerId}")
    public String updateCustomer(@PathVariable("customerId") Long customerId,@Valid @RequestBody Customer customer){
        try {
            customerService.updateCustomerById(customerId,customer);
        } catch (ResourceNotFoundException e) {
            return "Customer not found is list";
        }
        return "Customer Updated";
    }
}
