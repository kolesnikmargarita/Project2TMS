package tms.kolesnik.project;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Source {
    /*public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "Umbrella:)";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/shop";*/

    public static String getHashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}
