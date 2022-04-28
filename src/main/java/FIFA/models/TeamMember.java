package FIFA.models;

import java.time.LocalDate;

public abstract class TeamMember extends Person {

    private Team actualTeam;

    public TeamMember(String name, LocalDate birthDate, String typeDNI, String dNI, String nationality, Team actualTeam) {
        super(name, birthDate, typeDNI, dNI, nationality);
        this.actualTeam = actualTeam; //se tendria que crear primero el team obligatoriamente
    }

    public Team getActualTeam() {
        return actualTeam;
    }

    public void setActualTeam(Team actualTeam) {
        this.actualTeam = actualTeam;
    }
  
}
