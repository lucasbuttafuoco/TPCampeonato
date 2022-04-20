package org.example.classes;

public class Zone {
    // Consultar: usamos una estructura de datos o cuatro atributos que despues
    // ordenamos en una tabla?
    private Team team1;
    private Team team2;
    private Team team3;
    private Team team4;

    public Zone(Team team1, Team team2, Team team3, Team team4) {
        this.team1 = team1;
        this.team2 = team2;
        this.team3 = team3;
        this.team4 = team4;
    }

    public Team getteam1() {
        return team1;
    }

    public void setteam1(Team team1) {
        this.team1 = team1;
    }

    public Team getteam2() {
        return team2;
    }

    public void setteam2(Team team2) {
        this.team2 = team2;
    }

    public Team getteam3() {
        return team3;
    }

    public void setteam3(Team team3) {
        this.team3 = team3;
    }

    public Team getteam4() {
        return team4;
    }

    public void setteam4(Team team4) {
        this.team4 = team4;
    }

    // el constructor necesita que le pasemos 4 equipos que ya esten instanciados
    // desde antes.
}
