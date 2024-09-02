package unit5;

public class Rectangle {
    private int width;
    private int height;

    Rectangle(int w, int h) {
        width = w;
        height = h;
    }

    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + "]";
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + height;
        result = prime * result + width;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rectangle other = (Rectangle) obj;
        if (height != other.height)
            return false;
        if (width != other.width)
            return false;
        return true;
    }
}
