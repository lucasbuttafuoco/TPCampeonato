package FIFA.models;


public class Referee extends Person {
    public Referee(String name, String birthDate, String typeDNI, String dNI, String nationality, int yearsOfService) {
        super(name, birthDate, typeDNI, dNI, nationality);
        this.yearsOfService = yearsOfService;
    }

    private int yearsOfService;

    public int getyearsOfService() {
        return yearsOfService;
    }

    public void setyearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    @Override
    public String toString() {
        return super.toString() + " Referee: [years on service:" + yearsOfService +"] ";
    }


}
