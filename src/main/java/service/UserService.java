package service;

import dao.UserDao;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserService implements UserDao {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);;
    private final EntityManager em;

    public UserService() {
        em = emf.createEntityManager();
    }

    public void getConnectionIfAlreadyExists(){
        if (!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
    }

    @Override
    public boolean login(String nom,String password) {
        getConnectionIfAlreadyExists();
        String sql = "SELECT U FROM User U where  U.nom = :nom and U.password = :password ";
        Query query = em.createQuery(sql,User.class);
        query.setParameter("nom",nom);
        query.setParameter("password",password);
        try{
            User u = (User) query.getSingleResult();
            return true;
        }catch (Exception e){
            System.out.println("l'erreur => " + e.getMessage());
            return false;
        }
    }
}
