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
	@OneToMany(mappedBy="genre")
	private List<Anime_has_Genre> animeHasGenres;

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

	public List<Anime_has_Genre> getAnimeHasGenres() {
		return this.animeHasGenres;
	}

	public void setAnimeHasGenres(List<Anime_has_Genre> animeHasGenres) {
		this.animeHasGenres = animeHasGenres;
	}

	public Anime_has_Genre addAnimeHasGenre(Anime_has_Genre animeHasGenre) {
		getAnimeHasGenres().add(animeHasGenre);
		animeHasGenre.setGenre(this);

		return animeHasGenre;
	}

	public Anime_has_Genre removeAnimeHasGenre(Anime_has_Genre animeHasGenre) {
		getAnimeHasGenres().remove(animeHasGenre);
		animeHasGenre.setGenre(null);

		return animeHasGenre;
	}

}