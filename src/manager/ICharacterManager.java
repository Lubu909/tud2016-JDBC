package manager;

import java.sql.Connection;
import java.util.List;

import model.Character;

public interface ICharacterManager {
	public Connection getConnection();
	public int addCharacter(Character character);
	public int deleteCharacter(Character character);
	public int clearCharacter();
	public Character getCharacter(String nick);
	public Character getCharacter(int id);
	public List<Character> getAll();
}
