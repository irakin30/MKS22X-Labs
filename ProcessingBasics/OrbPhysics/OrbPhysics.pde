ArrayList<Orb>orbList;
Orb center; 
int MODE; 
int GRAVITY, ORBIT; 

void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2, height/2, 0, 0, 5);
  GRAVITY = 1; 
  ORBIT = -1; 
  MODE = GRAVITY;
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
  if (key == ' ') {
    MODE *= -1;
  } 
  if (keyCode == BACKSPACE) { 
    orbList = new ArrayList<Orb>();
  }
}

void draw() {
  background(255); 
  center.display(); 
  for (Orb o : orbList) {
    if (MODE == ORBIT) {
      center.attract(o);
    }
    o.move();
    o.display();
  }
  fill(0);
  text("FrameRate: " + frameRate, 20, 20);
  text("Orbs: " + orbList.size(), 20, 40);
  if (MODE == GRAVITY) {
    text("MODE: GRAVITY", 20, 60);
  }
  if (MODE == ORBIT) {
    text("MODE : ORBIT", 20, 60);
  }
}
