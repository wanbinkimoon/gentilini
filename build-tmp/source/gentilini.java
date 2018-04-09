import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import themidibus.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class gentilini extends PApplet {

 

MidiBus myBus; 
int valParser = 0;
public void setup() {
  
  background(125);

  MidiBus.list(); 
  myBus = new MidiBus(this, 0, 1);
}

public void controllerChange(int channel, int number, int value) {
  valParser = value;
  
  // Receive a controllerChange
  println();
  println("Controller Change:");
  println("--------");
  println("Channel:" + channel);
  println("Number:" + number);
  println("Value:" + value);
}

public void noteOn(int channel, int pitch, int velocity) {
    println(channel, pitch, velocity);
}

public void draw() {
  stroke(255);
  line(0, valParser, width, valParser);
}
  public void settings() {  size(800, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "gentilini" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
