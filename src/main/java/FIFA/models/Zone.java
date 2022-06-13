package FIFA.models;

import java.util.ArrayList;

public class Zone {
    
    private Championship actualChampionship;
    private ArrayList<Team> teams;

    public Zone(ArrayList<Team> teams) {
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
