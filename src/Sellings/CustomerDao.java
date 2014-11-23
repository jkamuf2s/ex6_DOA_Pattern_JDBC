package Sellings;

import java.util.List;

public interface CustomerDao {
    public boolean insertCustomer(Customer customer); // CREATE
    public Customer findCustomerByPrimKey(Integer primKey); // READ
    public boolean updateCustomer(Customer customer); // UPDATE
    public boolean deleteCustomer(Customer customer); // DELETE

    public List<Customer> getAllCostumers();
}
