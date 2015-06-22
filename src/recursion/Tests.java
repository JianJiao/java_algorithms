package recursion;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class Tests{

	public static void main(String[] args){
		Tests test = new Tests();
		test.testStairPattern();
		test.testGridRobot();
		test.testMagicIndex();
		test.testSubSets();
		test.testPermutation();
		test.testParentheses();
		test.testPaintFill();
		test.testCents();
		test.testEightQueen();
		test.testBoxes();
		test.testExp();
		// test.testExpression();
	}

	// public void testExpression(){
	// 	end();
	// 	start("expression");
	// 	Expression exp = new Expression();
	// 	System.out.println(exp.count("0|1&1&0", '1'));
	// 	end();
	// }

	public void testExp(){
		end();
		start("exp");
		Exp exp = new Exp();
		int result = exp.count("1|1&0&0", true);
		// int result = exp.count("1|1", false);
		System.out.println(result);
		end();
	}

	public void testBoxes(){
		end();
		start("boxes");
		Boxes bs = new Boxes();
		Box[] bss = new Box[3];
		for(int i = 0; i < 3; i++){
			//@problem here: what is height 0?
			Box b = new Box();
			b.height = i;
			b.width = i;
			b.length = i;
			bss[i] = b;
		}
		Result result = bs.heighest(bss);

		System.out.println(result.l.get(0).height);
		System.out.println(result.l.get(1).height);


		end();
	}

	public void testEightQueen(){
		end();
		start("eight queen");
		EightQueen eq = new EightQueen();
		eq.printQ();
		end();
	}

	public void testCents(){
		end();
		start("cents");
		Cents cents = new Cents();
		int result = cents.cents(11);
		System.out.println(result);

		end();
	}

	public void testPaintFill(){
		end();
		start("paint fill");
		PaintFill pf = new PaintFill();
		int[][] screen = new int[4][4];
		screen[0][1] = 1;
		screen[0][2] = 1;
		screen[1][0] = 1;
		screen[1][2] = 1;
		screen[1][3] = 1;
		screen[2][0] = 1;
		screen[2][3] = 1;
		for(int i = 0; i < 4; i++){
			screen[3][i] = 1;
		}
		printArray(screen);
		pf.paintFill(screen, 2, 1, 3);
		System.out.println();
		printArray(screen);
		end();
	}

	public void printArray(int[][] arr){
		int rowDim = arr.length;
		int colDim = arr[0].length;
		for(int i = 0; i < rowDim; i++){
			for(int j = 0; j < colDim; j++){
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public void testParentheses(){
		end();
		start("parentheses");
		Parentheses p = new Parentheses();
		p.printParentheses(4);
		System.out.println();
		p.printParentheses(1);
		System.out.println();
		p.printParentheses(0);
		System.out.println();
		p.printParentheses(2);


		end();
	}

	public void testPermutation(){
		end();
		start("permutation");
		Permutation per = new Permutation();
		List<String> l = per.permutation("rane");
		System.out.println(l);

		end();
	}

	public void testSubSets(){
		end();
		start("subsets");
		Subsets ss = new Subsets();
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(2);
		set.add(3);
		set.add(7);
		List<Set> l = ss.subSets(set);
		System.out.println(l);



		end();
	}



	public void testMagicIndex(){
		end();
		start("magic index");
		MagicIndex mi = new MagicIndex();
		int[] arr;
		arr = new int[0];
		System.out.println(mi.find(arr));
		arr = new int[1];
		arr[0] = 0;
		System.out.println(mi.find(arr));
		arr = new int[4];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		System.out.println(mi.find(arr));
		arr = new int[4];
		arr[0] = -3;
		arr[1] = 1;
		arr[2] = 5;
		System.out.println(mi.find(arr));
		arr = new int[4];
		arr[0] = -3;
		arr[1] = 1;
		arr[2] = 5;
		System.out.println(mi.findWithDup(arr));
		arr[0] = 0;
		System.out.println(mi.findWithDup(arr));
		arr = new int[0];
		System.out.println(mi.findWithDup(arr));
		arr = new int[4];
		arr[0] = -3;
		arr[1] = -3;
		arr[2] = 2;
		System.out.println(mi.findWithDup(arr));


		end();
	}

	public void testStairPattern(){
		end();
		start("stair pattern");
		StairPattern sp = new StairPattern();
		System.out.println(sp.dynaPatterns(5));
		System.out.println(sp.dynaPatterns(6));


		end();
	}

	public void testGridRobot(){
		end();
		start("grid robot");
		GridRobot gr = new GridRobot();
		System.out.println(gr.countWays(2, 2));
		System.out.println(gr.findPath(2,2));

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