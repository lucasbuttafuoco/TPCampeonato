package FIFA.models;


public class DT extends TeamMember{
    public DT(String name, String birthDate, String typeDNI, String dNI, String nationality, String actualTeam, int titles) {
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

    @Override
    public String toString() {
        return super.toString() + "DT [titles=" + titles + "]";
    }

    
}
