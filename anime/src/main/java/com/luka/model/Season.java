package com.luka.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Season database table.
 * 
 */
@Entity
@NamedQuery(name="Season.findAll", query="SELECT s FROM Season s")
public class Season implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSeason;

	private String description;

	private String name;

	//bi-directional many-to-one association to Anime
	@JsonIgnore
	@OneToMany(mappedBy="season")
	private List<Anime> animes;

	public Season() {
	}

	public int getIdSeason() {
		return this.idSeason;
	}

	public void setIdSeason(int idSeason) {
		this.idSeason = idSeason;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Anime> getAnimes() {
		return this.animes;
	}

	public void setAnimes(List<Anime> animes) {
		this.animes = animes;
	}

	public Anime addAnime(Anime anime) {
		getAnimes().add(anime);
		anime.setSeason(this);

		return anime;
	}

	public Anime removeAnime(Anime anime) {
		getAnimes().remove(anime);
		anime.setSeason(null);

		return anime;
	}

}