package Sellings;

// Data Transfer Object
public class Product {

    private int primK;
    private String productName;

    public int getPrimK() {
        return primK;
    }

    protected void setPrimK(int primK) {
        this.primK = primK;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        String erg = "Product[";

        erg += "productName:'" + productName + "'";

        return erg += "]";
    }

}
