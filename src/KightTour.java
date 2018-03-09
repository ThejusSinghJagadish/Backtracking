/**
 * 
 */

/**
 * @author thejussinghj
 *
 */
public class KightTour {

	public static void knightTour(int n){
		int[][] board = new int[n][n];
		for(int i=0; i< n; i++){
			for(int j=0; j<n; j++){
				board[i][j] = -1;
			}
		}
		int[] xmoves = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
		int[] ymoves = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
		if(!computePath(0, 0, 0, board, xmoves, ymoves)){
			System.out.println("Path not computed");
		}
		else{
			System.out.println("Path computed");
		}
		display(board);
	}
	private static void display(int[][] board) {
		// TODO Auto-generated method stub
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board.length; j++){
				System.out.print(board[i][j] + "    ");
			}
			System.out.println("");
		}
		
	}
	private static boolean computePath(int count, int i, int j, int[][] board, int[] xmoves, int[] ymoves) {
		// TODO Auto-generated method stub
		if(count == board.length * board.length){
			return true;
		}
		int xpos;
		int ypos;
		
		for(int k=0; k<8; k++){
			xpos = i+xmoves[k];
			ypos = j+ymoves[k];
			if(isSafe(xpos, ypos, board)){
				board[xpos][ypos] = count+1;
				if(computePath(count+1, xpos, ypos, board, xmoves, ymoves))
					return true;
				else
					board[xpos][ypos] = -1;
			}
		}
		
		return false;
	}
	private static boolean isSafe(int i, int j, int[][] board) {
		if(i>=0 && i<board.length && j>=0 && j<board.length && board[i][j] == -1)
			return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dimention = 3;
		knightTour(dimention);
	}

}
