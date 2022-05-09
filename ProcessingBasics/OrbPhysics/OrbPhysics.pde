ArrayList<Orb>orbList;
Orb center; 
int MODE; 
final int GRAVITY = 0; 
final int ORBIT = 1; 
final int SPRING = 2; 
boolean backgroundMode; 
boolean gravity; 
boolean lineMode; 
final float SPRING_CONSTANT = 0.005;
final float SPRING_LENGTH = 150;  
final float SPRING_DAMPEN = 0.995;

void setup() {
  size(1000, 800);
  backgroundMode = true; 
  gravity = true; 
  lineMode = true; 
  MODE = GRAVITY;
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2, height/2, 0, 0, 5);
}

void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  //orbList.add(new Orb(mouseX, mouseY, random(-3,3), random(-3,3), random(20,70))); 
  orbList.add(new Orb(mouseX, mouseY, 5, 0, 20));
}

void keyPressed() {
  if (keyCode == BACKSPACE) { 
    orbList = new ArrayList<Orb>();
  }
  switch(key) {
  case ' ': 
    MODE = (MODE < 2) ? MODE + 1 : 0; 
    break; 
  case 'g':
    gravity = !gravity; 
    break; 
  case 'b':
    backgroundMode = !backgroundMode; 
    break;
  case 'l':
    lineMode = !lineMode; 
    break;
  }
}


void draw() {
  if (backgroundMode) {
    background(255);
  }
  drawText(); 
  center.display(); 
  for (Orb o : orbList) {
    if (MODE == ORBIT) {
      center.attract(o);
    }
    if (MODE == SPRING) {
      center.attractSpring(o); 
      if (lineMode) {
        //if (MODE == SPRING) {
        //  stroke(0, 0, 0, 120); 
        //  line(o.x, o.y, center.x, center.y);  
        //}
      }
    }
    o.move();
    o.display();
  }
} 

void drawText() {
  fill(255);
  noStroke(); 
  rect(0, 0, 175, 120); 
  fill(0);
  text("FrameRate: " + frameRate, 20, 20);
  text("Orbs: " + orbList.size(), 20, 40);
  String mode = ""; 
  switch(MODE) {
  case ORBIT: 
    mode = "ORBIT"; 
    break; 
  case SPRING: 
    mode = "SPRING"; 
    break; 
  case GRAVITY: 
    mode = "GRAVITY"; 
    break;
  }
  text("MODE: " + mode, 20, 60);
  text("gravity? : " + gravity, 20, 80); 
  text("background? : " + backgroundMode, 20, 100);
  text("lines? : " + lineMode, 20, 120);
}
