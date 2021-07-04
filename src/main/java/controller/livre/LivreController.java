package controller.livre;

import entity.Livre;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.LivreService;

import java.io.IOException;

@WebServlet(name = "LivreController", value = "/LivreController")
public class LivreController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String libelle = request.getParameter("libelle");
        double cout = Double.parseDouble(request.getParameter("cout"));
        int auteur = Integer.parseInt(request.getParameter("auteur"));
        LivreService livreService = new LivreService();
        Livre livre = new Livre(libelle,cout,auteur);
        livreService.addLivre(livre);
        request.setAttribute("success","le livre a bien été inséré ");
        request.getRequestDispatcher("views/index.jsp").forward(request,response);
    }
}
