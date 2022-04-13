  int x,y;
  int MODE; 
  
  void setup(){
           size(800,800);
           MODE = 3;
           x = width/2;
           y = height/2;
  }
  void draw(){
           background(255);
           x = change(x);
           y = change(y);
           avatar(x,y);
           avatar(mouseX, mouseY); 
  }
  int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change value by +1, 0, or -1 randomly
     mode 3: change value by +1 , but if it goes past the end of the screen ,
           wrap back around to the other end of the screen.
    */

    switch(MODE){
     case 1:
       return (int) random(height);
     case 2:
       return value + (int) random(3) - 1;
     case 3:
       return (value < height) ? value + 1: 0;
     default:
       return width/2;
    }
  }
  
  void mouseClicked() {
    MODE = (MODE < 3)? MODE + 1 : 1; 
    println();
  }
  void avatar(int x, int y) {
    smile(x, y, 150);
  }
  
  //I based this off of a sticker I randomly had on my desk
  void smile(int x, int y, int size) {
    //overall head 
    fill(25, 156, 123);
    ellipse(x,y, size, size);
  
    //eyes 
    fill(0); 
    int eyeWidth = size / 10; 
    int xOffset = size / 4; 
    int yOffset = size / 5;
    
    ellipse(x - xOffset, y - yOffset, eyeWidth, eyeWidth); 
    ellipse(x + xOffset, y - yOffset, eyeWidth, eyeWidth); 
    
    //smile 
    noFill(); 
    stroke(0); 
    strokeWeight(eyeWidth * 0.6); 
    float smileSize = (size * 0.5); //this needs to be a floating point value sadly
    arc( (float) x, (float) y, smileSize, smileSize, 0, PI);
  }
