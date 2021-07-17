package service;

import dao.LivreDao;
import entity.Auteur;
import entity.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LivreService implements LivreDao {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    private final EntityManager em;

    public LivreService() {
        em = emf.createEntityManager();
    }

    public void getConnectionIfAlreadyExists(){
        if (!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
    }

    @Override
    public void addLivre(Livre livre) {
        getConnectionIfAlreadyExists();
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
        getConnectionIfAlreadyExists();
        Livre livre = em.find(Livre.class,livreId);
        em.remove(livre);
        em.getTransaction().commit();
        System.out.println(" livre => " + livre.getLibelle() + " supprimé");
    }

    @Override
    public void updateLivre(Livre livre) {
        getConnectionIfAlreadyExists();
        em.merge(livre);
        em.getTransaction().commit();
    }

    @Override
    public Livre getLivre(int livreId) {
        getConnectionIfAlreadyExists();
        Livre livre = em.find(Livre.class,livreId);
        em.getTransaction().commit();
        return livre;
    }
}
