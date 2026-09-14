package software.ulpgc.project.architecture.domain.model;

public record Canvas(int width, int height) {

    public static Canvas ofSize(int width, int height) {
        return new Canvas(width, height);
    }

    public Canvas fit(int imageWidth, int imageHeight) {
        double scale = Math.min((double) this.width / imageWidth, (double) this.height / imageHeight);
        return new Canvas((int) (imageWidth * scale), (int) (imageHeight * scale));
    }
}
