package software.ulpgc.project.window.ui;

import software.ulpgc.project.architecture.application.port.ImageDeserializer;
import software.ulpgc.project.architecture.application.port.ImageDisplay;
import software.ulpgc.project.architecture.application.port.ImageReader;
import software.ulpgc.project.architecture.domain.model.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import software.ulpgc.project.architecture.domain.model.Canvas;
public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private final ImageReader imageReader;
    private final ImageDeserializer imageDeserializer;
    private  Image currentImage;
    private BufferedImage image;

    public SwingImageDisplay(ImageReader imageReader, ImageDeserializer imageDeserializer) {
        this.imageReader = imageReader;
        this.imageDeserializer = imageDeserializer;
        this.setBackground(Color.BLACK);
    }

    @Override
    public void show(Image image) {
        this.currentImage = image;
        this.image= (BufferedImage) imageDeserializer.deserialize(imageReader.readBytes(image.getId()));
        repaint();
    }

    @Override
    public Image getCurrentImage() {
        return currentImage;
    }

    @Override
    public void clear() {
        this.currentImage = null;
        this.image = null;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null) {
            g.setColor(Color.WHITE);
            String message = "No Images found it";

            FontMetrics fm = g.getFontMetrics();
            int textX = (getWidth() - fm.stringWidth(message)) / 2;
            int textY = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

            g.drawString(message, textX, textY);
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Canvas canvas = Canvas.ofSize(getWidth(), getHeight()).fit(image.getWidth(), image.getHeight());


        g2d.drawImage(image,
                getX(canvas),
                getY(canvas),
                canvas.width(),
                canvas.height(),
                null);    }

    private int getX(Canvas canvas) {
        return (getWidth() - canvas.width()) / 2;
    }

    private int getY(Canvas canvas) {
        return (getHeight() - canvas.height()) / 2;
    }
}
