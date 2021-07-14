package controller.client;

import entity.Auteur;
import entity.Client;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.ClientService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/clients")
public class ClientController extends HttpServlet {
    ClientService clientService = new ClientService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = clientService.getAllClient();
        request.setAttribute("clients",clients);
        request.getRequestDispatcher("views/client/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int age = Integer.parseInt(request.getParameter("age"));
        Client client = new Client(nom,prenom,age);
        clientService.save(client);
        request.setAttribute("success","le client a bien été inséré ");
        List<Client> clients = clientService.getAllClient();
        request.setAttribute("clients",clients);
        request.getRequestDispatcher("views/client/index.jsp").forward(request,response);
    }
}
