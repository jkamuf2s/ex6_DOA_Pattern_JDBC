package Sellings;

import java.util.LinkedList;
import java.util.List;

import DB.DataBaseConnect;

public class ProductDaoImpl implements ProductDao {

	private static ProductDaoImpl instance = null;

	public static ProductDaoImpl getInstance() {
		if (instance == null)
			instance = new ProductDaoImpl();
		return instance;
	}

	private ProductDaoImpl() {
	}

	// CRUD interface(single Customer-Object)
	public boolean insertProduct(Product p) {
		String query = "INSERT INTO";

		try {
			DataBaseConnect.exeQurry(query);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteProduct(Product p) {
		return false;
	}

	public Customer findProductByPrimKey(Integer primKey) {
		return null;
	}

	public boolean updateProduct(Product p) {
		return false;
	}

	public List<Product> getAllProducts() {
        String query = "SELECT * FROM ex6.product";

        LinkedList<LinkedList<String>> productEntityList;
        LinkedList<Product> productList = new LinkedList<Product>();

        try {
            productEntityList = DataBaseConnect.exeQurry(query);

            for (LinkedList<String> productEntity : productEntityList) {
                Product product = new Product();
                product.setPrimK(Integer.parseInt(productEntity.get(0)));
                product.setProductName(productEntity.get(1));
                productList.add(product);
            }

            return productList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return productList;
        }
	}

}
