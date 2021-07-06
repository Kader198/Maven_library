package dao;

import entity.Auteur;
import entity.Client;

import java.util.List;

public interface AuteurDao {
    void save(Auteur auteur);

    List<Auteur> getAllAuteur();

    void deleteAuteur(Integer auteurID);

    Auteur updateAuteur(Auteur auteur);

    Auteur getAuteur(int auteurID);
}
