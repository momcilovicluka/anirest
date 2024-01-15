package com.luka.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the AnimeList_has_Anime database table.
 * 
 */
@Entity
@NamedQuery(name = "AnimeList_has_Anime.findAll", query = "SELECT a FROM AnimeList_has_Anime a")
public class AnimeList_has_Anime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAnimeList_has_Anime;

	private int position;

	// bi-directional many-to-one association to Anime
	@ManyToOne
	@JoinColumn(name = "Anime_idAnime")
	private Anime anime;

	// bi-directional many-to-one association to AnimeList
	@ManyToOne
	@JoinColumn(name = "AnimeList_idAnimeList")
	private AnimeList animeList;

	public AnimeList_has_Anime() {
	}

	public int getIdAnimeList_has_Anime() {
		return this.idAnimeList_has_Anime;
	}

	public void setIdAnimeList_has_Anime(int idAnimeList_has_Anime) {
		this.idAnimeList_has_Anime = idAnimeList_has_Anime;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Anime getAnime() {
		return this.anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}

	public AnimeList getAnimeList() {
		return this.animeList;
	}

	public void setAnimeList(AnimeList animeList) {
		this.animeList = animeList;
	}

}