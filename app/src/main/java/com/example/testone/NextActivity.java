package com.example.testone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.common.api.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NextActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener{



    private List<UserModel> userlist;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);










//        var API = retrofit.create(RetrofitInterface::class.java)
//        var call = API.users
//        call?.enqueue(object : Callback<List<UserModel?>?> {
//            override fun onResponse(
//                    call: Call<List<UserModel?>?>,
//            response: Response<List<UserModel?>?>
//            ) {
//                var userlist: List<UserModel>? = response.body() as List<UserModel>
//                        listvar = userlist
////                var user = arrayOfNulls<String>(userlist!!.size)
//                var adapter = userlist?.let { MyAdapter(it, this@NextActivity) }
//
//                adapter?.notifyDataSetChanged()
//                recyclerView.adapter = adapter
//
//            }
//
//            override fun onFailure(call: Call<List<UserModel?>?>, t: Throwable) {
//
//            }
//
//        })




    }

    @Override
    public void onItemClick(int position) {

        String lat = userlist.get(position).address.geo.lat.toString();
        String lon = userlist.get(position).address.geo.lng.toString();
        Intent intent =new Intent(getApplicationContext(),MapsActivity.class);
        intent.putExtra("lat",lat);
        intent.putExtra("lon",lon);
        startActivity(intent);

//        Intent intent =new Intent(getApplicationContext())

    /*    var lat = listvar!![position].address.geo.lat.toString()
        var lon = listvar!![position].address.geo.lng.toString()
        var intent = Intent(this, MapsActivity::class.java)
        intent.putExtra("lat", lat)
        intent.putExtra("lon", lon)
        startActivity(intent)
        */



    }

}