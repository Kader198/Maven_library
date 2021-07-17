package controller.livre;


import entity.Auteur;
import entity.Livre;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.AuteurService;
import service.LivreService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/editLivre")
public class editlivre extends HttpServlet {
    LivreService livreService = new LivreService();
    AuteurService auteurService = new AuteurService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Livre livreFound = livreService.getLivre(id);
        List<Auteur> auteurs = auteurService.getAllAuteur();
        request.setAttribute("livre",livreFound);
        request.setAttribute("auteurs",auteurs);
        request.getRequestDispatcher("views/livre/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String libelle = request.getParameter("libelle");
        int id = Integer.parseInt(request.getParameter("id"));
        double cout = Double.parseDouble(request.getParameter("cout"));
        int auteur = Integer.parseInt(request.getParameter("auteur_id"));
        Livre livre = livreService.getLivre(id);
        Auteur auteur1 = auteurService.getAuteur(auteur);
        livre.setAuteur(auteur1);
        livre.setLibelle(libelle);
        livre.setCout(cout);
        livreService.addLivre(livre);
        request.setAttribute("success","le livre a bien été inséré ");
        List<Livre> Livres = livreService.getAllLivre();
        request.setAttribute("livres",Livres);
        request.getRequestDispatcher("views/livre/index.jsp").forward(request,response);
    }
}

