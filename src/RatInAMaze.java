/**
 * 
 */

/**
 * @author thejussinghj
 *
 */
public class RatInAMaze {

	public static void findPath(int[][] maze){
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		for(int i=0; i<visited.length; i++){
			for(int j=0; j<visited[i].length; j++){
				visited[i][j] = maze[i][j] == 0;
			}
		}
		if(pathExist(0,0,visited,maze)){
			System.out.println("Path found");
		}
		else{
			System.out.println("Path not found");
		}
		display(maze);
	}
	private static void display(int[][] maze) {
		// TODO Auto-generated method stub
		for(int i=0; i<maze.length; i++){
			for(int j=0; j<maze[0].length; j++){
				System.out.print(maze[i][j] + "   ");
			}
			System.out.println("");
		}
	}
	private static boolean pathExist(int i, int j, boolean[][] visited, int[][] maze) {
		if(i == maze.length-1 && j == maze[0].length-1){
			return true;
		}
		else{
			visited[i][j] = true;
			maze[i][j] = 2;
			if(canMove(i, j+1, visited) && pathExist(i,j+1,visited,maze)){
				return true;
			}
			if(canMove(i+1, j, visited) && pathExist(i+1,j,visited,maze))
				return true;
			maze[i][j] = 1;
		}
		return false;
	}
	private static boolean canMove(int i, int j, boolean[][] visited) {
		if( i< visited.length && j < visited[0].length && !visited[i][j])
			return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze = new int[][]{{1, 0, 0, 0},{1, 1, 0, 1},{0, 1, 0, 0},{1, 1, 1, 1},{1, 0, 0, 0}};
		findPath(maze);
	}

}
