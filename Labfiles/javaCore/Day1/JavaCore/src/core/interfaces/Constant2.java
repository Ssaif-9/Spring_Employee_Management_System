package core.interfaces;

public interface Constant2 extends Constants {
	@Override
	default void sayHi() {
		// TODO Auto-generated method stub
		Constants.super.sayHi();
	}

	static int getUniversalID() {
		return 0;
	}


}
