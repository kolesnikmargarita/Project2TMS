package tms.kolesnik.project.repository.users;

public class AdminBuilder extends PersonBuilder{

    public AdminBuilder() {
        super.role(UsersRoles.ADMIN.getRole());
    }
    //admins methods
}
