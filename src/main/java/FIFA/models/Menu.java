package FIFA.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public static void MenuOp(Championship championship, ArrayList<Referee> referees, ArrayList<Team> teams) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        do{
            System.out.print("\n\t\tMenu\n---------------------------------------"
                    + "\n1:Jugar Partidos"
                    + "\n2:Mostrar tabla de posiciones por zona"
                    + "\n3:Reportes"
                    + "\n4:Salir\n");
            try {
                System.out.println("Seleccione una de las opciones");
                System.out.println();
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:	playMatches(championship, referees, teams);break;
                    case 2: showTables(championship);break;
                    case 3: reportsMenu(championship, teams);break;
                    case 4: System.out.println("Finalizado");salir = true;break;
                    default: System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir) ;
    }


    public static void showTables(Championship championship){
        ArrayList<TableComponent> tabla =  championship.getTable();
        ArrayList<Zone> zonas = championship.getZones();

        System.out.println("Posicion | Equipo | Puntos | PJ | Dif. de Gol | Goles a favor");
        for(int i = 0; i < tabla.size(); i++){
            TableComponent equipo = tabla.get(i);
            System.out.println(i+1 + "   " + 
                               equipo.getTeamName() + "   " + 
                               equipo.getPoints() + "   " + 
                               equipo.getMatchsPlayed() + "   " + 
                               equipo.getGoalsDifference() + "   " +
                               equipo.getGoals());
        }
    }


    public static void playMatches(Championship championship, ArrayList<Referee> referees, ArrayList<Team> teams){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        do{
            System.out.print("\n\t\tMenu\n---------------------------------------"
                    + "\n1:Jugar Zonas"
                    + "\n2:Jugar Campeonato"
                    + "\n3:Salir\n");
            try {
                System.out.println("Seleccione una de las opciones");
                System.out.println();
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1: playMatchesFromZones(championship, referees);break;						
                    case 2: playMatchesChampionship(championship, referees, teams);break;
                    case 3: System.out.println("Finalizado");salir = true;break;
                    default: System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir) ;
    }


    public static void playMatchesFromZones(Championship championship, ArrayList<Referee> referees){
        championship.playZones(referees);
    }


    public static void playMatchesChampionship(Championship championship, ArrayList<Referee> referees, ArrayList<Team> teams){
        ArrayList<Team> finalists=new ArrayList<Team>();
        Team winner = new Team();

        try {
            finalists = championship.playSemifinal(referees, teams);
        } catch (Exception e) {
            System.out.println("Todavia no se terminaron de jugar los partidos de las zonas");
            MenuOp(championship, referees, teams);
        }
        winner = championship.playFinal(referees,finalists);
        System.out.println("Ganador del torneo" + winner.toString());
    }


    public static void reportsMenu(Championship championship, ArrayList<Team> teams){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        do{
            System.out.print("\n\t\tMenu Reportes\n---------------------------------------"
                    + "\n1:Listado de Equipos"
                    + "\n2:Listado de Jugadores"
                    + "\n3:Volver\n");
            try {
                System.out.println("Seleccione una de las opciones");
                System.out.println();
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:	System.out.println("Listado de Equipos");teamsList(championship, teams);break;
                    case 2: playersList(championship, teams);break;						
                    case 3: System.out.println("Volver");salir = true;break;
                    default: System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir) ;
    }


    public static void teamsList(Championship championship, ArrayList<Team> teams){
        ArrayList<TableComponent> tabla =  championship.getTable();
        int w, r;

        for(int i = 0; i < tabla.size(); i++){
            System.out.println("-----------------------------");
            System.out.println(tabla.get(i).getTeamName());
            w = 0;
            while(tabla.get(i).getTeamName() != teams.get(w).getName()){
                w++;
            }
            r = 0;
            ArrayList<TeamMember> tml = teams.get(w).getTeamList();
            while(tml.get(r).getClass() == DT.class){
                r++;
            }
            System.out.println("Nacionalidad DT: " + tml.get(r).getNationality());
            System.out.println("Goles a favor: " + tabla.get(i).getGoals());
            System.out.println("Goles a en contra: " + tabla.get(i).getGoalsAgainst());
        }
    }


    public static void playersList(Championship championship, ArrayList<Team> teams){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        String posicion;
        
        do{
            System.out.print("\n\t\tSeleccione posicion\n---------------------------------------"
                    + "\n1:ARQUEROS"
                    + "\n2:DEFENSORES"
                    + "\n3:MEDIOCAMPISTAS"
                    + "\n4:DELANTEROS"
                    + "\n5:Volver\n");
            try {
                System.out.println("Seleccione una de las opciones");
                System.out.println();
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Arqueros");
                        readGoalKeepers(championship, teams);
                        break;
                    case 2:
                        posicion = new String("DEFENSOR");
                        System.out.println("Defensores");
                        readPlayers(teams, posicion);
                        break;						
                    case 3:
                        posicion = new String("MEDIOCAMPISTA");
                        System.out.println("Mediocampistas");
                        readPlayers(teams, posicion);
                        break;
                    case 4:
                        posicion = new String("DELANTERO");
                        System.out.println("Delanteros");
                        readPlayers(teams, posicion);
                        break;
                    case 5: System.out.println("Volver");salir = true;break;
                    default: System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir) ;
    }


    public static void readGoalKeepers(Championship championship, ArrayList<Team> teams){
        ArrayList<TableComponent> tabla =  championship.getTable();
        int w;

        for(int i = 0; i < teams.size(); i++){
            System.out.println("-----------------------------");
            System.out.println("Arqueros del equipo " + teams.get(i).getName());
            for(int j = 0; j < teams.get(i).getTeamList().size(); j++){
                TeamMember tm = teams.get(i).getTeamList().get(j);
            
                if(tm.getClass() == Player.class){
                    if(tm.getPosition().toString().equals("ARQUERO")){
                        System.out.println(tm.getName() + " " +
                                           tm.getBirthDate() + " " +
                                           tm.getTypeDNI() + " " +
                                           tm.getDNI() + " " +
                                           tm.getNationality() + " " +
                                           tm.getActualTeam());
                        w = 0;
                        while(tabla.get(w).getTeamName() != teams.get(i).getName()){
                            w++;
                        }
                        System.out.println("Goles a favor: " + tabla.get(w).getGoals());
                        System.out.println("Goles en contra: " + tabla.get(w).getGoalsAgainst());
                    }
                }
            }
        }
    }


    public static void readPlayers(ArrayList<Team> teams, String posicion){
        String pos = posicion.toUpperCase();

        for(int i = 0; i < teams.size(); i++){
            System.out.println("-----------------------------");
            System.out.println("Jugadores del equipo " + teams.get(i).getName() + " que juegan de " + posicion);
            for(int j = 0; j < teams.get(i).getTeamList().size(); j++){
                TeamMember tm = teams.get(i).getTeamList().get(j);
                
                if(tm.getClass() == Player.class){
                    if(tm.getPosition().toString().equals(pos)){
                        System.out.println(tm.getName() + " " +
                                           tm.getBirthDate() + " " +
                                           tm.getTypeDNI() + " " +
                                           tm.getDNI() + " " +
                                           tm.getNationality() + " " +
                                           tm.getActualTeam());
                    }
                }
            }
        }
    }

}


