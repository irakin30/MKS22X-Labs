public class Driver{
  public static void main(String[] args) {
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
    QueenBoard b = new QueenBoard();
    int[] test = {1,2,3,4,5,6,7,8};
    for(int a : test) {
      b = new QueenBoard(a);
      System.out.println(b.countSolutions());
    }
  }
}
