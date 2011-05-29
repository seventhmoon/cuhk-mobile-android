package edu.cuhk.place;

import com.google.android.maps.GeoPoint;

public enum Restaurant {

	CC_CCT(22.41665, 114.20969), 
	CC_LWC(22.41488, 114.20724), 
	CC_OL(22.41554, 114.20771), 
	CC_STAFF_CLUB(22.41594, 114.20777), 	 
	NA(22.42095, 114.20909), 
	NA_STAFF(22.42090, 114.20946), 
	NA_YUN_CHI_HSIEN(22.42075, 114.20928),
	UC(22.42100, 114.20611), 
	UC_STAFF(22.421073, 114.205842),
	SC(22.42252, 114.20100), 
	SC_SKY_GARDEN(22.42247, 114.20085), 
	SC_GARDEN(22.42262, 114.20096),
	CU_MED(22.41948, 114.20877),
	CU_STAFF_CANTEEN(22.41855, 114.20541), 
	CU_COFFEE_CORNER(22.41830, 114.20565),
	CU_POOL_SIDE_CAFE(22.41827, 114.20494),
	CU_FRANKLIN(22.41830, 114.20520), 
	CU_SNACK_BAR(22.41824, 114.20500),
	CU_SCR(22.41859, 114.20945);

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
