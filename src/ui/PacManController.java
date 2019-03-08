package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.stage.StageStyle;
import threads.MovingThread;

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
    private Arc pac;
    
    @FXML
    private Pane pane;
    
    private MovingThread mt;
    
    private boolean move;

    @FXML
    void load(ActionEvent event) {
    	move = true;
    	mt = new MovingThread(this, move);
    	mt.start();
    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void show(ActionEvent event) {

    }
    
    public boolean right(boolean move) {
    	if(move) {
    		pac.setLayoutX(pac.getLayoutX()+6);
    	}
    	if(pac.getLayoutX()>pane.getWidth()-pac.getRadiusX()) {
    		move = false;
    		pac.setRotate(180);
    	}
		return move;
    }
    
    public boolean left(boolean move) {
    	if(!move) {
    		pac.setLayoutX(pac.getLayoutX()-6);
    	}
    	if(pac.getLayoutX()<=pac.getRadiusX()) {
    		
			move = true;
			pac.setRotate(0);
			
		}	
		return move;
    }
    
    public boolean closeMouth(boolean sprite) {
    	if(move) {
    		pac.setLength(pac.getLength()+5);
    		pac.setStartAngle(pac.getStartAngle()-3);
    	}
    	if(pac.getLength()>=360) {
    		move = false;
    	}
		return move;
    }
    
    public boolean openMouth(boolean sprite) {
    	if(!move) {
    		pac.setLength(pac.getLength()-5);
    		pac.setStartAngle(pac.getStartAngle()+3);
    	}
    	if(pac.getLength()<270) {
    		move = true;
    	}
		return move;
    }
    
    @FXML
    void exit(ActionEvent event) {
    	System.exit(0);
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
}
