package org.example.classes;

import java.time.LocalDate;

public class DT extends TeamMember{
    public DT(String name, LocalDate birthDate, String typeDNI, String dNI, String nationality, Team actualTeam, int titles) {
        super(name, birthDate, typeDNI, dNI, nationality, actualTeam);
        this.titles=titles;
    }

    private int titles;

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }

}
