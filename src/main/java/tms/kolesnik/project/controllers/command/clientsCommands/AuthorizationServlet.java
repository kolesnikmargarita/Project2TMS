package tms.kolesnik.project.controllers.command.clientsCommands;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tms.kolesnik.project.Source;
import tms.kolesnik.project.repository.SystemService;
import tms.kolesnik.project.repository.users.UsersRoles;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "Authorization", urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        try {
            String passwordHash = Source.getHashPassword(req.getParameter("password"));
            ResultSet accounts = SystemService.getAccount(email, passwordHash);
            if(accounts.next()) {
                if(accounts.getString("role").equals(UsersRoles.ADMIN.getRole())) {
                    getServletContext().getRequestDispatcher("/admin").forward(req, resp);
                } else {
                    getServletContext().getRequestDispatcher("/user").forward(req, resp);
                }
            } else {
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
