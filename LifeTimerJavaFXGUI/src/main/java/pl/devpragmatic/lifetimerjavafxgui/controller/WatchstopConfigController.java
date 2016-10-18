package pl.devpragmatic.lifetimerjavafxgui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import pl.devpragmatic.lifetimer.domain.Time;
import pl.devpragmatic.lifetimerjavafxgui.control.NumberTextField;
import pl.devpragmatic.lifetimerjavafxgui.scene.WatchstopScene;

/**
 * FXML Controller class
 *
 * @author devpragmatic
 */
public class WatchstopConfigController implements Initializable {
    
    @FXML
    private NumberTextField daysField; 
    
    @FXML
    private NumberTextField hoursField;
    
    @FXML
    private NumberTextField minutesField;
    
    @FXML
    private NumberTextField secondsField;
    
    /**
     * Initializes the controller class.
     * @param location
     * The location used to resolve relative paths for the root object, or
     * <tt>null</tt> if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or <tt>null</tt> if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }    
    
    @FXML
    public void start(ActionEvent event) throws IOException
    {
        Time time = new Time();
        time.setTime(daysField.getInteger(), hoursField.getInteger(), minutesField.getInteger(), secondsField.getInteger());
        WatchstopScene watchstop = new WatchstopScene(time);
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        watchstop.start(stage);
    }
}
