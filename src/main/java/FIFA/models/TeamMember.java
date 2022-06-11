package FIFA.models;


public abstract class TeamMember extends Person {

    private String actualTeam;

    public TeamMember(String name, String birthDate, String typeDNI, String dNI, String nationality, String pais) {
        super(name, birthDate, typeDNI, dNI, nationality);
        this.actualTeam = pais; //se tendria que crear primero el team obligatoriamente
    }

    public String getActualTeam() {
        return actualTeam;
    }

    public void setActualTeam(String actualTeam) {
        this.actualTeam = actualTeam;
    }
  
}
