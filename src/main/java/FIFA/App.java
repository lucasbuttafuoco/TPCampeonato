package FIFA;

import java.util.*;

// import FIFA.enums.Positions;
import FIFA.models.*;
import FIFA.persistance.Reader;

class app {
    public static void main(String args[]) {
        List<Team> teams;
        teams=new ArrayList<Team>();
        Reader read=new Reader();
        read.readTeam(teams);
        System.out.println(teams);
        // Championship championship = new Championship();
        
        System.out.println("Campeonato Anual de Futbol :)");

        // Team boquita = new Team("Boquita", "Argentina", 1);
        // Team river = new Team("River","Argentina",2);

        // Player riquelme = new Player("Juan Roman Riquelme", LocalDate.of(1970, 3, 2) , "DNI", "129230242", "Argentina", boquita, Positions.FORWARD, 90);
        // boquita.addMember(riquelme);

        // Player palermo = new Player("Martin Palermo", LocalDate.of(1980, 3, 2), "DNI", "34012934", "Argentina", boquita, Positions.FORWARD, 91);
        // boquita.addMember(palermo);

        // Player alvarez = new Player("Julian Alvarez", LocalDate.of(1983, 3, 2), "DNI", "40012934", "Argentina", river, Positions.FORWARD, 91);
        // river.addMember(alvarez);

        // Referee pitana = new Referee("Nestor Pitana", LocalDate.of(1942, 3, 2), "DNI", "99012934", "Argentina", 15);

        // Match first = new Match(LocalDate.now(), boquita,river,pitana);
        // first.result(championship);
    };

}
