package unit11;

import java.io.File;
import java.io.IOException;

public class FileInfo {
    public static void main(String[] args) {
        File f = new File("input.txt");
        System.out.printf("The length of %1s is %2d bytes.%n",
                f.getName(), f.length());

        try {
            System.out.printf("%1s has a full path of %2s.%n",
                    f.getName(), f.getCanonicalPath());
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
