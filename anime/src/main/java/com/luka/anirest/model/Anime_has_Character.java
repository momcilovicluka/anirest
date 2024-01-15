package com.luka.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the Anime_has_Character database table.
 * 
 */
@Entity
@NamedQuery(name="Anime_has_Character.findAll", query="SELECT a FROM Anime_has_Character a")
public class Anime_has_Character implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAnime_has_Character;

	//bi-directional many-to-one association to Anime
	@ManyToOne
	@JoinColumn(name="Anime_idAnime")
	private Anime anime;

	//bi-directional many-to-one association to Character
	@ManyToOne
	@JoinColumn(name="AnimeCharacter_idCharacter")
	private AnimeCharacter character;

	public Anime_has_Character() {
	}

	public int getIdAnime_has_Character() {
		return this.idAnime_has_Character;
	}

	public void setIdAnime_has_Character(int idAnime_has_Character) {
		this.idAnime_has_Character = idAnime_has_Character;
	}

	public Anime getAnime() {
		return this.anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}

}