package main.java.ru.alvisid.guimodule;

import processing.core.PApplet;
import processing.core.PImage;

public class MyDisplay extends PApplet {
	private PImage img;
	
	@Override
	public void settings() {
		size(400, 400);		
	}

	@Override
	public void setup() {
		background(255);
		stroke(0);
		img = loadImage("http://cseweb.ucsd.edu/~minnes/palmTrees.jpg", "jpg");
		img.resize(0,  400);
		image(img, 0, 0);
	}
	
	@Override
	public void draw() {
		ellipse(width/4, height/5, width/4, height/5);
	}
	
	public static void main(String[] args) {
		PApplet.main(MyDisplay.class.getName());
	}

}
