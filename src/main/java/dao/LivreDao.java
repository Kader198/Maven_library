package dao;

import entity.Livre;

import java.util.List;

public interface LivreDao {
    void addLivre(Livre livre);

    List<Livre> getAllLivre();

    void deleteLivre(Integer livreId);

    Livre updateLivre(Livre livre);

    Livre getLivre(int livreId);
}
