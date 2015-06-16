package bitManipulation;

public class Tests{
	public static void main(String[] args){
		Tests test = new Tests();
		test.testFractionToBin();
		test.testSameOnes();
		test.testSameOnesNext();
		test.testSameOnesMath();
		test.testBitsToFlip();
		test.testSwapOddEven();
		test.testFindMissing();
	}

	public void testFindMissing(){
		end();
		start("find missing");
		FindMissing fm = new FindMissing();
		// @note: sequence of array, and number digits
		// 	they count from different direction
		// int[] a = {0, 1, 3, 4, 5, 6};
		// FindMissing.Arr arr = fm.new Arr(a);
		// int bit = arr.getFrom(0, 3);
		// System.out.println(bit);
		// end();
		int[] a = {0, 2, 1,  3,  5, 6};
		Arr arr = new Arr(a);
		int result = fm.findMissing(arr);
		System.out.println(result);

		end();

	}

	public void testSwapOddEven(){
		end();
		start("swap odd and even bits");
		SwapOddEven soe = new SwapOddEven();
		int num = 9;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(soe.swap(num)));

		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(soe.swap1(num)));
		end();
	}

	public void testBitsToFlip(){
		end();
		start("bits to flip");
		BitsToFlip btf = new BitsToFlip();
		System.out.println(Integer.toBinaryString(3));
		System.out.println(Integer.toBinaryString(5));
		System.out.println(btf.bitsToFlip(3, 5));
		System.out.println(Integer.toBinaryString(7));
		System.out.println(Integer.toBinaryString(12));
		System.out.println(btf.bitsToFlip(7, 12));


		end();
	}


	public void testSameOnes(){
		end();
		start("same ones");
		SameOnes so = new SameOnes();
		System.out.println(Integer.toBinaryString(3));
		so.nextSmallestAndLargest(3);

		end();
	}

	public void testSameOnesNext(){
		end();
		start("same ones next");
		SameOnes so = new SameOnes();
		System.out.println(Integer.toBinaryString(3));
		so.next(3);


		end();
	}

	public void testSameOnesMath(){
		end();
		start("same ones Math");
		SameOnes so = new SameOnes();
		System.out.println(Integer.toBinaryString(3));
		so.nextMath(3);
		so.prevMath(12);

		end();
	}

	public void testFractionToBin(){
		end();
		start("fraction to binary representation");
		FractionToBin ftb = new FractionToBin();
		ftb.fractionToBin(0.75);



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