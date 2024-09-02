package core.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	private static Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0),
			new Employee(2, "Bill Gates", 200000.0), new Employee(3, "Mark Zuckerberg", 300000.0) };

	private static List<Employee> empList = Arrays.asList(arrayOfEmps);

	/*
	 * public void whenMapIdToEmployees_thenGetEmployeeStream() { Integer[] empIds =
	 * { 1, 2, 3 }; EmployeeRepository employeeRepository = new
	 * EmployeeRepository(); List<Employee> employees =
	 * Stream.of(empIds).map(employeeRepository::findById).collect(Collectors.toList
	 * ()); }
	 */

	public static void main(String args[]) {
		Stream empStreamFromArray = Stream.of(arrayOfEmps);
		Stream empStreamFromList = empList.stream();
		Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);

		Stream.Builder<Employee> empStreamBuilder = Stream.builder();
		empStreamBuilder.accept(arrayOfEmps[0]);
		empStreamBuilder.accept(arrayOfEmps[1]);
		empStreamBuilder.accept(arrayOfEmps[2]);
		Stream<Employee> empStream = empStreamBuilder.build();

		
	}

	
	
}
