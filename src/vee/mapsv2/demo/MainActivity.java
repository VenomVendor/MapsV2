package vee.mapsv2.demo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {
	GoogleMap map;
	double latitude = 12.971689;
	double longitude = 77.594504;

	LatLng latlon = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		latlon = new LatLng(latitude, longitude);
		setUpMapIfNeeded(); // Required to check the availability of Maps

	}

	@Override
	protected void onResume() {
		super.onResume();
		setUpMapIfNeeded();
	}

	private void setUpMapIfNeeded() {
		if (map == null) {
			/*
			 * I avoid Crashing, if Google_Play_Services is not Updated or
			 * Unavailable
			 */
			map = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			/*
			 * To make sure map is loaded
			 */
			if (map != null) {
				setUpMap();
			}
		}
	}

	private void setUpMap() {
		/*
		 * Add a Marker Adding marker at 12.971689,77.594504;
		 */
		map.addMarker(new MarkerOptions().position(latlon)

		/*
		 * Add Title when clicked on marker
		 */
		.title("Title")
		/*
		 * Add Snippet when clicked on marker
		 */
		.snippet("I am a looooooooooooooong Snippet"));

		/*
		 * NormalMapView
		 */
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL); // Normal MapView

		/*
		 * Move Camera to Snippet Location
		 */
		float zoom = 11;
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlon, zoom)); // toPosition,
																			// ZoomLevel
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

}
