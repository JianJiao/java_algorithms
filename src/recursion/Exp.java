package recursion;
import java.util.HashMap;

public class Exp{

	HashMap<String, Result> map = new HashMap<String, Result>();


	public int count(String exp, boolean expected){
		// check args
		if(exp == null || exp.length() == 0){
			// @note: exception should be newed!
			throw new IllegalArgumentException("illegal expression");
		}
		// @todo: should also validate the string
		// @note: str.length() is a method, not a field
		Result result = countHelper(exp, 0, exp.length());
		return expected == true ? result.trues : result.falses;
	}
 /** * @param: start, inclusive; end, exclusive
	*/
	protected Result countHelper(String exp, int start, int end){
		String key = exp.substring(start, end);
		// @note: for HashMap, it's containsKey, not contains
		if(map.containsKey(key)){
			return map.get(key);
		}
		// the result
		Result result = new Result();
		// stop:
		if((start + 1) == end){
			if(exp.charAt(start) == '0'){
				result.trues = 0;
				result.falses = 1;
			}else{
				result.trues = 1;
				result.falses = 0;
			}
			map.put(key, result);
			return result;
		}
		// recur: loop:
		for(int i = start + 1; i < end; i += 2){
			// left
			Result subListLeft = countHelper(exp, start, i);
			// right
			Result subListRight = countHelper(exp, i + 1, end);
			// together
			Result loopResult = computeResult(exp, i, subListLeft, subListRight);
			// loop sumation
			result.trues += loopResult.trues;
			result.falses += loopResult.falses;
		}
		map.put(key, result);
		return result;
	}

	protected Result computeResult(String exp, int op, Result left, Result right){
		// check args
		Result result = new Result();
		if(exp.charAt(op) == '&'){
			result.trues = left.trues * right.trues;
			result.falses = (left.trues + left.falses) * (right.trues + right.falses) - result.trues;
		}else if(exp.charAt(op) == '|'){
			result.falses = left.falses * right.falses;
			result.trues = (left.trues + left.falses) * (right.trues + right.falses) - result.falses;
		}else if(exp.charAt(op) == '^'){
			result.trues = left.trues * right.falses;
			result.falses = left.falses * right.trues;
		}
		return result;
	}

	protected class Result{
		protected int trues;
		protected int falses;
	}

}