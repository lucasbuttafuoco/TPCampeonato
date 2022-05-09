package FIFA.models;

import java.util.ArrayList;


public class Championship {

    //preguntar como generar la tabla de posiciones. Variable ???
    private ArrayList<Zone> zonas;
    public ArrayList<Table> table;

    public Championship() {
    }

    public Championship(ArrayList<Zone> zonas, ArrayList<Table> table) {
        this.zonas = zonas;
        this.table = table;
    }


    public ArrayList<Zone> getZonas() {
        return zonas;
    }


    public void setZonas(ArrayList<Zone> zonas) {
        this.zonas = zonas;
    }


    public ArrayList<Table> getTable() {
        return table;
    }


    public void setTable(ArrayList<Table> table) {
        this.table = table;
    }
    
    

    
}
