package tms.kolesnik.project.objects.users;

public class AdminBuilder extends PersonBuilder{

    public AdminBuilder() {
        super.role(UsersRoles.ADMIN.getRole());
    }
    //admins methods
}
