package ML;
import weka.*;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Csv2arff4 {
	public static void main(String[] args) throws Exception {
		 FileOutputStream fos= new FileOutputStream("D:/downloadFolder/dataa/traiining_data.csv",true);
			PrintWriter pw =new PrintWriter(fos);
			ResultSet rs=null;
		   	Class c=Class.forName("com.mysql.cj.jdbc.Driver");
			 Driver pilote=(Driver)c.newInstance();
			 DriverManager.registerDriver(pilote);
			 //protocole de connexion
			 String protocole="jdbc:mysql:";
			 String ip="localhost";
		     String port="3306";
		     String nombase="javaproject";
		     String conString= protocole+"//"+ip+":"+port+"/"+nombase;
		     //indentifiants de conn et mtdp
		     String nomconnexion="root";
		     String motdepasse="";
		     //connexion
		     Connection con1=DriverManager.getConnection(conString, nomconnexion, motdepasse);
		     //envoi d'un requete generique
			 String query="SELECT * FROM resultat_scrapping where id<243 ;";
			PreparedStatement ps =con1.prepareStatement(query);
			rs=ps.executeQuery();
			String competenceStatement2="";
			String [] competencesListString = {"jee","sap", "html5", "python", "css3", "javascript" ,"react ", "jquery", "angular", "linux",  "php" ,"html","sql", "c++", "c#" ,"css", "vue" ,"docker","git","rest","boostrap",".net","js"};
            for(int i=0;i<competencesListString.length;i++) {
				competenceStatement2+=","+competencesListString[i];
			}
            //attributs:
			pw.println("poste"+competenceStatement2+",domaine");
		    		 
			String competence;
			String domaine;
			String description_entreprise, experience_requise,fonction,lien_annonce,localisation,niveau_etude,poste,secteur_activite,traits_perso,type_contrat;
			
			int pythonNumber=0;
			int sqlNumber=0;
			int htmlNumber=0;
			
			while(rs.next()) {
				String competences_requise=rs.getString("competences_requise");
				
				ArrayList lista=new ArrayList();
				for(int i=0;i<competencesListString.length;i++) {
					lista.add(false);
				}
               
				for(int j=0;j<competencesListString.length;j++) {
					if(competences_requise.toLowerCase().indexOf(competencesListString[j].toLowerCase())>=0) {
										
						lista.set(j, true);						
						
					}
					
				}
			
			
			
		        
				//experience_requise=rs.getString("experience_requise");
				
				//fonction=rs.getString("fonction");
				//localisation=rs.getString("localisation");
				//niveau_etude=rs.getString("niveau_etude");
				poste=rs.getString("poste");
				domaine=rs.getString("domaine");
				//secteur_activite=rs.getString("secteur_activite");
				//traits_perso=rs.getString("traits_perso");
				//type_contrat=rs.getString("type_contrat");
				String competenceStatement="";
				
				for(int i=0;i<competencesListString.length;i++) {
					competenceStatement+=","+lista.get(i);
				}
				System.out.println(competenceStatement);
				//valeurs
				pw.println(poste+competenceStatement+","+domaine);
				
			}
			
			
			pw.close();
			//csv to arff
		CSVLoader loader = new CSVLoader();
			loader.setSource(new File("D:/downloadFolder/dataa/traiining_data.csv"));	
			Instances data=loader.getDataSet();
			
			ArffSaver saver=new ArffSaver();
			saver.setInstances(data);
			saver.setFile(new File("D:/downloadFolder/dataa/traiining_data.arff"));
			saver.writeBatch();
		
		}
		
	

}
