package dao;

import entity.Auteur;
import entity.Client;

import java.util.List;

public interface AuteurDao {
    void addAuteur(Auteur auteur);

    List<Auteur> getAllAuteur();

    void deleteAuteur(Integer auteurID);

    Auteur updateAuteur(int id,String nom);

    Auteur getAuteur(int auteurID);
}
