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
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public ClientService() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
    }

    @Override
    public void save(Client client) {
        em.getTransaction().begin();
        em.persist(client);
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
        em.getTransaction().begin();
        Long id = (long) clientID;
        Client client = em.find(Client.class,id);
        em.remove(client);
        em.getTransaction().commit();
        System.out.println(" Client => " + client.getNom() + " supprimé");
    }

    @Override
    public Client updateClient(Client client) {
        em.getTransaction().begin();
        Client updateClient = em.find(Client.class,client.getId());
        updateClient.setNom(client.getNom());
        updateClient.setPrenom(client.getPrenom());
        em.getTransaction().commit();
        return updateClient;
    }

    @Override
    public Client getClient(int clientID) {
        em.getTransaction().begin();
        Client client = em.find(Client.class,clientID);
        em.getTransaction().commit();
        return client;
    }

}
