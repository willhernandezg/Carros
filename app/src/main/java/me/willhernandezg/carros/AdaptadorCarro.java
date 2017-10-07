package me.willhernandezg.carros;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class AdaptadorCarro extends BaseAdapter {
    private Context contexto;
    private ArrayList<Carro> carros;
    private Resources res;
    private String [] marcab, modelob;

    public AdaptadorCarro(Context contexto, ArrayList<Carro> carros) {
        this.contexto = contexto;
        this.carros = carros;
        res = contexto.getResources();
        marcab = res.getStringArray(R.array.marca);
        modelob = res.getStringArray(R.array.modelo);
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int i) {
        return carros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Definicion de las variables a utilizar
        res = contexto.getResources();
        View v = view;

        //Crear el Objerto LayoutInflater para modificar la vista
        LayoutInflater inf = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inf.inflate(R.layout.item_lista,null);

        //Creamos un Objeto Persona
        Carro c = carros.get(i);

        //Capturar elementos de la vista
        ImageView foto = (ImageView) v.findViewById(R.id.imgFoto);
        TextView placa = (TextView) v.findViewById(R.id.lblPlaca);
        TextView marca = (TextView) v.findViewById(R.id.lblMarca);
        TextView modelo = (TextView) v.findViewById(R.id.lblModelo);
        TextView precio = (TextView) v.findViewById(R.id.lblPrecio);

        //Setear elementos a la vista
        //foto.setImageDrawable(res.getDrawable(p.getFoto()));
        foto.setImageDrawable(ResourcesCompat.getDrawable(res,c.getFoto(),null));
        placa.setText(c.getPlaca());
        marca.setText(marcab[c.getMarca()]);
        modelo.setText(modelob[c.getModelo()]);
        precio.setText(c.getPrecio());

        return v;
    }
}
