package dao;

import entity.Livre;

import java.util.List;

public interface LivreDao {
    void addLivre(Livre livre);

    List<Livre> getAllLivre();

    void deleteLivre(Integer livreId);

    Livre updateLivre(String libelle,double cout,int auteur,int id);

    Livre getLivre(int livreId);
}
