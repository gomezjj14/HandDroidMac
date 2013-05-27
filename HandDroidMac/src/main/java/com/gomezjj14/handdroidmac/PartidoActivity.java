package com.gomezjj14.handdroidmac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gomezjj14 on 23/05/13.
 */
public class PartidoActivity extends Activity {
    //List view
    ListView lvAcciones;
    ArrayAdapter<String> adaptador;
    ArrayList<String> items;
    Integer n=0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido);

        //Escribe los nombres de local y visitante
        Intent intent = getIntent();
        String sLocal = intent.getStringExtra(MainActivity.EXTRA_LOCAL);
        String sVisitante = intent.getStringExtra(MainActivity.EXTRA_VISITANTE);

        ((TextView) findViewById(R.id.tvLocal)).setText(sLocal);
        ((TextView) findViewById(R.id.tvVisitante)).setText(sVisitante);

        //ListView
        lvAcciones = (ListView) findViewById(R.id.lvAcciones);
        items = new ArrayList<String>();
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        lvAcciones.setAdapter(adaptador);

    }

    public void anadirAccion(View view){
        Intent intent = new Intent(this, AccionActivity.class);
        startActivityForResult(intent, 0);

        //adaptador.insert("Prueba " + n++,0);
        //adaptador.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        items.add(0, data.getDataString());
        //adaptador.insert(data.getDataString(),0);
        adaptador.notifyAll();

    }
}