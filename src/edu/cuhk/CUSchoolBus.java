package edu.cuhk;

import java.util.*;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import edu.cuhk.R;
import edu.cuhk.place.BusStop;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

public class CUSchoolBus extends ListActivity {
	/** Called when the activity is first created. */
	// private final String MY_AD_UNIT_ID = "a14dd881af3fcdd";
	ArrayAdapter<String> menuAdapter;
	ArrayAdapter<String> dayTypesAdapter, upTimesAdapter, downTimesAdapter;
	ArrayAdapter<String> teachingDayRouteAdapter, nonTeachingDayRouteAdapter;
	ArrayAdapter<String> teachingDayTimetableAdapter1,
			teachingDayTimetableAdapter2, teachingDayTimetableAdapter3,
			teachingDayTimetableAdapter4, teachingDayTimetableAdapter5,
			teachingDayTimetableAdapter6, teachingDayTimetableAdapter7,
			nonTeachingDayTimetableAdapter1, nonTeachingDayTimetableAdapter2,
			nonTeachingDayTimetableAdapter3, nonTeachingDayTimetableAdapter4;
	ArrayAdapter<BusStop> stopsAdapter;

	// ArrayAdapter<String> cacheAdapter;

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		// if (getListAdapter() == stopsAdapter) {
		// BusStop s = stopsAdapter.getItem(position);
		// List<BusRoute> routes = new ArrayList<BusRoute>();
		//
		// for (BusRoute r : BusRoute.values()) {
		// if (r.contains(s)) {
		// routes.add(r);
		// }
		// }
		// ArrayAdapter<BusRoute> routeAdapter = new ArrayAdapter<BusRoute>(
		// this, R.layout.list_layout, routes);
		// setListAdapter(routeAdapter);
		// }

