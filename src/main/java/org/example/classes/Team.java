package org.example.classes;

import java.util.HashSet;
import java.util.Set;

public class Team {
    private String name;
    private String country;
    private int rankingPosition;
    private Set<TeamMember> teamList;
    //preguntar si esta bien las relaciones, un team siempre tiene una zona?

    public Team(String n, String c, int r) {
        name = n;
        country = c;
        rankingPosition = r;
        teamList = new HashSet<>();
    }

    public String getName() {
        return name;
    };

    public String getCountry() {
        return country;
    }

    public int getRankingPosition() {
        return rankingPosition;
    }

    public void setRankingPosition(int rankingPosition) {
        this.rankingPosition = rankingPosition;
    }

    public void addMember(TeamMember tm) {
        teamList.add(tm);
    }

    @Override
    public String toString() {
        return "[Team name: " + name + " Country: " + country + ", Ranking Position: " + rankingPosition + ", teamList: "
                + teamList + "]";
    };

    
}
