package controller.livre;

import entity.Auteur;
import entity.Livre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.LivreService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/deleteLivre")
public class deleteLivre extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LivreService livreService = new LivreService();
        int id = Integer.parseInt(req.getParameter("id"));
        livreService.deleteLivre(id);
        req.setAttribute("success","le livre a bien été supprimé ");
        List<Livre> livres = livreService.getAllLivre();
        req.setAttribute("livres",livres);
        req.getRequestDispatcher("views/livre/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
