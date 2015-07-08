package moderate;

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