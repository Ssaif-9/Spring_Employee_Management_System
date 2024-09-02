package unit19;

public class Deadlock {
	static class Friend {
		private final String name;

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public synchronized void Welcome(Friend fr) {
			System.out.format("%s: %s" + " Welcome Sir !" + "----> " + Thread.currentThread().getName() + "%n",
					this.name, fr.getName());
			fr.WelcomeBack(this);
		}

		public synchronized void WelcomeBack(Friend fr) {
			System.out.format("%s: %s" + " Welcome Back Sir!" + "---->" + Thread.currentThread().getName() + "%n",
					this.name, fr.getName());
		}

		public static void main(String[] args) {
			final Friend john = new Friend("John");
			final Friend clara = new Friend("Clara");
			new Thread(() -> john.WelcomeBack(clara)).start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new Thread(() -> clara.Welcome(john)).start();
		}

	}
}