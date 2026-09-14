package software.ulpgc.project.architecture.infrastructure.adapter;

import software.ulpgc.project.architecture.application.port.ImageRepository;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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



    private boolean isImgageFormat(File file) {
        return format.stream().anyMatch(file.getName().toLowerCase()::endsWith);
    }

    @Override
    public Optional<String> getFirstImageId() {
        List<String> images = getValidImageIds();
        return images.isEmpty() ? Optional.empty() : Optional.of(images.get(0));
    }

    @Override
    public Optional<String> getNextImageId(String id) {
        List<String> images = getValidImageIds();
        int nextIndex=(images.indexOf(id)+1)%images.size();
        return Optional.of(images.get(nextIndex));
    }

    @Override
    public Optional<String> getPreviousImageId(String id) {
        List<String> images = getValidImageIds();
        int prevIndex=(images.indexOf(id)-1+images.size())%images.size();
        return Optional.of(images.get(prevIndex));
    }

    private List<String> getValidImageIds() {
        File[] files = root.listFiles();
        if (files == null) return List.of();

        return Arrays.stream(files)
                .filter(File::isFile)
                .filter(this::isImgageFormat)
                .map(File::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
