package edu.cuhk.map;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.app.*;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.*;

public class HelloMap extends MapActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.bus_stop);
        BuildingItemizedOverlay itemizedoverlay = new BuildingItemizedOverlay(drawable, this);
        
        for (BusStop busStop : BusStop.values()){
        	OverlayItem overlayitem = new OverlayItem(busStop.getGeoPoint(), "", busStop.name());
        	itemizedoverlay.addOverlay(overlayitem);
        }
        
        mapOverlays.add(itemizedoverlay);
        
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}