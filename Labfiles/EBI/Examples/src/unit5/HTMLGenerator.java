package unit5;

public class HTMLGenerator {

    public static String generateHTML(String title) {
        StringBuilder builder = new StringBuilder(100);

        builder.append("<html>");
        builder.append("<head><title>");
        builder.append(title);
        builder.append("</title></head>");
        builder.append("<body>");
        builder.append("<h1>");
        builder.append(title);
        builder.append("</h1>");
        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateHTML("The Web Page"));
    }
}