package Sellings;

public class Customer {



    private int primK = -1;

    private String lastName;
    private String firstName;

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

    public void setPrimK(int primK) {
        this.primK = primK;
    }


    public int getPrimK() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length != 0) {
            return primK;
        } else {
            throw new IllegalAccessError("You are not allowed to call this method!!");
        }
    }
}
