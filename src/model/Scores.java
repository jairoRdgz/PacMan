package model;

public class Scores{
	private String names;
	private int points;
	
	public Scores(String n, int point) {
		this.names = n;
		this.points = point;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}
