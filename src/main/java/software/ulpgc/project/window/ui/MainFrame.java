package software.ulpgc.project.window.ui;

import software.ulpgc.project.architecture.application.command.NextCommand;
import software.ulpgc.project.architecture.application.command.PrevCommand;
import software.ulpgc.project.architecture.application.port.ImageDeserializer;
import software.ulpgc.project.architecture.application.port.ImageReader;
import software.ulpgc.project.architecture.application.port.ImageRepository;
import software.ulpgc.project.architecture.application.port.MetadataExtractor;
import software.ulpgc.project.architecture.application.usecase.LoaderImage;
import software.ulpgc.project.architecture.application.usecase.NavigateImage;
import software.ulpgc.project.architecture.infrastructure.adapter.SwingDeserializer;
import software.ulpgc.project.architecture.infrastructure.adapter.SwingImageRepository;
import software.ulpgc.project.architecture.infrastructure.adapter.SwingMetaDataExtractor;
import software.ulpgc.project.architecture.presentation.controller.NavigationController;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MainFrame extends JFrame {
    private final SwingImageDisplay imageDisplay;
    private final NavigationController navigationController;
    private final NavigateImage navigateImage;

    public MainFrame(String imageFolderPath) {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        File folder = new File(imageFolderPath);
        ImageRepository repository = new SwingImageRepository(folder);
        ImageDeserializer deserializer = new SwingDeserializer();
        MetadataExtractor extractor = new SwingMetaDataExtractor();

        ImageReader reader = getImageReader(folder);

        this.imageDisplay = new SwingImageDisplay(reader, deserializer);
        LoaderImage loaderImage = new LoaderImage(imageDisplay, reader, extractor);
        this.navigateImage = new NavigateImage(repository, loaderImage);

        this.navigationController = new NavigationController();
        navigationController.addCommand("next", new NextCommand(navigateImage));
        navigationController.addCommand("previous", new PrevCommand(navigateImage));
        SwingNavigationPanel navigationPanel = new SwingNavigationPanel(navigationController);

        this.add(imageDisplay, BorderLayout.CENTER);
        this.add(navigationPanel, BorderLayout.SOUTH);
    }

    private static ImageReader getImageReader(File folder) {
        return id -> {
            try {
                return Files.readAllBytes(new File(folder, id).toPath());
            } catch (IOException e) {
                return new byte[0];
            }
        };
    }

    public void start() {
        this.setVisible(true);
        this.navigateImage.start();
    }
}