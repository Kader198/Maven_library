package controller.emprunt;

import entity.Auteur;
import entity.Client;
import entity.Emprunt;
import entity.Livre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.*;
import service.ClientService;
import service.EmpruntService;
import service.LivreService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet(urlPatterns = "/editEmprunt")
public class editEmprunt extends HttpServlet {
    public LivreService livreService = new LivreService();
    public ClientService clientService = new ClientService();
    public EmpruntService empruntService = new EmpruntService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Emprunt emprunt = empruntService.getEmprunt(id);
        req.setAttribute("emprunt",emprunt);
        req.setAttribute("emprunts",empruntService.getAllEmprunt());
        req.getRequestDispatcher("views/emprunt/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateDebut = req.getParameter("dateDebut");
        String dateRt = req.getParameter("dateFin");
        int id = Integer.parseInt(req.getParameter("id"));
        Emprunt updatedEmprunt = empruntService.getEmprunt(id);
        int client_id = Integer.parseInt(req.getParameter("client_id"));
        int livre_id = Integer.parseInt(req.getParameter("livre_id"));
        double prix = Double.parseDouble(req.getParameter("prix"));
        int qte = Integer.parseInt(req.getParameter("qte"));
        int etat = Integer.parseInt(req.getParameter("etat"));
        Livre livre = livreService.getLivre(livre_id);
        Client client = clientService.getClient(client_id);
        updatedEmprunt.setDateEmprunt(dateDebut);
        updatedEmprunt.setEtat(etat);
        updatedEmprunt.setDateRetour(dateRt);
        updatedEmprunt.setClient(client);
        updatedEmprunt.setLivre(livre);
        updatedEmprunt.setPrix(prix);
        updatedEmprunt.setQte(qte);
        empruntService.addEmprunt(updatedEmprunt);
        System.out.println("Emprunt ajouté");
        req.setAttribute("success","l'emprunt a été bien modifié ");
        List<Emprunt> emprunts = empruntService.getAllEmprunt();
        req.setAttribute("emprunts",emprunts);
        req.getRequestDispatcher("views/emprunt/index.jsp").forward(req,resp);
    }
}
