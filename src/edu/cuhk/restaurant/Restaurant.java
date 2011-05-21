package edu.cuhk.restaurant;

import com.google.android.maps.GeoPoint;

public enum Restaurant {

	CCT(22.41665, 114.20969), LWC(22.41488, 114.20724), OL(22.41554, 114.20771), STAFF_CLUB(
			22.41594, 114.20777), MED(22.41948, 114.20877), NA(22.42095,
			114.20909), UC(22.42100, 114.20611), SC(22.42252, 114.20100), MC_STAFF_CANTEEN(
			22.41855, 114.20541), COFFEE_CORNER(22.41830, 114.20565), FRANKLIN(
			22.41830, 114.20520), SNACK_BAR(22.41824, 114.20500);

	private final double latitude, longitude;

	Restaurant(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public GeoPoint getGeoPoint() {
		return new GeoPoint((int) (this.latitude * 1e6),
				(int) (this.longitude * 1e6));
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

}
