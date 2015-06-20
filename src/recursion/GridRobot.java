package recursion;
import java.util.LinkedList;
// @note: many datastructures that are not shipped

public class GridRobot{
	// true if this point is in valid
	boolean[][] invalid = new boolean[10][10];

	/**
	*	@note: internally, x, y represent the distance to the destination point, not 
	*         the coordinates
	*/
	public int countWays(int x, int y){
		int[][] waysAtPoint = new int[x+1][y+1];
		// @note: todo: return
		return countWaysHelper(x, y, waysAtPoint);
	}


	public int countWaysHelper(int x, int y, int[][] waysAtPoint){
		// check args
		if(x < 0 || y < 0){
			return 0;
		}
		if(x == 0 && y == 0){
			return 0;
		}

		if(waysAtPoint[x][y] > 0){
			return waysAtPoint[x][y];
		}

		// stop
		if(x ==0 && y == 1 || x == 1 && y == 0){
			waysAtPoint[x][y] = 1;
			return 1;
		}
		// # of ways if we go down
		int downWays = countWays(x, y - 1);
		// # of ways if we go right
		// @note: check for semicolon once you finished your coding
		int rightWays = countWays(x - 1, y);

		int result = downWays + rightWays;
		waysAtPoint[x][y] = result;

		return result;

	}

	public LinkedList<Integer> findPath(int x, int y){
		LinkedList<Integer> stack = new LinkedList<Integer>();
		if(findPathHelper(x, y, stack)){
			return stack;
		}
		return null;
	}

	/**
	*	from start to end is better, treat x, y as the distance, not the points coordinates
	*/
	public boolean findPathHelper(int x, int y, LinkedList<Integer> stack){
		// check args stop:
		// @note: go beyond the range, false
		if(x < 0 || y < 0){
			return false;
		}
		// if reached the end, return true
		if(x == 0 && y == 0){
			return true;
		}
		// invalid way, return false 
		if(invalid[x][y]){
			return false;
		}
		// check if go down is possible
		boolean down = findPathHelper(x, y - 1, stack);
		if(down){
			// 1 means go down
			stack.push(1);
			return down;
		}
		// check if go right is possible
		boolean right = findPathHelper(x - 1, y, stack);
		if(right){
			// 2 means go right
			stack.push(2);
			return right;
		}
		// no way in both directions, so fuck off
		return false;
	}

}