package com.luka.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the AnimeCharacter database table.
 * 
 */
@Entity
@NamedQuery(name="AnimeCharacter.findAll", query="SELECT a FROM AnimeCharacter a")
public class AnimeCharacter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCharacter;

	private String age;

	private String bloodType;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String description;

	private int favourites;

	private String gender;

	@Lob
	private byte[] image;

	private String nameAlternative;

	private String nameAlternativeSpoiler;

	private String nameFirst;

	private String nameFull;

	private String nameLast;

	private String nameMiddle;

	private String nameNative;

	private String siteUrl;

	//bi-directional many-to-one association to CharacterList_has_Character
	@OneToMany(mappedBy="animeCharacter")
	private List<CharacterList_has_Character> characterListHasCharacters;

	public AnimeCharacter() {
	}

	public int getIdCharacter() {
		return this.idCharacter;
	}

	public void setIdCharacter(int idCharacter) {
		this.idCharacter = idCharacter;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBloodType() {
		return this.bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFavourites() {
		return this.favourites;
	}

	public void setFavourites(int favourites) {
		this.favourites = favourites;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getNameAlternative() {
		return this.nameAlternative;
	}

	public void setNameAlternative(String nameAlternative) {
		this.nameAlternative = nameAlternative;
	}

	public String getNameAlternativeSpoiler() {
		return this.nameAlternativeSpoiler;
	}

	public void setNameAlternativeSpoiler(String nameAlternativeSpoiler) {
		this.nameAlternativeSpoiler = nameAlternativeSpoiler;
	}

	public String getNameFirst() {
		return this.nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameFull() {
		return this.nameFull;
	}

	public void setNameFull(String nameFull) {
		this.nameFull = nameFull;
	}

	public String getNameLast() {
		return this.nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getNameMiddle() {
		return this.nameMiddle;
	}

	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}

	public String getNameNative() {
		return this.nameNative;
	}

	public void setNameNative(String nameNative) {
		this.nameNative = nameNative;
	}

	public String getSiteUrl() {
		return this.siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public List<CharacterList_has_Character> getCharacterListHasCharacters() {
		return this.characterListHasCharacters;
	}

	public void setCharacterListHasCharacters(List<CharacterList_has_Character> characterListHasCharacters) {
		this.characterListHasCharacters = characterListHasCharacters;
	}

	public CharacterList_has_Character addCharacterListHasCharacters(CharacterList_has_Character characterListHasCharacters) {
		getCharacterListHasCharacters().add(characterListHasCharacters);
		characterListHasCharacters.setAnimeCharacter(this);

		return characterListHasCharacters;
	}

	public CharacterList_has_Character removeCharacterListHasCharacters1(CharacterList_has_Character characterListHasCharacters) {
		getCharacterListHasCharacters().remove(characterListHasCharacters);
		characterListHasCharacters.setAnimeCharacter(null);

		return characterListHasCharacters;
	}

}