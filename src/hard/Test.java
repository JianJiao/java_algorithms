package hard;
import java.util.ArrayList;
import java.util.HashSet;

public class Test{

	public static void main(String[] args){
		Test test = new Test();
		test.testAddition();
		test.testNumberOf2s();
		test.testLongest();
		test.testSuffixTree();
		test.testMedian();
		test.testWordLadder();
		test.testWordLadderImproved();
		test.testMaxSquare();
		test.testMax();
		test.testMaxSum();


	}

	public void testMaxSum(){
		end();
		start("max sum");
		MaxSum ms = new MaxSum();
		int[][] mat = {
			{-1, -2, 3, 4, 5, 6},
			{0, 0, -1, 1, 1, 2},
			{0, 0, 0, 3, 2, 1},
			{0, 0, 0, -3, 2, -1},
			{0, 0, 0, -3, 2, -1},
			{0, 0, 0, -3, 2, -1}
		};
		int[][] result = ms.maxSum(mat);
		System.out.println(result.length + " " + result[0].length );
		// for(int i = 0; i < 6; i++){
		// 	System.out.println(result[0][i]);
		// }
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 4; j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		end();
	}

	public void testMax(){
		end();
		start("max");
		Max max = new Max();
		int[][] square = {
			{0,0,0,0,0},
			{0,0,1,1,1},
			{0,0,1,1,1},
			{0,0,1,1,1},
			{0,0,0,0,0},
		};
		int[][] result = max.max(square);
		System.out.println(result.length);
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(result[i][j] + ", ");
			}
			System.out.println();
		}

		end();
	}

	public void testMaxSquare(){
		end();
		start("max square");
		MaxSquare ms = new MaxSquare();
		boolean[][] init = {{true, true, true, true, true},
												{true, false, false, false, false},
												{true, false, true, false, true}, 
												{true, false, false, false, true},
												{true, true, true, true, true}};
		boolean[][] result = ms.maxSquare(init);
		System.out.println(result.length);
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(result[i][j] + ", ");
			}
			System.out.println();
		}


		end();
	}

	public void testWordLadderImproved(){
		end();
		start("word ladder improved");
		WordLadderImproved wli = new WordLadderImproved();
		HashSet<String> set = new HashSet<String>();
		set.add("buti");
		set.add("fuck");
		set.add("auti");
		set.add("atti");
		set.add("attd");
		ArrayList<String> result = wli.getPath("buti", "attd", set);
		System.out.println(result);


		end();
	}

	public void testWordLadder(){
		end();
		start("word ladder");
		WordLadder wl = new WordLadder();
		HashSet<String> set = new HashSet<String>();
		set.add("buti");
		set.add("fuck");
		set.add("auti");
		set.add("atti");
		set.add("attd");
		ArrayList<String> list = wl.getPath("buti", "attd", set);
		System.out.println(list);

		end();
	}

	public void testMedian(){
		end();
		start("median");
		Median m = new Median();
		m.insert(5);
		m.insert(5);
		m.insert(10);
		m.insert(30);
		m.insert(-3);

		int result = m.median();
		System.out.println(result);


		end();
	}

	public void testSuffixTree(){
		end();
		start("suffix tree");
		SuffixTree tree = new SuffixTree("bibsbi");
		ArrayList<Integer> list = tree.search("bi");
		System.out.println(tree.root.map.get('b').indices);
		System.out.println(list);

		end();
	}

	public void testLongest(){
		end();
		start("longest");
		Longest longest = new Longest();
		String[] strs = {"a", "abc", "abcde", "de", "abcdefghc", "fghc"};
		String result = longest.longest(strs);
		System.out.println(result);

		end();
	}

	public void testNumberOf2s(){
		end();
		start("number of 2s");
		NumberOf2s no = new NumberOf2s();
		int result = no.number(22);
		System.out.println(result);


		end();
	}


	public void testAddition(){
		end();
		start("addition");
		Addition a = new Addition();
		int result = a.addition(1, -5);
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