package software.ulpgc.project.architecture.domain.model;

import java.time.LocalDateTime;

public record ImageMetadata(String id, LocalDateTime created,int height, int width,long size) {

}
