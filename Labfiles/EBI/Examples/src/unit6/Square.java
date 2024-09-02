package unit6;

public class Square {
    private int length;

    Square(int len) {
        length = len;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + length;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Square other = (Square) obj;
        if (length != other.length)
            return false;
        return true;
    }
}
