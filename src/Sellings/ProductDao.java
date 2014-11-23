package Sellings;

import java.util.List;

public interface ProductDao {

    public boolean insertProduct(Product p); // CREATE
    public Customer findProductByPrimKey(Integer primKey); // READ
    public boolean updateProduct(Product p); // UPDATE
    public boolean deleteProduct(Product p); // DELETE

    public List<Product> getAllProducts();
}
