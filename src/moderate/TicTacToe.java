package moderate;

public class TicTacToe{

	/**
	*	@assume: the game is 3*3
	*/
	public boolean hasWon(char[][] board, char player){
		if(board == null || board.length == 0){
			return false;
		}
		if(board.length != 3 || board[0].length != 3){
			return false;
		}
		boolean flag = true;
		for(int i = 0; i < 3; i++){
			// @note: where you put this flag is important!
			// has to update it in each iteration
			flag = true;
			for(int j = 0; j < 3; j ++){
				if(board[i][j] != player){
					flag = false;
					break;
				}
			}
			if(flag){
				return true;
			}
		}
		System.out.println("what");

		for(int i = 0; i < 3; i++){
			flag = true;
			for(int j = 0; j < 3; j++){
				if(board[j][i] != player){
					flag = false;
					break;
				}
			}
			if(flag){
				return true;
			}
		}

		flag = true;
		for(int i = 0; i < 3; i++){
			if(board[i][i] != player){
				flag = false;
				break;
			}
		}
		if(flag){
			return true;
		}

		flag = true;
		for(int i = 0; i < 3; i++){
			if(board[i][2-i] != player){
				flag = false;
				break;
			}
		}
		if(flag){
			return true;
		}

		// @note: remember to return;
		return false;
	}
}