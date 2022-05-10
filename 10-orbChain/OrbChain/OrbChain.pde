
static int SPRING;
static float SPRING_LENGTH;
static float SPRING_DAMPEN;
static float SPRING_CONSTANT;
static float GRAVITY; 
static int MODE; 

OrbList orbs; 

void setup() {
  size(1000, 800);
  reset(); 
} 

void reset() {
  orbs = new OrbList();
  SPRING = 2;
  SPRING_LENGTH = 50;
  SPRING_DAMPEN = 0.990;
  SPRING_CONSTANT = 0.015;
  GRAVITY = 0.35; 
  MODE = SPRING;
}

void mouseClicked() {
  orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
} 

void keyPressed() {
  switch(key) {
  case '1' :
    SPRING_CONSTANT *= 1.05; 
    break;
  case '2' : 
    SPRING_CONSTANT *= 0.95; 
    break; 
  case '3' :
    SPRING_DAMPEN *= 1.05;
    break; 
  case '4' : 
    SPRING_DAMPEN *= 0.95;
    break; 
  case '5' : 
    SPRING_LENGTH *= 1.2; 
    break;
  case '6' :
    SPRING_LENGTH /= 1.2; 
    break; 
  case '7' : 
    GRAVITY *= 1.05; 
    break; 
  case '8' : 
    GRAVITY *= 0.95; 
    break;
  case ' ' :
    reset(); 
    break; 
  }
}

void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
}
