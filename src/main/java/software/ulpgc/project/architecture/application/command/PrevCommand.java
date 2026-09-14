package software.ulpgc.project.architecture.application.command;

import software.ulpgc.project.architecture.application.usecase.NavigateImage;

public class PrevCommand implements Command {
    private final NavigateImage navigateImage;
    public PrevCommand(NavigateImage navigateImage) {
        this.navigateImage = navigateImage;
    }
    @Override
    public void execute() {
        navigateImage.previousImage();
    }
}
