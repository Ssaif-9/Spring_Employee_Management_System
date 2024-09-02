package core.java.ebi;

import core.Numbers;

public class Packages implements Numbers{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Packages");
		Packages p = new Packages();
		p.saySomething();
		Numbers.sayHi();
	}

	@Override
	public int getNext() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setStart(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saySomething() {
		// TODO Auto-generated method stub
		System.out.println("saySomething");
	}

}
