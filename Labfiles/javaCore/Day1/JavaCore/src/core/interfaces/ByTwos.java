package core.interfaces;

import core.Circle;
import core.Numbers;

public class ByTwos implements core.interfaces.Numbers {

	int start;
	int val;

	Circle c = new Circle();
	public ByTwos() {
		start = 0;
		val = 0;
	}

	public int getNext() {
		val += 2;
		return val;
	}

	public void reset() {
		val = start;
	}

	public void setStart(int x) {
		start = x;
		val = x;
	}
}
