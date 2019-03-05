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
		img.resize(0, 400);
		image(img, 0, 0);
	}

	@Override
	public void draw() {
		int[] colorsRGB = sunColorSec(second());
		fill(colorsRGB[0], colorsRGB[1], colorsRGB[2]);
		ellipse(width / 4, height / 5, width / 4, height / 5);
	}

	public int[] sunColorSec(int second) {
		int red, green;
		int blue = 0;

		if (second <= 30) {
			red = green = 255 / 30 * second;			
		} else {
			red = green = 255 / 30 * (60 - second);
		}

		return new int[] {red, green, blue};
	}

	public static void main(String[] args) {
		PApplet.main(MyDisplay.class.getName());
	}

}
