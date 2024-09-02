package core.stream.api;

import java.time.Duration;
import java.time.LocalTime;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelExample {

	public static void main(String[] args) {
		LocalTime startTime = LocalTime.now();
		long count = Stream.iterate(0, n -> n + 1).limit(1_000_000)
				// .parallel() //with this 23s, without this 1m 14s on intel core i7 8th
				// generation with 32 GB memory
				.filter(ParallelExample::isPrime).peek(x -> System.out.format("%s\t", x)).count();
		LocalTime endTime = LocalTime.now();
		Duration duration = Duration.between(startTime, endTime);
		System.out.println("\nTotal: " + count);
		System.out.println("Computed in " + duration.getSeconds() + " seconds");
	}

	public static boolean isPrime(int number) {
		if (number <= 1)
			return false;
		return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
	}

}
