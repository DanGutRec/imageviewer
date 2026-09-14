package software.ulpgc.project.architecture.application.port;

import software.ulpgc.project.architecture.domain.model.Image;

public interface ImageDisplay {
    void show(Image image);
    Image getCurrentImage();
    void clear();
}

