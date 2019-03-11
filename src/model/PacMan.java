package model;

import java.io.BufferedReader;
import java.io.FileReader;

public class PacMan {
	
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	
	private int level;
	private double radio;
	private double posx;
	private double posy;
	private String direction;
	private int wait;
	private int bounces;
	private boolean stoped;
	
	public PacMan(double radio, double posx, double posy, String direction, int wait, int bounces, boolean stoped ) {
		this.radio = radio;
		this.posx = posx;
		this.posy = posy;
		this.direction = direction;
		this.wait = wait;
		this.bounces = bounces;
		this.stoped = stoped;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getPosx() {
		return posx;
	}

	public void setPosx(double posx) {
		this.posx = posx;
	}

	public double getPosy() {
		return posy;
	}

	public void setPosy(double posy) {
		this.posy = posy;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getWait() {
		return wait;
	}

	public void setWait(int wait) {
		this.wait = wait;
	}

	public int getBounces() {
		return bounces;
	}

	public void setBounces(int bounces) {
		this.bounces = bounces;
	}

	public boolean isStoped() {
		return stoped;
	}

	public void setStoped(boolean stoped) {
		this.stoped = stoped;
	}
	
}
