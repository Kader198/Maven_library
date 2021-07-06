package controller.auteur;

import entity.Auteur;
import entity.Livre;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.AuteurService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/editAuteur")
public class editAuteur extends HttpServlet{
    AuteurService auteurService = new AuteurService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Auteur auteur = auteurService.getAuteur(id);
        request.setAttribute("auteur",auteur);
        request.getRequestDispatcher("views/auteur/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        AuteurService auteurService = new AuteurService();
        Auteur auteur = new Auteur(nom);
        auteurService.updateAuteur(auteur);
        request.setAttribute("success","le auteur a bien été inséré ");
        List<Auteur> auteurs = auteurService.getAllAuteur();
        request.setAttribute("auteurs",auteurs);
        request.getRequestDispatcher("views/auteur/index.jsp").forward(request,response);
    }
}
