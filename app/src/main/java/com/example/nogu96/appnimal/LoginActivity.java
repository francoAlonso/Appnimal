package com.example.nogu96.appnimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity {

    EditText txtUsuario, txtContraseña;
    Button btnLogin;
    MensajeToast toast;
    RequestQueue requestQueue;
    String url = "http://192.168.0.6/ejercicio/Appnimal/index.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());
        // Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);


        txtUsuario = (EditText)findViewById(R.id.txt_usuario);
        txtContraseña = (EditText)findViewById(R.id.txt_contraseña);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        //login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String usuario = txtUsuario.getText().toString().trim();
                final String contraseña = txtContraseña.getText().toString().trim();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            //mensaje de respuesta
                            public void onResponse(String response) {
                                if(response.trim().equals("success")){
                                    Intent intent = new Intent(LoginActivity.this, MapActivity.class);
                                    intent.putExtra("usuario", usuario);
                                    startActivity(intent);
                                }else{
                                    toast = new MensajeToast(getApplicationContext(), response);
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            //mensaje de error
                            public void onErrorResponse(VolleyError error) {
                                toast = new MensajeToast(getApplicationContext(), error.toString());
                            }
                        }){
                    @Override
                    //parametros a enviar
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> map = new HashMap<String,String>();
                        map.put("usuario", usuario);
                        map.put("contraseña", contraseña);
                        return map;
                    }

                };

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
                requestQueue.start();
            }
        });

    }//onCreate

}//LoginActivity
