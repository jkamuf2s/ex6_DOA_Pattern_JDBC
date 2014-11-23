package main;

import java.util.List;

import DB.DataBaseConnect;
import Sellings.Customer;
import Sellings.CustomerDaoImpl;
import Sellings.ProductDaoImpl;

public class Client {
    public static void main(String[] args) {
		DataBaseConnect.init();

		CustomerDaoImpl cDao = CustomerDaoImpl.getInstance();
		ProductDaoImpl pDao = ProductDaoImpl.getInstance();

		List<Customer> cs = cDao.getAllCostumers();

        for (Customer customerEntity : cs) {
            System.out.println(customerEntity.toString());

        }

//		// C
//		Customer c = new Customer();
//		c.setLastName("Regina");
//		c.setFirstName("Richter");
//		cDao.insertCustomer(c);
//
//		// R
//		c = cs.get(0);
//		System.out.println(c.toString());
//
//		// U
//		c.setFirstName("yila");
//		cDao.updateCustomer(c);
//
//		// D
//		cDao.deleteCustomer(c);
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
