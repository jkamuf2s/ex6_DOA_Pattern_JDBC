package main;

import java.util.LinkedList;
import java.util.List;

import DB.DataBaseConnect;
import Sellings.*;

public class Client {
    public static void main(String[] args) {

        DataBaseConnect.init();


        // Tests for customer
        System.out.println("CRUD Tests for customer:");
        CustomerDaoImpl cDao = CustomerDaoImpl.getInstance();

        // CREATE
        Customer customer1 = new Customer();
        customer1.setLastName("Miriam");
        customer1.setFirstName("Musterfrau");

        // add Products for customer1
        LinkedList<Product> customer1Products = new LinkedList<Product>();
        Product customer1Product1 = new Product();
        customer1Product1.setProductName("Pencil");
        customer1Products.add(customer1Product1);

        Product customer1Product2 = new Product();
        customer1Product2.setProductName("Rubber");
        customer1Products.add(customer1Product2);

        customer1.setProducts(customer1Products);
        cDao.insertCustomer(customer1);

        // UPDATE
        customer1.setFirstName("Max");
        customer1.setLastName("Mustermann");

        Product customer1Product3 = new Product();
        customer1Product3.setProductName("Calculator");
        customer1Products.add(customer1Product3);

        customer1.setProducts(customer1Products);


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

        }


//        // Tests for product
//        System.out.println("CRUD Tests for products:");
//        ProductDaoImpl pDao = ProductDaoImpl.getInstance();
//
//        // CREATE
//        Product p = new Product();
//        p.setProductName("Headphone");
//        pDao.insertProduct(p);
//
//        // UPDATE
//        p.setProductName("Tablet");
//        pDao.updateProduct(p);
//
//
//        // READ
//        p = pDao.findProductByPrimKey(p.getPrimK());
//        System.out.println(p.toString());
//
//
//        // DELETE
//        pDao.deleteProduct(p);
//
//
//        // get All Test
//        List<Product> ps = pDao.getAllProducts();
//        System.out.println("Now all products who are still in the table:");
//        for (Product productEntity : ps) {
//            System.out.println(productEntity.toString());
//
//        }

    }

}
