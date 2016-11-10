package test;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;

import manager.CharacterManager;
import manager.AccountManager;
import manager.CharacterListManager;

import model.Character;
import model.Account;
import model.CharacterList;

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
	
	@Test
	public void CharacterAddTest(){
		Character chara = new Character("Test", "Warrior", "Human", 90);
		characterManager.clearCharacter();
		assertEquals(1,characterManager.addCharacter(chara));
		List<Character> chars = characterManager.getAll();
		assertEquals(1,chars.size());
		assertEquals(chara.getNick(),chars.get(0).getNick());
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
