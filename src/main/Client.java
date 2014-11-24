package main;

import java.util.List;

import DB.DataBaseConnect;
import Sellings.Customer;
import Sellings.CustomerDaoImpl;
import Sellings.Product;
import Sellings.ProductDaoImpl;

public class Client {
    public static void main(String[] args) {

        DataBaseConnect.init();

        CustomerDaoImpl cDao = CustomerDaoImpl.getInstance();
//
//
//        // get All Test
//		List<Customer> cs = cDao.getAllCostumers();
//        List<Product> ps = pDao.getAllProducts();
//
//        for (Customer customerEntity : cs) {
//            System.out.println(customerEntity.toString());
//
//        }
//
//        for (Product productEntity : ps) {
//            System.out.println(productEntity.toString());
//
//        }

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

        }
//
//
//		List<Product> ps = pDao.getAllProducts();
//		// C
//		Product p = new Product();
//		p.setProductName("Haus");
//		pDao.insertProduct(p);
//
//		// R
//		p = ps.get(0);
//		System.out.println(p.toString());
//
//		// U
//		p.setProductName("PC");
//		pDao.updateProduct(p);
//
//		// D
//		pDao.deleteProduct(p);


    }

}
