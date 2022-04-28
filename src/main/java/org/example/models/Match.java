package org.example.models;

import java.time.LocalDate;
import java.util.Random;

public class Match {
    private LocalDate date;
    private Team local;
    private Team visitor;
    private Referee ref;

    public Match(LocalDate date, Team local, Team visitor, Referee ref) {
        this.date = date;
        this.local = local;
        this.visitor = visitor;
        this.ref = ref;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Team getLocal() {
        return local;
    }

    public void setLocal(Team local) {
        this.local = local;
    }

    public Team getVisitor() {
        return visitor;
    }

    public void setVisitor(Team visitor) {
        this.visitor = visitor;
    }

    public Referee getRef() {
        return ref;
    }

    public void setRef(Referee ref) {
        this.ref = ref;
    }

    public void result() {
        Random randomGenerator = new Random();
        int localGoal = randomGenerator.nextInt(10);
        int visitorGoal = randomGenerator.nextInt(10);

        System.out.println(
                "Resultado " + local.getName() + " " + localGoal + " - " + visitorGoal + " " + visitor.getName());
        System.out.println("Referi del partido: " + ref.toString());
        if (localGoal > visitorGoal) {
            // actualizar tabla
            System.out.println("Ganador: " + local.getName() + "\n " + local.toString());

        } else if (localGoal < visitorGoal) {
            // actualizar tabla
            System.out.println("Ganador: " + visitor.getName() + "\n " + visitor.toString());
        } else {
            // actualizar: un punto a cada uno
            System.out.println("Empate");
        }
    }

}
