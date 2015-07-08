package moderate;

public class SwapInPlace{

	//@note: but wait, since java is pass by value, doing this is meaningless
	// doing swap in function for primitives is meaningless
	public static void main(String[] args){
		int a = 5;
		int b = 4;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a: " + a);
		System.out.println("b: " + b);

		System.out.println("second round");
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
}