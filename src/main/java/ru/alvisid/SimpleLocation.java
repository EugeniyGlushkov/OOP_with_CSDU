package main.java.ru.alvisid;

/**
 * Represents the point on the map bay latitude and longitude.
 * 
 * @author eglushkov.
 * @version 1.0
 * @since 24.02.2019
 */
public class SimpleLocation {
	/**
	 * The latitude of the point.
	 */
	private double latitude;
	
	/**
	 * The longitude of the point.
	 */
	private double longitude;
	
	/**
	 * Constructs default {@code SimpleLocation}.
	 */
	public SimpleLocation() {
		this(44.59, 33.48);
	}

	/**
	 * Constructs a new {@code SimpleLocation}
	 * with specified latitude and longitude.
	 * 
	 * @param lat the specified latitude.
	 * @param lon the specified longitude.
	 */
	public SimpleLocation(double lat, double lon) {
		this.latitude = lat;
		this.longitude = lon;
	}
	
	/**
	 * Returns a distance from the current simple location to the
	 * specified simple location. 
	 * 
	 * @param otherSimplLoc the specified simple location.
	 * @return the distance from the current simple location to the
	 * specified simple location.
	 */
	public double distance(SimpleLocation otherSimplLoc) {
		return distance(otherSimplLoc.getLatitude(), otherSimplLoc.getLongitude());
	}
	
	public double distance(double otherLat, double otherLon) {
		return 0;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public void setLatitude(double lat) {
		if (lat < -90 || lat > 90) {
			throw new IllegalArgumentException("Latitude must be from -90 to 90 degree!");
		} else {
			this.latitude = lat;
		}
	}
	
	public void setLongitude(double lon) {
		if (lon < -180 || lon > 180) {
			throw new IllegalArgumentException("Longitude must be from -180 to 180 degree!");
		} else {
			this.longitude = lon;
		}
	}
}
