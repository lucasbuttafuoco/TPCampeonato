package org.example.classes;

import java.time.LocalDate;

public abstract class TeamMember extends Person {
    public TeamMember(String name, LocalDate birthDate, String typeDNI, String dNI, String nationality) {
        super(name, birthDate, typeDNI, dNI, nationality);
    }

    
}
