package software.ulpgc.project.architecture.application.command;

import software.ulpgc.project.architecture.application.usecase.NavigateImage;

public class RestartCommand implements Command {
    private final NavigateImage navigateImage;

    public RestartCommand(NavigateImage navigateImage) {
        this.navigateImage = navigateImage;
    }

    @Override
    public void execute() {
        navigateImage.start();
    }
}
