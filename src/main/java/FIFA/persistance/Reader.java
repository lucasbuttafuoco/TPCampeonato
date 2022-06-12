package FIFA.persistance;

import java.io.File;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.util.*;

import FIFA.models.DT;
import FIFA.models.Player;
import FIFA.models.Referee;
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
            for (int index = 0; index < nList.getLength(); index++) {
                Node nNode = nList.item(index);
               
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    a=eElement.getElementsByTagName("nombre").item(0).getTextContent();	
                    String teamName=new String(a);
                    a=eElement.getElementsByTagName("pais").item(0).getTextContent();	
                    String teamCountry=new String(a);
                    a=eElement.getElementsByTagName("ranking").item(0).getTextContent();	
                    int ranking=Integer.parseInt(a);
                    int i=0;
                    Node nNodePlantel = nList.item(index);
                    Element eElementPlantel = (Element) nNodePlantel;
                    ArrayList<TeamMember> teamList= new ArrayList<TeamMember>();
                    while(eElementPlantel.getElementsByTagName("plantel").item(i)!=null){

                        while(eElement.getElementsByTagName("jugador").item(i)!=null) {
                            Element elementPlayer = (Element) eElement.getElementsByTagName("jugador").item(i);
                            NamedNodeMap jugadorAttributes = elementPlayer.getAttributes();
                            
                            a = jugadorAttributes.item(0).getTextContent();
                            String pos = new String(a);
                            a = jugadorAttributes.item(1).getTextContent();
                            int handi = Integer.parseInt(a);

                            a=eElement.getElementsByTagName("tipoDocumento").item(i).getTextContent();
                            String typeDoc=new String(a);
                            a=eElement.getElementsByTagName("nroDocumento").item(i).getTextContent();
                            String docNum=new String(a);
                            a=eElement.getElementsByTagName("nombrex").item(i).getTextContent();
                            String name=new String(a);
                            a=eElement.getElementsByTagName("paisx").item(i).getTextContent();
                            String nationality=new String(a);
                            a=eElement.getElementsByTagName("fechaNacimiento").item(i).getTextContent();
                            String birthDate=new String(a); 
                            
                            Player player = new Player(name, birthDate, typeDoc, docNum, nationality, teamName, pos, handi);
                            teamList.add(player);
                            i++;
                        }
                        if (eElement.getElementsByTagName("dt").item(0)!=null) {
                            a=eElement.getElementsByTagName("tipoDocumento").item(i).getTextContent();
                            String typeDoc=new String(a);
                            a=eElement.getElementsByTagName("nroDocumento").item(i).getTextContent();
                            String docNum=new String(a);
                            a=eElement.getElementsByTagName("nombrex").item(i).getTextContent();
                            String name=new String(a);
                            a=eElement.getElementsByTagName("paisx").item(i).getTextContent();
                            String nationality=new String(a);
                            a=eElement.getElementsByTagName("fechaNacimiento").item(i).getTextContent();
                            String birthDate=new String(a); 
                            a=eElement.getElementsByTagName("titulosObtenidos").item(0).getTextContent();
                            int titulosObtenidos=Integer.parseInt(a);
                            DT dt = new DT(name, birthDate, typeDoc, docNum, nationality, teamName, titulosObtenidos);
                            teamList.add(dt);
                        }
                    }
                    
                    Team team = new Team(teamName,teamCountry,ranking,teamList);
                    teams.add(team);
                }
                                
            }
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void readReferee(List<Referee> referees){
        String a=new String();
        try{
            File inputFile = new File("arbitros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("arbitro");   

            for (int index = 0; index < nList.getLength(); index++) {
                Node nNode = nList.item(index);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element asda = (Element) nNode;
                    String typeDoc=new String(a);
                    a=asda.getElementsByTagName("nroDocumento").item(index).getTextContent();
                    String docNum=new String(a);
                    a=asda.getElementsByTagName("nombrex").item(index).getTextContent();
                    String name=new String(a);
                    a=asda.getElementsByTagName("paisx").item(index).getTextContent();
                    String nationality=new String(a);
                    a=asda.getElementsByTagName("fechaNacimiento").item(index).getTextContent();
                    String birthDate=new String(a);
                    a=asda.getElementsByTagName("aniosReferato").item(index).getTextContent();
                    int yearsOfService=Integer.parseInt(a);

                    Referee ref = new Referee(name, birthDate,typeDoc, docNum, nationality, yearsOfService);
                    referees.add(ref);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
