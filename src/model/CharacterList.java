package model;

public class CharacterList {
	private int idCharacterList;
	private Account account;
	private Character character;
	
	public CharacterList() {
	}

	public int getIdCharacterList() {
		return idCharacterList;
	}
	public void setIdCharacterList(int idCharacterList) {
		this.idCharacterList = idCharacterList;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}
}
