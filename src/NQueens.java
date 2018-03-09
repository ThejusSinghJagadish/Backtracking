/**
 * 
 */

/**
 * @author thejussinghj
 *
 */
public class NQueens {

	public static void nQueens(int n){
		int[][] board = new int[n][n];
		boolean flag = false;
		if(posQueen(0, board)){
			System.out.println("Queens placed");
			flag = true;
		}
		else{
			System.out.println("Queens not placed");
		}
		if(flag)
			display(board);
	}
	private static boolean posQueen(int row, int[][] board) {
		// TODO Auto-generated method stub
		if(row == board.length)
			return true;
		else{
			for(int col=0; col<board.length; col++){
				if(isSafe(row, col, board)){
					board[row][col] = 1;
					if(posQueen(row+1, board))
						return true;
					board[row][col] = 0;
				}
			}
		}
		return false;
	}
	private static boolean isSafe(int row, int col, int[][] board) {
		for(int i = row-1; i>=0; i--){
			if(board[i][col] == 1)
				return false;
		}
		
		for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
			if(board[i][j] == 1)
				return false;
		}
		
		for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
			if(board[i][j] == 1)
				return false;
		}
		return true;
	}
	private static void display(int[][] board) {
		// TODO Auto-generated method stub
		System.out.println("");
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				
				System.out.print(board[i][j]);
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		nQueens(n);
	}

}
