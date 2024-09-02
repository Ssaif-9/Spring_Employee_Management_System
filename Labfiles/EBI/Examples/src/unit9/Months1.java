package unit9;

public class Months1 {
    public static void main(String[] args) {
        java.util.ArrayList<String> months = new java.util.ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        for (String month : months) {
            System.out.println(month);
        }
    }
}
