package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.StageStyle;

public class PacManController {

    @FXML
    private MenuItem cargarJuego;

    @FXML
    private MenuItem guardarJuego;

    @FXML
    private MenuItem salir;

    @FXML
    private MenuItem highScore;

    @FXML
    private MenuItem info;

    @FXML
    private Label points;

    @FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void information(ActionEvent event) {
    	Alert info = new Alert(AlertType.INFORMATION);
    	info.setTitle("Pac - Man");
    	info.setHeaderText(null);
    	info.initStyle(StageStyle.UTILITY);
    	info.setContentText("PAC - MAN");
    	info.show();
    }

    @FXML
    void load(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void show(ActionEvent event) {

    }

}
