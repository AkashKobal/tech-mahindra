package Client;


@FunctionalInterface
interface X<T extends Number> {
    public abstract void compare(T x, T y);
}

public class Functional_Interface {
    public static void main(String[] args) {
        // Provide two parameters for the lambda expression
        X<Integer> r1 = (x, y) -> {
            System.out.println("Comparing: " + x + " and " + y);
            System.out.println("Result: " + Integer.compare(x, y));
        };
        r1.compare(10, 20);

        X<Float> r2 = (x, y) -> {
            System.out.println("Comparing: " + x + " and " + y);
            System.out.println("Result: " + Float.compare(x, y));
        };
        r2.compare(5.6f, 3.2f);
    }
}
