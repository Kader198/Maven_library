package entity;

import javax.persistence.*;

@Entity(name = "auteur")
public class Auteur {
    private int id;
    private String nom;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public Auteur() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Auteur(String nom) {
        this.nom = nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }
}
