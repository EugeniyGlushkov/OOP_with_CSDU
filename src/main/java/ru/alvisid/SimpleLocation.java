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
	public double latitude;
	
	/**
	 * The longitude of the point.
	 */
	public double longitude;

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
		return 0;
	}
}
