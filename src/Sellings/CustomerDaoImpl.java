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
        String Querry = "INSERT INTO";

        try {
            DataBaseConnect.exeQurry(Querry);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCustomer(Customer c) {
        String Querry = "DELETE FROM " + customerTable + " WHERE ID =" + c.getPrimK();

        try {
            DataBaseConnect.exeQurry(Querry);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Customer findCustomerByPrimKey(Integer primKey) {
        String Querry = "INSERT INTO";
        Customer customer = new Customer();

        try {
            DataBaseConnect.exeQurry(Querry);
            return customer;
        } catch (Exception ex) {
            ex.printStackTrace();
            return customer;
        }
    }

    @Override
    public boolean updateCustomer(Customer c) {
        String Querry = "INSERT INTO";

        try {
            DataBaseConnect.exeQurry(Querry);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Customer> getAllCostumers() {
        String Querry = "SELECT * FROM ex6.customer";

        LinkedList<LinkedList<String>> customerEntityList;
        LinkedList<Customer> customerList = new LinkedList<Customer>();

        try {
            customerEntityList = DataBaseConnect.exeQurry(Querry);

            for (LinkedList<String> customerEntity : customerEntityList) {
                Customer customer = new Customer();
                customer.setPrimK(Integer.parseInt(customerEntity.get(0)));
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

}
