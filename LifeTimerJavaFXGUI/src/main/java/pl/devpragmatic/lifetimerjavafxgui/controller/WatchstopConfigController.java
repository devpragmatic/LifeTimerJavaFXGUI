/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
