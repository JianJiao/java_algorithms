package moderate;
import java.util.List;

public class Test{
	public static void main(String[] args){
		end();
		start("tic tac toe");
		TicTacToe ttt = new TicTacToe();
		char[][] board = {
			{'o', 'o', 'x'},
			{'o', 'o', 'x'},
			{'x', 'x', 'x'}
		};
		boolean result = ttt.hasWon(board, 'x');
		System.out.println(result);

		end();

		Test test = new Test();
		test.testTrailingZeros();
		test.testMax();
		test.testSortPartial();
		test.testPhrase();
		test.testSum();
		test.testRand();
		test.testSumTo();
	}

	public void testSumTo(){
		end();
		start("sum to");
		SumTo st = new SumTo();
		int[] arr = {1,2,3,4,5,6,7,2,3,2,2,1,1};
		List<int[]> list = st.find(arr, 4);
		for(int[] result : list){
			for(int i = 0; i < 2; i++){
				System.out.print(result[i] + ", ");
			}
			System.out.println();
		}



		end();
	}

	public void testRand(){
		end();
		start("rand");
		Rand rand = new Rand();
		int result = rand.rand7();
		System.out.println(result);


		end();
	}

	public void testSum(){
		end();
		start("sum");
		ContigiousSum cs = new ContigiousSum();
		int[] arr = {1,2,-3, -5, 4, -3, 5, -9, 8};
		int result = cs.contigiousSum(arr);
		result = cs.contigiousSum1(arr);
		System.out.println(result);


		end();
	}

	public void testPhrase(){
		end();
		start("basicPhrase");
		PhraseOfInteger poi = new PhraseOfInteger();
		String result = poi.basicPhrase(908).toString();
		System.out.println(result);

		end();
		start("print");
		poi.print(-209800207);


		end();
	}


	public void testSortPartial(){
		end();
		start("sort partial");
		SortPartial sp = new SortPartial();
		int[] ints = {1, 2, 3, 5, 4, 6, 2, 20, 7, 13, 7, 15, 18, 20, 20, 20, 50};
		// @note: use the class, not the instance
		SortPartial.Result result = sp.find(ints);
		System.out.println(result.m);
		System.out.println(result.n);


		end();
	}

	public void testMax(){
		end();
		start("max");

		Max max = new Max();
		int result = max.max(44, 77);
		System.out.println(result);
		result = max.max1(44, 4);
		System.out.println(result);

		end();
	}

	public void testTrailingZeros(){
		end();
		start("trailing zeros");
		TrailingZeros tz = new TrailingZeros();
		int result = tz.trailingZeros(25);
		System.out.println(result);
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