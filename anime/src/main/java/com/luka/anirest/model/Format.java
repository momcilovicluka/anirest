package com.luka.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Format database table.
 * 
 */
@Entity
@NamedQuery(name="Format.findAll", query="SELECT f FROM Format f")
public class Format implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idformat;

	private String description;

	private String name;

	//bi-directional many-to-one association to Anime
	@JsonIgnore
	@OneToMany(mappedBy="format")
	private List<Anime> animes;

	public Format() {
	}

	public int getIdformat() {
		return this.idformat;
	}

	public void setIdformat(int idformat) {
		this.idformat = idformat;
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
		anime.setFormat(this);

		return anime;
	}

	public Anime removeAnime(Anime anime) {
		getAnimes().remove(anime);
		anime.setFormat(null);

		return anime;
	}

}