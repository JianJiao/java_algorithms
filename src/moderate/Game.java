package moderate;
import java.util.HashSet;
import java.util.Iterator;

/**
*	@wrong: the solotion is wrong!
* shouldn't use set, it exclude duplicates. 
* you could use chained hashtable or arraylist
*/

public class Game{

	public Result evaluate(char[] solution, char[] guess){
		if(solution == null || guess == null){
			throw new IllegalArgumentException();
		}
		if(solution.length != 4 || guess.length != 4){
			throw new IllegalArgumentException("length must be 4");
		}
		HashSet<Character> sSet = new HashSet<Character>();
		HashSet<Character> gSet = new HashSet<Character>();
		int hits = 0;
		int pseudos = 0;
		for(int i = 0; i < 4; i++){
			if(solution[i] == guess[i]){
				hits++;
			}else{
				sSet.add(solution[i]);
				gSet.add(guess[i]);
			}
		}
		if(hits != 4){
			// @note: call iterator doesn't need to provide <>
			Iterator<Character> iter = gSet.iterator();
			// @note: here it should be while, not if, this is supposed to be a loop
			while(iter.hasNext()){
				char color = iter.next();
				if(sSet.contains(color)){
					pseudos++;
					sSet.remove(color);
				}
			}
		}
		Result result = new Result(hits, pseudos);
		return result;
	}

	public static void main(String[] args){
		Game game = new Game();
		Computer computer = new Computer();
		User user = new User();
		char[] solution = computer.giveSolution();
		char[] guess = user.guess();
		System.out.println("solution: ");
		for(int i = 0; i < solution.length; i++){
			System.out.println(solution[i]);
		}
		System.out.println("guess: ");
		for(int i = 0; i < guess.length; i++){
			System.out.println(guess[i]);
		}
		Game.Result result = game.evaluate(solution, guess);
		System.out.println("hits: " + result.hits);
		System.out.println("pseudos: " + result.pseudos);
	}


	public class Result{
		protected int hits;
		protected int pseudos;
		public Result(int hits, int pseudos){
			this.hits = hits;
			this.pseudos = pseudos;
		}
	}

}