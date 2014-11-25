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
        String query = "INSERT INTO ex6.customer (firstname, lastname) VALUES ( '"+ c.getFirstName() + "','"+ c.getLastName()+"' ) RETURNING id";
        LinkedList<LinkedList<String>> customerIDList;

        try {
            customerIDList = DataBaseConnect.exeQurry(query);
            c.setPrimK(Integer.parseInt(customerIDList.getFirst().get(0)));
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }


        // insert Products for customer
        ProductDaoImpl pDao = ProductDaoImpl.getInstance();

        for (Product productEntity : c.getProducts()) {
            pDao.insertProduct(productEntity,c.getPrimK());

        }



        return true;
    }

    @Override
    public boolean deleteCustomer(Customer c) {
        String query = "DELETE FROM  ex6.customer WHERE ID =" + c.getPrimK();

        try {
            DataBaseConnect.exeUpdate(query);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Customer findCustomerByPrimKey(Integer primKey) {
        String query = "SELECT * FROM ex6.customer WHERE id="+primKey;
        LinkedList<LinkedList<String>> customerEntityList;
        Customer customer = new Customer();

        try {
            customerEntityList = DataBaseConnect.exeQurry(query);


            customer.setPrimK(Integer.parseInt(customerEntityList.getFirst().get(0)));
            customer.setFirstName(customerEntityList.getFirst().get(1));
            customer.setLastName(customerEntityList.getFirst().get(2));


            return customer;

        } catch (Exception ex) {
            ex.printStackTrace();
            return customer;
        }
    }

    @Override
    public boolean updateCustomer(Customer c) {
        String query = "UPDATE ex6.customer SET firstname ='" + c.getFirstName() + "', lastname ='" + c.getLastName() + "' WHERE id ="+ c.getPrimK();

        try {
            DataBaseConnect.exeUpdate(query);

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }


        // update existing Products for customer
        ProductDaoImpl pDao = ProductDaoImpl.getInstance();

        for (Product productEntity : c.getProducts()) {
            pDao.updateProduct(productEntity);

        }

        // insert new and only new products
        for (Product productEntity : c.getProducts()) {
            pDao.insertProduct(productEntity,c.getPrimK());

        }

        return true;
    }

    @Override
    public List<Customer> getAllCostumers() {
        String query = "SELECT * FROM ex6.customer";

        LinkedList<LinkedList<String>> customerEntityList;
        LinkedList<Customer> customerList = new LinkedList<Customer>();

        try {
            customerEntityList = DataBaseConnect.exeQurry(query);

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

    public VirtualList<Product> createProductList(int id ){
              return new VirtualList<Product>(id);
    }

}
