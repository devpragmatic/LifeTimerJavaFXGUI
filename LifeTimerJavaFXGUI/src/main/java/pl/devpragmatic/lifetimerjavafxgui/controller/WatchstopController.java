/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.devpragmatic.lifetimerjavafxgui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import pl.devpragmatic.lifetimer.domain.Time;

/**
 * FXML Controller class
 *
 * @author devpragmatic
 */
public class WatchstopController implements Initializable {
        
    private final Time timeSecond;
    
    @FXML
    private ProgressBar progressBar; 
    
    @FXML
    private Text timeLabel;
    
    public WatchstopController(){
        timeSecond = new Time();
        timeSecond.setTime(0, 0, 0, 1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void runWatchstop(final Time time, final Stage stage) {
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        final Time tmp = new Time();
        tmp.addTime(time);
        progressBar.prefWidthProperty().bind(stage.widthProperty().subtract(5));
        progressBar.prefHeightProperty().bind(stage.heightProperty().subtract(5));
        timeLabel.setText(tmp.getAsString());
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                  new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        tmp.subTime(timeSecond);
                        progressBar.setProgress((time.getAsSeconds()-tmp.getAsSeconds())/(double) time.getAsSeconds());
                        if(progressBar.getProgress() > 0.99){
                            progressBar.setStyle("-fx-accent: red;");
                        }else if(progressBar.getProgress() > 0.75){
                            progressBar.setStyle("-fx-accent: yellow;");
                        }else{
                            progressBar.setStyle("-fx-accent: green;");
                        }
                        stage.setTitle(tmp.getAsString());
                        timeLabel.setText(tmp.getAsString());
                        if(tmp.getAsSeconds() == 0L){
                            timeline.stop();
                            progressBar.setStyle("-fx-accent: red;");
                        }
                    }
                }));
        timeline.playFromStart();
    }
}
