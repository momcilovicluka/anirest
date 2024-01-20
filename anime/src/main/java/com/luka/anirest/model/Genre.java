package com.luka.anirest.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Genre database table.
 * 
 */
@Entity
@NamedQuery(name="Genre.findAll", query="SELECT g FROM Genre g")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGenre;

	private String name;

	//bi-directional many-to-one association to Anime_has_Genre
	@JsonIgnore
	@ManyToMany(mappedBy="genres")
	List<Anime> animes;

	public Genre() {
	}

	public int getIdGenre() {
		return this.idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
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
		anime.getGenres().add(this);

		return anime;
	}

	public Anime removeAnime(Anime anime) {
		getAnimes().remove(anime);
		anime.getGenres().add(this);

		return anime;
	}
}