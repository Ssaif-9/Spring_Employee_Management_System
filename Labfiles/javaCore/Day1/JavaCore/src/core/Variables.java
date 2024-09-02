package core;

public class Variables {

	public static void main(String[] args) {
		int x = 10; // known to all code within main x = 10;
		int intArrays[]=new int[1000];
		int y2=~1;
		//intArrays [0][2]= 3;
		double doubleArrays[]= {1.0,2.,3.1};
		
		if (x == 10) { // start new scope
			int y = 20; // known only to this block
			// x and y both known here.
			System.out.println("x and y: " + x + " " + y);
			x = y * 2;
		} // y = 100; // Error! y not known here // x is still known here.
			 System.out.println("x is " + x);
			 //System.out.println("intArrays is " + intArrays[0][2]);
			 System.out.println("doubleArrays is " + doubleArrays[1]);
			 for (int i=0;i<intArrays.length;i++) {
				 intArrays[i] +=1;
			 }
			 System.out.println("The Min Value of the array is: " + y2);
			 

	}

}
