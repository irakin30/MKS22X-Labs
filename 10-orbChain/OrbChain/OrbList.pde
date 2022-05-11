public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }

  /**
   *complete this method
   */
  void add(OrbNode orb) {
    //insert orb at the end of the list before the last node.
    
    orb.prev = last.prev; 
    orb.next = last; 
    
    if (last.prev != null) {
      (last.prev).next = orb; 
    } 
    
    last.prev = orb; 
  } 
  
  void add(int xcor, OrbNode toBeAdded) {
     return; 
  }
  
  void delete(OrbNode target) {
    if (target == null) return; 
  } 
  
  OrbNode getNodeAt(int x, int y) { 
    OrbNode current = first; 
    while(current != null) {
      if(dist(x, y, current.x, current.y)  < current.radius) {
         return current; 
      }
      current = current.next; 
    }
    return null; 
  }
  

  /**
   *complete this method
   *process all nodes by running move.
   */
  void processAll() {
    OrbNode current = first;
    //advance current to next until it is null, move() each of the nodes
    while(current != null) {
      current.move(); 
      current = current.next; 
    }
  }
  
  /**
   *complete this method
   *Display all nodes by running their display().
   */
  void display() {
    OrbNode current = first; 
    //advance current to next until it is null, display() each of the nodes 
    while (current != null) { 
      current.display();  
      current = current.next; 
    }
  }
}
