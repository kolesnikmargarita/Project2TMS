package tms.kolesnik.project.repository;

import tms.kolesnik.project.Source;
import tms.kolesnik.project.objects.products.Product;
import tms.kolesnik.project.objects.products.ProductBuilder;
import tms.kolesnik.project.repository.users.Person;
import tms.kolesnik.project.repository.users.UsersRoles;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SystemService {

    public static ArrayList<Product> getProductList() {
        ArrayList<Product> productsList = new ArrayList<>();
        try{
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet productsSet = statement.executeQuery("select * from products");
            while (productsSet.next()) {
                productsList.add(new ProductBuilder()
                        .name(productsSet.getString("name"))
                        .description(productsSet.getString("description"))
                        .price(productsSet.getFloat("price"))
                        .img(productsSet.getString("image"))
                        .build());
            }
            ConnectionPool.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return productsList;
    }

    public static boolean thereIsNotAdminAccount() {
        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet adminAccountsSet = statement.executeQuery("select * from users where role='" + UsersRoles.ADMIN + "'");
            ConnectionPool.returnConnection(connection);
            if (!adminAccountsSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
        return false;
    }

    public static void createFirstAdminAccount(Person admin) {
        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO users (email, phone, name, role, password_hash) VALUES ('"
                    + admin.getEmail() + "', '" + admin.getPhone() + "', '" + admin.getName() + "', '"
                    + admin.getRole() + "', '" + admin.getPasswordHash() + "')");
            ConnectionPool.returnConnection(connection);
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
    }

    public static ResultSet getAccount(String email, String passwordHash) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        return ConnectionPool.getConnection().createStatement()
                .executeQuery("SELECT * FROM users where email='" + email + "' AND password_hash='" + passwordHash + "'");
    }
}
