package software.ulpgc.project.architecture.application.port;

import software.ulpgc.project.architecture.domain.model.ImageMetadata;

public interface MetadataExtractor {
    public ImageMetadata extractMetadata(String id,byte[] image);
}
