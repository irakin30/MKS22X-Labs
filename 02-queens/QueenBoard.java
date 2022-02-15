public class QueenBoard{
  //member variables
  private int[][] board;

  public QueenBoard() {
    this(8);
  }

  public QueenBoard(int n) {
    board  = new int[n][n];
  }
  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _
  *excludes the characters up to the comment(*)
  */

  public String toString(){
    String ans = "";
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        if (board[i][j] == -1) ans += "Q";
        else {
          ans += "_";
        }
        ans += " ";
      }
      ans += "\n";
    }
    return ans;
  }

  public String toStringDebug() {
    String ans = "";
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        if (board[i][j] == -1) {
          ans += "Q";
        }
        else if (board[i][j] == 0) {
          ans += "_";
        }
        else{
          ans += board[i][j];
        }
        ans += " ";
      }
      ans += "\n";
    }
    return ans;
  }
  /**
  *@return true when the queen added correctly, false Otherwise
  *@precondition r and c are valid indices of the board array
  *@postcondition the board is only changed when the function returns true
  * in which case the queen is added and all it's threatened positions are incremented
  */

  public boolean addQueen(int r, int c){
    //check if space is valid
    if (r >= board.length || c >= board[r].length) return false;
    if(board[r][c] != 0) return false;

    //place queen
    board[r][c] = -1;
    r++;

    int ld = c - 1;
    int rd = c + 1;
    while(r < board.length) {
      board[r][c] += 1;
      if (ld >= 0) board[r][ld--] += 1;
      if(rd < board[r].length) board[r][rd++] += 1;
      r++;
    }
    return true;
  }

  /**Remove the queen that was added to r,c
  *@precondition r and c are valid indices of the board array and there is a queen at position r,c
  *@postcondition the board is modified to remove that queen and all it's
  *threatened positions are decremented
  */

  public void removeQueen(int r, int c){
    //check if coordinates are valid
    if (r >= board.length || c >= board[r].length) return;
    if (board[r][c] != -1) return;

    board[r][c] = 0;
    r++;

    int ld = c - 1;
    int rd = c + 1;
    while (r < board.length) {
      board[r][c] -= 1;
      if (ld >= 0)
        board[r][ld--] -= 1;
      if (rd < board[r].length)
        board[r][rd++] -= 1;
      r++;
    }


  }

  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
  *  move the previous queen to the next valid space. This means everyone will generate the same
  *  first solution.
  *@postcondition: the board remains in a solved state.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
  */

  public boolean solve() {
      isEmpty();
      return solve(0, false);
  }

  private void isEmpty() throws IllegalStateException {
    for(int[] a : board) {
        for(int b : a) {
          if (b != 0) throw new IllegalStateException("Board is not empty");
        }
    }
  }

  public boolean solveDebug() {
      isEmpty();
      return solve(0, true);
  }


  private boolean solve(int row, boolean debug) {
      if (row == board.length) {
        return true;
      }
      else {
        for(int col = 0; col < board[row].length; col++) {
          if(addQueen(row, col)) {

            //debug stuff
            if (debug) {
              System.out.println(Text.go(1,1));
              System.out.println(this);//can change this to your debug print as well
              Text.wait(500);
            }

            if (solve(row + 1, debug)) {
              return true;
            }
            else {
              removeQueen(row, col);
            }

          }
        }
      return false;
    }
  }

  /**Find all possible solutions to this size board.
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  */

  public int countSolutions(){
    isEmpty();
    return countSolutions(int row);
  }
}
