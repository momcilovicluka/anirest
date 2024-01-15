package com.luka.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the CharacterList_has_Character database table.
 * 
 */
@Entity
@NamedQuery(name = "CharacterList_has_Character.findAll", query = "SELECT c FROM CharacterList_has_Character c")
public class CharacterList_has_Character implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCharacterList_has_Character;

	private int position;

	// bi-directional many-to-one association to AnimeCharacter
	@ManyToOne
	@JoinColumn(name = "Character_idCharacter")
	private AnimeCharacter animeCharacter;

	// bi-directional many-to-one association to CharacterList
	@ManyToOne
	@JoinColumn(name = "CharacterList_idCharacterList")
	private CharacterList characterList;

	public CharacterList_has_Character() {
	}

	public int getIdCharacterList_has_Character() {
		return this.idCharacterList_has_Character;
	}

	public void setIdCharacterList_has_Character(int idCharacterList_has_Character) {
		this.idCharacterList_has_Character = idCharacterList_has_Character;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public AnimeCharacter getAnimeCharacter() {
		return this.animeCharacter;
	}

	public void setAnimeCharacter(AnimeCharacter animeCharacter1) {
		this.animeCharacter = animeCharacter1;
	}

	public CharacterList getCharacterList() {
		return this.characterList;
	}

	public void setCharacterList(CharacterList characterList) {
		this.characterList = characterList;
	}

}