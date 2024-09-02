package unit19;

import java.util.Random;

public class Producer implements Runnable {

	private Drop drop;

	public Producer(Drop drop) {
		this.drop = drop;
	}

	public void run() {
		String info[] = { "Waking up at 5:00", "Taking a shawer at 5:15", "Taking breakfast at 6:00",
				"Going to work at 6:30" };
		Random random = new Random();
		for (int i = 0; i < info.length; i++) {
			drop.put(info[i]);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
		drop.put("DONE");
	}
}
