package com.luka.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Anime_has_Genre database table.
 * 
 */
@Entity
@NamedQuery(name="Anime_has_Genre.findAll", query="SELECT a FROM Anime_has_Genre a")
public class Anime_has_Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAnime_has_Genre;

	//bi-directional many-to-one association to Anime
	@ManyToOne
	@JoinColumn(name="Anime_idAnime")
	private Anime anime;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	@JoinColumn(name="Genre_idGenre")
	private Genre genre;

	public Anime_has_Genre() {
	}

	public int getIdAnime_has_Genre() {
		return this.idAnime_has_Genre;
	}

	public void setIdAnime_has_Genre(int idAnime_has_Genre) {
		this.idAnime_has_Genre = idAnime_has_Genre;
	}

	public Anime getAnime() {
		return this.anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}