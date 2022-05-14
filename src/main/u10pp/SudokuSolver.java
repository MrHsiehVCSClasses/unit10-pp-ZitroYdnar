package u10pp;
public class SudokuSolver{

    // declare variables
    static int rowSize;
    static int colSize;
    static int [][] solution;
    static boolean pass;
    

    // Solves the puzzle that is given
    public static int[][] solve(int[][] puzzle) {

        // declare small array 1x1 array. 
        int[][] oneByOne = new int[1][1];
        oneByOne[0][0] = 1;

        // initiate row and col 
        // sets the solved puzzle to the puzzle given
        rowSize = puzzle.length;
        colSize = puzzle[0].length;
        solution = puzzle;

        // if puzzle is a 1x1 then it just return 1
        if (rowSize == 1 && colSize == 1) {
            return oneByOne;
        } 
        else if (run(solution, 0, 0)) {
            return solution;
        }
      
        int[][] somthing = new int[1][1];
        return somthing;
        
    }

    public static boolean run(int solution[][], int row, int col) {
        if (row == rowSize - 1 && col == rowSize){
			return true;
        }

		if (col == rowSize) {
			row++;
			col = 0;
		}

		if (solution[row][col] != 0){
			return run(solution, row, col + 1);
      }
		for (int num = 1; num < 10; num++) {
			if (isSafe(solution, row, col, num)) {
				solution[row][col] = num;
        }
			if (run(solution, row, col + 1)){
				return true;
			}
			solution[row][col] = 0;
		  }
		return false;
    }


	// function that prints out the outcome
	static void print(int[][] solution)
	{
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < rowSize; j++){
				System.out.print(solution[i][j] + " ");
			System.out.println();
        }
		}
	}

  // function that checks if the square allows that number to be there
	static boolean isSafe(int[][] solution, int row, int col, int num)
	{
        // check row first 
		for (int x = 0; x <= (rowSize - 1); x++){
			if (solution[row][x] == num){
				return false;
        }
    }  
        // check column second
		for (int x = 0; x <= (rowSize - 1); x++){
			if (solution[x][col] == num){
				return false;
      }
    }

      //checks the row and even
    if (solution.length % 2 == 0) {
  		int startRow = row - row % 2, startCol = col - col % 2;
  		for (int i = 0; i < 2; i++){
  			for (int j = 0; j < 2; j++){
  				if (solution[i + startRow][j + startCol] == num){
  					return false; 
          }
        }    
      }
    }  
    // Checks the odd nums 
    else if (solution.length % 3 == 0) {
		  int startRow = row - row % 3, startCol = col - col % 3;
  		for (int i = 0; i < 3; i++){
  			for (int j = 0; j < 3; j++){
  				if (solution[i + startRow][j + startCol] == num){
  					return false;
            }
          }
      }
    }
		return true;
	}

}