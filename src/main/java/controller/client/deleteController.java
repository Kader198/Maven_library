package controller.client;

import entity.Auteur;
import entity.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ClientService;

import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/deleteClient")
public class deleteController extends HttpServlet {

    ClientService clientService = new ClientService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        clientService.deleteClient(id);
        req.setAttribute("success","le client a bien été supprimé ");
        List<Client> clients = clientService.getAllClient();
        req.setAttribute("clients",clients);
        req.getRequestDispatcher("views/client/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
