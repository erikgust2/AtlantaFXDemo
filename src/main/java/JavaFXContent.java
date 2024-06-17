import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class JavaFXContent {
    public VBox getContent() {
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Hello from JavaFX!"));
        return vbox;
    }
}
