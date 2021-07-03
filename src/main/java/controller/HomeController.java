package controller;

import entity.Livre;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.LivreService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = "/HomeController")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LivreService livreService = new LivreService();
        List<Livre> Livres = livreService.getAllLivre();
        request.setAttribute("livres",Livres);
        request.getRequestDispatcher("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
