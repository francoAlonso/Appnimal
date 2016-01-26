package com.example.nogu96.appnimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MapActivity extends Activity {

    TextView txtUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        txtUsuario = (TextView)findViewById(R.id.txt_usuario);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        txtUsuario.setText("hola " + bundle.getString("usuario"));

    }


}//MapActivity
