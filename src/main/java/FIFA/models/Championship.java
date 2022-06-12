package FIFA.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Championship {
    private List<Zone> zones;
    private ArrayList<TableComponent> positionTable;

    public Championship(List<Zone> zones, ArrayList<Team> teams) {
        this.positionTable = createPositionTable(teams);
        this.zones = zones;
    }


    public List<Zone> getZones() {
        return zones;
    }


    public void setZones(List<Zone> zonas) {
        this.zones = zonas;
    }


    public ArrayList<TableComponent> getTable() {
        return positionTable;
    }

    private ArrayList<TableComponent> createPositionTable(ArrayList<Team> teams){
        positionTable=new ArrayList<TableComponent>();
        for (int i= 0 ; i < teams.size(); i++){
            TableComponent e = new TableComponent(teams.get(i).getName());
            positionTable.add(e);
        }
        return positionTable;
    }

    public void updatePositionTable(ArrayList<TableComponent> positionTable){
        Collections.sort(positionTable,Collections.reverseOrder());
        
    }

}
