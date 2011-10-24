package edu.cuhk;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import edu.cuhk.R;
import edu.cuhk.place.Bank;
import edu.cuhk.place.BusStop;
import edu.cuhk.place.Restaurant;
import edu.cuhk.place.Store;

import android.app.*;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;

import java.util.*;

public class CampusMap extends MapActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);

		// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);

		// Define a listener that responds to location updates
		LocationListener locationListener = new LocationListener() {
			public void onLocationChanged(Location location) {
				// Called when a new location is found by the network location
				// provider.
				// makeUseOfNewLocation(location);
			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {
			}

			public void onProviderEnabled(String provider) {
			}

			public void onProviderDisabled(String provider) {
			}
		};

		// Register the listener with the Location Manager to receive location
		// updates
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

		Location lastKnownLocation = locationManager
				.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

		GeoPoint current = new GeoPoint(
				(int) (lastKnownLocation.getLatitude() * 1e6),
				(int) (lastKnownLocation.getLongitude() * 1e6));

		MapView mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		MapController mc = mapView.getController();
		mc.animateTo(BusStop.SRR.getGeoPoint());
		mc.setZoom(16);
		
		
		List<Overlay> mapOverlays = mapView.getOverlays();
		BuildingItemizedOverlay currentLocOverlay = new BuildingItemizedOverlay(
				this.getResources().getDrawable(R.drawable.map_bluedot_sm),
				this);
		currentLocOverlay.addOverlay(new OverlayItem(current, "", ""));
		mapOverlays.add(currentLocOverlay);

		Bundle bundle = this.getIntent().getExtras();
		boolean busStop = bundle.getBoolean("busStop");
		boolean bank = bundle.getBoolean("bank");
		boolean restaurant = bundle.getBoolean("restaurant");
		boolean store = bundle.getBoolean("store");

		if (busStop) {
			BuildingItemizedOverlay overlay = new BuildingItemizedOverlay(this
					.getResources().getDrawable(R.drawable.pin_blue), this);
			for (BusStop stop : BusStop.values()) {
				OverlayItem overlayitem = new OverlayItem(
						stop.getGeoPoint(), "", "");
				overlay.addOverlay(overlayitem);
			}
			mapOverlays.add(overlay);
		}

		if (bank){
			BuildingItemizedOverlay overlay = new BuildingItemizedOverlay(this
					.getResources().getDrawable(R.drawable.pin_purple), this);
			
			OverlayItem hase = new OverlayItem(Bank.HASE.getGeoPoint(), getResources().getText(R.string.hase).toString(), getResources().getText(R.string.hase_loc).toString());
			overlay.addOverlay(hase);
			OverlayItem bea = new OverlayItem(Bank.BEA.getGeoPoint(), getResources().getText(R.string.bea).toString(), getResources().getText(R.string.bea_loc).toString());
			overlay.addOverlay(bea);

			OverlayItem haseatm = new OverlayItem(Bank.HASE_ATM_MTR.getGeoPoint(), getResources().getText(R.string.hase_atm).toString(), getResources().getText(R.string.hase_atm_loc).toString());
			overlay.addOverlay(haseatm);
			OverlayItem beaatm = new OverlayItem(Bank.BEA_ATM_FRANKLIN.getGeoPoint(), getResources().getText(R.string.bea_atm).toString(), getResources().getText(R.string.bea_atm_loc).toString());
			overlay.addOverlay(beaatm);
			
			OverlayItem hsbcatm = new OverlayItem(Bank.HSBC_ATM_MTR.getGeoPoint(), getResources().getText(R.string.hsbc_atm).toString(), getResources().getText(R.string.hsbc_atm_loc).toString());
			overlay.addOverlay(hsbcatm);
			OverlayItem bocatm = new OverlayItem(Bank.BOA_ATM_MTR.getGeoPoint(), getResources().getText(R.string.boa_atm).toString(), getResources().getText(R.string.boa_atm_loc).toString());
			overlay.addOverlay(bocatm);
			OverlayItem scbatm = new OverlayItem(Bank.SCB_ATM_NA.getGeoPoint(), getResources().getText(R.string.scb_atm).toString(), getResources().getText(R.string.scb_atm_loc).toString());
			overlay.addOverlay(scbatm);
			mapOverlays.add(overlay);
		}
		
		if (store){
			BuildingItemizedOverlay overlay = new BuildingItemizedOverlay(this
					.getResources().getDrawable(R.drawable.pin_purple), this);
			
			OverlayItem parknstore = new OverlayItem(Store.PARK_N_SHOP.getGeoPoint(), getResources().getText(R.string.park_n_shop).toString(), getResources().getText(R.string.park_n_shop_loc).toString() +"\n" + getResources().getText(R.string.park_n_shop_opening).toString());
			overlay.addOverlay(parknstore);
			OverlayItem seveneleven = new OverlayItem(Store.SEVEN_ELEVEN.getGeoPoint(), getResources().getText(R.string.seven_eleven).toString(), getResources().getText(R.string.seven_eleven_loc).toString());
			overlay.addOverlay(seveneleven);
			
			OverlayItem bookstore = new OverlayItem(Store.UNIVERSITY_BOOK_STORE.getGeoPoint(), getResources().getText(R.string.cu_book_store).toString(), getResources().getText(R.string.cu_book_store_loc).toString() +"\n" + getResources().getText(R.string.cu_book_store_opening).toString());
			overlay.addOverlay(bookstore);
			OverlayItem ccbookstore = new OverlayItem(Store.CC_BOOK_STORE.getGeoPoint(), getResources().getText(R.string.cc_book_store).toString(), getResources().getText(R.string.cc_book_store_loc).toString() +"\n" + getResources().getText(R.string.cc_book_store_opening).toString());
			overlay.addOverlay(ccbookstore);
			
			mapOverlays.add(overlay);
		}
		
	
		if (restaurant) {
			Drawable drawable = this.getResources().getDrawable(
					R.drawable.pin_yellow);
			BuildingItemizedOverlay itemizedoverlay = new BuildingItemizedOverlay(
					drawable, this);

			Restaurant[] restaurants = Restaurant.values();
			String[] names = getResources().getStringArray(R.array.restaurant_array);
			String[] openings = getResources().getStringArray(R.array.restaurant_opening_array);
			
			for (int i=0; i<restaurants.length; i++){
				GeoPoint point = restaurants[i].getGeoPoint();
				itemizedoverlay.addOverlay(new OverlayItem(point, names[i], openings[i]));
			}
			
			mapOverlays.add(itemizedoverlay);
		}

		AdView adView = (AdView) this.findViewById(R.id.adView);
		adView.loadAd(new AdRequest());
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}