package model;

public class CharacterList {
	private int idCharacterList;
	private int idAccount;
	private int idCharacter;
	
	public CharacterList() {
	}
	
	public CharacterList(int idAccount, int idCharacter) {
		super();
		this.idAccount = idAccount;
		this.idCharacter = idCharacter;
	}

	public int getIdCharacterList() {
		return idCharacterList;
	}
	public void setIdCharacterList(int idCharacterList) {
		this.idCharacterList = idCharacterList;
	}
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	public int getIdCharacter() {
		return idCharacter;
	}
	public void setIdCharacter(int idCharacter) {
		this.idCharacter = idCharacter;
	}
}
