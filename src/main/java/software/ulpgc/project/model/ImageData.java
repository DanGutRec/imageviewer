package software.ulpgc.project.model;

import java.time.LocalDateTime;

public class ImageData {
    private final String id;
    private final Size size;
    private final Format format;
    private final long bytesSize;
    private final LocalDateTime creationTime;

    public ImageData(String id, Size size, Format format, long bytesSize, LocalDateTime creationTime) {
        this.id = id;
        this.size = size;
        this.format = format;
        this.bytesSize = bytesSize;
        this.creationTime = creationTime;
    }

    public record Size(int width, int height){}
    public enum Format {PNG,JPEG,JPG}
}
