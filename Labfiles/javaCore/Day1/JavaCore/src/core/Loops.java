package core;

public class Loops {

	public static void main(String[] args) {
		int x =5;
		outer: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j > i) {
					System.out.println();
					break outer;
				}
				System.out.print("	" + (i * j));
							}
		}
		System.out.println();
					
	}

}
