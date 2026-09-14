package software.ulpgc.project.architecture.presentation.controller;

import software.ulpgc.project.architecture.application.command.Command;

import java.util.HashMap;
import java.util.Map;

public class NavigationController {
    private final Map<String, Command> commands;

    public NavigationController() {
        this.commands = new HashMap<>();
    }
    public void addCommand(String name, Command command) {
        commands.put(name, command);
    }
    public void execute(String name) {
        if (commands.containsKey(name)) {
            commands.get(name).execute();
        }
    }
}
