import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JavaFX in Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JFXPanel fxPanel = new JFXPanel();
            frame.add(fxPanel);
            frame.setVisible(true);

            Platform.runLater(() -> {
                VBox root = new VBox();
                Scene scene = new Scene(root, 800, 600);
                scene.getStylesheets().add(Main.class.getResource("/styles/primer-dark.css").toExternalForm());

                root.getChildren().add(new JavaFXContent().getContent());

                fxPanel.setScene(scene);
            });

            // Create a button to show a new JavaFX dialog
            JButton button = new JButton("Open JavaFX Dialog");
            button.addActionListener(e -> FXDialog.showFXDialog(frame));
            frame.add(button, BorderLayout.SOUTH);
        });
    }
}
