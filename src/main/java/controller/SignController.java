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

@WebServlet("/SignServlet")
public class SignController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("nom");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        boolean logged = userService.login(name,password);
        if (logged){
            LivreService livreService = new LivreService();
            List<Livre> Livres = livreService.getAllLivre();
            request.setAttribute("livres",Livres);
            request.getSession().setAttribute("login",name);
            response.sendRedirect(request.getContextPath());
        }else {
            request.setAttribute("error","invalid credentials");

            request.getRequestDispatcher("/views/login.jsp").forward(request,response);
        }
    }
}
