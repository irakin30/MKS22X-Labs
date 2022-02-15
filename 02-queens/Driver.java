public class Driver{
  public static void main(String[] args) {
    QueenBoard a = new QueenBoard();
    //System.out.println(a);

    // System.out.println("AddQueen Testing");
    // for(int i = 0; i < 6; i++) {
    //   int r = (int) (Math.random() * 8);
    //   int c = (int) (Math.random() * 8);
    //   System.out.printf("R: %d C: %d \n", r, c);
    //   System.out.println(a.addQueen(r, c));
    //   System.out.println(a.toStringDebug());
    // }
    //
    // System.out.println("RemoveQueen Testing");
    // QueenBoard b = new QueenBoard();
    //
    // for (int i = 0; i < 6; i++) {
    //   int r = (int) (Math.random() * 8);
    //   int c = (int) (Math.random() * 8);
    //   System.out.printf("R: %d C: %d \n", r, c);
    //   System.out.println(b.addQueen(r, c));
    //   System.out.println(b.toStringDebug());
    //
    //   if(Math.random() * 2 > 1) {
    //     System.out.printf("Queen at R: %d C: %d removed \n", r, c);
    //     b.removeQueen(r, c);
    //     System.out.println(b.toStringDebug());
    //   }
    // }
    System.out.println(Text.CLEAR_SCREEN); 
    a.solveDebug();
  }
}
