package main.java.com.tud2016JDBC.model;

public class Character {
	private int idCharacter;
	private String nick;
	private String characterClass;
	private String characterRace;
	private int level;
	
	public Character(){
	}
	
	public Character(int idCharacter, String nick, String characterClass, String characterRace, int level) {
		super();
		this.idCharacter = idCharacter;
		this.nick = nick;
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.level = level;
	}
	
	public Character(String nick, String characterClass, String characterRace, int level) {
		super();
		this.nick = nick;
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.level = level;
	}
	
	public int getIdCharacter() {
		return idCharacter;
	}
	public void setIdCharacter(int idCharacter) {
		this.idCharacter = idCharacter;
	}
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getCharacterClass() {
		return characterClass;
	}
	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}
	public String getCharacterRace() {
		return characterRace;
	}
	public void setCharacterRace(String characterRace) {
		this.characterRace = characterRace;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
