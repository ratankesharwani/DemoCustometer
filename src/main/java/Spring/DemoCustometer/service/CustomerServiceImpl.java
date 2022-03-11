package Spring.DemoCustometer.service;

import Spring.DemoCustometer.controller.ResourceNotFoundException;
import Spring.DemoCustometer.model.Customer;
import Spring.DemoCustometer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class   CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer(boolean isDeleted) {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Long id) throws ResourceNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()){
            throw new ResourceNotFoundException("Customer not found");
        }
        else{
            customerRepository.deleteById(id);
        }
    }

    @Override
    public Customer getCustomerById(Long id) throws ResourceNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()){
            throw new ResourceNotFoundException("Customer not found");
        }
        return customerRepository.getById(id);
    }

    @Override
    public Customer updateCustomerById(Long id,Customer customer) throws ResourceNotFoundException {

        Optional<Customer> customer1 = customerRepository.findById(id);
        if(customer1.isEmpty()){
            throw new ResourceNotFoundException("Customer not found");
        }
        else{
            Customer oldCustomer = customerRepository.getById(id);
        if(customer.getFirstName() !=null && !customer.getFirstName().equals(oldCustomer.getFirstName())){
                oldCustomer.setFirstName(customer.getFirstName());
        }

        if(customer.getMiddleName()!=null && !customer.getMiddleName().equals(oldCustomer.getMiddleName())){
            oldCustomer.setMiddleName(customer.getMiddleName());
        }
        if(customer.getLastName()!=null && !customer.getLastName().equals(oldCustomer.getLastName())){
            oldCustomer.setLastName(customer.getLastName());
        }
        if(customer.getAddress()!=null && !customer.getAddress().equals(oldCustomer.getAddress())){
            oldCustomer.setAddress(customer.getAddress());
        }

        if(customer.getPhoneNo()!=null && !customer.getPhoneNo().equals(oldCustomer.getPhoneNo())){
            oldCustomer.setPhoneNo(customer.getPhoneNo());
        }
        if(customer.getEmail()!=null && !customer.getEmail().equals(oldCustomer.getEmail())){
            oldCustomer.setEmail(customer.getEmail());
        }
        if(customer.getDob()!=null && !customer.getDob().equals(oldCustomer.getDob())){
            oldCustomer.setDob(customer.getDob());
        }
        if(customer.getAge()!=null && !customer.getAge().equals(oldCustomer.getAge())){
            oldCustomer.setAge(customer.getAge());
        }
        if(customer.getGender()!=null && !customer.getGender().equals(oldCustomer.getGender())){
            oldCustomer.setGender(customer.getGender());
        }
        return customerRepository.save(oldCustomer);
        }
    }
@Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}

