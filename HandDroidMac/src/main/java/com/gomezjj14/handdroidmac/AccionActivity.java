package com.gomezjj14.handdroidmac;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by gomezjj14 on 24/05/13.
 */
public class AccionActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accion);
    }

    public void retornarAccion(View view){
        Intent data = new Intent();
        data.setData(Uri.parse(((EditText) findViewById(R.id.etAccion)).getText().toString()));
        setResult(0, data);
        finish();

    }
}