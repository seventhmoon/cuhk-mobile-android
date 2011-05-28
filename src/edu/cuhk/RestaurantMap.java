package edu.cuhk;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.app.*;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.*;

public class RestaurantMap extends MapActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);

		MapView mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		MapController mc = mapView.getController();
		mc.animateTo(BusStop.MTR.getGeoPoint());
		mc.setZoom(16);

		Bundle bundle = this.getIntent().getExtras();
		String map = bundle.getString("map");
		if (map != null){
			GeoPoint p = Restaurant.valueOf(map).getGeoPoint();
			mc.animateTo(p);
		}
		
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources()
				.getDrawable(R.drawable.red_pin);
		BuildingItemizedOverlay itemizedoverlay = new BuildingItemizedOverlay(
				drawable, this);

//		Drawable drawable2 = this.getResources()
//				.getDrawable(R.drawable.red_pin);
//		BuildingItemizedOverlay itemizedoverlay2 = new BuildingItemizedOverlay(
//				drawable2, this);

		GeoPoint ucCan = Restaurant.UC.getGeoPoint();
		itemizedoverlay.addOverlay(new OverlayItem(ucCan, getResources().getText(R.string.uc_student_canteen).toString(), getResources().getText(R.string.uc_student_canteen_opening).toString()));
		
		GeoPoint ucStaffCan = Restaurant.UC_STAFF.getGeoPoint();
		itemizedoverlay.addOverlay(new OverlayItem(ucStaffCan, getResources().getText(R.string.uc_staff_restaurant).toString(), getResources().getText(R.string.uc_staff_restaurant_opening).toString()));
		
		
//		for (BusStop busStop : BusStop.values()) {
//			OverlayItem overlayitem = new OverlayItem(busStop.getGeoPoint(),
//					"Bus Stop", busStop.name());
//			itemizedoverlay.addOverlay(overlayitem);
//		}

//		for (Restaurant restaurant : Restaurant.values()) {
//			OverlayItem overlayitem = new OverlayItem(restaurant.getGeoPoint(),
//					"Restaurant", restaurant.name());
//			itemizedoverlay2.addOverlay(overlayitem);
//		}
		mapOverlays.add(itemizedoverlay);
		//mapOverlays.add(itemizedoverlay2);

	    AdView adView = (AdView)this.findViewById(R.id.adView);
	    adView.loadAd(new AdRequest());
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}