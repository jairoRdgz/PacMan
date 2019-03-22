package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<PacMan> pacos;
	private Scores[] scores;
	
	public Game(){
		pacos = new ArrayList<PacMan>();
		scores = new Scores[10];
	}
	
	public void createHallOfFame(String nick, int score) {
		for(int i = 0; i< scores.length ;i++) {
			if(scores[i]==null) {
				scores[i] = new Scores(nick, score);
			}
			if(i<scores.length) {
				if(scores[i].getPoints()>score) {
					scores[i].setPoints(score);
					scores[i].setNames(nick);
				}
			}
		}
		organizeHall();
	}
	
	public void organizeHall() {
		for(int i = 0; i < scores.length-1; i++) {
			if(scores[i].getPoints()>scores[i+1].getPoints()) {
				int temp = scores[i].getPoints();
				scores[i].setPoints(scores[i+1].getPoints());
				scores[i+1].setPoints(temp);
			}
		}
	}
	
	public String showHall() {
		String hall = "";
		hall = "## \t\t Nicknames \t Points \n";
		for (int i = 0; i < scores.length; i++) {
			if(scores[i]!=null)
			hall+= (i+1)+"\t\t  "+ scores[i].getNames()+"\t\t  "+scores[i].getPoints()+"\n";
			
		}
		return hall;
	}
	
	public Scores getScores(int id) {
		return scores[id];
	}
	
	public int addPacos(double radio, double posx, double posy, int wait, int bounces, boolean stoped, Direction direc) {
		pacos.add(new PacMan(radio, posx, posy, wait, bounces, stoped, direc));
		return pacos.size()-1;
	}
	
	public PacMan getPacMan(int id) {
		return pacos.get(id);
	}
	
	public int getPoints(int id) {
		return scores[id].getPoints();
	}
	
	public ArrayList<PacMan> getPacs(){
		return (ArrayList<PacMan>) pacos;
	}
}
