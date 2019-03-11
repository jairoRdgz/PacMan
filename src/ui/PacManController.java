package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.StageStyle;
import model.PacMan;
import threads.MovingThread;

public class PacManController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane pane;

    @FXML
    private MenuItem level0;

    @FXML
    private MenuItem level1;

    @FXML
    private MenuItem level2;

    @FXML
    private MenuItem guardarJuego;

    @FXML
    private MenuItem salir;

    @FXML
    private MenuItem highScore;

    @FXML
    private MenuItem info;

    @FXML
    private Arc pac;

    @FXML
    private Label points;

    private boolean move;	
    
    private PacMan paco;
    
    private int level;
    
    private ArrayList<PacMan> pacos;
    
    private MovingThread mt;
    
    private int wait;
    
    @FXML
    void exit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void information(ActionEvent event) {
    	Alert info = new Alert(AlertType.INFORMATION);
    	info.setTitle("PacMan");
    	info.setHeaderText(null);
    	info.initStyle(StageStyle.UTILITY);
    	info.setContentText(" INSTRUCTIONS \n\n"+
    	" Choose a level of dificulty in the ''load Game'' option\n"+
    	" Click on the Pac-Mans before they bounce on the walls "+
    	" Every time they bounce you get a point get as less point you can"+
    	" so you can be in our hall of fame"+
    	" \n\ngood luck MotherF*kcers");
    	info.show();
    }

    @FXML
    void loadLevel0(ActionEvent event) {
    	setLevel(0);
    	String filePath = "./Levels/level0.txt";
    	loadLevel(filePath);
    	startGame();
    	
    	mt = new MovingThread(this, move, wait);
    	mt.start();
    }

    @FXML
    void loadLevel1(ActionEvent event) {
    	setLevel(1);
    	String filePath = "./Levels/level1.txt";
    	loadLevel(filePath);
    	startGame();
    }

    @FXML
    void loadLevel2(ActionEvent event) {
    	setLevel(2);
    	String filePath = "./Levels/level2.txt";
    	loadLevel(filePath);
    	startGame();
    }
    
    public void loadLevel(String filePath) {
	    double radio;
	    double posx;
	    double posy;
	    String direction;
	    int bounces;
	    boolean stoped;
    	try {
			FileReader levels = new FileReader(filePath);
			BufferedReader br = new BufferedReader(levels);
			String thisLine = br.readLine();
			while(thisLine != null) {
				String[] variables = thisLine.split("\t");
				radio = Integer.parseInt(variables[0]);
				posx = Integer.parseInt(variables[1]);
				posy = Integer.parseInt(variables[2]);
				wait = Integer.parseInt(variables[3]);
				direction = variables[4];
				bounces = Integer.parseInt(variables[5]);
				if(variables[6]=="false") {
					stoped = false;
				}else {
					stoped = true;
				}
				paco = new PacMan(radio, posx, posy, direction, wait, bounces, stoped);
				pacos.add(paco);
				thisLine = br.readLine();
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
    	    	
    }

    public void startGame() {
    	for(int i = 0 ; i < pacos.size() ; i++) {
    		pac = new Arc(pacos.get(i).getPosx(), pacos.get(i).getPosx(), pacos.get(i).getRadio(), pacos.get(i).getRadio(), 32, 300);
    		pac.setFill(Color.YELLOW);
    		pac.setStroke(Color.BLACK);
    		pac.setStrokeWidth(3);
    		pac.setType(ArcType.ROUND);
    		pane.getChildren().add(pac);
    	}
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
    void initialize() {
        pacos = new ArrayList<PacMan>();
    }

	
    public int getLevel() {
		return level;
	}
    

	public void setLevel(int level) {
		this.level = level;
	}
}