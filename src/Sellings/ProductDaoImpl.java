package Sellings;

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
		// TODO Auto-generated method stub
		return null;
	}

}
