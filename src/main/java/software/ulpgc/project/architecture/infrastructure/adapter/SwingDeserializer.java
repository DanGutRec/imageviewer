package software.ulpgc.project.architecture.infrastructure.adapter;

import software.ulpgc.project.architecture.application.port.ImageDeserializer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SwingDeserializer implements ImageDeserializer {
    private final Map<Integer, BufferedImage> image;

    public SwingDeserializer() {
        this.image = new HashMap<>();
    }

    @Override
    public Object deserialize(byte[] imageData) {
        return image.computeIfAbsent(Arrays.hashCode(imageData), i -> read(imageData));
    }

    private BufferedImage read(byte[] imageData) {
        try {
            return ImageIO.read(new ByteArrayInputStream(imageData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}