package main.java.ru.alvisid.citymaps.earthquake;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;

public class EarthquakeCityMap extends PApplet {
	private UnfoldingMap map;

    public void settings() {
        size(950, 600, P3D);
    }

    public void setup() {
        //map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
    	map = new UnfoldingMap(this, 200, 50, 700, 500, new Microsoft.HybridProvider());
		map.zoomToLevel(2);
        MapUtils.createDefaultEventDispatcher(this, map); 
        Location valLoc = new Location(-38.14f, -73.03f);
        SimplePointMarker val = new SimplePointMarker(valLoc);
        map.addMarker(val);
    }

    public void draw() {  
		background(220);      
        map.draw();
		addKey();
    }  
	
	public static void main(String[] args) {
		PApplet.main(EarthquakeCityMap.class.getName());
	}
	
	private void addKey() {
		fill(255);
		rect(25, 50, 150, 300, 5);
		fill(0);
		textSize(12);
		text("Earthquake Key", 50, 80);
		text("5.0+ Magnitude", 70, 145);
		text("4.0+ Magnitude", 70, 205);
		text("Below 4.0", 70, 265);
		fill(255, 0, 0);
		circle(50, 140, 18);
		fill(255, 255, 0);
		circle(50, 200, 10);
		fill(0, 0, 255);
		circle(50, 260, 6);
	}
}
