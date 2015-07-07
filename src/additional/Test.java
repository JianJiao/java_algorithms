package additional;

public class Test{

	public static void main(String[] args){
		System.out.println("en?");
		Test test = new Test();
		test.testCircularArray();
	}

	public void testCircularArray(){
		end();
		start("circular array");
		CircularArray<Integer> ca = new CircularArray<Integer>(5);
		// @note: Integer array and int array cannot be autoboxed
		Integer[] ints = new Integer[5];
		for(int i = 0; i < 5; i ++){
			ints[i] = i;
		}
		ca.array = ints;
		for(int i : ca){
			System.out.println(i);
		}

		start("fengexian");

		ca.rotateRight(4);
		for(int i : ca){
			System.out.println(i);
		}

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