package me.willhernandezg.carros;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CrearCarro extends AppCompatActivity {
    private EditText placa, precio;
    private Resources res;
    private Spinner cajaMarca, cajaModelo, cajaColor;
    private String [] marca, modelo, color;
    private ArrayList<Integer> fotos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carro);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.carro1);
        fotos.add(R.drawable.carro2);
        fotos.add(R.drawable.carro3);

        placa = (EditText) findViewById(R.id.txtPlaca);
        precio = (EditText) findViewById(R.id.txtPrecio);
        cajaMarca = (Spinner)findViewById(R.id.cmbMarca);
        cajaModelo = (Spinner)findViewById(R.id.cmbModelo);
        cajaColor = (Spinner)findViewById(R.id.cmbColor);
        res = this.getResources();

        marca = res.getStringArray(R.array.marca);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,marca);
        cajaMarca.setAdapter(adapter1);

        modelo = res.getStringArray(R.array.modelo);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,modelo);
        cajaModelo.setAdapter(adapter2);

        color = res.getStringArray(R.array.color);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,color);
        cajaColor.setAdapter(adapter3);
    }


    public void guardar(View v){
        String placa2, precio2;
        int marca, modelo, color;

        placa2 = placa.getText().toString();
        marca = cajaMarca.getSelectedItemPosition();
        modelo = cajaModelo.getSelectedItemPosition();
        color = cajaColor.getSelectedItemPosition();
        precio2 = precio.getText().toString();

        Carro c = new Carro(Metodos.fotoAleatoria(fotos),placa2,marca,modelo,color,precio2);
        c.guardar();

        Toast.makeText(this,res.getString(R.string.mensajeGuardado),Toast.LENGTH_SHORT).show();
        limpiar();

    }

    public void limpiar(View v){
        limpiar();
    }

    private void limpiar(){
        placa.setText("");
        cajaMarca.setSelection(0);
        cajaModelo.setSelection(0);
        cajaColor.setSelection(0);
        precio.setText("");
        placa.requestFocus();
    }

}
