package recursion;
import java.util.ArrayList;

public class Parentheses{

	public void printParentheses(int n){
		ArrayList<Character> l = new ArrayList<Character>();
		printHelper(n, 0, 0, l);
	}

	protected void printHelper(int n, int left, int right, ArrayList<Character> l){
		if(left < 0 || left > n || right < 0 || right > n){
			throw new IllegalArgumentException("left and right count out of bound");
		}
		if(left == n && right == n){
			for(int i = 0; i < l.size(); i++){
				System.out.print(l.get(i));
			}
			System.out.println();
			return;
		}
		// check if you can add left parentheses
		if(left < n){
			// add left
			l.add('(');
			printHelper(n, left + 1, right, l);
			// @note: have to add it back when backtracking if you are using the same one,
			// like a list or a set or a string builder, not a copy for everyone
			l.remove(l.size() - 1);
		}
		// check if you can add right parentheses
		if(right < n && right < left){
			l.add(')');
			printHelper(n, left, right + 1, l);
			l.remove(l.size() - 1);
		}
	}
}