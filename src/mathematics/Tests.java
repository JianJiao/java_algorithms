package mathematics;

public class Tests{

	public static void main(String[] args){
		end();
		start("Operations");
		Operations op = new Operations();
		System.out.println(op.negative(3));
		System.out.println(op.negative(-4));
		System.out.println(op.negative(0));
		int result = op.multiply(3, 5);
		System.out.println(result);
		result = op.multiply(0, 4);
		System.out.println(result);
		result = op.multiply(-4, 4);
		System.out.println(result);
		result = op.subtract(-4, 4);
		System.out.println(result);
		result = op.subtract(-4, -4);
		System.out.println(result);
		result = op.subtract(4, 1);
		System.out.println(result);
		result = op.divide(4, 1);
		System.out.println(result);
		result = op.divide(4, 5);
		System.out.println(result);
		result = op.divide(15, 5);
		System.out.println(result);
		result = op.divide(-15, 5);
		System.out.println(result);
		result = op.divide(0, 5);
		System.out.println(result);
		result = op.divide(-4, -3);
		System.out.println(result);

		System.out.println(op.negate(0));
		System.out.println(op.negate(-3));
		System.out.println(op.negate(3));
		end();

		end();
		start("number with primes");
		NumberWithPrime nwp = new NumberWithPrime();
		System.out.println(nwp.find(1));
		System.out.println(nwp.find(3));
		System.out.println(nwp.find1(1));
		System.out.println(nwp.find1(10));


		end();
	}




	public static void println(Object obj){
		System.out.println(obj);
	}

	public static void start(String str){
		System.out.println("***testing " + str);
	}

	public static void end(){
		System.out.println();
	}
}