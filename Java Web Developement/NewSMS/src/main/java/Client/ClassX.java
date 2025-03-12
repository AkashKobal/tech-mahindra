package Client;
import java.util.function.Consumer;

public class ClassX {
	public static void method1() {
		System.out.println("Method1");
		
	}
	
	public static void method2(int a) {
		System.out.println("Method2" + a);
	}
	public static void main(String[] args) {
	
		ClassX.method1();
		ClassX.method2(10);
		
		Consumer<Integer> a = ClassX.method1();
		a.accept(10);
		
		// two stream
		
	}
	
}
