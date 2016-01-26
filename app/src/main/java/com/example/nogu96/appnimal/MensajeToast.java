package com.example.nogu96.appnimal;

import android.content.Context;
import android.os.Vibrator;
import android.widget.Toast;


public class MensajeToast {

    int duracion = Toast.LENGTH_SHORT;

    public MensajeToast(Context activity, String mensaje){

        Vibrator vibrator =(Vibrator)activity.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(200);
        Toast toast = Toast.makeText(activity, mensaje, duracion);
        toast.show();
    }

}
