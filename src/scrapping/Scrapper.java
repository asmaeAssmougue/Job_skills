package scrapping;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import Dao.Annonce;
import controle.based;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 import java.sql.SQLException;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document.OutputSettings;

import java.sql.Statement;
/**
 *
 * @author HP
 */
public class Scrapper {

     
     
     
     public static void main(String[] args) throws Exception {
         Annonce annonce =new Annonce();
         based methode=new based();
         String url1="https://www.rekrute.com/offres.html?s=3&p=1&o=1&query=full+stack&keyword=full+stack&st=d";//50lignes
        String  url2="https://www.rekrute.com/offres.html?s=2&p=1&o=1&query=sap&keyword=sap&st=d";//25 lignzs
        
         String  url4="https://www.rekrute.com/offres.html?clear=1&keyword=data%20analyste";//50lignes
          String url5="https://www.rekrute.com/offres.html?s=3&p=1&o=1&query=html+css&keyword=HTML+CSS";//50lignes
          String  url6="https://www.rekrute.com/offres.html?s=3&p=1&o=1&query=chef+de+projet+web+technique&keyword=Chef+de+projet+web+technique.+&st=d";//50
          String  url7="https://www.rekrute.com/offres.html?s=2&p=1&o=1&query=ingenieur+devops&keyword=ing%C3%A9nieur+devops&st=d";//25
         String url8="https://www.rekrute.com/offres.html?s=3&p=1&o=1&query=traffic+manager&keyword=traffic+manager&st=d";//50
         String url9="https://www.rekrute.com/offres.html?s=2&p=1&o=1&query=developpeur+net&keyword=developpeur+.NET&st=d";//25
         String url10="https://www.rekrute.com/offres.html?clear=1&keyword=ios";
          String url11="https://www.rekrute.com/offres.html?st=d&keywordNew=1&keyword=Consultant+en+Web+Analytique&filterLogo=&filterLogo=&filterLogo=&filterLogo=";//50lignes
        String  url12="https://www.rekrute.com/offres.html?s=2&p=1&o=1&query=cyber+securite&keyword=cyber+s%C3%A9curit%C3%A9&st=d";//25 lignzs
        
         String  url13="https://www.rekrute.com/offres.html?s=3&p=1&o=1&query=developpeur+c&keyword=developpeur+c%23&st=d";//50lignes
         String url14="https://www.rekrute.com/offres.html?s=3&p=1&o=1&query=html+css&keyword=HTML+CSS";//50lignes
          String  url15="https://www.rekrute.com/offres.html?s=3&p=1&o=1&query=chef+de+projet+web+technique&keyword=Chef+de+projet+web+technique.+&st=d";//50*/
          String  url16="https://www.rekrute.com/offres.html?s=2&p=1&o=1&query=software&keyword=software&st=";
          String  url17="https://www.rekrute.com/offres.html?st=d&keywordNew=1&keyword=front+end&filterLogo=&filterLogo=&filterLogo=&filterLogo=";
           String  url18="https://www.rekrute.com/offres.html?s=3&p=1&o=1&query=back+end&keyword=back+end+&st=d";
          String url19= "https://www.rekrute.com/offres.html?s=3&p=1&o=1&query=software+quality+assurance+analyst&keyword=Software+quality+assurance+analyst&st=d";
          String url20="https://www.rekrute.com/offres.html?s=2&p=1&o=1&query=cloud+developper&keyword=cloud+developper&st=d";//50lignes
          String  url21="https://www.rekrute.com/offres.html?s=3&p=1&o=1&query=developpeur&keyword=developpeur&st=d";//25 lignzs
          
           String  url3="https://www.rekrute.com/offres.html?st=d&keywordNew=1&keyword=freelance&filterLogo=&filterLogo=&filterLogo=&filterLogo=";//50lignes
            String url22="https://www.rekrute.com/offres.html?st=d&keywordNew=1&keyword=backend+&filterLogo=&filterLogo=&filterLogo=&filterLogo=";//50lignes
            String  url23="https://www.rekrute.com/offres.html?s=3&p=1&o=1&query=chef+de+projet+web+technique&keyword=Chef+de+projet+web+technique.+&st=d";//50
         
          final String[] urls={url1,url2,url3,url4,url5,url6,url7,url8,url9,url10,url11,url12,url13,url14,url15,url16,url17,url18,url19,url20,url21,url22};
     
          for(String url:urls ){ 
              
                      final  Document resultat_scrapping = Jsoup.connect(url).get();
              int i=0;//
              for(Element e: resultat_scrapping.select("div.col-sm-10.col-xs-12")) {
                  i++;
                     
                     annonce.setProfil_recherche((e.select("h2").text()).split("\\|")[0]);
                     annonce.setLocalisation((e.select("h2").text()).split("\\|")[1]);
                     
                     annonce.setSecteur_activite((e.select("li:nth-of-type(1)")).text().split("\\:") [1]);
                     annonce.setExperience_requise((e.select("li:nth-of-type(3)")).text().split("\\:") [1]);
                       
                     annonce.setNiveau_etude((e.select("li:nth-of-type(4)")).text().split("\\:") [1]);
                     annonce.setType_contrat((e.select("li:nth-of-type(5)")).text().split("\\:") [1]);
                     annonce.setFonction((e.select("li:nth-of-type(2)")).text().split("\\:") [1]);
                    
                    
                   
                    String lien_annonce =(e.select("h2 >a")).attr("href");
                    String full_annonce_link= "https://www.rekrute.com"+ lien_annonce ;
                    annonce.setLien_annonce(full_annonce_link);
                    System.out.println(full_annonce_link );
                    //partie de l 'annonce complete
                    
                    Document annonce_complete = Jsoup.connect(full_annonce_link).get();
                    for (Element annonces : annonce_complete.select("div.contentbloc")){
                        
                        annonce.setCompetences(annonces.select("div:nth-child(5)").text());
                        annonce.setTraits_perso(annonces.select("div:nth-child(7) > p ").text());
                    }
                    
                     
                   
                  //connexion a la base 
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/annonces","root","root");
                  System.out.println("Connexion effective ");
                  PreparedStatement insert = con.prepareStatement("insert into resultat_scrapping (`poste`, `localisation`, `secteur_activite`, `experience_requise`, `niveau_etude`, `type_contrat`,`fonction`,`lien_annonce`, `competences_requise` ,`traits_perso`) VALUES (?,?,?,?,?,?,?,?,?,?)");
                  //it will insert to the second field of data base wich is t[1] the value of variable name
                  insert.setString(1,annonce.getProfil_recherche());
                  insert.setString(2,annonce.getLocalisation());
                  insert.setString(3, annonce.getSecteur_activite());
                  insert.setString(4, annonce.getExperience_requise());
                  insert.setString(5,annonce.getNiveau_etude());
                  insert.setString(6,annonce.getType_contrat());
                  //insert.setString(7,annonce.getEntreprise());
                  insert.setString(7,annonce.getFonction());
                  insert.setString(8, annonce.getLien_annonce());
                  insert.setString(9,annonce.getCompetences());
                    insert.setString(10, annonce.getTraits_perso());
                    
                  insert.executeUpdate();
                  methode.selection(con);
                    
              }                           
                  
                 
        }           
             
     } 
      
     
     }



