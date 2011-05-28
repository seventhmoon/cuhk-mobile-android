package edu.cuhk;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CUCampus extends ListActivity {
	private ArrayAdapter<String> menuItemAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String[] menuItemArray = { "Transport", "Restaurants", "Map" };
		menuItemAdapter = new ArrayAdapter<String>(this, R.layout.list_layout,
				menuItemArray);
		setListAdapter(menuItemAdapter);
		
	    //AdView adView = (AdView)this.findViewById(R.id.adView);
	    //adView.loadAd(new AdRequest());
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		if (getListAdapter() == menuItemAdapter) {
			if (position == 0) {
				//setListAdapter(teachingDayRouteAdapter);
			} else if (position == 1) {
				Intent intent=new Intent();
				intent.setClass(CUCampus.this, RestaurantMap.class);
				Bundle bundle=new Bundle();
				bundle.putString("map", Restaurant.UC.toString());
				intent.putExtras(bundle);
				startActivity(intent);
				//setListAdapter(nonTeachingDayRouteAdapter);
			}
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			setListAdapter(menuItemAdapter);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}