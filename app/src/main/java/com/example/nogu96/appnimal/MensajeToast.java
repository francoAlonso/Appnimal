package com.example.nogu96.appnimal;

import android.content.Context;
import android.widget.Toast;


public class MensajeToast {

    int duracion = Toast.LENGTH_SHORT;

    public MensajeToast(Context activity, String mensaje){

        Toast toast = Toast.makeText(activity, mensaje, duracion);
        toast.show();
    }

}
