package model;

import java.io.Serializable;

public class PacMan implements Serializable{
	
	private Direction direction;
	
	private double radio;
	private double posx;
	private double posy;
	private int wait;
	private int bounces;
	private boolean stoped;
	
	public PacMan(double radio, double posx, double posy, int wait, int bounces, boolean stoped) {
		this.radio = radio;
		this.posx = posx;
		this.posy = posy;
		this.wait = wait;
		this.bounces = bounces;
		this.stoped = stoped;
		
		direction = Direction.RIGHT;
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
	
	public void horizontalMove(double maxH) {
		switch(direction) {
		case RIGHT:
			if(posx+10+radio>maxH) {
				direction = Direction.LEFT;
				posx = maxH-radio;
			}else {
				posx = posx+10;					
			}
		break;
		case LEFT:
			if(posx-10-radio<0) {
				direction = Direction.RIGHT;
				posx = radio;
			}else {
				posx = posx-10;					
			}
		break;
		}
	}
	public void verticalMove(double maxV) {
		switch(direction) {
		case UP:
			if(posx+10+radio>maxV) {
				direction = Direction.LEFT;
				posx = maxV-radio;
			}else {
				posx = posx+10;					
			}
		break;
		case DOWN:
			if(posx-10-radio<0) {
				direction = Direction.RIGHT;
				posx = radio;
			}else {
				posx = posx-10;					
			}
		break;
		}
	}
}
