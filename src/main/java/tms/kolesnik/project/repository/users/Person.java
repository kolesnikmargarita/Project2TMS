package tms.kolesnik.project.repository.users;

import tms.kolesnik.project.repository.ConnectionPool;

import java.sql.SQLException;

public class Person {
    private String email;
    private String phone;
    private String name;
    private String passwordHash;
    private String role;

    Person(){}

    void setEmail(String setEmail) {
        email = setEmail;
    }

    void setPhone(String setPhone) {
        phone = setPhone;
    }

    void setName(String setName) {
        name = setName;
    }

    void setRole(String setRole) {
        role = setRole;
    }

    void setPasswordHash(String setPasswordHash) {
        passwordHash = setPasswordHash;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void safeAccount() throws SQLException {
        String sqlString = "INSERT INTO users (email, phone, name, role, password_hash) VALUES ('" + email + "', '" +
                phone + "', '" + name + "', '" + role + "', '" + passwordHash + "')";
        ConnectionPool.getConnection().createStatement().executeUpdate(sqlString);
    }
}
