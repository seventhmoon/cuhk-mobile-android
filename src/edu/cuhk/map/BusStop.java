package edu.cuhk.map;

import com.google.android.maps.GeoPoint;

public enum BusStop {

	MTR(22.414324, 114.210066), U_GYM(22.417723, 114.210839), PMHC(22.41828,
			114.20934), SRR(22.41980, 114.20707), FKK(22.41986, 114.20304), UC(
			22.42040, 114.20529), NA(22.42131, 114.20768), R3(22.42139,
			114.20344), SC(22.42243, 114.20134), CC(22.41561, 114.20833);

	private final double latitude, longitude;

	BusStop(double latitude, double longitude) {
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
