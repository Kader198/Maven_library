package dao;

import entity.Client;
import entity.Livre;
import java.util.List;

public interface ClientDao {
    void save(Client client);

    List<Client> getAllClient();

    void deleteClient(Integer clientID);

    Client updateClient(Client client);

    Client getClient(int clientID);
}
