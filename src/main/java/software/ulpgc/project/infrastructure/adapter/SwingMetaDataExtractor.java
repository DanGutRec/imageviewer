package software.ulpgc.project.infrastructure.adapter;

import software.ulpgc.project.application.port.MetadataExtractor;
import software.ulpgc.project.domain.model.ImageMetadata;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class SwingMetaDataExtractor implements MetadataExtractor {
    @Override
    public ImageMetadata extractMetadata(String id, byte[] image) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image));
            return new ImageMetadata(id, image, LocalDateTime.now(), bufferedImage.getHeight() , bufferedImage.getWidth(), image.length);
        } catch (IOException e) {
            throw new RuntimeException("No se pudieron extraer los metadatos", e);
        }
    }
}
