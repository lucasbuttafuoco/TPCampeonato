package FIFA.models;

public abstract class Person{
    private String name;
    private String birthDate;
    private String typeDNI;
    private String DNI;
    private String nationality;

    public Person(String name, String birthDate, String typeDNI, String dNI, String nationality) {
        this.name = name;
        this.birthDate = birthDate;
        this.typeDNI = typeDNI;
        DNI = dNI;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getTypeDNI() {
        return typeDNI;
    }

    public void setTypeDNI(String typeDNI) {
        this.typeDNI = typeDNI;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }
    
    public String getNationality() {
        return nationality;
    };

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    
    public String toString(){
        return ("\n - Name: " + name + " Birth date: " + birthDate + " " + typeDNI +  ": " + DNI +  " Nationality: " + nationality);
    }
}
