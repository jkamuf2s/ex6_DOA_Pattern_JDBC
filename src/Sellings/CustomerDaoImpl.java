package Sellings;

import java.util.LinkedList;
import java.util.List;

import DB.DataBaseConnect;

public class CustomerDaoImpl implements CustomerDao{

    private static String customerTable = "customer";


    private static CustomerDaoImpl instance = null;

    public static CustomerDaoImpl getInstance() {
        if (instance == null)
            instance = new CustomerDaoImpl();
        return instance;
    }

    private CustomerDaoImpl() {
    }

    // CRUD interface(single Customer-Object)
    public boolean insertCustomer(Customer c) {
        String query = "INSERT INTO";

        try {
            DataBaseConnect.exeQurry(query);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCustomer(Customer c) {
        String query = "DELETE FROM " + customerTable + " WHERE ID =" + c.getPrimK();

        try {
            DataBaseConnect.exeQurry(query);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Customer findCustomerByPrimKey(Integer primKey) {
        String query = "INSERT INTO";
        Customer customer = new Customer(1);

        try {
            DataBaseConnect.exeQurry(query);
            return customer;
        } catch (Exception ex) {
            ex.printStackTrace();
            return customer;
        }
    }

    @Override
    public boolean updateCustomer(Customer c) {
        String query = "INSERT INTO";

        try {
            DataBaseConnect.exeQurry(query);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Customer> getAllCostumers() {
        String query = "SELECT * FROM ex6.customer";

        LinkedList<LinkedList<String>> customerEntityList;
        LinkedList<Customer> customerList = new LinkedList<Customer>();

        try {
            customerEntityList = DataBaseConnect.exeQurry(query);

            for (LinkedList<String> customerEntity : customerEntityList) {
                Customer customer = new Customer(Integer.parseInt(customerEntity.get(0)));
                customer.setFirstName(customerEntity.get(1));
                customer.setLastName(customerEntity.get(2));
                customerList.add(customer);
            }

            return customerList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return customerList;
        }
    }

    public VirtualList<Product> getProductList(int id ){
              return new VirtualList<Product>(id);
    }

}
