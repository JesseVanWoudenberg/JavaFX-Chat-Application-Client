package app.components;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ExitBox extends StackPane {

    private Text closeButtonIcon;

    public ExitBox() {

        this.createContent();
        this.setProperties();

    }

    private void createContent() {

    this.closeButtonIcon = GlyphsDude.createIcon(FontAwesomeIcon.TIMES, "25");
    this.closeButtonIcon.setFill(Color.gray(1.0));

    }

    private void setProperties() {

        this.setMinSize(40,40);
        this.setMaxSize(40,40);
        this.getChildren().add(this.closeButtonIcon);
        this.setStyle
                (
                        "-fx-background-color: #3179d7;"
                );
    }
}