		if (getListAdapter() == dayTypesAdapter) {
			if (position == 0) {
				setListAdapter(teachingDayRouteAdapter);
			} else if (position == 1) {
				setListAdapter(nonTeachingDayRouteAdapter);
			}
		} else if (getListAdapter() == teachingDayRouteAdapter) {
			if (position == 0) {
				setListAdapter(teachingDayTimetableAdapter1);
			} else if (position == 1) {
				setListAdapter(teachingDayTimetableAdapter2);
			} else if (position == 2) {
				setListAdapter(teachingDayTimetableAdapter3);
			} else if (position == 3) {
				setListAdapter(teachingDayTimetableAdapter4);
			} else if (position == 4) {
				setListAdapter(teachingDayTimetableAdapter5);
			} else if (position == 5) {
				setListAdapter(teachingDayTimetableAdapter6);
			} else if (position == 6) {
				setListAdapter(teachingDayTimetableAdapter7);
			}
		} else if (getListAdapter() == nonTeachingDayRouteAdapter) {
			if (position == 0) {
				setListAdapter(nonTeachingDayTimetableAdapter1);
			} else if (position == 1) {
				setListAdapter(nonTeachingDayTimetableAdapter2);
			} else if (position == 2) {
				setListAdapter(nonTeachingDayTimetableAdapter3);
			} else if (position == 3) {
				setListAdapter(nonTeachingDayTimetableAdapter4);
			}
		} else if (getListAdapter() == menuAdapter) {
			if (position == 0) {
				setListAdapter(dayTypesAdapter);
			} else if (position == 1) {
				Intent intent = new Intent();
				intent.setClass(CUSchoolBus.this, CampusMap.class);
				Bundle bundle = new Bundle();
				bundle.putBoolean("busStop", true);
				intent.putExtras(bundle);
				startActivity(intent);
			}

		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			if (getListAdapter() != menuAdapter) {
				setListAdapter(menuAdapter);
			} else {
				return super.onKeyDown(keyCode, event);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.list_layout);
		/*
		 * List<Map<String, String>> list = new ArrayList<Map<String,
		 * String>>(); HashMap<String, String> map1 = new HashMap<String,
		 * String>(); HashMap<String, String> map2 = new HashMap<String,
		 * String>();
		 * 
		 * String[] key = {"name", "desc"};
		 * 
		 * map1.put(key[0], "one"); map1.put(key[1], "oneone"); map2.put(key[0],
		 * "two"); map2.put(key[1], "twotwo");
		 * 
		 * list.add(map1); list.add(map2);
		 * 
		 * SimpleAdapter adapter = new SimpleAdapter(this, list,
		 * R.layout.list_layout, key, new int[] {R.id.listitem_title,
		 * R.id.listitem_content});
		 */

		// BusStop[] stopsArray = BusStop.values();
		// stopsAdapter = new ArrayAdapter<BusStop>(this, R.layout.list_layout,
		// stopsArray);

		String[] menuItemsArray = getResources().getStringArray(
				R.array.bus_menu);

		this.menuAdapter = new ArrayAdapter<String>(this, R.layout.list_layout,
				menuItemsArray);
		String[] dayTypesArray = getResources().getStringArray(
				R.array.day_type_array);
		dayTypesAdapter = new ArrayAdapter<String>(this, R.layout.list_layout,
				dayTypesArray);
		//
		String[] teachingDayRoutesArray = getResources().getStringArray(
				R.array.teaching_day_bus_array);
		String[] nonTeachingDayRoutesArray = getResources().getStringArray(
				R.array.non_teaching_day_bus_array);

		teachingDayRouteAdapter = new ArrayAdapter<String>(this,
				R.layout.list_layout, teachingDayRoutesArray);
		nonTeachingDayRouteAdapter = new ArrayAdapter<String>(this,
				R.layout.list_layout, nonTeachingDayRoutesArray);

		teachingDayTimetableAdapter1 = new ArrayAdapter<String>(this,
				R.layout.list_layout, getResources().getStringArray(
						R.array.mtr_to_na_time_array));
		teachingDayTimetableAdapter2 = new ArrayAdapter<String>(this,
				R.layout.list_layout, getResources().getStringArray(
						R.array.mtr_to_sc_time_array));
		teachingDayTimetableAdapter3 = new ArrayAdapter<String>(this,
				R.layout.list_layout, getResources().getStringArray(
						R.array.mtr_to_sc_to_mtr_time_array));
		teachingDayTimetableAdapter4 = new ArrayAdapter<String>(this,
				R.layout.list_layout, getResources().getStringArray(
						R.array.mtr_to_r11_time_array));
		teachingDayTimetableAdapter5 = new ArrayAdapter<String>(this,
				R.layout.list_layout, getResources().getStringArray(
						R.array.na_to_mtr_time_array));
		teachingDayTimetableAdapter6 = new ArrayAdapter<String>(this,
				R.layout.list_layout, getResources().getStringArray(
						R.array.sc_to_mtr_time_array));
		teachingDayTimetableAdapter7 = new ArrayAdapter<String>(this,
				R.layout.list_layout, getResources().getStringArray(
						R.array.r11_to_mtr_time_array));
		//
		nonTeachingDayTimetableAdapter1 = new ArrayAdapter<String>(this,
				R.layout.list_layout, getResources().getStringArray(
						R.array.ntd_mtr_to_sc_time_array));
		nonTeachingDayTimetableAdapter2 = new ArrayAdapter<String>(this,
				R.layout.list_layout, getResources().getStringArray(
						R.array.ntd_mtr_to_r11_time_array));
		nonTeachingDayTimetableAdapter3 = new ArrayAdapter<String>(this,
				R.layout.list_layout, getResources().getStringArray(
						R.array.ntd_sc_to_mtr_time_array));
		nonTeachingDayTimetableAdapter4 = new ArrayAdapter<String>(this,
				R.layout.list_layout, getResources().getStringArray(
						R.array.ntd_r11_to_mtr_time_array));

		// String[] buses = getResources().getStringArray(R.array.bus_array);
		// String[] upTimes =
		// getResources().getStringArray(R.array.up_time_array);
		// String[] downTimes = getResources().getStringArray(
		// R.array.down_time_array);

		dayTypesAdapter = new ArrayAdapter<String>(this, R.layout.list_layout,
				dayTypesArray);
		// busesAdapter = new ArrayAdapter<String>(this, R.layout.list_layout,
		// buses);
		// upTimesAdapter = new ArrayAdapter<String>(this, R.layout.list_layout,
		// upTimes);
		// downTimesAdapter = new ArrayAdapter<String>(this,
		// R.layout.list_layout,
		// downTimes);

		setListAdapter(menuAdapter);
		// setListAdapter(stopsAdapter);

	}

}