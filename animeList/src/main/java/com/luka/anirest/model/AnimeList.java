package com.luka.anirest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotBlank;


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

	@NotBlank(message = "Title must be set")
	private String title;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="User_idUser")
	private User user;

	//bi-directional many-to-one association to AnimeList_has_Anime
	@ManyToMany(mappedBy="animeLists")
	private List<Anime> animes;

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

	public List<Anime> getAnimes() {
		return this.animes;
	}

	public void setAnimes(List<Anime> animes) {
		this.animes = animes;
	}

	public Anime addAnime(Anime anime) {
		if(getAnimes() == null)
			setAnimes(new ArrayList<Anime>());
		animes.add(anime);
		
		return anime;
	}

	public Anime removeAnime(Anime anime) {
		animes.remove(anime);
		return anime;
	}
}