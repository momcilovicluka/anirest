package com.luka.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Anime_has_Tag database table.
 * 
 */
@Entity
@NamedQuery(name="Anime_has_Tag.findAll", query="SELECT a FROM Anime_has_Tag a")
public class Anime_has_Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAnime_has_Tag;

	//bi-directional many-to-one association to Anime
	@ManyToOne
	@JoinColumn(name="Anime_idAnime")
	private Anime anime;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="Tag_idTag")
	private Tag tag;

	public Anime_has_Tag() {
	}

	public int getIdAnime_has_Tag() {
		return this.idAnime_has_Tag;
	}

	public void setIdAnime_has_Tag(int idAnime_has_Tag) {
		this.idAnime_has_Tag = idAnime_has_Tag;
	}

	public Anime getAnime() {
		return this.anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}