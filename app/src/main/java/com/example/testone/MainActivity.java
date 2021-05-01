package com.example.testone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_username =findViewById(R.id.et_username);
        EditText et_password =findViewById(R.id.et_password);
        Button bt_submit =findViewById(R.id.bt_submit);
        final Boolean[] flag = {false};
        SharedPreferences pref = getSharedPreferences("Details", MODE_PRIVATE);
        flag[0] = pref.getBoolean("key", flag[0]);

        if (flag[0] == true) {

            Intent intent =new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "please fill details & submit", Toast.LENGTH_SHORT).show();
        }




        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_username.getText().toString().trim().equals("123") && et_password.getText().toString().trim().equals("123") ){
                    flag[0] = true;
                  SharedPreferences pref = getSharedPreferences("Details", MODE_PRIVATE);
                  SharedPreferences.Editor editor= pref.edit();

                    editor.putBoolean("key", flag[0]);
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(intent);

                }else {
                    Toast.makeText( getApplicationContext(), "enter all details as 123", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

/*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var et_username = findViewById<EditText>(R.id.et_username)
        var et_password = findViewById<EditText>(R.id.et_password)
        var bt_submit = findViewById<Button>(R.id.bt_submit)
        var flag: Boolean = false

        var pref: SharedPreferences = getSharedPreferences("Details", MODE_PRIVATE)
        flag = pref.getBoolean("key", flag)


        if (flag == true) {

            var intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
            finish()

        } else {
            Toast.makeText(this, "please fill details & submit", Toast.LENGTH_SHORT).show()
        }

        bt_submit.setOnClickListener {

            if (et_username.text.trim()
                    .toString() == "123" && et_password.text.toString() == "123"
            ) {
                flag = true
                var pref: SharedPreferences = getSharedPreferences("Details", MODE_PRIVATE)
                var editor: SharedPreferences.Editor = pref.edit()
                editor.putBoolean("key", flag)
                editor.apply()
                var intent = Intent(this, NextActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "enter all details as 123", Toast.LENGTH_SHORT).show()
            }
        }


    }
}


 */