package edu.cuhk.place;

import com.google.android.maps.GeoPoint;

public enum Store {

	PARK_N_SHOP(22.418147, 114.204640), SEVEN_ELEVEN(22.413290, 114.210289), CC_BOOK_STORE(
			22.415182, 114.206950), UNIVERSITY_BOOK_STORE(22.418249, 114.204726);

	private final double latitude, longitude;

	Store(double latitude, double longitude) {
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
