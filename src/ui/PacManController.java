package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Direction;
import model.Game;
import threads.PacManGUIThread;
import threads.PacManThread;

public class PacManController {
	
	private Stage stage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane pane;

    @FXML
    private Label points;

    @FXML
    private Pane panel;
    
    @FXML
    private Arc pac;
    
    @FXML
    private Menu game;
    
    private int level;
    
    private int wait;
    
    private List<Arc> pacs = new ArrayList<Arc>();
    
    private Game pacos;
    private Direction direction;
    
    private double radio;
    private double posx;
    private double posy;
    private int bounces;
    
    private boolean stoped;
    
    //METHODS
    
    @FXML
    void level0(ActionEvent event) {
    	setLevel(0);
    	String filePath = "./Levels/level0.txt";
    	loadLevel(filePath);
    	
    	int id = pacos.addPacos(radio, posx, posy, wait, bounces, stoped, direction); 
    	
    	PacManThread pmt = new PacManThread(pacos.getPacMan(id), this);
    	pmt.setDaemon(true);
    	pmt.start();
    	
    	game.setDisable(true);
    }
    
    @FXML
    void level1(ActionEvent event) {
    	setLevel(1);
    	String filePath = "./Levels/level1.txt";
    	loadLevel(filePath);
    	
    	int id = pacos.addPacos(radio, posx, posy, wait, bounces, stoped, direction);
    	
    	PacManThread pmt = new PacManThread(pacos.getPacMan(id), this);
    	pmt.setDaemon(true);
    	pmt.start();
    	
    	game.setDisable(true);
    	
    }

    @FXML
    void level2(ActionEvent event) {
    	setLevel(2);
    	String filePath = "./Levels/level2.txt";
    	loadLevel(filePath);
    	
    	int id = pacos.addPacos(radio, posx, posy, wait, bounces, stoped, direction);
    	
    	PacManThread pmt = new PacManThread(pacos.getPacMan(id), this);
    	pmt.setDaemon(true);
    	pmt.start();
    	
    	game.setDisable(true);
    }
    
    void loadLevel(String filePath) {
    	radio=0;
	    posx=0;
	    posy=0;
	    bounces=0;
	    boolean stoped=false;
    	try {
			FileReader levels = new FileReader(filePath);
			BufferedReader br = new BufferedReader(levels);
			String thisLine = br.readLine();
			thisLine = br.readLine();
			thisLine = br.readLine();
			thisLine = br.readLine();
			
			while(thisLine != null) {
				String[] variables = thisLine.split("\t");
				radio = Integer.parseInt(variables[0]);
				posx = Integer.parseInt(variables[1]);
				posy = Integer.parseInt(variables[2]);
				wait = Integer.parseInt(variables[3]);
				String directions = variables[4];
				if(directions.equals("RIGHT")) {
					direction = Direction.RIGHT;
				}else if(directions.equals("LEFT")) {
					direction = Direction.LEFT;
				}else if(directions.equals("UP")){
					direction = Direction.UP;
				}else {
					direction = Direction.DOWN;
				}
				bounces = Integer.parseInt(variables[5]);
				if(variables[6]=="false") {
					stoped = false;
				}else {
					stoped = true;
				}
				
				pacos.addPacos(radio, posx, posy, bounces, bounces, stoped, direction);
				
				thisLine = br.readLine();
			}
			startGame();
			levels.close();
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    void startGame() {
    	for(int i = 0 ; i < pacos.getPacs().size() ; i++) {
    		pac = new Arc(pacos.getPacMan(i).getPosx(), pacos.getPacMan(i).getPosy(),pacos.getPacMan(i).getRadio(),pacos.getPacMan(i).getRadio(), 32, 300);
    		pac.setFill(Color.YELLOW);
    		pac.setStroke(Color.BLACK);
    		pac.setStrokeWidth(4);
    		pac.setType(ArcType.ROUND);
       		panel.getChildren().add(pac);
       		pacs.add(pac);
    	}    	
    	
    }
    
    public void movePacMans() {
    	for (int id = 0; id < pacs.size(); id++) {
    		if(pacs.get(id)!= null) {
				pacs.get(id).setLayoutX(pacos.getPacMan(id).getPosx());
				pacs.get(id).setLayoutY(pacos.getPacMan(id).getPosy());
				pacs.get(id).setRotate(pacs.get(id).getStartAngle());
	    		pacs.get(id).setLength(pacs.get(id).getLength());
    		}
    		PacManThread pmt = new PacManThread(pacos.getPacMan(id), this);
    		pmt.setDaemon(true);
    		pmt.start();
		}
    }

    @FXML
    void loadGame(ActionEvent event) {
    	File file = new File("./Levels/level0.txt");
    	if(file.exists()) {
    		try {
    			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
    			pacs = (List<Arc>) input.readObject();
    			input.close();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void saveGame(ActionEvent event) throws FileNotFoundException, IOException {
    	ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("./Levels/level0.txt"));
    	save.writeObject(pacs);
    	save.close();
    }
    
    public int getLevel() {
		return level;
	}
    
	public void setLevel(int level) {

		this.level = level;
	}
	
	public int getWait() {
		return wait;
	}

	@FXML
    void showHighScores(ActionEvent event) {
    	Alert score = new Alert(AlertType.INFORMATION);
    	score.setTitle("PacMan");
    	score.setHeaderText("Hall Of Fame");
    	score.initStyle(StageStyle.DECORATED);
    	score.setContentText(pacos.showHall());
    	score.show();
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
    	" \n\ngood luck");
    	info.show();
    }
	
	@FXML
    void exit(ActionEvent event) {
		System.exit(0);
    }
	
	@FXML
    void initialize() {
    	pacos = new Game();
    	pacos.createHallOfFame("--------", 0);
    	
    	PacManGUIThread pmg = new PacManGUIThread(this);
    	pmg.setDaemon(true);
    	pmg.start();
    }
	
	 public void setStage(Stage st) {
	    	stage = st;
	 }
    
    public double getWidth() {
    	return stage.getScene().getWidth();
    }
    
    public double getHeight() {
    	return stage.getScene().getHeight();
    }
}
