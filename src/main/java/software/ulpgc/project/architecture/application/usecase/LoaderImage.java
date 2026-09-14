package software.ulpgc.project.architecture.application.usecase;

import software.ulpgc.project.architecture.application.port.ImageDisplay;
import software.ulpgc.project.architecture.application.port.ImageReader;
import software.ulpgc.project.architecture.application.port.MetadataExtractor;
import software.ulpgc.project.architecture.domain.model.Image;
import software.ulpgc.project.architecture.domain.model.ImageMetadata;

public class LoaderImage {
    private final ImageDisplay imageDisplay;
    private final ImageReader imageReader;
    private final MetadataExtractor metadataExtractor;
    public LoaderImage(ImageDisplay imageDisplay, ImageReader imageReader, MetadataExtractor metadataExtractor) {
        this.imageDisplay = imageDisplay;
        this.imageReader = imageReader;
        this.metadataExtractor = metadataExtractor;
    }
    public void loadImage(String id){
        imageDisplay.show(getImage(id));
    }

    private Image getImage(String id) {
        return new Image(id, getImageMetadata(id));
    }

    private ImageMetadata getImageMetadata(String id) {
        return metadataExtractor.extractMetadata(id, getBytes(id));
    }

    private byte[] getBytes(String id) {
        return imageReader.readBytes(id);
    }
}
