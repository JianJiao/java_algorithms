package sortingAndSearching;

public class Tests{

	public static void main(String[] args){
		Tests test = new Tests();
		test.testMerge();
		test.testGroupAnagram();
		test.testSearchRoastedSorted();
		test.testFindWithEmptyString();
		test.testSearchSortedMatrix();
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