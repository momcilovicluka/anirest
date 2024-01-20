package com.luka.anirest.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Tag database table.
 * 
 */
@Entity
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTag;

	private String name;

	private String category;

	private String description;

	private byte isAdult;

	private byte isGeneralSpoiler;

	private byte isMediaSpoiler;

	private int rank;

	private int userId;

	//bi-directional many-to-one association to Anime_has_Tag
	@JsonIgnore
	@ManyToMany(mappedBy="tags")
	private List<Anime> animes;

	public Tag() {
	}

	public int getIdTag() {
		return this.idTag;
	}

	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getIsAdult() {
		return this.isAdult;
	}

	public void setIsAdult(byte isAdult) {
		this.isAdult = isAdult;
	}

	public byte getIsGeneralSpoiler() {
		return this.isGeneralSpoiler;
	}

	public void setIsGeneralSpoiler(byte isGeneralSpoiler) {
		this.isGeneralSpoiler = isGeneralSpoiler;
	}

	public byte getIsMediaSpoiler() {
		return this.isMediaSpoiler;
	}

	public void setIsMediaSpoiler(byte isMediaSpoiler) {
		this.isMediaSpoiler = isMediaSpoiler;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Anime> getAnimes() {
		return this.animes;
	}

	public void setAnimes(List<Anime> animes) {
		this.animes = animes;
	}

	public Anime addAnime(Anime anime) {
		getAnimes().add(anime);
		anime.getTags().add(this);

		return anime;
	}

	public Anime removeAnime(Anime anime) {
		getAnimes().remove(anime);
		anime.getTags().add(this);

		return anime;
	}

}