package software.ulpgc.project.application.port;

import java.util.List;

public interface ImageRepository {
    List<String> findAllImageIds();
}
