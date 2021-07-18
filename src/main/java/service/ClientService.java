package service;

import dao.ClientDao;
import entity.Client;
import entity.Emprunt;
import entity.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ClientService implements ClientDao {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    private final EntityManager em;

    public ClientService() {
        em = emf.createEntityManager();
    }

    public void getConnectionIfAlreadyExists(){
        if (!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
    }

    @Override
    public void save(Client client) {
        getConnectionIfAlreadyExists();
        em.merge(client);
        em.getTransaction().commit();
    }

    @Override
    public List<Client> getAllClient() {
        String sql = "SELECT c FROM clients c ";
        Query query = em.createQuery(sql);
        List<Client> clients = query.getResultList();
        return clients;
    }

    @Override
    public void deleteClient(Integer clientID) {
        getConnectionIfAlreadyExists();
        Client client = em.find(Client.class,clientID);
        em.remove(client);
        em.getTransaction().commit();
        System.out.println(" Client => " + client.getNom() + " supprimé");
    }

    @Override
    public Client updateClient(Client client,int id) {
        getConnectionIfAlreadyExists();
        Client updateClient = em.find(Client.class,id);
        updateClient.setNom(client.getNom());
        updateClient.setPrenom(client.getPrenom());
        updateClient.setAge(client.getAge());
        em.getTransaction().commit();
        return updateClient;
    }

    @Override
    public Client getClient(int clientID) {
        getConnectionIfAlreadyExists();
        Client client = em.find(Client.class,clientID);
        em.getTransaction().commit();
        return client;
    }

}
