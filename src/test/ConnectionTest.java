package test;

import static org.junit.Assert.*;

import org.junit.Test;

import manager.CharacterManager;
import manager.AccountManager;
import manager.CharacterListManager;

public class ConnectionTest {
	
	CharacterManager characterManager = new CharacterManager();
	AccountManager accountManager = new AccountManager();
	CharacterListManager characterListManager = new CharacterListManager();
	
	@Test
	public void checkConnection(){
		assertNotNull(characterManager.getConnection());
		assertNotNull(accountManager.getConnection());
		assertNotNull(characterListManager.getConnection());
	}
	
	/*@Test
	public void checkList(){
		addAccount();
		addCharacter();
		addCharacter();
		viewCharacterList();
	}*/

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
