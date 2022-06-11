package FIFA.models;

import java.util.Random;

public class Match {
    private String date;
    private Team local;
    private Team visitor;
    private Referee ref;
    //private int index;

    public Match(String date, Team local, Team visitor, Referee ref) {
        this.date = date;
        this.local = local;
        this.visitor = visitor;
        this.ref = ref;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public void result(Championship championship) {
        Random randomGenerator = new Random();
        int localGoal = randomGenerator.nextInt(10);
        int visitorGoal = randomGenerator.nextInt(10);
        //ArrayList<Table> table;

        System.out.println(
                "Resultado " + local.getName() + " " + localGoal + " - " + visitorGoal + " " + visitor.getName());
        System.out.println("Referi del partido: " + ref.toString());
        
        //table = championship.getTable();
        //index = table.indexOf(local.getName());
        //table.get(index).updateTable(local.getName(),localGoal,visitorGoal);
        
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
