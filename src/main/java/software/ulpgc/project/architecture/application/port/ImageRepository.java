package software.ulpgc.project.architecture.application.port;

import java.util.Optional;

public interface ImageRepository {
    Optional<String> getFirstImageId();
    Optional<String> getNextImageId(String id);
    Optional<String> getPreviousImageId(String id);
}
