package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "livre")
public class Livre {
    private int id;
    private String libelle;
    private Double cout;
    private Integer auteurId;

    public Livre(){

    }

    public Livre(String libelle, Double cout, Integer auteurId) {
        this.libelle = libelle;
        this.cout = cout;
        this.auteurId = auteurId;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "cout")
    public Double getCout() {
        return cout;
    }

    public void setCout(Double cout) {
        this.cout = cout;
    }

    @Basic
    @Column(name = "auteur_id")
    public Integer getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(Integer auteurId) {
        this.auteurId = auteurId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livre livre = (Livre) o;

        if (id != livre.id) return false;
        if (libelle != null ? !libelle.equals(livre.libelle) : livre.libelle != null) return false;
        if (cout != null ? !cout.equals(livre.cout) : livre.cout != null) return false;
        return auteurId != null ? auteurId.equals(livre.auteurId) : livre.auteurId == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (cout != null ? cout.hashCode() : 0);
        result = 31 * result + (auteurId != null ? auteurId.hashCode() : 0);
        return result;
    }
}
