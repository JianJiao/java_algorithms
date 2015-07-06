package sortingAndSearching;

public class Tests{

	public static void main(String[] args){
		Tests test = new Tests();
		test.testMerge();
		test.testGroupAnagram();
		test.testSearchRoastedSorted();
		test.testFindWithEmptyString();
		test.testSearchSortedMatrix();
		test.testCircuit();
		test.testIntStream();
		test.testIntStreamN();
	}

	public void testIntStreamN(){
		end();
		start("int stream new");
		IntStreamN isn = new IntStreamN();
		for(int i = 0; i < 5; i++){
			isn.track(i);
		}
		isn.track(3);
		isn.track(3);
		int result = isn.getRankOfNumber(3);
		System.out.println(result);


		end();
	}

	public void testIntStream(){
		end();
		start("int stream");
		IntStream is = new IntStream();
		is.track(4);
		is.track(2);
		is.track(9);
		is.track(3);
		is.track(2);
		System.out.println(is.getRankOfNumber(3));


		end();
	}

	public void testCircuit(){
		end();
		start("circuit");
		Person[] pers = new Person[4];
		for(int i = 0; i < 4; i ++){
			pers[i] = new Person(i + 1, i + 1);
		}

		pers[3] = new Person(3, 3);
		Circuit c = new Circuit();
		int result = c.maxTower(pers);
		System.out.println(result);
		end();
	}

	public void testSearchSortedMatrix(){
		end();
		start("sorted matrix");
		int[][] mat = {{1,2,3,4}, {2,3,4,5}, {6,7,8,9},{11,12,33,55}};
		SearchSortedMatrix ssm = new SearchSortedMatrix();
		SearchSortedMatrix.Result result = ssm.find(3, mat);
		System.out.println(result.row + ", " + result.col);


		end();
	}

	public void testFindWithEmptyString(){
		end();
		start("find with empty string");
		FindWithEmptyString fwes = new FindWithEmptyString();
		String[] strs = {"a", "", "", "", "bac","c", "", "", "oma", "rnll", ""};
		int result = fwes.find("oma", strs);
		System.out.println(result);
		end();
	}

	public void testSearchRoastedSorted(){
		end();
		start("roasted 。。。 ==! start");
		SearchRoatedSorted srs = new SearchRoatedSorted();
		int[] arr = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
		int result = srs.find(arr, 9);
		System.out.println(result);



		end();
	}


	public void testGroupAnagram(){
		end();
		start("grouping anagrams");
		GroupAnagram ga = new GroupAnagram();
		String[] strs = {"12345", "23456", "54321", "24365", "123", "231"};
		ga.group(strs);
		for(int i = 0; i < strs.length; i++){
			System.out.print(strs[i] + ", ");
			end();
		}
		end();
		start("sort");
		ga.sort(strs);
		for(int i = 0; i < strs.length; i++){
			System.out.print(strs[i] + ", ");
			end();
		}

		end();
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