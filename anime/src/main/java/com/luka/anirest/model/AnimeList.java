package com.luka.anirest.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the AnimeList database table.
 * 
 */
@Entity
@NamedQuery(name="AnimeList.findAll", query="SELECT a FROM AnimeList a")
public class AnimeList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAnimeList;

	private String description;

	private String title;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_idUser")
	private User user;

	//bi-directional many-to-one association to AnimeList_has_Anime
	@OneToMany(mappedBy="animeList")
	private List<AnimeList_has_Anime> animeListHasAnimes;

	public AnimeList() {
	}

	public int getIdAnimeList() {
		return this.idAnimeList;
	}

	public void setIdAnimeList(int idAnimeList) {
		this.idAnimeList = idAnimeList;
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

	public List<AnimeList_has_Anime> getAnimeListHasAnimes() {
		return this.animeListHasAnimes;
	}

	public void setAnimeListHasAnimes(List<AnimeList_has_Anime> animeListHasAnimes) {
		this.animeListHasAnimes = animeListHasAnimes;
	}

	public AnimeList_has_Anime addAnimeListHasAnime(AnimeList_has_Anime animeListHasAnime) {
		getAnimeListHasAnimes().add(animeListHasAnime);
		animeListHasAnime.setAnimeList(this);

		return animeListHasAnime;
	}

	public AnimeList_has_Anime removeAnimeListHasAnime(AnimeList_has_Anime animeListHasAnime) {
		getAnimeListHasAnimes().remove(animeListHasAnime);
		animeListHasAnime.setAnimeList(null);

		return animeListHasAnime;
	}

}