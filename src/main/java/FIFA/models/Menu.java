package FIFA.models;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public static void MenuOp(Championship championship, ArrayList<Referee> referees, ArrayList<Team> teams) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        do{
            System.out.print("\n\t\tMenu\n---------------------------------------"
                    + "\n1:Jugar Partido"
                    + "\n2:Jugar Zonas"
                    + "\n3:Jugar Campeonato"
                    + "\n4:Reportes"
                    + "\n5:Salir\n");
            
            try {
                System.out.println("Seleccione una de las opciones");
                System.out.println();
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:	System.out.println("Juega Part");;break;
                    case 2: playMatchesFromZones(championship, referees);break;						
                    case 3: playMatchesChampionship(championship, referees, teams);;break;
                    case 4: reportsMenu(championship, teams);;break;
                    case 5: System.out.println("Finalizado");salir = true;break;
                    default: System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir) ;
    }


    public void playMatch(Championship championship, ArrayList<Referee> referees){
        //Match match = new Match();

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
                    + "\n2:MEDIOCAMPISTAS"
                    + "\n2:DELANTEROS"
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
                        posicion = "defensor";
                        System.out.println("Defensores");
                        readPlayers(teams, posicion);
                        break;						
                    case 3:
                        posicion = "mediocampista";
                        System.out.println("Mediocampistas");
                        readPlayers(teams, posicion);
                        break;
                    case 4:
                        posicion = "delantero";
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
        ArrayList<TableComponent> tabla;

        for(int i = 0; i < teams.size(); i++){
            System.out.println("Arqueros del equipo " + teams.get(i).getName());
            for(int j = 0; j < teams.get(i).getTeamList().size(); j++){
                // if( == "arquero"){
                //     System.out.println("datos");
                //     tabla = championship.getTable();
                // }
            }
        }

    }


    public static void readPlayers(ArrayList<Team> teams, String posicion){
        for(int i = 0; i < teams.size(); i++){
            System.out.println("Jugadores del equipo " + teams.get(i).getName() + " que juegan de " + posicion);
            for(int j = 0; j < teams.get(i).getTeamList().size(); j++){
                // if(teams.get(i).getTeamList().get(j). == posicion){
                //     System.out.println("datos");
                // }
            }
        }

    }

}


