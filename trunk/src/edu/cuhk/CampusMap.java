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
		boolean schoolBus = bundle.getBoolean("schoolBus");
		boolean restaurant = bundle.getBoolean("restaurant");

		if (schoolBus) {
			BuildingItemizedOverlay overlay = new BuildingItemizedOverlay(this
					.getResources().getDrawable(R.drawable.bus_stop), this);
			for (BusStop busStop : BusStop.values()) {
				OverlayItem overlayitem = new OverlayItem(
						busStop.getGeoPoint(), "", "");
				overlay.addOverlay(overlayitem);
			}
			mapOverlays.add(overlay);
		}

		// String map = bundle.getString("map");
		// if (map != null){
		// GeoPoint p = Restaurant.valueOf(map).getGeoPoint();
		// mc.animateTo(p);
		// }
		if (restaurant) {
			Drawable drawable = this.getResources().getDrawable(
					R.drawable.red_pin);
			BuildingItemizedOverlay itemizedoverlay = new BuildingItemizedOverlay(
					drawable, this);

			GeoPoint ucCan = Restaurant.UC.getGeoPoint();
			itemizedoverlay.addOverlay(new OverlayItem(ucCan, getResources()
					.getText(R.string.uc_student_canteen).toString(),
					getResources().getText(R.string.uc_student_canteen_opening)
							.toString()));

			GeoPoint ucStaffCan = Restaurant.UC_STAFF.getGeoPoint();
			itemizedoverlay.addOverlay(new OverlayItem(ucStaffCan,
					getResources().getText(R.string.uc_staff_restaurant)
							.toString(), getResources().getText(
							R.string.uc_staff_restaurant_opening).toString()));

			// for (Restaurant restaurant : Restaurant.values()) {
			// OverlayItem overlayitem = new
			// OverlayItem(restaurant.getGeoPoint(),
			// "Restaurant", restaurant.name());
			// itemizedoverlay2.addOverlay(overlayitem);
			// }
			mapOverlays.add(itemizedoverlay);
		}
		// mapOverlays.add(itemizedoverlay2);

		AdView adView = (AdView) this.findViewById(R.id.adView);
		adView.loadAd(new AdRequest());
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}