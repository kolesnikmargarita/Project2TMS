package tms.kolesnik.project.controllers.command.clientsCommands.serviceServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tms.kolesnik.project.repository.users.Person;
import tms.kolesnik.project.repository.users.UserBuilder;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

@WebServlet(name = "RegistrationSafe", urlPatterns = "/registrationSafe")
public class RegistrationSafeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Person user = new UserBuilder()
                    .name(req.getParameter("name"))
                    .phone(req.getParameter("phone"))
                    .email(req.getParameter("email"))
                    .password(req.getParameter("password"))
                    .build();
            user.safeAccount();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/registrationResultPage.jsp").forward(req, resp);
    }
}
