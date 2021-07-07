package service;

import dao.LivreDao;
import entity.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LivreService implements LivreDao {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public LivreService() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
    }

    @Override
    public void addLivre(Livre livre) {
        em.getTransaction().begin();
        em.persist(livre);
        em.getTransaction().commit();
    }

    @Override
    public List<Livre> getAllLivre() {
        String sql = "SELECT S FROM livre S ";
        Query query = em.createQuery(sql);
        List<Livre> etudiants = query.getResultList();
        return etudiants;
    }

    @Override
    public void deleteLivre(Integer livreId) {
        em.getTransaction().begin();
        Livre livre = em.find(Livre.class,livreId);
        em.remove(livre);
        em.getTransaction().commit();
        System.out.println(" livre => " + livre.getLibelle() + " supprimé");
    }

    @Override
    public Livre updateLivre(String libelle,double cout,int auteurId,int id) {
        em.getTransaction().begin();
        Livre updatedLivre = em.find(Livre.class,id);
        updatedLivre.setLibelle(libelle);
        updatedLivre.setCout(cout);
        em.getTransaction().commit();
        return updatedLivre;
    }

    @Override
    public Livre getLivre(int livreId) {
        em.getTransaction().begin();
        Livre livre = em.find(Livre.class,livreId);
        em.getTransaction().commit();
        return livre;
    }
}
