package test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
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
	public void clearAllTest(){
		Character chara = new Character("Clear" + (int)(Math.random() *1001), "Hunter", "Goblin", 15);
		Account acc = new Account("ClearAcc" + (int)(Math.random() *1001), "qwerty1234");
		assertEquals(1,accountManager.addAccount(acc));
		assertEquals(1,characterManager.addCharacter(chara));
		acc = accountManager.getAccount(acc.getLogin());
		chara = characterManager.getCharacter(chara.getNick());
		assertEquals(1,characterListManager.addCharacterToAcc(acc, chara));
		assertTrue(characterListManager.clearAll() > 0);
		assertTrue(characterManager.clearCharacter() > 0);
		assertTrue(accountManager.clearAccount() > 0);
		List<Character> chars = characterManager.getAll();
		List<Account> accs = accountManager.getAll();
		List<CharacterList> lista = characterListManager.listAll();
		assertEquals(0,chars.size());
		assertEquals(0,accs.size());
		assertEquals(0,lista.size());
	}

	@Test
	public void CharacterAddTest(){
		Character chara = new Character("Test" + (int)(Math.random() *1001), "Warrior", "Human", 90);
		characterManager.clearCharacter();
		assertEquals(1,characterManager.addCharacter(chara));
		List<Character> chars = characterManager.getAll();
		assertEquals(1,chars.size());
		assertEquals(chara.getNick(),chars.get(0).getNick());
	}
	
	@Test
	public void AccountAddTest(){
		accountManager.clearAccount();
		Account acc = new Account("KontoTestowe" + (int)(Math.random() *1001), "1234");
		assertEquals(1,accountManager.addAccount(acc));
		List<Account> accs = accountManager.getAll();
		assertEquals(1,accs.size());
		assertEquals(acc.getLogin(),accs.get(0).getLogin());
	}

	@Test
	public void CharacterListAddTest(){
		characterManager.clearCharacter();
		accountManager.clearAccount();
				
		Account acc = new Account("TestListy" + (int)(Math.random() *1001), "qwerty");
		Character char1 = new Character("Zenek" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char2 = new Character("Gandalf" + (int)(Math.random() *1001), "Mage", "Human", 100);
		
		assertEquals(1,accountManager.addAccount(acc));
		assertEquals(1,characterManager.addCharacter(char1));
		assertEquals(1,characterManager.addCharacter(char2));
		
		acc = accountManager.getAccount(acc.getLogin());
		char1 = characterManager.getCharacter(char1.getNick());
		char2 = characterManager.getCharacter(char2.getNick());
		assertEquals(1,characterListManager.addCharacterToAcc(acc, char1));
		assertEquals(1,characterListManager.addCharacterToAcc(acc, char2));
		
		List<Character> listaPostaci = characterListManager.listCharacters(acc);	
		assertEquals(2,listaPostaci.size());
		assertEquals(char1.getNick(),listaPostaci.get(0).getNick());
		assertEquals(char2.getNick(),listaPostaci.get(1).getNick());
	}

	@Test
	public void CharacterDeleteTest(){
		characterManager.clearCharacter();
		
		Character char1 = new Character("Pierwsza" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char2 = new Character("Druga" + (int)(Math.random() *1001), "Mage", "Human", 100);
		Character char3 = new Character("Trzecia" + (int)(Math.random() *1001), "Shaman", "Troll", 120);
		Character char4 = new Character("Czwarta" + (int)(Math.random() *1001), "BladeDancer", "Human", 80);
		
		assertEquals(1,characterManager.addCharacter(char1));
		assertEquals(1,characterManager.addCharacter(char2));
		assertEquals(1,characterManager.addCharacter(char3));
		assertEquals(1,characterManager.addCharacter(char4));
		
		List<Character> chars = characterManager.getAll();
		assertEquals(4,chars.size());
		
		char1 = characterManager.getCharacter(char1.getNick());
		char2 = characterManager.getCharacter(char2.getNick());
		char3 = characterManager.getCharacter(char3.getNick());
		char4 = characterManager.getCharacter(char4.getNick());
		
		List<Character> istniejace = new ArrayList<Character>();
		istniejace.add(char2);
		istniejace.add(char3);
		istniejace.add(char4);
		
		assertEquals(1,characterManager.deleteCharacter(char1));
		chars = characterManager.getAll();
		assertEquals(3,chars.size());
		boolean char1exists = false;
		for(int i=0; i<chars.size(); i++){
			assertEquals(chars.get(i).getNick(),istniejace.get(i).getNick());
			if(chars.get(i).getNick()==char1.getNick()) char1exists = true;
		}
		assertFalse(char1exists);
	}
	
	@Test
	public void AccountDeleteTest(){
		accountManager.clearAccount();
		
		Account acc1 = new Account("Pierwsze" + (int)(Math.random() *1001), "qwerty");
		Account acc2 = new Account("Drugie" + (int)(Math.random() *1001), "qwerty");
		Account acc3 = new Account("Trzecie" + (int)(Math.random() *1001), "qwerty");
		Account acc4 = new Account("Czwarte" + (int)(Math.random() *1001), "qwerty");
		
		assertEquals(1,accountManager.addAccount(acc1));
		assertEquals(1,accountManager.addAccount(acc2));
		assertEquals(1,accountManager.addAccount(acc3));
		assertEquals(1,accountManager.addAccount(acc4));
		
		List<Account> accs = accountManager.getAll();
		assertEquals(4,accs.size());
		
		acc1 = accountManager.getAccount(acc1.getLogin());
		acc2 = accountManager.getAccount(acc2.getLogin());
		acc3 = accountManager.getAccount(acc3.getLogin());
		acc4 = accountManager.getAccount(acc4.getLogin());
		
		List<Account> istniejace = new ArrayList<Account>();
		istniejace.add(acc2);
		istniejace.add(acc3);
		istniejace.add(acc4);
		
		assertEquals(1,accountManager.deleteAccount(acc1));
		accs = accountManager.getAll();
		assertEquals(3,accs.size());
		boolean acc1exists = false;
		for(int i=0; i<accs.size(); i++){
			assertEquals(accs.get(i).getLogin(),istniejace.get(i).getLogin());
			if(accs.get(i).getLogin()==acc1.getLogin()) acc1exists = true;
		}
		assertFalse(acc1exists);
	}
	
	@Test
	public void CharacterListDeleteTest(){
		characterManager.clearCharacter();
		accountManager.clearAccount();
		
		Account acc1 = new Account("Account1" + (int)(Math.random() *1001), "qwerty");
		Character char1 = new Character("Char1" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char2 = new Character("Char2" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char3 = new Character("Char3" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		
		assertEquals(1,accountManager.addAccount(acc1));
		assertEquals(1,characterManager.addCharacter(char1));
		assertEquals(1,characterManager.addCharacter(char2));
		assertEquals(1,characterManager.addCharacter(char3));
		
		acc1 = accountManager.getAccount(acc1.getLogin());
		char1 = characterManager.getCharacter(char1.getNick());
		char2 = characterManager.getCharacter(char2.getNick());
		char3 = characterManager.getCharacter(char3.getNick());
		assertEquals(1,characterListManager.addCharacterToAcc(acc1, char1));
		assertEquals(1,characterListManager.addCharacterToAcc(acc1, char2));
		assertEquals(1,characterListManager.addCharacterToAcc(acc1, char3));
		
		List<Character> lista = characterListManager.listCharacters(acc1);
		assertEquals(3,lista.size());
		
		assertEquals(1,characterListManager.delCharacterFromAcc(acc1, char2));
		
		lista = characterListManager.listCharacters(acc1);
		assertEquals(2,lista.size());
		
		assertEquals(lista.get(0).getNick(),char1.getNick());
		assertEquals(lista.get(1).getNick(),char3.getNick());
	}
	
	@Test
	public void CharacterListPurgeTest(){
		characterManager.clearCharacter();
		accountManager.clearAccount();
		
		Character char1 = new Character("Char1Acc1" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char2 = new Character("Char2Acc1" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char3 = new Character("Char1Acc2" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char4 = new Character("Char2Acc2" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Account acc1 = new Account("Account1" + (int)(Math.random() *1001), "qwerty");
		Account acc2 = new Account("Account2" + (int)(Math.random() *1001), "qwerty");
		
		assertEquals(1,characterManager.addCharacter(char1));
		assertEquals(1,characterManager.addCharacter(char2));
		assertEquals(1,characterManager.addCharacter(char3));
		assertEquals(1,characterManager.addCharacter(char4));
		assertEquals(1,accountManager.addAccount(acc1));
		assertEquals(1,accountManager.addAccount(acc2));
		
		List<Character> chars = characterManager.getAll();
		assertEquals(4,chars.size());
		List<Account> accs = accountManager.getAll();
		assertEquals(2,accs.size());
		
		acc1 = accountManager.getAccount(acc1.getLogin());
		acc2 = accountManager.getAccount(acc2.getLogin());
		char1 = characterManager.getCharacter(char1.getNick());
		char2 = characterManager.getCharacter(char2.getNick());
		char3 = characterManager.getCharacter(char3.getNick());
		char4 = characterManager.getCharacter(char4.getNick());
		assertEquals(1,characterListManager.addCharacterToAcc(acc1, char1));
		assertEquals(1,characterListManager.addCharacterToAcc(acc1, char2));
		assertEquals(1,characterListManager.addCharacterToAcc(acc2, char3));
		assertEquals(1,characterListManager.addCharacterToAcc(acc2, char4));
		
		List<Character> acc1List = characterListManager.listCharacters(acc1);
		assertEquals(2,acc1List.size());
		List<Character> acc2List = characterListManager.listCharacters(acc2);
		assertEquals(2,acc2List.size());
		
		characterListManager.purgeAcc(acc1);
		
		acc1List = characterListManager.listCharacters(acc1);
		assertEquals(0,acc1List.size());
		acc2List = characterListManager.listCharacters(acc2);
		assertEquals(2,acc2List.size());
	}
	
	@Test
	public void ListAllCharacters(){
		characterManager.clearCharacter();
		
		Character char1 = new Character("Char1" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char2 = new Character("Char2" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char3 = new Character("Char3" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		
		assertEquals(1,characterManager.addCharacter(char1));
		assertEquals(1,characterManager.addCharacter(char2));
		assertEquals(1,characterManager.addCharacter(char3));
		
		List<Character> chars = characterManager.getAll();
		assertEquals(3,chars.size());
	
		assertEquals(chars.get(0).getNick(),char1.getNick());
		assertEquals(chars.get(1).getNick(),char2.getNick());
		assertEquals(chars.get(2).getNick(),char3.getNick());
	}
	
	@Test
	public void ListAllAccounts(){
		accountManager.clearAccount();
		
		Account acc1 = new Account("Account1" + (int)(Math.random() *1001), "qwerty");
		Account acc2 = new Account("Account2" + (int)(Math.random() *1001), "qwerty");
		Account acc3 = new Account("Account3" + (int)(Math.random() *1001), "qwerty");
		
		assertEquals(1,accountManager.addAccount(acc1));
		assertEquals(1,accountManager.addAccount(acc2));
		assertEquals(1,accountManager.addAccount(acc3));
		
		List<Account> accs = accountManager.getAll();
		assertEquals(3,accs.size());
		
		assertEquals(accs.get(0).getLogin(),acc1.getLogin());
		assertEquals(accs.get(1).getLogin(),acc2.getLogin());
		assertEquals(accs.get(2).getLogin(),acc3.getLogin());
	}
	
	@Test
	public void CharacterListAllTest(){
		characterManager.clearCharacter();
		accountManager.clearAccount();
		
		Character char1 = new Character("Char1Acc1" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char2 = new Character("Char2Acc1" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char3 = new Character("Char1Acc2" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Character char4 = new Character("Char2Acc2" + (int)(Math.random() *1001), "Warrior", "Elf", 110);
		Account acc1 = new Account("Account1" + (int)(Math.random() *1001), "qwerty");
		Account acc2 = new Account("Account2" + (int)(Math.random() *1001), "qwerty");
		
		assertEquals(1,characterManager.addCharacter(char1));
		assertEquals(1,characterManager.addCharacter(char2));
		assertEquals(1,characterManager.addCharacter(char3));
		assertEquals(1,characterManager.addCharacter(char4));
		assertEquals(1,accountManager.addAccount(acc1));
		assertEquals(1,accountManager.addAccount(acc2));
		
		List<Character> chars = characterManager.getAll();
		assertEquals(4,chars.size());
		List<Account> accs = accountManager.getAll();
		assertEquals(2,accs.size());
		
		acc1 = accountManager.getAccount(acc1.getLogin());
		acc2 = accountManager.getAccount(acc2.getLogin());
		char1 = characterManager.getCharacter(char1.getNick());
		char2 = characterManager.getCharacter(char2.getNick());
		char3 = characterManager.getCharacter(char3.getNick());
		char4 = characterManager.getCharacter(char4.getNick());
		assertEquals(1,characterListManager.addCharacterToAcc(acc1, char1));
		assertEquals(1,characterListManager.addCharacterToAcc(acc1, char2));
		assertEquals(1,characterListManager.addCharacterToAcc(acc2, char3));
		assertEquals(1,characterListManager.addCharacterToAcc(acc2, char4));
		
		List<CharacterList> listaCala = characterListManager.listAll();
		assertEquals(4,listaCala.size());
	}

}
