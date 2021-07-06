package controller;

import service.LivreService;
import service.UserService;
import entity.Livre;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/")
public class SignController extends HttpServlet {
    LivreService livreService = new LivreService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nom");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        boolean logged = userService.login(name,password);
        if (logged){
            List<Livre> Livres = livreService.getAllLivre();
            request.setAttribute("livres",Livres);
            request.getSession().setAttribute("login",name);
            response.sendRedirect(request.getContextPath()+"/home");
        }else {
            request.setAttribute("error","Informations incorrectes");

            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
