package dao;

import entity.Livre;
import entity.Emprunt;
import java.util.Date;
import java.util.List;

public interface EmpruntDao {

    void addEmprunt(Emprunt emprunt);

    List<Emprunt> getAllEmprunt();

    void deleteEmprunt(int idEmprunt);

    Emprunt editEmprunt(int idEmprunt, int nbrJoursplus);

    public Emprunt  getEmprunt(int idEmprunt);
}
