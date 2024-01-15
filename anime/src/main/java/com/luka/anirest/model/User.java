package com.luka.anirest.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	private String email;

	private String name;

	private String password;

	private String surname;

	private String username;

	//bi-directional many-to-one association to AnimeList
	@OneToMany(mappedBy="user")
	private List<AnimeList> animeLists;

	//bi-directional many-to-one association to CharacterList
	@OneToMany(mappedBy="user")
	private List<CharacterList> characterLists;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<AnimeList> getAnimeLists() {
		return this.animeLists;
	}

	public void setAnimeLists(List<AnimeList> animeLists) {
		this.animeLists = animeLists;
	}

	public AnimeList addAnimeList(AnimeList animeList) {
		getAnimeLists().add(animeList);
		animeList.setUser(this);

		return animeList;
	}

	public AnimeList removeAnimeList(AnimeList animeList) {
		getAnimeLists().remove(animeList);
		animeList.setUser(null);

		return animeList;
	}

	public List<CharacterList> getCharacterLists() {
		return this.characterLists;
	}

	public void setCharacterLists(List<CharacterList> characterLists) {
		this.characterLists = characterLists;
	}

	public CharacterList addCharacterList(CharacterList characterList) {
		getCharacterLists().add(characterList);
		characterList.setUser(this);

		return characterList;
	}

	public CharacterList removeCharacterList(CharacterList characterList) {
		getCharacterLists().remove(characterList);
		characterList.setUser(null);

		return characterList;
	}

}