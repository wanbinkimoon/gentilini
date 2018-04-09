import themidibus.*; 
import processing.*;
MidiBus myBus; 
int valParser = 0;

void setup() {
  size(800, 800);
  background(125);

  MidiBus.list(); 
  myBus = new MidiBus(this, 0, 1);
}

void controllerChange(int channel, int number, int value) {
  valParser = value;
  
  // Receive a controllerChange
  println();
  println("Controller Change:");
  println("--------");
  println("Channel:" + channel);
  println("Number:" + number);
  println("Value:" + value);
}

void noteOn(int channel, int pitch, int velocity) {
    println(channel, pitch, velocity);
}

void draw() {
  stroke(255);
  line(0, valParser, width, valParser);
}