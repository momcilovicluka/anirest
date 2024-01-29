package com.luka.anirest.model;

import java.io.Serializable;
import jakarta.persistence.*;


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

	private String category;

	private String description;

	private byte isAdult;

	private byte isGeneralSpoiler;

	private byte isMediaSpoiler;

	private String name;

	private int rank;

	private int userId;

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

}