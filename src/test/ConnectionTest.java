package test;

import static org.junit.Assert.*;

import org.junit.Test;

import manager.CharacterManager;

public class ConnectionTest {
	
	CharacterManager characterManager = new CharacterManager();
	
	@Test
	public void checkConnection(){
		assertNotNull(characterManager.getConnection());
	}

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
