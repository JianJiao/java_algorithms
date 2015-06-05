package arrayAndStrings;

public class Test{
	
	public static void main(String args[]){
		UniqueCharacter uniq = new UniqueCharacter();
		String strs[] = new String[4];
		strs[0]= "not aaa";
		strs[1] = "lalalak";
		strs[2] = "klab";
		strs[3] = " what  ";
		for(int i=0; i<4; i++){
			boolean result = uniq.allUnique1(strs[i]);
			System.out.println(result);
		}
		System.out.println("**********");
		for(int i=0; i<4; i++){
			boolean result = uniq.allUnique2(strs[i]);
			System.out.println(result);
		}

		System.out.println("\n*testing permutation");
		Permutation per = new Permutation();
		String str1 = "good";
		String str2 = "bad";
		boolean result = per.isPermutation(str1, str2);
		System.out.println(result);
		result = per.isPermutation(str1, str2);
		System.out.println(result);
		str1 = "lalalalala";
		str2 = "lllaaalala";
		result = per.isPermutation(str1, str2);
		System.out.println(result);
		result = per.isPermutation1(str1, str2);
		System.out.println(result);
		str1 = "";
		str2 = "";
		result = per.isPermutation(str1, str2);
		System.out.println(result);
		result = per.isPermutation1(str1, str2);
		System.out.println(result);

		System.out.println("\n*testing space");
		Space sp = new Space();
		String str = "what are you  expecting from this?";
		char[] content = str.toCharArray();
		sp.replaceSpace(content, 15);
		System.out.println(content);
		char[] content1 = str.toCharArray();
		sp.replaceSpace1(content1, 15);
		System.out.println(content1);

		System.out.println("\n*testing compression");
		Compression comp = new Compression();
		str = "lalalalala";
		System.out.println(comp.compress(str));
		System.out.println(comp.compress1(str));
		str = "abcdefgg";
		System.out.println(comp.compress(str));
		System.out.println(comp.compress1(str));
		str = "pilipalapilia";
		System.out.println(comp.compress(str));
		System.out.println(comp.compress1(str));

		str = "pppllliii";
		System.out.println(comp.compress(str));
		System.out.println(comp.compress1(str));

		str = "fllliiiomgddddddd";
		System.out.println(comp.compress(str));
		System.out.println(comp.compress1(str));

		System.out.println("\n *testing rotate");
		int[][] img = new int[3][3];
		Test.initializeMatrix(img);
		Test.printDeterminant(img);
		Rotate rot = new Rotate();
		rot.rotate(img);
		Test.printDeterminant(img);

		img = new int[9][9];
		Test.initializeMatrix(img);
		Test.printDeterminant(img);
		rot.rotate(img);
		Test.printDeterminant(img);

		Test test = new Test();
		test.testSetZero();
	}


	public void testSetZero(){
		System.out.println("\n*testing setZero");
		SetZero sz = new SetZero();
		int[][] mat = {{1,2,3,4,5}, {4,5,6,7,7}, {4,5,6,0,3}};
		Test.printMatrix(mat);
		sz.setZero(mat);
		Test.printMatrix(mat);
		mat = new int[][] {{1,2,3,4,5},{1,2,3,0,5}, {1,2,3,0,5}, {0,0,0,2,3}};
		Test.printMatrix(mat);
		sz.setZero(mat);
		Test.printMatrix(mat);

	}

	// @assume: intput array is matrix
	public static void initializeMatrix(int[][] img){
		int N = img.length;
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				img[i][j] = N*i + j;
			}
		}
	}
	// @assume: input array is a determinant 
	public static void printDeterminant(int[][] img ){
		System.out.println();
		int N = img.length;
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(img[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	// @assume: input array is a matrix
	// and it's not null 
	public static void printMatrix(int[][] mat){
		System.out.println();
		int M = mat.length;
		int N = mat[0].length;
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}















}