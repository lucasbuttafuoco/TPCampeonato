package FIFA.models;

public class TableComponent implements Comparable<TableComponent>{
    private Integer points;
    private String teamName;
    private int matchsPlayed;
    private int matchsWinned;
    private int matchsTied;
    private int matchsLost;
    private Integer goals;
    private int goalsAgainst;
    private Integer goalsDifference;

    public TableComponent(String teamName) {
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

    
    /** 
     * @return int
     */
    public int getPoints() {
        return points;
    }

    
    /** 
     * @return String
     */
    public String getTeamName() {
        return teamName;
    }

    
    /** 
     * @return int
     */
    public int getMatchsPlayed() {
        return matchsPlayed;
    }

    
    /** 
     * @return int
     */
    public int getMatchsWinned() {
        return matchsWinned;
    }

    
    /** 
     * @return int
     */
    public int getMatchsTied() {
        return matchsTied;
    }

    
    /** 
     * @return int
     */
    public int getMatchsLost() {
        return matchsLost;
    }

    
    /** 
     * @return int
     */
    public int getGoals() {
        return goals;
    }

    
    /** 
     * @return int
     */
    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    
    /** 
     * @return int
     */
    public int getGoalsDifference() {
        return goalsDifference;
    }

    
    /** 
     * @param teamName
     * @param goals
     * @param goalsReceieved
     */
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

    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(TableComponent o) {
        int result=this.points.compareTo(o.points);
        Integer resGoalsDif = 0;
        if(result == 0){
            resGoalsDif = this.goalsDifference.compareTo(o.goalsDifference);
            if(resGoalsDif == 0){
                return this.goals.compareTo(o.goals);
            }
            else{
                return resGoalsDif;
            }    
        }
        else{
            return result;
        }      
    }
}
