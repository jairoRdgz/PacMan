package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Game;
import model.Scores;
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
    
    private int level;
    
    private int wait;
    
    private int point;
    
    private boolean move;
    
    private List<Arc> pacs = new ArrayList<Arc>();
    
    private Scores scores;
    
    private Game pacos;
    
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
    	startGame();
    	
    	int id = pacos.addPacos(radio, posx, posy, wait, bounces, stoped); 
    	
    	PacManThread pmt = new PacManThread(pacos.getPacMan(id), this);
    	pmt.setDaemon(true);
    	pmt.start();
    		
    }
    
    @FXML
    void level1(ActionEvent event) {
    	setLevel(1);
    	String filePath = "./Levels/level1.txt";
    	loadLevel(filePath);
    	startGame();
    	
    }

    @FXML
    void level2(ActionEvent event) {
    	setLevel(2);
    	String filePath = "./Levels/level2.txt";
    	loadLevel(filePath);
    	startGame();
    }
    
    void loadLevel(String filePath) {
    	double radio;
	    double posx;
	    double posy;
	    int bounces;
	    boolean stoped;
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
				bounces = Integer.parseInt(variables[5]);
				if(variables[6]=="false") {
					stoped = false;
				}else {
					stoped = true;
				}
				pacos.addPacos(radio, posx, posy, bounces, bounces, stoped);
				
				thisLine = br.readLine();
				startGame();
			}
			
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    void startGame() {
    	for(int id = 0 ; id < pacs.size() ; id++) {
    		pac = new Arc(pacos.getPacMan(id).getPosx(), pacos.getPacMan(id).getPosy(),pacos.getPacMan(id).getRadio(),pacos.getPacMan(id).getRadio(), 30, 300);
    		pac.setFill(Color.YELLOW);
    		pac.setStroke(Color.BLACK);
    		pac.setStrokeWidth(4);
    		pac.setType(ArcType.ROUND);
       		panel.getChildren().add(pac);
    	}
    	pacs.add(pac);
    }
    
    public void movePacMans() {
    	for (int id = 1; id < pacs.size(); id++) {
    		if(pacs.get(id)!= null) {
    			System.out.println("Esta Monda sirve");
				pacs.get(id).setLayoutX(pacos.getPacMan(id).getPosx());
				pacs.get(id).setLayoutY(pacos.getPacMan(id).getPosy());
    		}else {
    			System.out.println("Esta Monda no sirve");
    		}
		}
    }

    @FXML
    void loadGame(ActionEvent event) {
    	
    }

    @FXML
    void saveGame(ActionEvent event) throws FileNotFoundException, IOException {
    	ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("./points/"));
    	save.writeObject(scores);
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
    
    public double getWidth() {
    	return panel.getWidth();
    }
}
