package FIFA.models;

import FIFA.enums.*;

public class Player extends TeamMember {
    private Positions position;
    private int handicap;

    public Player(String name, String fechaNacimiento, String typeDNI, String dNI, String nationality, String pais, Positions pos,
            int handicap) {
        super(name, fechaNacimiento, typeDNI, dNI, nationality, pais);
        this.position = pos;
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
