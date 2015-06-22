package sortingAndSearching;

public class Tests{

	public static void main(String[] args){
		Tests test = new Tests();
		test.testMerge();
	}

	public void testMerge(){
		end();
		start("merge");
		Merge m = new Merge();
		int[] target = {1, 2, 3, 5, 7, 9, 23, 0, 0, 0, 0, 0};
		int[] src = {3, 4, 5, 6, 7};
		m.merge(src, target, 7);
		for(int i = 0; i < target.length; i++){
			System.out.print(target[i] + ", ");
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