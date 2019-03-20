package model;

import java.io.Serializable;

public class Scores implements Serializable{
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
	
	
	
	/*public String createHall() {
		names = new String[10];
		scors = new int[10];
		
		String hall = " ## \t NichName \t Score \n";
		for (int i = 0; i < scors.length-1; i++) {
			hall+= " " + (i+1) +"- \t "+ names[i]+"\t\t\t"+scors[i]+"\n";
		}
		return hall;
	}
	
	public void hallOfFame() {
		
		String[] names = new String[10];
		scors[5]=5;
		for (int i = 0; i < names.length; i++) {
			names[i]="Empty";
		}
		for(int i = 0; i<scors.length-1;i++) {
			for(int j = i+1; j <scors.length ;j++) {
				if(scors[i]<scors[j]) {
					int temp = scors[i];
					scors[i] = scors[j];
					scors[j] = temp; 
				}
			}
		}
	}*/
	
}
