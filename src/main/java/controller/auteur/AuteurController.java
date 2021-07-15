package controller.auteur;

import entity.Auteur;
import entity.Livre;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.AuteurService;
import service.LivreService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auteurs")
public class AuteurController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuteurService auteurService = new AuteurService();
        List<Auteur> auteurs = auteurService.getAllAuteur();
        request.setAttribute("auteurs",auteurs);
        request.getRequestDispatcher("views/auteur/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        Auteur auteur = new Auteur(nom);
        AuteurService auteurService = new AuteurService();
        auteurService.addAuteur(auteur);
        request.setAttribute("success","l'auteur a bien été inséré ");
        List<Auteur> auteurs = auteurService.getAllAuteur();
        request.setAttribute("auteurs",auteurs);
        request.getRequestDispatcher("views/auteur/index.jsp").forward(request,response);
    }
}
