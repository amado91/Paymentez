package com.example.juanamado.examen.modelos;

import java.util.ArrayList;

public class TodosLosLugares extends BasicModel {

    ArrayList<LugaresEncontrados> allBussines = new ArrayList<LugaresEncontrados>();

    public ArrayList<LugaresEncontrados> getAllBussines() {
        return allBussines;
    }

    public void setAllBussines(ArrayList<LugaresEncontrados> allBussines) {
        this.allBussines = allBussines;
    }
}
