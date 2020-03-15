package com.royaldreams.coronavirustracker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.royaldreams.coronavirustracker.R;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    String latitude, longitude, country, cases, death;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Bundle bundle = getIntent().getExtras();
        latitude = bundle.getString("latitude");
        longitude = bundle.getString("longitude");
        country = bundle.getString("country");
        cases = bundle.getString("case");
        death = bundle.getString("death");


        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
        supportMapFragment.getMapAsync(this);

/*
        ArrayList<MarkerData> markersArray = new ArrayList<MarkerData>();

        for(int i = 0 ; i < markersArray.size() ; i++) {

            createMarker(markersArray.get(i).getLatitude(), markersArray.get(i).getLongitude(), markersArray.get(i).getTitle(), markersArray.get(i).getSnippet(), markersArray.get(i).getIconResID());
        }


        protected Marker createMarker(double latitude, double longitude, String title, String snippet, int iconResID) {

            return googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(latitude, longitude))
                    .anchor(0.5f, 0.5f)
                    .title(title)
                    .snippet(snippet)
                    .icon(BitmapDescriptorFactory.fromResource(iconResID)));
        }

 */
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        MarkerOptions markerOptions = new MarkerOptions();
        LatLng latLng = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
        markerOptions.position(latLng);
        markerOptions.title("Country: "+country+"\nConfirmed Cases: "+cases+"\nReported Deaths: "+death);
        gMap.clear();
        gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
        gMap.addMarker(markerOptions);
       /* gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

            }
        });*/
    }
}
