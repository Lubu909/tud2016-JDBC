package main.java.com.tud2016JDBC.manager;

import java.sql.Connection;
import java.util.List;

import main.java.com.tud2016JDBC.model.Character;

public interface ICharacterManager {
	public Connection getConnection();
	public int addCharacter(Character character);
	public int deleteCharacter(Character character);
	public int clearCharacter();
	public Character getCharacter(String nick);
	public Character getCharacter(int id);
	public List<Character> getAll();
}
