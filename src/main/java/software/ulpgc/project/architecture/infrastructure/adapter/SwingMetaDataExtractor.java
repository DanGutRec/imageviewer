package software.ulpgc.project.architecture.infrastructure.adapter;

import software.ulpgc.project.architecture.application.port.MetadataExtractor;
import software.ulpgc.project.architecture.domain.model.ImageMetadata;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class SwingMetaDataExtractor implements MetadataExtractor {
    @Override
    public ImageMetadata extractMetadata(String id, byte[] image) {
        try {
            if (image == null || image.length == 0) {
                return new ImageMetadata(id, LocalDateTime.now(), 0, 0, 0);
            }
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image));
            if (bufferedImage == null) {
                return new ImageMetadata(id, LocalDateTime.now(), 0, 0, image.length);
            }
            return new ImageMetadata(id, LocalDateTime.now(), bufferedImage.getHeight() , bufferedImage.getWidth(), image.length);
        } catch (IOException e) {
            throw new RuntimeException("No se pudieron extraer los metadatos", e);
        }
    }
}