ArrayList<Orb>orbList;
Orb center; 
int MODE; 
int GRAVITY, ORBIT, SPRING; 
boolean backgroundMode; 
boolean gravity; 

void setup() {
  size(1000, 800);
  GRAVITY = 0; 
  ORBIT = 1;
  SPRING = 2; 
  backgroundMode = true; 
  gravity = true; 
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
    o.move();
    o.display();
  }
} 

void drawText() {
  fill(255);
  noStroke(); 
  rect(0, 0, 175, 100); 
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
