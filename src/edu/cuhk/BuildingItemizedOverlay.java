package edu.cuhk;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import java.util.*;

public class BuildingItemizedOverlay extends ItemizedOverlay<OverlayItem>  {
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	Context mContext;

	public BuildingItemizedOverlay(Drawable defaultMarker) {
		// super(defaultMarker);
		super(boundCenterBottom(defaultMarker));
	}

	public BuildingItemizedOverlay(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		mContext = context;
	}

	@Override
	protected boolean onTap(int index) {
		OverlayItem item = mOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
		String title = item.getTitle();
		String message = item.getSnippet();
		dialog.setTitle(title);
		dialog.setMessage(message);
		if (!title.equals("") && !message.equals("")){
			dialog.show();
		}
		return true;
	}

	public void addOverlay(OverlayItem overlay) {
		mOverlays.add(overlay);
		populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		return mOverlays.get(i);
	}

	@Override
	public int size() {
		return mOverlays.size();
	}
}
