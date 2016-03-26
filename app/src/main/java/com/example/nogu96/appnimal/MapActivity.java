package com.example.nogu96.appnimal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

public class MapActivity extends Activity{

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //Bundle bundle = getIntent().getExtras();


    }

}//MapActivity
