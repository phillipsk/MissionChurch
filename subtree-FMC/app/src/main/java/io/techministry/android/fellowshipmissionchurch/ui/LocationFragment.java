
package io.techministry.android.fellowshipmissionchurch.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import io.fmc.R;
import io.fmc.R2;


public class LocationFragment extends Fragment implements OnMapReadyCallback {

    SupportMapFragment mapFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location,container,false);



        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            mapFragment.getMapAsync(this);
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.map_google_M, mapFragment)
                    .commit();
        }


// initializing Map // this doesn't work because onCreateView would initalize the object every time
        // the fragment creates the view
       // SupportMapFragment mapFragment =(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
       // mapFragment.getMapAsync(this);

        return view;
    }

    /*
    * Marker marker = myMap.addMarker(new MarkerOptions()
                     .position(latLng)
                     .title("Title")
                     .snippet("Snippet")
                     .icon(BitmapDescriptorFactory
                     .fromResource(R.drawable.marker)));

marker.showInfoWindow();
*/
    @Override
    public void onMapReady(GoogleMap googleMap) {
        MarkerOptions marker = new MarkerOptions();
        marker.position(new LatLng(42.3284719,-71.097651));
        marker.title("Fellowship Mission Church");
        marker.snippet("Click for directions!");


        Marker myMarker = googleMap.addMarker(marker);
        LatLng center = new LatLng(42.3284719,-71.097651);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center,17));

        myMarker.showInfoWindow();

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String url = "https://www.google.com/maps/place/Fellowship+Mission+Church/@42.3284719,-71.097651,17z";
                Uri mapUri = Uri.parse(url);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
    //mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                return false;
            }
        });


//        map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    //googleMap.addMarker(new MarkerOptions().position(new LatLng(42.3284719,-71.097651)). title("Fellowship Mission Church"));

    }


    //    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//        Bundle savedInstanceState) {
//        View view  =  inflater.inflate(R.layout.fragment_location, container, false);
//        return view;
//    }

}
