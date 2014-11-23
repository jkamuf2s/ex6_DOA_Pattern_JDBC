package Sellings;

import java.util.List;

// Data Transfer Object
public class Customer {

    private int primK;
    private String lastName;
    private String firstName;

    private List<Product> products = null;

    public Customer(int primK) {
        this.primK = primK;
    }

    public int getPrimK() {
        return primK;
    }

    public void setPrimK(int primK) {
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
        if ( products == null ) {
            ProductDaoImpl pDao = ProductDaoImpl.getInstance();
            products = pDao.findForCustomer(  this.getPrimK() );
        }
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        String erg = "Costumer[";

        erg += "lastName:'" + lastName + "'";
        erg += "firstName:'" + firstName + "'";
        erg += "productsForCustomer:" + getProducts().toString();

        return erg += "]";
    }

}
