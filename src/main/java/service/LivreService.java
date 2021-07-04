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
        Long id = (long) livreId;
        Livre livre = em.find(Livre.class,id);
        em.remove(livre);
        em.getTransaction().commit();
        System.out.println(" livre => " + livre.getLibelle() + " supprimé");
    }

    @Override
    public Livre updateLivre(Livre livre) {
        em.getTransaction().begin();
        Livre updatedLivre = em.find(Livre.class,livre.getId());
        updatedLivre.setLibelle(livre.getLibelle());
        updatedLivre.setCout(livre.getCout());
        updatedLivre.setAuteurId(livre.getAuteurId());
        em.getTransaction().commit();
        return updatedLivre;
    }

    @Override
    public Livre getLivre(int livreId) {
        return null;
    }
}
