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