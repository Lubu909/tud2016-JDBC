package main.java.com.tud2016JDBC.manager;

import java.sql.Connection;
import java.util.List;

import main.java.com.tud2016JDBC.model.Account;
import main.java.com.tud2016JDBC.model.Character;
import main.java.com.tud2016JDBC.model.CharacterList;

public interface ICharacterListManager {
	public Connection getConnection();
	public int addCharacterToAcc(Account account, Character character);
	public int delCharacterFromAcc(Account account, Character character);
	public int clearAll();
	public int purgeAcc(Account account);
	public List<Character> listCharacters(Account account);
	public List<CharacterList> listAll();
}
