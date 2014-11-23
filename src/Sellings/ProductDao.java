package Sellings;

import java.util.List;

/**
 * Created by JAYDESKTOP on 23.11.2014.
 */
public interface ProductDao {

    public boolean insertProduct(Product p);
    public boolean deleteProduct(Product p);
    public Customer findProductByPrimKey(Integer primKey);
    public boolean updateProduct(Product p);
    public List<Product> getAllProducts();
}
