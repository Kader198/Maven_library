package controller.auteur;

import entity.Auteur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AuteurService;

import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/deleteAuteur")
public class deleteAuteur extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuteurService auteurService = new AuteurService();
        int id = Integer.parseInt(req.getParameter("id"));
        auteurService.deleteAuteur(id);
        req.setAttribute("success","l' auteur a bien été supprimé ");
        List<Auteur> auteurs = auteurService.getAllAuteur();
        req.setAttribute("auteurs",auteurs);
        req.getRequestDispatcher("views/auteur/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
