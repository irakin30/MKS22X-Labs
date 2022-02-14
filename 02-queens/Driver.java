public class Driver{
  public static void main(String[] args) {
    QueenBoard a = new QueenBoard();
    System.out.println(a);

    System.out.println(a.addQueen(0,0));
    System.out.println(a.toStringDebug());
    System.out.println(a.addQueen(0,1)); 
  }
}
