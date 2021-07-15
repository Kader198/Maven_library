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
        super.doPost(req, resp);
    }
}
