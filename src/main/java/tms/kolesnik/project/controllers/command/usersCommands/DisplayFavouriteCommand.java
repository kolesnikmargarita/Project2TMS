package tms.kolesnik.project.controllers.command.usersCommands;

import tms.kolesnik.project.controllers.Command;
import tms.kolesnik.project.service.UserService;

public class DisplayFavouriteCommand implements Command {

    UserService userService;

    public DisplayFavouriteCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        userService.displayFavourite();
    }
}
