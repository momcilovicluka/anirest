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
	@OneToMany(mappedBy="tag")
	private List<Anime_has_Tag> animeHasTags;

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

	public List<Anime_has_Tag> getAnimeHasTags() {
		return this.animeHasTags;
	}

	public void setAnimeHasTags(List<Anime_has_Tag> animeHasTags) {
		this.animeHasTags = animeHasTags;
	}

	public Anime_has_Tag addAnimeHasTag(Anime_has_Tag animeHasTag) {
		getAnimeHasTags().add(animeHasTag);
		animeHasTag.setTag(this);

		return animeHasTag;
	}

	public Anime_has_Tag removeAnimeHasTag(Anime_has_Tag animeHasTag) {
		getAnimeHasTags().remove(animeHasTag);
		animeHasTag.setTag(null);

		return animeHasTag;
	}

}