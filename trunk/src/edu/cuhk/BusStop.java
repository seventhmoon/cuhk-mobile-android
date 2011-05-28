package edu.cuhk;

import com.google.android.maps.GeoPoint;

public enum BusStop {

	MTR(22.414324, 114.210066), U_GYM(22.417723, 114.210839), PMHC(22.41828,
			114.20934), SRR(22.41980, 114.20707), FKK(22.41986, 114.20304), UC(
			22.42040, 114.20529), NA(22.42131, 114.20768), R3(22.42139,
			114.20344), SC(22.42243, 114.20134), CC(22.41561, 114.20833), ADMIN_BLDG(
			22.41883, 114.20529), CCHH(22.42194, 114.20476), UCSR(22.42300,
			114.20573), R15(22.42366, 114.20657), R10(22.42507, 114.20778);

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
