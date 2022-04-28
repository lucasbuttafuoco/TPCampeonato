package org.example.classes;

import java.util.ArrayList;

public class Championship {

    //preguntar como generar la tabla de posiciones. Variable ???
    private ArrayList<Zone> zonas;


    public Championship(ArrayList<Zone> zonas) {
        this.zonas = zonas;
    }


    public ArrayList<Zone> getZonas() {
        return zonas;
    }


    public void setZonas(ArrayList<Zone> zonas) {
        this.zonas = zonas;
    }
    

    
}
