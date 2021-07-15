package controller.emprunt;

import entity.Emprunt;
import entity.Livre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.*;
import service.EmpruntService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/deleteEmprunt")
public class deleteEmprunt extends HttpServlet {
    public EmpruntService empruntService = new EmpruntService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        empruntService.deleteEmprunt(id);
        req.setAttribute("success","l'emprunt a bien été supprimé ");
        List<Emprunt> emprunts = empruntService.getAllEmprunt();
        req.setAttribute("emprunts",emprunts);
        req.getRequestDispatcher("views/emprunt/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
