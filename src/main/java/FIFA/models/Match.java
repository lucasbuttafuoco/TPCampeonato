package FIFA.models;

import java.util.ArrayList;
import java.util.Random;

public class Match {
    private String date;
    private Team local;
    private Team visitor;
    private Referee ref;

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

    public void result(ArrayList<TableComponent> positionTable, ArrayList<TableComponent> zoneTable) {
        String localName = local.getName();
        String visitorName = visitor.getName();
        int localRanking = local.getRankingPosition();
        int visitorRanking = visitor.getRankingPosition();

        boolean result;
        ArrayList<Integer> goalResult = new ArrayList<Integer>();
        int goalsLocal;
        int goalsVisitor;

        if(localRanking > visitorRanking){
            result = calculateLoserProb(localRanking, visitorRanking);
            goalResult=calculateGoals();
            if (result){
                goalsLocal=goalResult.get(1);
                goalsVisitor=goalResult.get(0);
            }
            else{
                goalsLocal=goalResult.get(0);
                goalsVisitor=goalResult.get(1);
            }
        }
        else{
            result = calculateLoserProb(visitorRanking, localRanking);
            goalResult=calculateGoals();
            if (result){
                goalsLocal=goalResult.get(0);
                goalsVisitor=goalResult.get(1);
            }
            else{
                goalsLocal=goalResult.get(1);
                goalsVisitor=goalResult.get(0);
            }
        }

        updateGlobalTable(positionTable, localName, visitorName, goalsLocal, goalsVisitor);
        updateZoneTable(zoneTable, localName, visitorName, goalsLocal, goalsVisitor);

        //show match result
        System.out.println(
            "Resultado " + localName + " " + goalsLocal + " - " + goalsVisitor + " " + visitorName);
        System.out.println("Referi del partido: " + ref.toString());
        System.out.println("-----------------------------------------");

    }
    
    private boolean calculateLoserProb(int team1ranking, int team2ranking){
        float p = team1ranking+team2ranking;
        float result;
        double random = Math.random();
        if(team1ranking > team2ranking){
            result = team1ranking/p;
        }
        else{
            result = team2ranking/p;
        }
        if(result > random){
            return true;
        }
        else{
            return false;
        }
    }

    private ArrayList<Integer> calculateGoals(){
        Random randomGenerator = new Random();
        Random randomGeneratorTie = new Random();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int loserGoals;
        int tieProbs = randomGeneratorTie.nextInt(5);
        if (tieProbs == 0){
            //tie 20% probs
            int goals = randomGenerator.nextInt(5);
            result.add(goals);
            result.add(goals);
        }
        else{
            int winnerGoals = randomGenerator.nextInt(5)+1;
            result.add(winnerGoals);
            if (winnerGoals == 1){
                loserGoals = 0;
            }
            else{
                loserGoals = randomGenerator.nextInt(winnerGoals-1);
            }
            
            result.add(loserGoals);
        }   
        return result;
    }

    private void updateZoneTable(ArrayList<TableComponent> zoneTable, String localName, String visitorName, int goalsLocal, int goalsVisitor){
        int i = 0;
        i = 0;
        while(zoneTable.get(i).getTeamName().compareTo(localName) != 0){
            i++;
        }
        zoneTable.get(i).updateTable(localName, goalsLocal, goalsVisitor);
        i = 0;
        while(zoneTable.get(i).getTeamName().compareTo(visitorName) != 0){
            i++;
        }
        zoneTable.get(i).updateTable(visitorName, goalsVisitor, goalsLocal);
        Championship.updatePositionTable(zoneTable);

    }

    private void updateGlobalTable(ArrayList<TableComponent> positionTable, String localName, String visitorName, int goalsLocal, int goalsVisitor){
        int i = 0;
        while(positionTable.get(i).getTeamName().compareTo(localName) != 0){
            i++;
        }
        positionTable.get(i).updateTable(localName, goalsLocal, goalsVisitor);
        i = 0;
        while(positionTable.get(i).getTeamName().compareTo(visitorName) != 0){
            i++;
        }
        positionTable.get(i).updateTable(visitorName, goalsVisitor, goalsLocal);
        Championship.updatePositionTable(positionTable);
    }

    public Team resultSemifinal(){
        String localName = local.getName();
        String visitorName = visitor.getName();
        int localRanking = local.getRankingPosition();
        int visitorRanking = visitor.getRankingPosition();
        int goalsLocal;
        int goalsVisitor;
        //
        boolean localLost = calculateLoserProb(localRanking, visitorRanking);
        ArrayList<Integer> goalResultFirst = new ArrayList<Integer>();
        goalResultFirst=calculateGoals();
        if (localLost){
            goalsLocal=goalResultFirst.get(1);
            goalsVisitor=goalResultFirst.get(0);
        }
        else{
            goalsLocal=goalResultFirst.get(0);
            goalsVisitor=goalResultFirst.get(1);
        }
        
        System.out.println(
            "Resultado Semifinal de ida: " + localName + " " + goalsLocal + " - " + goalsVisitor + " " + visitorName);
        System.out.println("Referi del partido: " + ref.toString());
        System.out.println("-----------------------------------------");

        ArrayList<Integer> goalResultSecond = new ArrayList<Integer>();
        goalResultSecond=calculateGoals();
        if (localLost){
            goalsLocal+=goalResultSecond.get(1);
            goalsVisitor+=goalResultSecond.get(0);
        }
        else{
            goalsLocal+=goalResultSecond.get(0);
            goalsVisitor+=goalResultSecond.get(1);
        }
        System.out.println(
            "Resultado final etapa de Semifinal: " + localName + " " + goalsLocal + " - " + goalsVisitor + " " + visitorName);
        System.out.println("Referi del partido: " + ref.toString());
        System.out.println("-----------------------------------------");
        if (goalsLocal == goalsVisitor){
            System.out.println("--- Penales ---");
            Team winner = penalties(this.local,this.visitor);
            return winner;
        }
        else if( goalsLocal > goalsVisitor){
            return this.local;

        }
        else {
            return this.visitor;
        }
    }

    public Team penalties(Team local, Team visitor){
        Random randomGenerator = new Random();
        int penaltiesTeamLocal = randomGenerator.nextInt(5);
        int penaltiesTeamVisitor = randomGenerator.nextInt(5);
        if (penaltiesTeamLocal == penaltiesTeamVisitor){
            return penalties(local,visitor);
        }
        System.out.println("Penales realizados por " + local.getName() + " " + penaltiesTeamLocal);
        System.out.println("Penales realizados por " + visitor.getName() + " " + penaltiesTeamVisitor);
        if (penaltiesTeamLocal > penaltiesTeamVisitor){
            return local;
        }
        else{
            return visitor;
        }
    } 

}
