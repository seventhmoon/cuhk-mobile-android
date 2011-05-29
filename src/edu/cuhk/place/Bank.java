package edu.cuhk.place;

import com.google.android.maps.GeoPoint;

public enum Bank {

	HASE(22.418125, 114.204579), BEA(22.414773, 114.207336), HASE_ATM_MTR(
			22.41366, 114.20992), HSBC_ATM_MTR(22.41329, 114.21025), BEA_ATM_FRANKLIN(
			22.41847, 114.20526), BOA_ATM_MTR(22.413421, 114.210289);

	private final double latitude, longitude;

	Bank(double latitude, double longitude) {
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
