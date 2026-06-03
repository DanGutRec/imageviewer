package software.ulpgc.project.application.port;

import software.ulpgc.project.domain.model.ImageMetadata;

public interface MetadataExtractor {
    public ImageMetadata extractMetadata(String id,byte[] image);
}
