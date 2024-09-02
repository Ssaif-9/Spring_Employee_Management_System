package unit4;

public class Bank3 {

    public static void main(String[] args) {
        Customer3 cust = new Customer3();
        cust.firstName = "Jim";
        cust.lastName = "Stewart";
        cust.addAccount(250.0);

        Customer3 cust2 = new Customer3();
        cust2.firstName = "Joan";
        cust2.lastName = "Stewart";
        cust2.addAccount(500.0);
    }
}
