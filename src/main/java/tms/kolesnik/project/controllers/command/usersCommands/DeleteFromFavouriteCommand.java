package tms.kolesnik.project.controllers.command.usersCommands;

import tms.kolesnik.project.controllers.Command;
import tms.kolesnik.project.service.UserService;

public class DeleteFromFavouriteCommand implements Command {

    UserService userService;

    public DeleteFromFavouriteCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        userService.deleteFromFavourite();
    }
}
