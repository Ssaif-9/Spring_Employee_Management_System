package unit19;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DateTimeApp extends JFrame implements Runnable {
	Thread th;
	Date d = new Date();
	JLabel center = new JLabel("The new date is " + d.toString());

	public DateTimeApp() {
		this.setTitle(d.toString());
		th = new Thread(this);
		th.start();
	}

	public static void main(String[] args) {
		DateTimeApp app = new DateTimeApp();
		app.setBounds(50, 50, 600, 400);
		app.setVisible(true);
	}

	public void run() {
		while (true) {
			d = new Date();
			this.setTitle(d.toString());
			this.add(center);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // you’ll need to catch an exception here
		}
	}
}
