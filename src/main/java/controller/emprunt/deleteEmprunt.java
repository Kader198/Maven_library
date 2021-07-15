package controller.emprunt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jdk.internal.net.http.frame.Http2Frame;

import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/deleteEmprunt")
public class deleteEmprunt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
