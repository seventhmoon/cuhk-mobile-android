package edu.cuhk;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class CUCampus extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		String[] menuItemArray = {"Transport", "Restaurants"};
		ArrayAdapter<String>menuItemAdapter = new ArrayAdapter<String>(this, R.layout.list,
				menuItemArray);
        setListAdapter(menuItemAdapter);
    }
}