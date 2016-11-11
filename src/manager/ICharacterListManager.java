package manager;

import java.sql.Connection;
import java.util.List;

import model.Account;
import model.Character;
import model.CharacterList;

public interface ICharacterListManager {
	public Connection getConnection();
	public int addCharacterToAcc(Account account, Character character);
	public int delCharacterFromAcc(Account account, Character character);
	public int clearAll();
	public int purgeAcc(Account account);
	public List<Character> listCharacters(Account account);
	public List<CharacterList> listAll();
}
