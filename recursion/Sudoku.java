class Sudoku {
   // Check if it's safe to place a number in a particular position
   public boolean isSafe(char[][] board, int row, int col, int number) {
       // Check column
       for (int i = 0; i < board.length; i++) {
           if (board[i][col] == (char) (number + '0')) {
               return false;
           }
       }
      
       // Check row
       for (int j = 0; j < board.length; j++) {
           if (board[row][j] == (char) (number + '0')) {
               return false;
           }
       }
      
       // Check grid
       int startRow = 3 * (row / 3);
       int startCol = 3 * (col / 3);
      
       for (int i = startRow; i < startRow + 3; i++) {
           for (int j = startCol; j < startCol + 3; j++) {
               if (board[i][j] == (char) (number + '0')) {
                   return false;
               }
           }
       }
      
       return true;
   }
  
   // Recursive helper function to solve the Sudoku puzzle
   public boolean helper(char[][] board, int row, int col) {
       // Base case: If all cells have been filled, return true
       if (row == board.length) {
           return true;
       }
      
       // Determine the next row and column indices
       int nextRow = 0;
       int nextCol = 0;
      
       if (col == board.length - 1) {
           nextRow = row + 1;
           nextCol = 0;
       } else {
           nextRow = row;
           nextCol = col + 1;
       }
      
       // If the current cell is not empty, move on to the next cell
       if (board[row][col] != '.') {
           return helper(board, nextRow, nextCol);
       } else {
           // Try placing numbers from 1 to 9 in the current cell
           for (int i = 1; i <= 9; i++) {
               if (isSafe(board, row, col, i)) {
                   board[row][col] = (char) (i + '0');
                   if (helper(board, nextRow, nextCol)) {
                       return true;
                   } else {
                       board[row][col] = '.';
                   }
               }
           }
       }
                     
       return false;
   }
  
   // Main function to solve the Sudoku puzzle
   public void solveSudoku(char[][] board) {
       helper(board, 0, 0);
   }
}
