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
        AbstractMapProvider p1 = new Google.GoogleMapProvider();
        map = new UnfoldingMap(this, 200, 50, 700, 500, p1);
		map.zoomToLevel(2);
        MapUtils.createDefaultEventDispatcher(this, map);       
    }

    public void draw() {        
        map.draw();
		background(10);
    }   
	/*
	private UnfoldingMap map;
	
	public void settings() {
		size(950, 600, P3D);
		
	}
	
	@Override
	public void setup() {
		map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
	}

	@Override
	public void draw() {
		background(10);
		map.draw();
		//addKey();
	}
	*/
	
	public static void main(String[] args) {
		PApplet.main(EarthquakeCityMap.class.getName());
	}
}
