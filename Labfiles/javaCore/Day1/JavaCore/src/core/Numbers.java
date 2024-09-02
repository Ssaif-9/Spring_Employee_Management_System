package core;

public interface Numbers {
	public static final int x = 0;
	int getNext();

	void reset();

	void setStart(int x);
	default public void sayHi() { 
		System.out.println("Hi");
	}

}
