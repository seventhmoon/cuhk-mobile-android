package edu.cuhk;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

import edu.cuhk.R;

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

		String[] menuItemArray = getResources().getStringArray(
				R.array.main_menu);
		// String[] menuItemArray = { "School Bus Information", "Bus Stops",
		// "Banks and ATMs" };
		menuItemAdapter = new ArrayAdapter<String>(this, R.layout.list_layout,
				menuItemArray);
		setListAdapter(menuItemAdapter);

		// AdView adView = (AdView)this.findViewById(R.id.adView);
		// adView.loadAd(new AdRequest());
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		if (getListAdapter() == menuItemAdapter) {
			if (position == 0) {
				// setListAdapter(teachingDayRouteAdapter);
				Intent intent = new Intent();
				intent.setClass(CUCampus.this, CUSchoolBus.class);

				startActivity(intent);
			} else if (position == 1) {

				Intent intent = new Intent();
				intent.setClass(CUCampus.this, CampusMap.class);
				Bundle bundle = new Bundle();
				bundle.putBoolean("bank", true);
				intent.putExtras(bundle);
				startActivity(intent);
			} else if (position == 2) {

				Intent intent = new Intent();
				intent.setClass(CUCampus.this, CampusMap.class);
				Bundle bundle = new Bundle();
				bundle.putBoolean("store", true);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			if (getListAdapter().equals(menuItemAdapter)) {
				return super.onKeyDown(keyCode, event);
			} else {
				setListAdapter(menuItemAdapter);
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}