package service;

import dao.AuteurDao;
import entity.Auteur;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AuteurService implements AuteurDao {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    private final EntityManager em;

    public AuteurService() {
        em = emf.createEntityManager();
    }

    public void getConnectionIfAlreadyExists(){
        if (!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
    }
    @Override
    public void addAuteur(Auteur auteur) {
        getConnectionIfAlreadyExists();
        em.merge(auteur);
        em.getTransaction().commit();
    }

    @Override
    public List<Auteur> getAllAuteur() {
        String sql = "SELECT S FROM auteur S ";
        Query query = em.createQuery(sql);
        List<Auteur> auteurs = query.getResultList();
        return auteurs;
    }

    @Override
    public void deleteAuteur(Integer auteurID) {
        getConnectionIfAlreadyExists();
        Auteur auteur = em.find(Auteur.class,auteurID);
        em.remove(auteur);
        em.getTransaction().commit();
        System.out.println(" auteur  => " + auteur.getNom() + " supprimé");
    }

    @Override
    public Auteur updateAuteur(int id,String nom) {
        getConnectionIfAlreadyExists();
        Auteur updatedAuteur = em.find(Auteur.class,id);
        updatedAuteur.setNom(nom);
        em.getTransaction().commit();
        return updatedAuteur;
    }

    @Override
    public Auteur getAuteur(int auteurID) {
        getConnectionIfAlreadyExists();
        Auteur updatedAuteur = em.find(Auteur.class,auteurID);
        return updatedAuteur;
    }
}
