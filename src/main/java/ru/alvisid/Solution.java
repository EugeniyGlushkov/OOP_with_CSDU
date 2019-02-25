package main.java.ru.alvisid;

public class Solution {
	public static void main(String[] args) {
		SimpleLocation sl = new SimpleLocation(34.3, 44.0);
		System.out.println("Distanse is " + sl.distance(sl));
		sl.setLatitude(91);
	}
}
