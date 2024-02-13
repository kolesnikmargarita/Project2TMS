package tms.kolesnik.project.repository.users;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PersonBuilder {

    private Person person;

    protected PersonBuilder() {
        person = new Person();
    }
    public PersonBuilder email(String email) {
        person.setEmail(email);
        return this;
    }
    public PersonBuilder phone(String phone) {
        person.setPhone(phone);
        return this;
    }
    public PersonBuilder name(String name) {
        person.setName(name);
        return this;
    }
    public PersonBuilder password(String passwordHash) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException {
        person.setPasswordHash(passwordHash);
        return this;
    }
    public PersonBuilder role(String role) {
        person.setRole(role);
        return this;
    }

    public Person build() {
        return person;
    }
}
