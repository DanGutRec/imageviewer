package software.ulpgc.project.window.ui;

import software.ulpgc.project.architecture.presentation.controller.NavigationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SwingNavigationPanel extends JPanel {
    private final NavigationController navigationController;

    public SwingNavigationPanel(NavigationController navigationController) {
        this.navigationController = navigationController;
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        init();
    }
    private void init() {
        JPanel bottomPanel = new JPanel(new FlowLayout());

        JButton previousButton = createButton("Previous",e->navigationController.execute("previous"));
        JButton nextButton = createButton("Next",e->navigationController.execute("next"));

        bottomPanel.add(previousButton);
        bottomPanel.add(nextButton);
        add(bottomPanel);
    }

    private static JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setFocusPainted(false);
        return button;

    }
}
