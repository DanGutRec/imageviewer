package software.ulpgc.project.domain.model;

import java.time.LocalDateTime;

public record ImageMetadata(String id,byte[] imageData, LocalDateTime created,int height, int width,long size) {

}
