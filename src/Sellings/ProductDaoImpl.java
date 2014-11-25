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
        String query = "INSERT INTO ex6.product (description) VALUES ( '"+ p.getProductName() +" ' ) RETURNING id";
        LinkedList<LinkedList<String>> productIDList;

        try {
            productIDList = DataBaseConnect.exeQurry(query);
            p.setPrimK(Integer.parseInt(productIDList.getFirst().get(0)));
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }



        return true;
	}

	public boolean deleteProduct(Product p) {
        String query = "DELETE FROM  ex6.product WHERE ID =" + p.getPrimK();

        try {
            DataBaseConnect.exeUpdate(query);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
	}

	public Product findProductByPrimKey(Integer primKey) {
        String query = "SELECT id, description FROM ex6.product WHERE id= "+primKey;
        LinkedList<LinkedList<String>> productEntityList;
        Product product = new Product();

        try {
            productEntityList = DataBaseConnect.exeQurry(query);


            product.setPrimK(Integer.parseInt(productEntityList.getFirst().get(0)));
            product.setProductName(productEntityList.getFirst().get(1));



            return product;

        } catch (Exception ex) {
            ex.printStackTrace();
            return product;
        }
	}

	public boolean updateProduct(Product p) {
        String query = "UPDATE ex6.product SET description ='" + p.getProductName() + "' WHERE id ="+ p.getPrimK();

        try {
            DataBaseConnect.exeUpdate(query);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
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

    public  List<Product> findForCustomer(int primK){
        String query = "SELECT * FROM ex6.product WHERE customerId = "+primK;

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
