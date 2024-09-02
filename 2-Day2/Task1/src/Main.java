import java.util.function.Function;

public class Main {
    public double convertToFahrenheit (double Celsius  ) {
        return (Celsius * (1.8) )+ 32.0;
    }
    public static void main(String[] args) {
        Main main = new Main();
        double tempCelsius = Double.parseDouble(args[0]);

        Function<Double,Double> convert = (Double) -> {
            double tempFahrenheit = main.convertToFahrenheit(tempCelsius);
            System.out.printf("Fahrenheit Temperature : %f F.\nCentigrade Temperature : %f C.\n",tempFahrenheit,tempCelsius);
            return tempFahrenheit;
        };

        convert.apply(tempCelsius);

    }
}