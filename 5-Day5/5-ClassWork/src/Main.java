import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream.*;

public class Main {
    private static Employee[] employeeArray = {
            new Employee(1, "Seif Sultan " , 10200.9),
            new Employee(2, "Abdo Hassan"  , 12000.9),
            new Employee(3, "Mazeen Nasser", 15320.2),
            new Employee(4, "Ahmed Shrief" , 15963.2)
    };
    private static List<Employee> employeeList = Arrays.asList(employeeArray);


    public static void main(String[] args) {


//        Stream<Employee> empStreamFromArray = Stream.of(employeeArray);
//        Stream<Employee> empStreamFromList = employeeList.stream();
//        Stream.of(employeeArray[0],employeeArray[1],employeeArray[2]);
//
//        Stream.Builder <Employee> empStreamBuilder = Stream.builder();
//        empStreamBuilder.accept(employeeArray[0]);
//        empStreamBuilder.accept(employeeArray[1]);
//        empStreamBuilder.accept(employeeArray[2]);
//
//        Stream<Employee> empStream = empStreamBuilder.build();
//

//





    }
}

//        int[] values = {3, 6, 9, 12, 15, 18, 15, 12, 9, 6, 3};
//        System.out.print("Original Values : ");
//        IntStream.of(values).forEach(value -> System.out.printf("%d ", value / 3));
//        System.out.println();
//        System.out.printf("Count : %d%n ", IntStream.of(values).count());
//        System.out.printf("Min   : %d%n ", IntStream.of(values).min().getAsInt());
//        System.out.printf("Max   : %d%n ", IntStream.of(values).max().getAsInt());
//        System.out.printf("Sum   : %d%n ", IntStream.of(values).sum());
//        System.out.printf("%nAverage : %f%n ", IntStream.of(values).average().getAsDouble());
//
//        System.out.printf("Sum of square via reduce method : %d%n ", IntStream.of(values).reduce(0, (x, y) -> x + y * y));
//
//        System.out.print("%nEven numbers : ");
//        IntStream.of(values).filter(value -> value % 2 == 0).sorted().distinct().forEach(value -> System.out.print(value + " "));
//        System.out.print("%nOdd Numbers : ");
//        IntStream.of(values).filter(value -> value % 2 != 0).map(value -> value * 10).sorted().forEach(value -> System.out.print(value + " "));
//        System.out.printf("%nSum of range 1~10 : %d", IntStream.of(values).filter(value -> value <= 10 && value >= 1).sum());