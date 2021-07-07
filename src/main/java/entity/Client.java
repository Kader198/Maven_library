package entity;

import javax.persistence.*;

@Entity(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    private String prenom;

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

}
