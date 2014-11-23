package Sellings;

// Data Transfer Object
public class Customer {

    private int primK = -1;
    private String lastName;
    private String firstName;

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

    @Override
    public String toString() {
        String erg = "Costumer[";

        erg += "lastName:'" + lastName + "'";
        erg += "firstName:'" + firstName + "'";

        return erg += "]";
    }

}
