package FIFA.persistance;

import java.io.File;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.util.*;

import FIFA.enums.Positions;
import FIFA.models.Player;
import FIFA.models.Team;
import FIFA.models.TeamMember;

public class Reader {
    public void readTeam(List<Team> teams){
        String a=new String();
        try{
            File inputFile = new File("torneo.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("equipo");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    a=eElement.getElementsByTagName("nombre").item(0).getTextContent();	
                    String nombre=new String(a);
                    System.out.println("nombre:" + nombre);
                    a=eElement.getElementsByTagName("pais").item(0).getTextContent();	
                    String pais=new String(a);
                    System.out.println("pais:" + pais);
                    a=eElement.getElementsByTagName("ranking").item(0).getTextContent();	
                    int ranking=Integer.parseInt(a);
                    System.out.println("ranking:" + ranking);
                    int i=0;
                    
                    ArrayList<TeamMember> teamList= new ArrayList<TeamMember>();

                    while(eElement.getElementsByTagName("jugador").item(i)!=null) {
                        //System.out.println(eElement);
                        a= eElement.getAttribute("posicion");
                        //System.out.println(a);
                        //Positions pos= Positions.valueOf(a);
                        Positions pos = Positions.DEFENSOR;
                        a= eElement.getAttribute("puntuacion");
                        //System.out.println(a.getClass());
                        int handi= 3;
                        //System.out.println(handi);
                        a=eElement.getElementsByTagName("tipoDocumento").item(i).getTextContent();
	            	    String tipodoc=new String(a);
                        a=eElement.getElementsByTagName("nroDocumento").item(i).getTextContent();
	            	    String nroDoc=new String(a);
                        a=eElement.getElementsByTagName("nombre").item(i).getTextContent();
	            	    String name=new String(a);
                        a=eElement.getElementsByTagName("pais").item(i).getTextContent();
	            	    String nationality=new String(a);
                        a=eElement.getElementsByTagName("fechaNacimiento").item(i).getTextContent();
	            	    String fechaNacimiento=new String(a); 
                        Player player = new Player(name, fechaNacimiento, tipodoc, nroDoc, nationality, pais, pos, handi);
                        teamList.add(player);
                    }
                    while(eElement.getElementsByTagName("jugador").item(i)!=null) {
                    }
                    Team team = new Team(nombre,pais,ranking,teamList);
                    teams.add(team);
                }
                
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
