package FIFA;
import java.util.*;

import FIFA.models.*;
import FIFA.persistance.Reader;

class app {
    public static void main(String args[]) {
        ArrayList<Team> teams;
        ArrayList<Referee> referees;
        ArrayList<Zone> zones;
        teams=new ArrayList<Team>();
        referees=new ArrayList<Referee>();
        zones=new ArrayList<Zone>();

        Reader read=new Reader();
        read.readTeam(teams);
        read.readReferee(referees);
       
        Championship championship = new Championship(zones, teams);
        System.out.println("Campeonato Anual de Futbol :)");
        
        Match first = new Match("11-06-2022", teams.get(0),teams.get(1),referees.get(0));
        first.result(championship);
    };

}
