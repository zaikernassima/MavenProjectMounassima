package net.kiranatos.snake;

/*
Base from: https://github.com/HbotondS
*/

import net.kiranatos.snake.contr.SettingsViewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.prefs.Preferences;

public class App extends Application {
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;

	private Preferences prefs;

	private final String UP = "UP";
	private final String DOWN = "DOWN";
	private final String RIGHT = "RIGHT";
	private final String LEFT = "LEFT";
        
        private final String pathFXML = "fxml/WelcomeView.fxml";
        private final String pathImg = "img/snake_icon.png";
        
        public static void main(String[] args) { launch(); }

	public void start(Stage primaryStage) {
            
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass()
                        .getClassLoader()
                        .getResource(pathFXML));
            } catch (Exception ex) {
                MyLogger.WARN(pathFXML + " file not found !");
                System.exit(0);
            }
            
            try {
                primaryStage.getIcons()
                        .add(new Image(getClass()
                                .getClassLoader()
                                .getResourceAsStream(pathImg)));
            } catch (Exception ex) {
                MyLogger.WARN(pathImg + " file not found.");
                System.exit(0);
            }
            
            primaryStage.setTitle("Snake Learning Language");
            primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            
            setDefCont();
            
            primaryStage.show();
        }
        
        // reset the controls to default
	// every time the application started
	private void setDefCont() {
            MyLogger.INFO("set controls");
            prefs = Preferences.userRoot().node(SettingsViewController.class.getName());
            
            prefs.put(UP, UP);
            prefs.put(DOWN, DOWN);
            prefs.put(RIGHT, RIGHT);
            prefs.put(LEFT, LEFT);
            
            prefs.putBoolean("renderScore", false);
	}
}