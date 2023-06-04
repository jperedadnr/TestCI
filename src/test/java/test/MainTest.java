package test;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
public class MainTest {

    @Start
    public void start(Stage stage) {
        Button button = new Button("Click me");
        button.setOnAction(e -> stage.setTitle("Clicked"));
        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 600, 300);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void ButtonTest(FxRobot robot) {
        robot.clickOn(".button");
        verifyThat(".button", node -> "Clicked".equals(((Stage) node.getScene().getWindow()).getTitle()));
    }
}