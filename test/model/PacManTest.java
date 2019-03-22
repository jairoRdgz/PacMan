package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PacManTest {
	private PacMan pac;
	
	public void setupScennary1() {
		pac = new PacMan(10, 10, 10, 10, 10,false, Direction.RIGHT);
	}
	
	public void setupScennary2() {
		
	}
	@Test
	void PacManCreationTest() {
		setupScennary1();
		assertNotNull(pac);
	}
	
	@Test
	void PacManNonCreation() {
		setupScennary2();
		assertNull(pac);
	}
}
