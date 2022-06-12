package FIFA;
import java.util.*;

import FIFA.models.*;
import FIFA.persistance.Reader;

class app {
    public static void main(String args[]) {
        List<Team> teams;
        List<Referee> referees;
        teams=new ArrayList<Team>();
        referees=new ArrayList<Referee>();
        
        Reader read=new Reader();
        read.readTeam(teams);
        read.readReferee(referees);
       
        Championship championship = new Championship();
        System.out.println("Campeonato Anual de Futbol :)");
        
        Match first = new Match("11-06-2022", teams.get(3),teams.get(0),referees.get(0));
        first.result(championship);
    };

}
