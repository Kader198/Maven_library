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

@WebServlet(urlPatterns = "/livres")
public class LivreController extends HttpServlet {
    LivreService livreService = new LivreService();
    AuteurService auteurService = new AuteurService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Livre> Livres = livreService.getAllLivre();
        List<Auteur> auteurs = auteurService.getAllAuteur();
        request.setAttribute("livres",Livres);
        request.setAttribute("auteurs",auteurs);
        request.getRequestDispatcher("views/livre/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String libelle = request.getParameter("libelle");
        double cout = Double.parseDouble(request.getParameter("cout"));
        int auteur = Integer.parseInt(request.getParameter("auteur_id"));
//        LivreService livreService = new LivreService();
        Livre livre = new Livre(libelle,cout);
//        livreService.addLivre(livre);
        Auteur auteur1 = auteurService.getAuteur(auteur);
        auteur1.getLivres().add(livre);
        request.setAttribute("success","le livre a bien été inséré ");
        List<Livre> Livres = livreService.getAllLivre();
        List<Auteur> auteurs = auteurService.getAllAuteur();
        request.setAttribute("auteurs",auteurs);
        request.setAttribute("livres",Livres);
        request.getRequestDispatcher("views/livre/index.jsp").forward(request,response);
    }
}
