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
  }

  /**
   *  @return the amount of elements in the deque.
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
    // because you can have an even number of space on both sides
    @SuppressWarnings("unchecked")
    E[] newData = (E[]) new Object[(data.length * 2) + 2]; 
    int newStart = (data.length)/2 + 1; 
    
    //Wrapped around case
    if(end < start) {
        int j = newStart;
        for(int i = start; start < data.length; i++, j++) {
          newData[j] = data[i]; 
        }
        for(int i = 0; i < end; i++, j++) {
          newData[j] = data[i]; 
        }
    }

    //not Wrapped around case
    else {
      for(int i = 0; start < data.length; i++) {
        newData[newStart + i] = data[i]; 
      }
    }

    start = newStart; 
    end = newStart + data.length; 
    data = newData; 
  }

  /**
   * 
  */
  public void addFirst(E element) {
    if(element == null) throw new NullPointerException();
    if(size + 1 > data.length) resize(); 

    if (start - 1 < 0) {
      data[data.length - 1] = element;
      start = data.length - 1;
    }
    else {
      data[start - 1] = element;
      start--;
    }
  }

  /**
   * 
  */
  public void addLast(E element) {
    if(element == null) throw new NullPointerException(); 
    if (size + 1 > data.length) resize();

    if (end + 1 > data.length - 1) {
      data[0] = element;
      end = 0;
    } 
    else {
      data[end + 1] = element;
      end++;
    }
  }

  /**
   * @return
   * @throws
  */
  public E removeFirst() {
      if (size == 0) throw new NoSuchElementException();
      E element = data[start]; 
      data[start] = null; 
      start++;
      size--; 
      return element; 
  }

  /**
   * @return
   * @throws
  */
  public E removeLast() {
    if (size == 0) throw new NoSuchElementException();
    E element = data[end];
    data[end] = null;
    end--;
    size--;
    return element;
  }

  /**
   * Returns the first element in the deque without removing the element.
   * @return the first element of the deque
   * @throws
  */

  public E getFirst() {
    if (size == 0) throw new NoSuchElementException(); 
    return data[start]; 
  }

  /**
   * Returns the last element in the deque without removing the element.
   * @return the last element of the deque
   * @throws
  */

  public E getLast() {
    if (size == 0) throw new NoSuchElementException(); 
    return data[end]; 
  }
}
