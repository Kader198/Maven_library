package controller;

import entity.Auteur;
import entity.Livre;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.AuteurService;
import service.LivreService;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {
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

    }
}
