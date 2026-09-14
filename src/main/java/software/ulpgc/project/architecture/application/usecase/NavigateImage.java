package software.ulpgc.project.architecture.application.usecase;

import software.ulpgc.project.architecture.application.port.ImageRepository;

public class NavigateImage {
    private final ImageRepository imageRepository;
    private final LoaderImage loaderImage;
    private String currentImageId;
    public NavigateImage(ImageRepository imageRepository, LoaderImage loaderImage) {
        this.imageRepository = imageRepository;
        this.loaderImage = loaderImage;
        this.currentImageId = null;
    }
    public void start() {
        imageRepository.getFirstImageId().ifPresent(id -> {
            this.currentImageId = id;
            loaderImage.loadImage(id);
        });    }
    public void nextImage() {
        if (currentImageId == null) return;
        imageRepository.getNextImageId(currentImageId).ifPresent(id ->{
                this.currentImageId=id;
                loaderImage.loadImage(id);
        });
    }
    public void previousImage() {
        if (currentImageId == null) return;
        imageRepository.getPreviousImageId(currentImageId).ifPresent(id ->{
            this.currentImageId=id;
            loaderImage.loadImage(id);
        });
    }

}
