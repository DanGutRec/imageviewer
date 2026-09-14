package software.ulpgc.project.architecture.application;

import software.ulpgc.project.window.ui.MainFrame;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                String folderPath = "images";
                File imagesDirectory = new File(folderPath);

                if (!imagesDirectory.exists()) {
                    imagesDirectory.mkdirs();
                }

                MainFrame frame = new MainFrame(folderPath);

                frame.start();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Error iniciando la aplicación: " + e.getMessage(),
                        "Error Crítico",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });
    }
}
