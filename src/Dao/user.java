package Dao;

public class user {
   private String nom,prenom,username,password,email;

   public user(String nom, String prenom, String username, String password, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public user() {
		this.nom = "";
		this.prenom = "";
		this.username = "";
		this.password = "";
		this.email = "";
	}
public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



@Override
public String toString() {
	return "user [nom=" + nom + ", prenom=" + prenom + ", username=" + username + ", password=" + password + ", email="
			+ email + "]";
} 
public void affiche() {
	System.out.println(this.toString());
}
   
}
