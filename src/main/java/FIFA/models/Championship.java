package FIFA.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Championship {
    private ArrayList<Zone> zones;
    private ArrayList<TableComponent> positionTable;
    private ArrayList<TableComponent> positionTableZone1;
    private ArrayList<TableComponent> positionTableZone2;

    public Championship(ArrayList<Zone> zones2, ArrayList<Team> teams) {
        this.positionTable = createPositionTable(teams);
        this.zones = createZones(teams);
    }

    
    /** 
     * @return ArrayList<Zone>
     */
    public ArrayList<Zone> getZones() {
        return zones;
    }

    
    /** 
     * @return ArrayList<TableComponent>
     */
    public ArrayList<TableComponent> getTable() {
        return positionTable;
    }

    
    /** 
     * @param teams
     * @return ArrayList<Zone>
     */
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

    
    /** 
     * @param teams
     * @return ArrayList<TableComponent>
     */
    private ArrayList<TableComponent> createPositionTable(ArrayList<Team> teams){
        ArrayList<TableComponent> posT=new ArrayList<TableComponent>();
        for (int i= 0 ; i < teams.size(); i++){
            TableComponent e = new TableComponent(teams.get(i).getName());
            posT.add(e);
        }
        return posT;
    }

    
    /** 
     * @param positionTable
     */
    public static void updatePositionTable(ArrayList<TableComponent> positionTable){
        Collections.sort(positionTable,Collections.reverseOrder());
    }

    
    /** 
     * @param referees
     */
    public void playZones(ArrayList<Referee> referees){
        String actualDate = "11-11-2020";
        this.positionTableZone1 = createPositionTable(zones.get(0).getTeams()) ;
        this.positionTableZone2 = createPositionTable(zones.get(1).getTeams()) ;
        
        System.out.println("PARTIDOS ZONA 1");
        //matchs ZONE 1:
        for (int i = 0 ; i < 4 ; i ++){
            for (int j = 0 ; j < 4 ; j++){
               
                if (j < i){
                    Match actualMatch = new Match(actualDate, zones.get(0).getTeams().get(i), zones.get(0).getTeams().get(j) ,referees.get(0));
                    actualMatch.result(positionTable, this.positionTableZone1);
                }
            }
        }
        System.out.println();
        System.out.println("PARTIDOS ZONA 2");
        //matchs ZONE 2:
        for (int i = 0 ; i < 4 ; i ++){
            for (int j = 0 ; j < 4 ; j++){
               
                if (j < i){
                    Match actualMatch = new Match(actualDate, zones.get(1).getTeams().get(i), zones.get(1).getTeams().get(j) ,referees.get(0));
                    actualMatch.result(positionTable, this.positionTableZone2);
                }
            }
        }
        System.out.println();
    }

    
    /** 
     * @param referees
     * @param teams
     * @return ArrayList<Team>
     */
    public ArrayList<Team> playSemifinal(ArrayList<Referee> referees, ArrayList<Team> teams){
        ArrayList<Team> winnersZone1 = new ArrayList<Team>();
        ArrayList<Team> winnersZone2 = new ArrayList<Team>();
        ArrayList<Team> finalists = new ArrayList<Team>();
        String actualDate = "16-11-2020";

        int w = 0 ;
        String winner1 = positionTableZone1.get(0).getTeamName();
        while(teams.get(w).getName().compareTo(winner1) != 0){
            w++;
        }
        winnersZone1.add(teams.get(w));
        String winner2 = positionTableZone1.get(1).getTeamName();
        w=0;
        while(teams.get(w).getName().compareTo(winner2) != 0){
            w++;
        }
        winnersZone1.add(teams.get(w));
        String winner3 = positionTableZone2.get(0).getTeamName();
        w=0;
        while(teams.get(w).getName().compareTo(winner3) != 0){
            w++;
        }
        winnersZone2.add(teams.get(w));
        String winner4 = positionTableZone2.get(1).getTeamName();
        w=0;
        while(teams.get(w).getName().compareTo(winner4) != 0){
            w++;
        }
        winnersZone2.add(teams.get(w));
        
        // top 1 zone 1 vs top 2 zone 2
        Match firstMatch = new Match(actualDate, winnersZone1.get(0),winnersZone2.get(1) ,referees.get(0));
        Team firstSemifinalWinner = firstMatch.resultSemifinal();
        finalists.add(firstSemifinalWinner);
        Match secondMatch = new Match(actualDate, winnersZone1.get(1),winnersZone2.get(0) ,referees.get(0));
        Team secondSemifinalWinner = secondMatch.resultSemifinal();
        finalists.add(secondSemifinalWinner);
        
        return finalists;
    }
    
    
    /** 
     * @param referees
     * @param finalists
     * @return Team
     */
    public Team playFinal(ArrayList<Referee> referees, ArrayList<Team> finalists){
        Random randomGenerator = new Random();
        String actualDate = "20-11-2020";
        System.out.println("FINAL DEL TORNEO:");
        Match finalMatch = new Match(actualDate, finalists.get(0),finalists.get(1) ,referees.get(0));
        int team1Goals = randomGenerator.nextInt(3);
        int team2Goals = randomGenerator.nextInt(3);
        System.out.println( finalists.get(0).getName() + " " + team1Goals + " - " + team2Goals + " " + finalists.get(1).getName());
        System.out.println("Referi del partido: " + referees.get(0).toString());
        System.out.println("-----------------------------------------");
        if (team1Goals > team2Goals){
            return finalists.get(0);
        }
        else if (team1Goals < team2Goals){
            return finalists.get(1);
        }   
        else{
            return finalMatch.penalties(finalists.get(0), finalists.get(1));
        }
    }
}
