package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String prenom;
    private int age;

    @OneToMany(targetEntity = Emprunt.class,mappedBy = "client",cascade = { CascadeType.ALL },orphanRemoval = false)
    private List<Emprunt> emprunts = new ArrayList<>();

    public Client(){

    }

    public Client(String nom, String prenom,int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
