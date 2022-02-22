import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controle.based;

	
public class download {
	

	
	 public void downloadFile(String path,Connection connection) {
	 
	   try {
		   
		FileOutputStream fos = new FileOutputStream(path+"\\data22.csv",true);   
	    PrintWriter pw = new PrintWriter(fos);
	    ResultSet rs=null;
	 
	    String query="select * from resultat_scrapping";
	    PreparedStatement ps=connection.prepareStatement(query);
	    rs=ps.executeQuery();
	    pw.println("poste,localisation,secteur_activite,experience_requise,niveau_etude,type_contrat,fonction,lien_annonce,competences_requise,traits_perso");
	   String poste,localisation,secteur_activite,experience_requise,niveau_etude,type_contrat,fonction,lien_annonce,competences_requise,traits_perso;
	    while(rs.next()){
	    poste=rs.getString("poste");
	    localisation=rs.getString("localisation");
	    secteur_activite=rs.getString("secteur_activite");
	    experience_requise=rs.getString("experience_requise");
	    niveau_etude=rs.getString("niveau_etude");
	    type_contrat=rs.getString("type_contrat");
	    fonction=rs.getString("fonction");
	    lien_annonce=rs.getString("lien_annonce");
	    competences_requise=rs.getString("competences_requise");
	    traits_perso=rs.getString("traits_perso");
	    pw.println(poste+","+localisation+","+secteur_activite+","+experience_requise+","+niveau_etude+","+type_contrat+","+fonction+","+lien_annonce+","+competences_requise+","+traits_perso);
	    }
	    pw.close();
	  
	 
	   }
	    catch (Exception e) {
	    e.printStackTrace();
	   } 
	 }
	 }
	

