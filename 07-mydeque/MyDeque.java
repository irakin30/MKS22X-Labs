import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  /**
   * 
  */
  public MyDeque(){
    this(16); 
  }

  /**
   * 
  */
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[initialCapacity];
    data = d;
    size = 0;
    start = data.length / 2; 
    end = data.length - start; 
  }

  /**
   * @return the amount of elements in the deque.
  */
  public int size(){
      return size;
  }

  public String toString(){
    String ans = "[ "; 
    //wrap-around case
    if (end < start) {
      for (int i = start; i < data.length; i++) {
        ans += data[i] + ", ";
      }  
      for(int i = 0; i < end - 1; i++) {
        ans += data[i] + ", ";
      }
    } 

    //not-wrapped around
    else {
      for(int i = start; i < end - 1; i++) {
        ans += data[i] + ", ";
      }
    }

    ans += data[end] + "]"; 
    return ans; 
  }
  
  private void resize() {
    // + 2 is required for idiot-proofing and even numbers are nice
      E[] newData = (E[]) new Object[(data.length * 2) + 2]; 
     
  }

  /**
   * 
  */
  public void addFirst(E element) throws NullPointerException{
    if(element == null) throw new NullPointerException(); 
  }

  /**
   * 
  */
  public void addLast(E element) throws NullPointerException{
    if(element == null) throw new NullPointerException(); 
  }

  /**
   * @return
  */
  public E removeFirst() throws NoSuchElementException{
      if (size == 0) throw new NoSuchElementException();
      E element = data[start]; 
      data[start] = null; 
      size--; 
      return element; 
  }

  /**
   * @return
  */
  public E removeLast() throws NoSuchElementException{
    if (size == 0) throw new NoSuchElementException();
    E element = data[end];
    data[end] = null;
    size--;
    return element;

  }

  /**
   * Returns the first element in the deque without removing the element.
   * @return the first element of the deque
  */

  public E getFirst() throws NoSuchElementException{
    if (size == 0) throw new NoSuchElementException(); 
    return data[start]; 
  }

  /**
   * Returns the last element in the deque without removing the element.
   * @return the last element of the deque
  */
  public E getLast() throws NoSuchElementException{
    if (size == 0) throw new NoSuchElementException(); 
    return data[end]; 
  }

}
