package Sellings;

import java.util.List;

// Data Transfer Object
public class Customer {

    private Integer primK = null;
    private String lastName;
    private String firstName;
    private List products = null;

    public Customer() {
    }

    public int getPrimK() {

        if (primK != null) {
            return primK;
        } else {
            throw new IllegalAccessError("Primary Key not set by database");
        }
    }

    protected void setPrimK(int primK) {
        this.primK = primK;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Product> getProducts() {

        if (products == null) {
            CustomerDaoImpl cDao = CustomerDaoImpl.getInstance();
            products = cDao.createProductList(primK);
        }

        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        String erg = "Costumer[";

        erg += "lastName:'" + lastName + "' ";
        erg += "firstName:'" + firstName + "' ";
        erg += "productsForCustomer:" + getProducts().toString();

        return erg += "]";
    }

}
