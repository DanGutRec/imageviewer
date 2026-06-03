package software.ulpgc.project.infrastructure.adapter;

import software.ulpgc.project.application.port.ImageDeserializer;
import software.ulpgc.project.domain.model.ImageMetadata;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SwingDeserializer implements ImageDeserializer {
    private final Map<String,BufferedImage> image;

    public SwingDeserializer() {
        this.image = new HashMap<>();
    }

    @Override
    public Object deserialize(byte[] imageData) {
        try {
             return ImageIO.read(new ByteArrayInputStream(imageData)) ;
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
