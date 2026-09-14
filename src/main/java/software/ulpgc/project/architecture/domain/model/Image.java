package software.ulpgc.project.architecture.domain.model;

import java.util.Objects;

public class Image {
    private final String id;

    private final ImageMetadata imageMetadata;


    public Image(String id, ImageMetadata imageMetadata) {
        this.id = id;
        this.imageMetadata = imageMetadata;
    }
    public String getId() {
        return id;
    }
    public ImageMetadata getImageMetadata() {return imageMetadata;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image image)) return false;
        return Objects.equals(id, image.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
