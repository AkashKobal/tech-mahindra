package Client;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFunctionalInterface {

	public static void main(String[] args) {
		
		Consumer<Integer> a = (x) -> {
            System.out.println(x);
        };
        
		a.accept(10);
		
		
		Supplier<Double> b = () -> {
			double y = 10.5;
		return y;
		};
		b.get();
		
		Predicate<Integer> c = x ->{
			return x>10;
		};
		System.out.println(c.test(100));
 	}

}
