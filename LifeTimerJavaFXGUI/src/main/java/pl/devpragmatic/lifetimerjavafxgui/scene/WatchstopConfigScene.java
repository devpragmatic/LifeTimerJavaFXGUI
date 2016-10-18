/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.devpragmatic.lifetimerjavafxgui.scene;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author devpragmatic
 */
public class WatchstopConfigScene implements SceneManager{

    @Override
    public void start(Stage stage) throws IOException {
        stage.hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/WatchstopConfig.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Watchstop configuration");
        stage.setScene(scene);
        stage.setMaxWidth(300);
        stage.setMaxHeight(75);
        stage.show();
    }
    
}
