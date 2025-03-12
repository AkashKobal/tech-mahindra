package Presentation;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class FunctionalDemo {
	  public static void main(String[] args) {
	        // 1. Consumer<T>: Consumes input, no return
	        Consumer<String> printMessage = message -> System.out.println("Message: " + message);
	        printMessage.accept("Hello, Functional Interfaces!"); 

	        // 2. Supplier<T>: Produces output, no input
	        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);
	        System.out.println("Random Number: " + randomNumberSupplier.get());

	        // 3. Function<T, R>: Transforms data
	        Function<String, String> toUpperCase = str -> str.toUpperCase();
	        System.out.println("Uppercase: " + toUpperCase.apply("hello"));

	        // 4. Predicate<T>: Takes input, returns boolean
	        Predicate<Integer> isEven = num -> num % 2 == 0;
	        System.out.println("Is 10 even? " + isEven.test(10));

	        // 5. Custom Functional Interface
	        MathOperation addition = (a, b) -> a + b;
	        System.out.println("Sum: " + addition.operate(5, 3));

	        // 6. Function + Consumer together
	        Function<Integer, Integer> squareFunction = x -> x * x;
	        Consumer<Integer> printResult = result -> System.out.println("Square: " + result);
	        int number = 4;
	        printResult.accept(squareFunction.apply(number));

	        // 7. Method References (Static Method)
	        Function<Integer, Integer> methodRefSquare = FunctionalDemo::square;
	        System.out.println("Square using Method Reference: " + methodRefSquare.apply(5));

	        // 8. Method References (Instance Method)
	        FunctionalDemo demo = new FunctionalDemo();
	        Consumer<String> methodRefPrinter = demo::printInstanceMessage;
	        methodRefPrinter.accept("Hello from Method Reference!");

	        // 9. Method References (Arbitrary Object)
	        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
	        names.forEach(System.out::println);

	        // 10. Method Reference (Constructor)
	        Function<String, Person> constructorRef = Person::new;
	        Person p1 = constructorRef.apply("Alice");
	        System.out.println(p1);

	        // 11. Streams API
	        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 20, 10, 60, 70, 80, 90, 100);

	        System.out.println("Filtered (n > 30): " + numbers.stream().filter(n -> n > 30).collect(Collectors.toList()));
	        System.out.println("Mapped (n * 2): " + numbers.stream().map(n -> n * 2).collect(Collectors.toList()));
	        System.out.println("Sorted: " + numbers.stream().sorted().collect(Collectors.toList()));
	        System.out.println("Distinct: " + numbers.stream().distinct().collect(Collectors.toList()));
	        System.out.println("Limited (First 5 numbers): " + numbers.stream().limit(5).collect(Collectors.toList()));
	        System.out.println("Skipped (After first 3 numbers): " + numbers.stream().skip(3).collect(Collectors.toList()));
	        System.out.println("Count of numbers > 50: " + numbers.stream().filter(n -> n > 50).count());
	        numbers.stream().forEach(n -> System.out.print(n + " "));
	        System.out.println();
	        System.out.println("Collected Set: " + numbers.stream().collect(Collectors.toSet()));
	        System.out.println("Sum of all numbers: " + numbers.stream().reduce(0, (a, b) -> a + b));
	        System.out.println("Is there a number > 80? " + numbers.stream().anyMatch(n -> n > 80));
	    }

	    public static int square(int number) {
	        return number * number;
	    }

	    public void printInstanceMessage(String message) {
	        System.out.println(message);
	    }
	}