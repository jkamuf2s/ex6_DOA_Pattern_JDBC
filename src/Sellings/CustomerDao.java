package Sellings;

import java.util.List;

/**
 * Created by JAYDESKTOP on 23.11.2014.
 */
public interface CustomerDao {

    public boolean insertCustomer(Customer customer);
    public boolean deleteCustomer(Customer customer);
    public Customer findCustomerByPrimKey(Integer primKey);
    public boolean updateCustomer(Customer customer);
    public List<Customer> getAllCostumers();
}
