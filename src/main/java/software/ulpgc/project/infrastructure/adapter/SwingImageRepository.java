package software.ulpgc.project.infrastructure.adapter;

import software.ulpgc.project.application.port.ImageRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwingImageRepository implements ImageRepository {
    private final File root;
    private final static List<String> format = Arrays.asList("jpg","bmp", "jpeg", "wbmp", "png", "gif", "tiff");



    public SwingImageRepository(File root) {
        this.root = testDirectory(root);
    }

    private File testDirectory(File root) {
        if (!root.isDirectory() || !root.isDirectory()) throw new IllegalArgumentException("the root must be a directory");
        return root;
    }


    @Override
    public List<String> findAllImageIds() {

        return List.of(Arrays.stream(root.listFiles())
                .filter(File::isFile)
                .filter(this::isImgageFormat).toArray(String[]::new));
    }

    private boolean isImgageFormat(File file) {
        return format.stream().anyMatch(file.getName().toLowerCase()::endsWith);
    }
}
