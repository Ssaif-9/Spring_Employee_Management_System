package core.annotation;

import java.util.Scanner;

public class TrySome {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Enter username");

	    String userName = myObj.nextLine();
	    System.out.println("Username is: " + userName);
	    int i =10;
	    Integer intobj=i;
	    System.out.println(intobj);
	    int sum = i + intobj;
	    int x = new Integer("5");
	    System.out.println("the Sum value : " + sum + x);
	  

	}

}
