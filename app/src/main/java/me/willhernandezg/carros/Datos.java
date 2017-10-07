package me.willhernandezg.carros;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class Datos {

    private static ArrayList<Carro> carros = new ArrayList<>();

    public static void guardarCarro(Carro c){
        carros.add(c);
    }

    public static ArrayList<Carro> obtenerCarros(){
        return carros;
    }

}
