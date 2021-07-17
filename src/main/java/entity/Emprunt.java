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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emprunt emprunt = (Emprunt) o;

        if (id != emprunt.id) return false;
        if (dateEmprunt != null ? !dateEmprunt.equals(emprunt.dateEmprunt) : emprunt.dateEmprunt != null) return false;
        if (dateRetour != null ? !dateRetour.equals(emprunt.dateRetour) : emprunt.dateRetour != null) return false;
        if (prix != null ? !prix.equals(emprunt.prix) : emprunt.prix != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateEmprunt != null ? dateEmprunt.hashCode() : 0);
        result = 31 * result + (dateRetour != null ? dateRetour.hashCode() : 0);
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        return result;
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
