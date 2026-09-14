package software.ulpgc.project.architecture.application.command;
import software.ulpgc.project.architecture.application.usecase.NavigateImage;

public class NextCommand implements Command{
    private final NavigateImage navigateImage;
    public NextCommand(NavigateImage navigateImage) {
        this.navigateImage = navigateImage;
    }
    @Override
    public void execute() {
        navigateImage.nextImage();

    }
}
