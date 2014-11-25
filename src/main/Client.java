package main;

import java.util.List;

import DB.DataBaseConnect;
import Sellings.*;

public class Client {
    public static void main(String[] args) {

        DataBaseConnect.init();



/*        // Tests for customer
        CustomerDaoImpl cDao = CustomerDaoImpl.getInstance();


        // CREATE
        Customer customer1 = new Customer();
        customer1.setLastName("Miriam");
        customer1.setFirstName("Musterfrau");
        cDao.insertCustomer(customer1);

        // UPDATE
        customer1.setFirstName("Max");
        customer1.setLastName("Mustermann");
        cDao.updateCustomer(customer1);

        // READ
        customer1 = cDao.findCustomerByPrimKey(customer1.getPrimK());
        System.out.println(customer1.toString());



        // DELETE
        cDao.deleteCustomer(customer1);

        // get All Test
        List<Customer> cs = cDao.getAllCostumers();
        System.out.println("Now all customers who are still in the table:");
        for (Customer customerEntity : cs) {
            System.out.println(customerEntity.toString());

        }*/


        // Tests for product
        ProductDaoImpl pDao = ProductDaoImpl.getInstance();

        // CREATE
        Product p = new Product();
        p.setProductName("Headphone");
        pDao.insertProduct(p);

        // UPDATE
        p.setProductName("Tablet");
        pDao.updateProduct(p);


        // READ
        p = pDao.findProductByPrimKey(p.getPrimK());
        System.out.println(p.toString());


        // DELETE
        pDao.deleteProduct(p);


        // get All Test
        List<Product> ps = pDao.getAllProducts();
        System.out.println("Now all products who are still in the table:");
        for (Product productEntity : ps) {
            System.out.println(productEntity.toString());

        }

    }

}
