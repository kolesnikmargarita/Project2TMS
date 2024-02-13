package tms.kolesnik.project.controllers.command.clientsCommands.serviceServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tms.kolesnik.project.controllers.Developer;
import tms.kolesnik.project.controllers.DeveloperBuilder;
import tms.kolesnik.project.controllers.command.usersCommands.*;
import tms.kolesnik.project.service.UserService;

import java.io.IOException;

@WebServlet(name = "UserPage", urlPatterns = "/user")
public class UserAccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        Developer developer = new DeveloperBuilder()
                .addInFavourite(new AddInFavouriteCommand(userService))
                .deleteFromFavourite(new DeleteFromFavouriteCommand(userService))
                .deleteFromCart(new DeleteFromCartCommand(userService))
                .addInCart(new AddInCartCommand(userService))
                .displayCart(new DisplayCartCommand(userService))
                .displayFavourite(new DisplayFavouriteCommand(userService))
                .displayOrders(new DisplayOrdersCommand(userService))
                .placeOrder(new PlaceOrderCommand(userService))
                .build();
        getServletContext().getRequestDispatcher("/jsp/userAccount.jsp").forward(req, resp);
    }
}
