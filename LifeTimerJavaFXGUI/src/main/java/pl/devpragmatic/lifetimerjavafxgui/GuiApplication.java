package pl.devpragmatic.lifetimerjavafxgui;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.devpragmatic.lifetimerjavafxgui.scene.WatchstopConfigScene;
/**
 *
 * @author devpragmatic
 */
public class GuiApplication extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        stage.getIcons().add(new Image(getClass().getResource("/images/icon.jpg").toString()));
        stage.initStyle(StageStyle.UNIFIED);
        WatchstopConfigScene configScene = new WatchstopConfigScene();
        configScene.start(stage);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
