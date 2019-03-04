package main.java.ru.alvisid.week_3.meet_with_PApplet;

import java.time.LocalTime;

import processing.core.*;

public class MyPApplet extends PApplet {	
	private String URL = "https://filmets.net/uploads/posts/2019-02/1549058690-791538044-kapitan-marvel.jpg";
	//private String URL = "http://cseweb.ucsd.edu/~minnes/palmTrees.jpg";
	private PImage backgroundImage;
	
	@Override
	public void settings() {
		size(200, 200);
		
	}
	
	@Override
	public void setup() {
		backgroundImage = loadImage(URL, "jpg");
	}
	
	@Override
	public void draw() {
		//If on of the parameters is zero then another parameter is resized to nonzero, and zero parameter
		//is resized proportionally started values. 
		backgroundImage.resize(200, 0);
		image(backgroundImage, 0, 0);
		//fill(255, 209, 0);
		int secs = LocalTime.now().getSecond();
		int r = (int)(4.25 * secs);
		int g = (int)(3.483 * secs);
		int b = 0;
		fill(r, g, b);
		//ellipse(50, 40, 40, 40);
		circle(50, 40, 40);
	}
	
	public static void main(String[] args) {
		PApplet.main(MyPApplet.class.getName());
		
	}
}
