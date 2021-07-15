package service;


import dao.EmpruntDao;
import entity.Emprunt;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmpruntService implements EmpruntDao {

    private static final String PERSISTENCE_UNIT_NAME = "default";
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public EmpruntService() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
    }


    @Override
    public void addEmprunt(Emprunt emprunt) {
        em.getTransaction().begin();
        em.merge(emprunt);
        em.getTransaction().commit();
    }

    @Override
    public List<Emprunt> getAllEmprunt() {

        String sql = "SELECT S FROM Emprunt S ";
        Query query = em.createQuery(sql);
        List<Emprunt> emprunts = query.getResultList();
        return emprunts;

    }

    @Override
    public void deleteEmprunt(int idEmprunt) {

        em.getTransaction().begin();
        Emprunt emprunt = em.find(Emprunt.class,idEmprunt);
        em.remove(emprunt);
        em.getTransaction().commit();
        System.out.println(" emprunt => " + emprunt.getId() + " supprimé");

    }

    @Override
    public Emprunt editEmprunt(int idEmprunt, int nbrJoursplus) {

        em.getTransaction().begin();
        Emprunt editedEmprunt = em.find(Emprunt.class,idEmprunt);
        editedEmprunt.setDateEmprunt(editedEmprunt.getDateEmprunt());
        editedEmprunt.setDateRetour(editedEmprunt.getDateRetour());
        editedEmprunt.setPrix((editedEmprunt.getPrix())+(nbrJoursplus*editedEmprunt.getPrix()));
        em.getTransaction().commit();
        return editedEmprunt;

    }

    @Override
    public Emprunt getEmprunt(int idEmprunt) {
        em.getTransaction().begin();
        Emprunt emprunt = em.find(Emprunt.class,idEmprunt);
        em.getTransaction().commit();
        return emprunt;
    }
}
