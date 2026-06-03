package software.ulpgc.project.application.port;

import software.ulpgc.project.domain.model.Image;

import java.util.List;

public interface ImageDisplay {
    void show(Image image);
    Image getCurrentImage();
    void clear();
}

