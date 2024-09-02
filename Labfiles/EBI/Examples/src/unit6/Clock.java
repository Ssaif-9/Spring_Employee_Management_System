package unit6;

public class Clock {
    private int hour;
    private int minute;
    private int second;
    private StringBuilder manufacturer;

    public Clock() {
    }

    public Clock(int h, int m, int s) {
        hour = h;
        minute = m;
        second = s;
        manufacturer = new StringBuilder("");
    }

    public StringBuilder getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(StringBuilder m) {
        m.append(" Corporation");
        manufacturer = m;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int h) {
        if (h > 12)
            h = 24 - h;
        hour = h;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int m) {
        minute = m;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int s) {
        second = s;
    }

    public String toString() {
        return "Clock [hour=" + hour + ", minute=" + minute
                + ", second=" + second + ", man=" + manufacturer + "]";
    }

    protected void finalize() {
        System.out.println("finalize called");
    }
}