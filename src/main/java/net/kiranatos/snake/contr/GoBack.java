package net.kiranatos.snake.contr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.kiranatos.snake.MyLogger;

public abstract class GoBack {

	public void back(ActionEvent actionEvent) {
		Button button = (Button) actionEvent.getSource();

		Stage stage = (Stage) button.getScene().getWindow();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/WelcomeView.fxml"));
		} catch (Exception ex) {
			MyLogger.WARN("fxml/WelcomeView.fxml file not found");
			System.exit(0);
		}

		stage.setScene(new Scene(root));
		stage.show();
	}
}