package core.interfaces;

public class Demo2 implements Constants{

	public static void main(String[] args) {
		ByTwos twoOb = new ByTwos();
		ByThrees threeOb = new ByThrees();
		Numbers ob ;
		Constants con = new Demo2();
		for (int i = 0; i < 5; i++) {
			ob =  twoOb;
			System.out.println("Next ByTwos value is " + ob.getNext());
			ob = (Numbers) threeOb;
			System.out.println("Next ByThrees value is " + ob.getNext() );
			System.out.println(mon);
			con.sayHi();
		}
	}

}
