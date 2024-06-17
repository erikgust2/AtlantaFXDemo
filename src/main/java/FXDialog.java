import javax.swing.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class FXDialog {

    public static void showFXDialog(JFrame owner) {
        JDialog dialog = new JDialog(owner, "JavaFX Dialog", true);
        JFXPanel fxPanel = new JFXPanel();
        dialog.add(fxPanel);
        dialog.setSize(600, 400);
        dialog.setVisible(true);

        Platform.runLater(() -> {
            VBox root = new VBox();
            root.setPadding(new Insets(10));
            root.setSpacing(10);

            Scene scene = new Scene(root, 600, 400);
            scene.getStylesheets().add(FXDialog.class.getResource("/styles/nord-dark.css").toExternalForm());

            // Add different JavaFX components
            Label label = new Label("This is a styled label");
            Button button = new Button("Styled Button");
            TextField textField = new TextField("Styled Text Field");
            Slider slider = new Slider();
            ProgressBar progressBar = new ProgressBar(0.5);
            CheckBox checkBox = new CheckBox("Styled CheckBox");

            // Set up a GridPane to showcase components nicely
            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.add(label, 0, 0);
            gridPane.add(button, 1, 0);
            gridPane.add(textField, 0, 1);
            gridPane.add(slider, 1, 1);
            gridPane.add(progressBar, 0, 2);
            gridPane.add(checkBox, 1, 2);

            root.getChildren().add(gridPane);

            fxPanel.setScene(scene);
        });
    }

}
