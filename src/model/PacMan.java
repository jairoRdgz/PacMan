package model;

public class PacMan{
	
	private Direction direction;
	
	private double radio;
	private double posx;
	private double posy;
	private int wait;
	private int bounces;
	private String directions;
	private boolean stoped;
	private boolean keep;
	private double length;
	
	public PacMan(double radio, double posx, double posy, int wait, int bounces, boolean stoped, Direction direc) {
		this.radio = radio;
		this.posx = posx;
		this.posy = posy;
		this.wait = wait;
		this.bounces = bounces;
		this.stoped = stoped;
		this.direction = direc;
		
		keep=true;	
		length = 270;
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
	
	public String getDirections() {
		return directions;
	}
	
	public void setDirections(String directions) {
		this.directions = directions;
	}

	public void move(double maxH, double maxV) {
		switch(direction) {
		case RIGHT:
			mouthSprite();
			if(posx+10+radio>maxH) {
				direction = Direction.LEFT;
				posx = maxH+radio;
			}else {
				posx = posx+10;		
				setBounces(getBounces()+1);
			}
		break;
		case LEFT:
			mouthSprite();
			if(posx-10-radio<0) {
				direction = Direction.RIGHT;
				posx = radio;
			}else {
				posx = posx-10;	
				setBounces(getBounces()+1);
			}
		break;
		case UP:
			mouthSprite();
			if(posy-10-radio<0) {
				direction = Direction.DOWN;
				posy = radio;
			}else {
				posy = posy-10;	
				setBounces(getBounces()+1);
			}
		break;
		case DOWN:
			mouthSprite();
			if(posy+10+radio<0) {
				direction = Direction.UP;
				posy = radio;
			}else {
				posy = posy+10;	
				setBounces(getBounces()+1);
			}
		break;
		}
	}
	
	public void mouthSprite() {
		if(keep) {
			length = length+4;
		}
		if(length>=360) {
			keep = false;
		}
		
		if(!keep) {
			length = length-4;
		}
		if(length<270) {
			keep = true;
		}
	}
}
