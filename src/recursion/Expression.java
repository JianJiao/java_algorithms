package recursion;
import java.util.LinkedList;
import java.util.HashSet;


public class Expression{






	/**
	* @note: this solution is problematic, see the eval function for detailed explaination.
	*/
	// @note: hashset and char  not together
	HashSet<Character> oprands = new HashSet<Character>();
	HashSet<Character> ops = new HashSet<Character>();

	public Expression(){
		oprands.add('0');
		oprands.add('1');
		ops.add('&');
		ops.add('|');
		ops.add('^');
	}

	public int count(String exp, char result){
		System.out.println("look here");
		char[] test = {'0', '|', '1', '&', '1', '&', '0'};
		eval(test, 5);
		eval(test, 3);
					System.out.println("ee");
					for(int k = 0; k < 7; k++){
						System.out.print(test[k]);
					}
					System.out.println();


		char[] expression = exp.toCharArray();
		if(!valid(expression)){
			throw new IllegalArgumentException("expression not valid");
		}
		LinkedList<Integer> ops = new LinkedList<Integer>();
		for(int i = 1; i < exp.length(); i += 2){
			ops.add(i);
		}
		System.out.println(ops);
		for(int i = 0; i < 3; i++){
			System.out.println(expression[ops.get(i)]);
		}
		LinkedList<Result> results = results(ops, expression);
		int count = 0;
		for(int i = 0; i < results.size(); i++){
			System.out.println(results.get(i).result);
			if(results.get(i).result == result){
				count++;
			}
		}
		return count;
	}

	protected class Result{
		char[] exp;
		char result;

		public Result(char[] exp, char result){
			this.exp = exp;
			this.result = result;
		}
	}


	/**
	* @return an arraylist of results: 0 or 1
	* @param: the ops is a list of indices of the ops in the expression
	*/
	protected LinkedList<Result> results(LinkedList<Integer> ops, char[] expression){
		if(ops == null){
			throw new IllegalArgumentException("ops cannot be null");
		}
		LinkedList<Result> results = new LinkedList<Result>();
		// stop:
		if(ops.size() == 0){
			// last one, only one possibility
			char[] retExp = new char[expression.length];
			for(int i = 0; i < expression.length; i++){
				retExp[i] = expression[i];
			}
			Result result = new Result(retExp, expression[0]);
			results.add(result);
			return results;
		}
		// loop the ops
		for(int i = 0; i < ops.size(); i++){
			int op = ops.remove(i);
			// subset result
			LinkedList<Result> childResults = results(ops, expression);
			// for each result from the subresults, add this op, then place to the result
			for(int j = 0; j < childResults.size(); j++){
					System.out.println("start this result");
					System.out.println("previous");
					for(int k = 0; k < 7; k++){
						System.out.print(childResults.get(j).exp[k]);
					}
					System.out.println("\nok");
				char[] exp = eval(childResults.get(j).exp, op);
				Result result = new Result(exp, exp[op - 1]);
				// if(ops.size() == 2){
					for(int k = 0; k < 7; k++){
						System.out.print(result.exp[k]);
					}
					System.out.println();
				// }
				results.add(result);
				System.out.println(ops);
				System.out.println("and op " + op + "end this one");
			}
			// restore the ops
			ops.add(i, op);
		}
		return results;
	}



	/**
	* @note: @wrong: if you only change two sides of it, it is not right. There might be multiple
	* cells that has already been combined into one, but you are only changing part of it.
	* If you have to compute all the permutations, then create copy of the array each time.
	*/
	protected char[] eval(char[] exp, int idx){
		// todo: remove this
		if(!valid(exp)){
			throw new IllegalArgumentException("illegal expression");
		}
		if(idx % 2 == 0 || idx < 0 || idx >= exp.length){
			throw new IllegalArgumentException("illegal index");
		}
		boolean left = exp[idx - 1] == '0' ? false : true;
		boolean right = exp[idx + 1] == '0' ? false : true;
		if(exp[idx] == '&'){
			char result = left & right == false ? '0' : '1';
			exp[idx - 1] = exp[idx + 1] = result;
		}else if(exp[idx] == '|'){
			char result = left | right == false ? '0' : '1';
			exp[idx -1] = exp[idx + 1] = result;
		}else{
			char result = left ^ right == false ? '0' : '1';
			exp[idx - 1] = exp[idx + 1] = result;
		}
		return exp;
	}


	protected boolean valid(char[] exp){
		if(exp == null || exp.length == 0){
			return false;
		}
		for(int i = 0; i < exp.length; i += 2){
			if(!(oprands.contains(exp[i]))){
				return false;
			}
		}
		for(int i = 1; i < exp.length; i +=2){
			if(!(ops.contains(exp[i]))){
				return false;
			}
		}
		return true;
	}
}