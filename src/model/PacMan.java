package model;

public class PacMan {
	
	public static final int ARRIBA = 1;
	public static final int ABAJO = 2;
	public static final int IZQUIERDA = 3;
	public static final int DERECHA = 4;
	
	//private int level;
	private double radio;
	private double posx;
	private double posy;
	private int direction;
	private int wait;
	private int bounces;
	private boolean stoped;
	
	public PacMan(double radio, double posx, double posy, int direction, int wait, int bounces, boolean stoped ) {
		this.radio = radio;
		this.posx = posx;
		this.posy = posy;
		this.direction = direction;
		this.wait = wait;
		this.bounces = bounces;
		this.stoped = stoped;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
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
	
	public void loadFile() {
		
	}
}
