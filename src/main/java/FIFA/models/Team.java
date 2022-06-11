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

    @XmlElement(name = "equipo")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "pais")
    public void setCountry(String country) {
        this.country = country;
    }
    
    
    @XmlElementWrapper(name = "jugadores")
    @XmlElement(name = "jugador")
    public void setTeamList(ArrayList<TeamMember> teamList) {
        this.teamList = teamList;
    }

    public String getName() {
        return name;
    };

    public String getCountry() {
        return country;
    }

    public int getRankingPosition() {
        return rankingPosition;
    }
    
    @XmlElement(name = "ranking")
    public void setRankingPosition(int rankingPosition) {
        this.rankingPosition = rankingPosition;
    }

    public void addMember(TeamMember tm) {
        teamList.add(tm);
    }

    @Override
    public String toString() {
        return "[Team name: " + name + " Country: " + country + ", Ranking Position: " + rankingPosition + ", teamList: "
                + teamList + "]";
    };

    
}
