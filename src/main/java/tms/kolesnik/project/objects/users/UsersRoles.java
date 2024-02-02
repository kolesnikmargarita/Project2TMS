package tms.kolesnik.project.objects.users;

public enum UsersRoles {
    USER, ADMIN;

    public String getRole() {
        if(this == USER)
            return "USER";
        return "ADMIN";
    }
}
