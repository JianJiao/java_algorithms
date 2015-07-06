package recursion;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Boxes{
	Box[] boxes;
	Result[] results;

	public Result heighest(Box[] boxes){
		if(boxes == null){
			return null;
		}
		this.boxes = boxes;
		// @note: have to new the array before you use it 
		this.results  = new Result[boxes.length];
		for(int i = 0; i < boxes.length; i++){
			if(results[i] == null){
				results[i] = heighestHelper(i);
			}
		}
		for(int i = 0; i < boxes.length; i++){
			Arrays.sort(results);
		}
		return results[results.length - 1];
	}

	protected Result heighestHelper(int idx){
		if(idx < 0 || idx >= boxes.length){
			throw new IllegalArgumentException("no such box");
		}

		if(results[idx] != null){
			return results[idx];
		}

		Result result = new Result();
		result.l = new LinkedList<Box>();
		result.height = 0;
		result.l.add(boxes[idx]);
		result.height = boxes[idx].height;
		for(int i = 0; i < boxes.length; i++){
			if(i != idx){
				if(checkValid(idx, i)){
					Result childResult;
					if(results[i] != null){
						childResult = results[i];
					}else{
						childResult = heighestHelper(i);
					}
					// @note: should compare and then assign
					// if this one is bigger, change to this one
					if(childResult.height + boxes[idx].height > result.height){
						// @note: I think there is a problem: should delete the previous one
						// a better way would be first deal with all children: find the max among 
						// all children, and then construct the result
						result.l.addAll(childResult.l);
						result.height = childResult.height + boxes[idx].height;
					}
				}
			}
		}
		results[idx] = result;
		return result;
	}


	protected boolean checkValid(int under, int above){
		if(boxes[under].height > boxes[above].height && boxes[under].width > boxes[above].width 
			&& boxes[under].length > boxes[above].length){
			return true;
		}
		return false;
	}

}

