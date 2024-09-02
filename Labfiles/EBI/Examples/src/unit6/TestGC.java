package unit6;

public class TestGC {
    public static void main(String[] args) {
        Clock[] clocks = new Clock[101];
        for (int i = 0; i < clocks.length; i++) {
            clocks[i] = new Clock();
            System.out.println("Clock created");
            clocks[i] = null;
            // System.gc();
        }

    }
}