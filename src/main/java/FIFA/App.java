package FIFA;
import java.util.*;

import FIFA.models.*;
import FIFA.persistance.Reader;

class app {
    public static void main(String args[]) {
        ArrayList<Team> teams=new ArrayList<Team>();
        ArrayList<Referee> referees=new ArrayList<Referee>();
        ArrayList<Zone> zones=new ArrayList<Zone>();
        ArrayList<Team> finalists=new ArrayList<Team>();
        Team winner = new Team();
        Reader read=new Reader();
        read.readTeam(teams);
        read.readReferee(referees);
       
        Championship championship = new Championship(zones,teams);
        System.out.println("Campeonato Anual de Futbol :)");
        championship.playZones(referees);
        finalists = championship.playSemifinal(referees, teams);
        winner = championship.playFinal(referees,finalists);
        System.out.println("Ganador del torneo" + winner.toString());
    }


}
