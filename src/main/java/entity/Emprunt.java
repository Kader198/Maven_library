package entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_emprunt")
    private String dateEmprunt;

    @Column(name = "date_retour")
    private String dateRetour;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "livre_id")
    private Livre livre;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "qte")
    private int qte;

    @Column(name = "etat")
    private int etat;

    public Emprunt() {

    }

    public Emprunt(String dateEmprunt, String dateRetour, Double prix,int qte,int etat) {
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.prix = prix;
        this.qte = qte;
        this.etat = etat;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }


    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
}
