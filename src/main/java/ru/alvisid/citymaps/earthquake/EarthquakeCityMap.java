package main.java.ru.alvisid.citymaps.earthquake;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class EarthquakeCityMap extends PApplet {
	private UnfoldingMap map;

    public void settings() {
        size(950, 600, P3D);
    }

    public void setup() {
        map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
		map.zoomToLevel(2);
        MapUtils.createDefaultEventDispatcher(this, map);       
    }

    public void draw() {  
		background(220);      
        map.draw();
		//addKey();
    }  
	
	public static void main(String[] args) {
		PApplet.main(EarthquakeCityMap.class.getName());
	}
}
