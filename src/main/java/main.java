import entity.Client;
import entity.Emprunt;
import entity.Livre;
import service.ClientService;
import service.EmpruntService;
import service.LivreService;

public class main {
    public static void main(String[] args) {
        LivreService livreService = new LivreService();
        ClientService clientService = new ClientService();
        EmpruntService empruntService = new EmpruntService();
        Emprunt emprunt = new Emprunt();
        Livre livre1 = new Livre("Alignement de texte",12300d);
        Client client1 = new Client("Ahmed","Sidi",32);
        livreService.addLivre(livre1);
        clientService.save(client1);
        emprunt.setClient(client1);
        emprunt.setLivre(livre1);
        empruntService.addEmprunt(emprunt);
        System.out.println("Emprunt ajouté");
    }
}
