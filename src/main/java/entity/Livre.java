package entity;

import javax.persistence.*;

@Entity(name = "livre")
public class Livre {

    @Id
    @GeneratedValue
    private int id;
    private String libelle;
    private Double cout;

    @ManyToOne()
    @JoinColumn(name = "auteur_id")
    private Auteur auteur;


    public Livre(){

    }

    public Livre(String libelle, Double cout) {
        this.libelle = libelle;
        this.cout = cout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getCout() {
        return cout;
    }

    public void setCout(Double cout) {
        this.cout = cout;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
}
