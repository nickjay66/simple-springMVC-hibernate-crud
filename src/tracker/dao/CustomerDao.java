package tracker.dao;

import tracker.entity.Customer;

import java.util.List;


public interface CustomerDao {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
