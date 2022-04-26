public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float radius;
  color c;

  public Orb(float x_, float y_, float xSpeed_, float ySpeed_, float radius_ ) {
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;

    //make sure it doesn't clip into the wall
    while (x - radius <= 0) {
      x += 0.1;
    }
    while (x + radius >= width) {
      x -= 0.1;
    }
    while (y + radius >= height) {
      y -= 0.1;
    }
    while (y - radius <= 0) {
      y += 0.1;
    }
    //random color... why not.
    c = color(random(255), random(255), random(255), random(75, 255));
  }


  void display() {
    //Part 1:
    //draw a ellipse at the x,y position, with the correct radius.
    //make sure it is the correct color
    //make sure you read the parameters of ellipse, so that you have the correct size.
    //radius is NOT one of the parameters of ellipse by default. 
    noStroke(); 
    fill(c); 
    ellipse(x, y, radius * 2, radius * 2); 
    stroke(5); 
    fill(0); 
    line(x, y, x + (xSpeed * 3), y + (ySpeed * 3));
  }

  void move() {

    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)
    if (MODE == GRAVITY) { 
      if (x + xSpeed >= width - radius || x + xSpeed <= radius) {
        xSpeed *= -1;
      }
      if (y + ySpeed >= height - radius || y + ySpeed <= radius) {
        ySpeed *= -1;
      }
    }
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed 
    x += xSpeed; 
    y += ySpeed; 

    //Part 4
    //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
    //You don't need a variable for this if every object experiences the same
    //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).
    if (MODE == GRAVITY) {
      ySpeed += 0.15;
    }
  }

  void attract(Orb other) {
    float G = 20; 
    other.xSpeed += G * (x - other.x) / pow(dist(x, y, other.x, other.y), 2); 
    other.ySpeed += G * (y - other.y) / pow(dist(x, y, other.x, other.y), 2);
  }
}
