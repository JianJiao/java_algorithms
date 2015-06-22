package recursion;
import java.util.LinkedList;


// @note: give it a geneirc type
public class Result implements Comparable<Result>{
	int height;
	LinkedList<Box> l;

	public int compareTo(Result result){
		return this.height - result.height;
	}
}