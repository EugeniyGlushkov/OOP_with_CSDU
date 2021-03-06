package main.java.ru.alvisid.citymaps.lifeexpectancy;

import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import parsing.ParseFeed;
import processing.core.PApplet;

public class LifeExpectancy extends PApplet {
	private UnfoldingMap map;
	private Map<String, Float> lifeExpByCountry;

	private List<Feature> countries;
	private List<Marker> countryMarkers;

	@Override
	public void settings() {
		size(800, 600, P3D);
	}

	@Override
	public void setup() {
		//map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		 map = new UnfoldingMap(this, 50, 50, 700, 500, new Microsoft.HybridProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		lifeExpByCountry = ParseFeed.loadLifeExpectancyFromCSV(this, "LifeExpectancyWorldBank.csv");
		countries = GeoJSONReader.loadData(this, "data/countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarkers);
		shadeCountries();
	}

	@Override
	public void draw() {
		map.draw();
	}

	private void shadeCountries() {
		for (Marker marker : countryMarkers) {
			String countryId = marker.getId();

			if (lifeExpByCountry.containsKey(countryId)) {
				float lifeExp = lifeExpByCountry.get(countryId);
				int colorLvl = (int) map(lifeExp, 40, 90, 10, 255);
				marker.setColor(color(255 - colorLvl, 100, colorLvl));
			} else {
				marker.setColor(color(150, 150, 150));
			}
		}
	}

	public static void main(String[] args) {
		PApplet.main(LifeExpectancy.class.getName());
	}
}
