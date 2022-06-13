package FIFA;
import java.util.*;

import FIFA.models.*;
import FIFA.persistance.Reader;

class app {
    public static void main(String args[]) {
        ArrayList<Team> teams=new ArrayList<Team>();
        ArrayList<Referee> referees=new ArrayList<Referee>();
        ArrayList<Zone> zones=new ArrayList<Zone>();

        Reader read=new Reader();
        read.readTeam(teams);
        read.readReferee(referees);
       
        Championship championship = new Championship(zones,teams);
        System.out.println("Campeonato Anual de Futbol :)");
        championship.playZones(referees);
        championship.playSemifinal(referees, teams);
    }


}
