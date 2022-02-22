package Dao;
public class Annonce {
    private String competences;

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getCompetences() {
        return competences;
    }

    public Annonce( String traits_perso,String fonction,String competences, String profil_recherche, String localisation, String secteur_activite, String experience_requise, String niveau_etude, String type_contrat, String lien_annonce) {
        this.competences = competences;
        this.profil_recherche = profil_recherche;
        this.localisation = localisation;
        this.fonction=fonction;
        this.secteur_activite = secteur_activite;
        this.experience_requise = experience_requise;
        this.niveau_etude = niveau_etude;
        this.type_contrat = type_contrat;
      //  this.entreprise = entreprise;
        this.traits_perso= traits_perso;
       
        this.lien_annonce = lien_annonce;
    }
    private String traits_perso ;

    public void setTraits_perso(String traits_perso) {
        this.traits_perso = traits_perso;
    }

    public String getTraits_perso() {
        return traits_perso;
    }
    
   private  String profil_recherche;
   
   private  String localisation;
   
  private String fonction;

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getFonction() {
        return fonction;
    }
   
   private  String secteur_activite;
    
   private String experience_requise;
   
   private String niveau_etude;
   
   private String type_contrat;
     
   private String entreprise;
   private String lien_annonce;
      public Annonce() {
        this.profil_recherche = "";
        this.localisation = "";
       
        this.secteur_activite = "";
        this.experience_requise = "";
        this.niveau_etude = "";
        this.type_contrat = "";
     //   this.entreprise = "";
        
        this.lien_annonce = "";
    }

  

   /* public String getEntreprise() {
        return entreprise;
    }*/

    public String getProfil_recherche() {
        return profil_recherche;
    }

    public void setProfil_recherche(String profil_recherche) {
        this.profil_recherche = profil_recherche;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

   

    public String getSecteur_activite() {
        return secteur_activite;
    }

    public void setSecteur_activite(String secteur_activite) {
        this.secteur_activite = secteur_activite;
    }

    public String getExperience_requise() {
        return experience_requise;
    }

    public void setExperience_requise(String experience_requise) {
        this.experience_requise = experience_requise;
    }

    public String getNiveau_etude() {
        return niveau_etude;
    }

    public void setNiveau_etude(String niveau_etude) {
        this.niveau_etude = niveau_etude;
    }

    public String getType_contrat() {
        return type_contrat;
    }

    public void setType_contrat(String type_contrat) {
        this.type_contrat = type_contrat;
    }

  

   

    public String getLien_annonce() {
        return lien_annonce;
    }

    public void setLien_annonce(String lien_annonce) {
        this.lien_annonce = lien_annonce;
    }
     public String toString() {
         return "Annonce [profil=" + getProfil_recherche()+ ", localisation=" + getLocalisation() + ", lien_entreprise=" +getLien_annonce() 
				+  ", Niveau_etude"+ getNiveau_etude()+", type de contrat" +getType_contrat()+"]";
    }
    public void affiche(){
        System.out.println("Les donnees concernant le livre sont:  "+this.toString());
    }

   /* void setEntreprise(String entreprise) {
        this.entreprise=entreprise; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
