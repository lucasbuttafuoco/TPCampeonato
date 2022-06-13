package FIFA.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Team {
    private String name;
    private String country;
    private int rankingPosition;
    private ArrayList<TeamMember> teamList;
    
    public Team(){
        name = " ";
        country = " ";
        rankingPosition = 1;
        teamList = new ArrayList<>();
    }

    public Team(String n, String c, int r, ArrayList<TeamMember> teamList2) {
        name = n;
        country = c;
        rankingPosition = r;
        teamList = teamList2;
    }

    
    /** 
     * @param name
     */
    @XmlElement(name = "equipo")
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @param country
     */
    @XmlElement(name = "pais")
    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
    /** 
     * @param teamList
     */
    @XmlElementWrapper(name = "jugadores")
    @XmlElement(name = "jugador")
    public void setTeamList(ArrayList<TeamMember> teamList) {
        this.teamList = teamList;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    };

    
    /** 
     * @return String
     */
    public String getCountry() {
        return country;
    }

    
    /** 
     * @return int
     */
    public int getRankingPosition() {
        return rankingPosition;
    }
    
    
    /** 
     * @return ArrayList<TeamMember>
     */
    public ArrayList<TeamMember> getTeamList() {
        return teamList;
    }

    
    /** 
     * @param rankingPosition
     */
    @XmlElement(name = "ranking")
    public void setRankingPosition(int rankingPosition) {
        this.rankingPosition = rankingPosition;
    }

    
    /** 
     * @param tm
     */
    public void addMember(TeamMember tm) {
        teamList.add(tm);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "[Team name: " + name + " Country: " + country + ", Ranking Position: " + rankingPosition + ", teamList: "
                + teamList + "]";
    };

    
}
