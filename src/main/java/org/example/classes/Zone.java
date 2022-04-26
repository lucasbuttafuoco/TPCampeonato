package org.example.classes;

import java.util.ArrayList;

public class Zone {
    
    private Championship actualChampionship;
    private ArrayList<Team> teams;

    public Zone(Championship actualChampionship, ArrayList<Team> teams) {
        this.actualChampionship = actualChampionship;
        this.teams = teams;
    }

    public Championship getActualChampionship() {
        return actualChampionship;
    }

    public void setActualChampionship(Championship actualChampionship) {
        this.actualChampionship = actualChampionship;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    
}
