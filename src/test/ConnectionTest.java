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
	
	@Test
	public void AccountAddTest(){
		Account acc = new Account("KontoTestowe", "1234");
		accountManager.clearAccount();
		assertEquals(1,accountManager.addAccount(acc));
		List<Account> accs = accountManager.getAll();
		assertEquals(1,accs.size());
		assertEquals(acc.getLogin(),accs.get(0).getLogin());
	}
	
	@Test
	public void CharacterListAddTest(){
		fail("Not yet implemented");
	}

}
