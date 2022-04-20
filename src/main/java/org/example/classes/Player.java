package org.example.classes;
import java.time.LocalDate;
import org.example.enums.*;

public class Player extends TeamMember {
    private Positions position;
    private int handicap;

    public Player(String name, LocalDate birthDate, String typeDNI, String dNI, String nationality, Positions position,
            int handicap) {
        super(name, birthDate, typeDNI, dNI, nationality);
        this.position = position;
        this.handicap = handicap;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public int getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    @Override
    public String toString() {
        return super.toString() + " Player: [handicap:" + handicap + ", position:" + position + "]";
    }

    

};
