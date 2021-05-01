package com.example.testone;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback ,MyAdapter.OnItemClickListener {


    private List<UserModel> userlist;
    private MyAdapter adapter;
    private GoogleMap mMap;
    private double lat = 17.408460;
    private double lon = 78.439908;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<UserModel>> call = apiService.getUserList();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                userlist = response.body();
                adapter =new  MyAdapter(userlist,MapsActivity.this::onItemClick);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }
        });

//        var intent_lat = getIntent().getStringExtra("lat")
//        var intent_lon = getIntent().getStringExtra("lon")
//        lat = intent_lat.toString().toDouble()
//        lon = intent_lon.toString().toDouble()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng india = new LatLng(lat, lon);

        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in India"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onItemClick(int position) {
        lat = Double.parseDouble(userlist.get(position).address.geo.lat);
       lon = Double.parseDouble(userlist.get(position).address.geo.lng);
       String name = userlist.get(position).name;

            mMap.clear();

            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(lat, lon);
            mMap.addMarker(new MarkerOptions().position(sydney).title(name));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));



    }
}