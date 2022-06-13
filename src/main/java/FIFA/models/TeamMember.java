package FIFA.models;

import FIFA.enums.Positions;

public abstract class TeamMember extends Person {

    private String actualTeam;

    public TeamMember(String name, String birthDate, String typeDNI, String dNI, String nationality, String pais) {
        super(name, birthDate, typeDNI, dNI, nationality);
        this.actualTeam = pais;
    }

    public String getActualTeam() {
        return actualTeam;
    }

    public void setActualTeam(String actualTeam) {
        this.actualTeam = actualTeam;
    }

    abstract public Positions getPosition();
    
  
}
