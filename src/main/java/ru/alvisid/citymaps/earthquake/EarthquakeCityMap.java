package main.java.ru.alvisid.citymaps.earthquake;

import processing.core.PApplet;

import java.util.List;
import java.util.stream.Collectors;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import parsing.ParseFeed;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;

public class EarthquakeCityMap extends PApplet {
	// You can ignore this. It's to keep eclipse from generating a warning.
	private static final long serialVersionUID = 1L;

	// IF YOU ARE WORKING OFFLINE, change the value of this variable to true
	private static final boolean offline = false;

	// Less than this threshold is a light earthquake
	public static final float THRESHOLD_MODERATE = 5;
	// Less than this threshold is a minor earthquake
	public static final float THRESHOLD_LIGHT = 4;

	/**
	 * This is where to find the local tiles, for working without an Internet
	 * connection
	 */
	public static String mbTilesString = "src/data/blankLight-1-3.mbtiles";

	private final int RED = color(255, 0, 0);
	private final int YELLOW = color(255, 255, 0);
	private final int BLUE = color(0, 0, 255);

	// feed with magnitude 2.5+ Earthquakes
	private String earthquakesURL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";

	private UnfoldingMap map;

	public void settings() {
		size(950, 600, P3D);
	}

	public void setup() {
		if (offline) {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
			earthquakesURL = "2.5_week.atom"; // Same feed, saved Aug 7, 2015, for working offline
		} else {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
			// IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
			// earthquakesURL = "2.5_week.atom";
			// map = new UnfoldingMap(this, 200, 50, 700, 500, new
			// Microsoft.HybridProvider());
		}
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		
	    //Use provided parser to collect properties for each earthquake
	    //PointFeatures have a getLocation method
	    List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
	    
	    List<Marker> markers = earthquakes.stream().map(earthQuake -> createMarker(earthQuake)).collect(Collectors.toList());
		map.addMarkers(markers);
	}

	public void draw() {
		background(100);
		map.draw();
		addKey();
	}
	
	private SimplePointMarker createMarker(PointFeature feature) {
		// To print all of the features in a PointFeature (so you can see what they are)
		// uncomment the line below. Note this will only print if you call createMarker
		// from setup
		// System.out.println(feature.getProperties());
		Location location = feature.getLocation();

		Object magObj = feature.getProperty("magnitude");
		float mag = Float.parseFloat(magObj.toString());

		// Finally return the marker
		return mag >= THRESHOLD_MODERATE ? new MarkerStrongMagnitude(location) :
			(mag >= THRESHOLD_LIGHT ? new MarkerMiddleMagnitude(location) : new MarkerLowMagnitude(location));
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

	/**
	 * Strong magnitude marker, shows earthquake is 5.0+ magnitude.
	 * 
	 * @author evgen glushkov
	 * @since 2019.03.07
	 * @see EarthquakeCityMap#MarkerMiddleMagnitude.
	 * @see EarthquakeCityMap#MarkerLowMagnitude.
	 */
	public class MarkerStrongMagnitude extends SimplePointMarker {
		public MarkerStrongMagnitude(Location location) {
			super(location);
			setColor(RED);
			setDiameter(18);
		}
	}

	/**
	 * Middle magnitude marker, shows earthquake is 4.0 to 5.0 magnitude.
	 * 
	 * @author evgen glushkov
	 * @since 2019.03.07
	 * @see EarthquakeCityMap#MarkerStrongMagnitude.
	 * @see EarthquakeCityMap#MarkerLowMagnitude.
	 */
	public class MarkerMiddleMagnitude extends SimplePointMarker {
		public MarkerMiddleMagnitude(Location location) {
			super(location);
			setColor(YELLOW);
			setDiameter(10);
		}
	}

	/**
	 * Low magnitude marker, shows earthquake is below 4.0 magnitude.
	 * 
	 * @author evgen glushkov
	 * @since 2019.03.07
	 * @see EarthquakeCityMap#MarkerStrongMagnitude.
	 * @see EarthquakeCityMap#MarkerMiddleMagnitude.
	 */
	public class MarkerLowMagnitude extends SimplePointMarker {
		public MarkerLowMagnitude(Location location) {
			super(location);
			setColor(BLUE);
			setDiameter(6);
		}
	}

}
