package tms.kolesnik.project.controllers.command.usersCommands;

import tms.kolesnik.project.controllers.Command;
import tms.kolesnik.project.service.UserService;

public class AddInCartCommand implements Command {

    UserService userService;

    public AddInCartCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        userService.addInCart();
    }
}
