package FIFA.models;

public class Table {
    private int points;
    private String teamName;
    private int matchsPlayed;
    private int matchsWinned;
    private int matchsTied;
    private int matchsLost;
    private int goals;
    private int goalsAgainst;
    private int goalsDifference;

    public Table(String teamName) {
        this.points = 0;
        this.teamName = teamName;
        this.matchsPlayed = 0;
        this.matchsWinned = 0;
        this.matchsTied = 0;
        this.matchsLost = 0;
        this.goals = 0;
        this.goalsAgainst = 0;
        this.goalsDifference = 0;
    }

    public int getPoints() {
        return points;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getMatchsPlayed() {
        return matchsPlayed;
    }

    public int getMatchsWinned() {
        return matchsWinned;
    }

    public int getMatchsTied() {
        return matchsTied;
    }

    public int getMatchsLost() {
        return matchsLost;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalsDifference() {
        return goalsDifference;
    }

    public void updateTable(String teamName, int goals, int goalsReceieved){
        matchsPlayed++;
        if (goals == goalsReceieved){
            //TIED
            matchsTied++;
            points++;
        }
            else if (goals > goalsReceieved){
                //WINNER
                matchsWinned++;
                points=points+3;
            }
                else{
                    matchsLost++;
                }
        this.goals+=goals;
        goalsAgainst+=goalsReceieved;
        goalsDifference=this.goals-goalsAgainst;
    }
    

    




}
