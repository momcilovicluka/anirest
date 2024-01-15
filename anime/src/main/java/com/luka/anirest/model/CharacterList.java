package com.luka.anirest.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the CharacterList database table.
 * 
 */
@Entity
@NamedQuery(name="CharacterList.findAll", query="SELECT c FROM CharacterList c")
public class CharacterList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCharacterList;

	private String description;

	private String title;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_idUser")
	private User user;

	//bi-directional many-to-one association to CharacterList_has_Character
	@OneToMany(mappedBy="characterList")
	private List<CharacterList_has_Character> characterListHasCharacters;

	public CharacterList() {
	}

	public int getIdCharacterList() {
		return this.idCharacterList;
	}

	public void setIdCharacterList(int idCharacterList) {
		this.idCharacterList = idCharacterList;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CharacterList_has_Character> getCharacterListHasCharacters() {
		return this.characterListHasCharacters;
	}

	public void setCharacterListHasCharacters(List<CharacterList_has_Character> characterListHasCharacters) {
		this.characterListHasCharacters = characterListHasCharacters;
	}

	public CharacterList_has_Character addCharacterListHasCharacter(CharacterList_has_Character characterListHasCharacter) {
		getCharacterListHasCharacters().add(characterListHasCharacter);
		characterListHasCharacter.setCharacterList(this);

		return characterListHasCharacter;
	}

	public CharacterList_has_Character removeCharacterListHasCharacter(CharacterList_has_Character characterListHasCharacter) {
		getCharacterListHasCharacters().remove(characterListHasCharacter);
		characterListHasCharacter.setCharacterList(null);

		return characterListHasCharacter;
	}

}