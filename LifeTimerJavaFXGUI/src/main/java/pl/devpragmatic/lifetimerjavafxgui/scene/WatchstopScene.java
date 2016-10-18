package pl.devpragmatic.lifetimerjavafxgui.scene;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.devpragmatic.lifetimer.domain.Time;
import pl.devpragmatic.lifetimerjavafxgui.controller.WatchstopController;

/**
 *
 * @author devpragmatic
 */
public class WatchstopScene implements SceneManager{

    private Time time = new Time();
        
    public WatchstopScene(Time time) {
        this.time = time != null ? time : new Time();
    }
    
    @Override
    public void start(Stage stage) throws IOException{
        stage.hide();
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/fxml/Watchstop.fxml"));
        Parent root = fXMLLoader.load();
        WatchstopController controller = fXMLLoader.getController();
        Scene scene = new Scene(root);
        stage.setTitle(time.getAsString());
        stage.setScene(scene);
        stage.setMaxWidth(300);
        stage.setMaxHeight(75);
        stage.show();
        controller.runWatchstop(time, stage);
    }
}
