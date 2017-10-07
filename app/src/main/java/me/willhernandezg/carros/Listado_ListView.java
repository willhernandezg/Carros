package me.willhernandezg.carros;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Listado_ListView extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Carro> carros;
    private Context context;
    private AdaptadorCarro adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado__list_view);

        lista = (ListView) findViewById(R.id.lstListadoCarros);
        context = this.getApplicationContext();
        carros = Datos.obtenerCarros();
        adapter = new AdaptadorCarro(context,carros);
        lista.setAdapter(adapter);
    }
}
