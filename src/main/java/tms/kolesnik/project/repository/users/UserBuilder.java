package tms.kolesnik.project.repository.users;

import tms.kolesnik.project.Source;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class UserBuilder extends PersonBuilder {

    public UserBuilder() {
        super.role(UsersRoles.USER.getRole());
    }

    public PersonBuilder password(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException {
        super.password(Source.getHashPassword(password));
        return this;
    }
    //users methods
}
