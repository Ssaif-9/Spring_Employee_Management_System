package unit4;

public class Bank4 {

    public static void main(String[] args) {
        Customer4 cust = new Customer4();
        cust.firstName = "Jim";
        cust.lastName = "Stewart";
        cust.addAccount();

        Customer4 cust2 = new Customer4();
        cust2.firstName = "Joan";
        cust2.lastName = "Stewart";
        cust2.addAccount(500.0);
    }
}
