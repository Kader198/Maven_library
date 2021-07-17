package controller.client;

import entity.Auteur;
import entity.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AuteurService;
import service.ClientService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/editClient")
public class editController extends HttpServlet {
    ClientService clientService = new ClientService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Client client = clientService.getClient(id);
        req.setAttribute("client",client);
        req.getRequestDispatcher("views/client/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        int age = Integer.parseInt(req.getParameter("age"));
        ClientService clientService = new ClientService();
        clientService.updateClient(id,nom,prenom,age);
        req.setAttribute("success","le client a bien été modifié ");
        List<Client> clients = clientService.getAllClient();
        req.setAttribute("clients",clients);
        req.getRequestDispatcher("views/client/index.jsp").forward(req,resp);
    }
}
