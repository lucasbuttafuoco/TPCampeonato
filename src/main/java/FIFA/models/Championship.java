package FIFA.models;

import java.util.ArrayList;
import java.util.Collections;

public class Championship {
    private ArrayList<Zone> zones;
    private ArrayList<TableComponent> positionTable;

    public Championship(ArrayList<Zone> zones2, ArrayList<Team> teams) {
        this.positionTable = createPositionTable(teams);
        this.zones = createZones(teams);
    }

    public ArrayList<Zone> getZones() {
        return zones;
    }

    public ArrayList<TableComponent> getTable() {
        return positionTable;
    }

    public ArrayList<Zone> createZones(ArrayList<Team> teams) {
        zones=new ArrayList<Zone>();
        ArrayList<Team> teamsFromZone1 = new ArrayList<Team>();
        ArrayList<Team> teamsFromZone2 = new ArrayList<Team>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int cantZones = 2;
        
        for(int i=0;i<teams.size();i++){
            list.add(i);  
        }
        Collections.shuffle(list);
        
        for(int j=0;j<list.size()/cantZones;j++){
            teamsFromZone1.add(teams.get(list.get(j)));
        }
        Zone zone1 = new Zone(teamsFromZone1);
        zones.add(zone1);
    
        for(int j = 4 ;j<list.size();j++){
            teamsFromZone2.add(teams.get(list.get(j)));
        }
        Zone zone2 = new Zone(teamsFromZone2);
        zones.add(zone2);

        return zones;
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
