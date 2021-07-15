package controller.emprunt;

import entity.Auteur;
import entity.Client;
import entity.Emprunt;
import entity.Livre;
import jakarta.servlet.annotation.WebServlet;
import service.ClientService;
import service.EmpruntService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.AuteurService;
import service.LivreService;

import java.io.DataInput;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/emprunts")
public class EmpruntController extends HttpServlet {
    public EmpruntService empruntService = new EmpruntService();
    public LivreService livreService = new LivreService();
    public ClientService clientService = new ClientService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emprunt> emprunts = empruntService.getAllEmprunt();
        List<Livre> livres = livreService.getAllLivre();
        List<Client> clients = clientService.getAllClient();
        req.setAttribute("livres",livres);
        req.setAttribute("clients",clients);
        req.setAttribute("emprunts",emprunts);
        req.getRequestDispatcher("views/emprunt/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateDebut = req.getParameter("dateDebut");
        String dateRt = req.getParameter("dateFin");
        Date DateRetour = null;
        Date DateDebut = null;
        try {
            DateDebut = new SimpleDateFormat("yyyy-mm-dd").parse(dateDebut);
            DateRetour = new SimpleDateFormat("yyyy-mm-dd").parse(dateRt);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        int client_id = Integer.parseInt(req.getParameter("client_id"));
        int livre_id = Integer.parseInt(req.getParameter("livre_id"));
        double prix = Double.parseDouble(req.getParameter("prix"));

        Livre livre = livreService.getLivre(livre_id);
        Client client = clientService.getClient(client_id);
        Emprunt emprunt = new Emprunt(DateDebut,DateRetour,prix);
        emprunt.setClient(client);
        emprunt.setLivre(livre);
        empruntService.addEmprunt(emprunt);
        System.out.println("Emprunt ajouté");
        req.setAttribute("success","le livre a bien été emprunté ");
        List<Emprunt> emprunts = empruntService.getAllEmprunt();
        req.setAttribute("emprunts",emprunts);
        req.getRequestDispatcher("views/emprunt/index.jsp").forward(req,resp);
    }
}
