package recursion;

public class EightQueen{


	/**
	*
	*/
	public void printQ(){
		// position[raw] = col
		int[] position = new int[8];
		printQHelper(position, 0);
	}

	protected void printQHelper(int[] position, int level){
		//check arg
		if(level < 0 || level > 7){
			throw new IllegalArgumentException();
		}
		// stop
		if(level == 7){
			for(int i = 0; i < 8; i++){
				if(valid(position, level, i)){
					position[level] = i;
					printB(position);
					return;
				}
			}
		}
		for(int i = 0; i < 8; i++){
			if(valid(position, level, i)){
				position[level] = i;
				printQHelper(position, level + 1);
			}
		}
	}

	protected boolean valid(int[] position, int level, int pos){
		int left = pos - 1;
		int right = pos + 1;
		for(int i = level - 1; i >= 0; i--){
			if(position[i] == left || position[i] == right || position[i] == pos){
				return false;
			}
			left--;
			right++;
		}
		return true;
	}

	protected void printB(int[] position){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(position[i] == j){
					System.out.print("1, ");
				}else{
					System.out.print("0, ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}





	// /**
	// * @better: this approach wastes too much space
	// * @better: since here are just 8 raws, you could just use a loop.
	// */

	// // set to false to indicate there are still position to put queens
	// protected int[] position = new int[8];

	// public void print(){
	// 	boolean board[][] = new boolean[8][8];
	// 	printHelper(0, board);
	// }

	// protected void printHelper(int level, boolean[][] oldBoard){
	// 	if(level > 7 || level < 0 ){
	// 		throw new IllegalArgumentException("level out of boundary");
	// 	}
	// 	if(level == 7){
	// 		for(int i = 0; i < 8; i++){
	// 			if(!oldBoard[7][i]){
	// 				position[level] = i;
	// 				printBoard();
	// 				// @note: remember to return
	// 				return;
	// 			}
	// 		}
	// 	}


	// 	for(int i = 0; i < 8; i++){
	// 		if(!oldBoard[level][i]){
	// 			position[level] = i;
	// 			boolean[][] board = copyBoard(oldBoard);
	// 			setBoard(level, true, board);
	// 			// go to the next level
	// 			printHelper(level + 1, board);
	// 		}
	// 	}
	// }

	// protected boolean[][] copyBoard(boolean[][] board){
	// 	boolean[][] newBoard = new boolean[8][8];
	// 	for(int i = 0; i < 8; i++){
	// 		for(int j = 0; j < 8; j++){
	// 			newBoard[i][j] = board[i][j];
	// 		}
	// 	}
	// 	return newBoard;
	// }

	// /**
	// * @param: option == true, cross it; option == false, free it
	// */
	// protected void setBoard(int level, boolean option, boolean[][] board){
	// 	int self = position[level];
	// 	int left = position[level] - 1;
	// 	int right = position[level] + 1;
	// 	// @note: array index and array length
	// 	for(int i = level + 1; i < 8; i++){
	// 		board[i][self] = option;
	// 		if(left >= 0){
	// 			board[i][left] = option;
	// 		}
	// 		if(right <= 7 ){
	// 			board[i][right] = option;
	// 		}
	// 		left--;
	// 		right++;
	// 	}
	// }


	// protected void printBoard(){
	// 	// @note: array index and array length
	// 	for(int i = 0; i < 8; i++){
	// 		for(int j = 0; j < 8; j++){
	// 			if(position[i] == j){
	// 				System.out.print("1, ");
	// 			}else{
	// 				System.out.print("0, ");
	// 			}
	// 		}
	// 		System.out.println();
	// 	}
	// 	System.out.println();
	// }




}