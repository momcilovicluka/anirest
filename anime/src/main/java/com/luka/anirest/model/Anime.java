package com.luka.anirest.model;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Anime database table.
 * 
 */
@Entity
@NamedQuery(name="Anime.findAll", query="SELECT a FROM Anime a")
public class Anime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAnime;

	private int averageScore;

	private int duration;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private int episodes;

	private int idMal;

	private int popularity;

	private int seasonYear;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@NotBlank(message = "Anime name can not be empty")
	private String title;

	private String titleNative;

	private String titleRomaji;

	//bi-directional many-to-one association to Format
	@ManyToOne
	@JoinColumn(name="format_idFormat")
	private Format format;

	//bi-directional many-to-one association to Season
	@ManyToOne
	@JoinColumn(name="Season_idSeason")
	private Season season;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="Status_idStatus")
	private Status status;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="Type_idType")
	private Type type;

	//bi-directional many-to-many association to Genre
	@ManyToMany
	@JoinTable(
		name="Anime_has_Genre"
		, joinColumns={
			@JoinColumn(name="Anime_idAnime")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Genre_idGenre")
			}
		)
	private List<Genre> genres;

	//bi-directional many-to-many association to Tag
	@ManyToMany
	@JoinTable(
		name="Anime_has_Tag"
		, joinColumns={
			@JoinColumn(name="Anime_idAnime")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Tag_idTag")
			}
		)
	private List<Tag> tags;

	//bi-directional many-to-one association to AnimeList_has_Anime
	@JsonIgnore
	@OneToMany(mappedBy="anime")
	private List<AnimeList_has_Anime> animeListHasAnimes;

	//bi-directional many-to-one association to Anime_has_Character
	@OneToMany(mappedBy="anime")
	private List<Anime_has_Character> animeHasCharacters;

	//bi-directional many-to-one association to Anime_has_Genre
	@JsonIgnore
	@OneToMany(mappedBy="anime")
	private List<Anime_has_Genre> animeHasGenres;

	//bi-directional many-to-one association to Anime_has_Tag
	@JsonIgnore
	@OneToMany(mappedBy="anime")
	private List<Anime_has_Tag> animeHasTags;

	public Anime() {
	}

	public int getIdAnime() {
		return this.idAnime;
	}

	public void setIdAnime(int idAnime) {
		this.idAnime = idAnime;
	}

	public int getAverageScore() {
		return this.averageScore;
	}

	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getEpisodes() {
		return this.episodes;
	}

	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}

	public int getIdMal() {
		return this.idMal;
	}

	public void setIdMal(int idMal) {
		this.idMal = idMal;
	}

	public int getPopularity() {
		return this.popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public int getSeasonYear() {
		return this.seasonYear;
	}

	public void setSeasonYear(int seasonYear) {
		this.seasonYear = seasonYear;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleNative() {
		return this.titleNative;
	}

	public void setTitleNative(String titleNative) {
		this.titleNative = titleNative;
	}

	public String getTitleRomaji() {
		return this.titleRomaji;
	}

	public void setTitleRomaji(String titleRomaji) {
		this.titleRomaji = titleRomaji;
	}

	public Format getFormat() {
		return this.format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Season getSeason() {
		return this.season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<AnimeList_has_Anime> getAnimeListHasAnimes() {
		return this.animeListHasAnimes;
	}

	public void setAnimeListHasAnimes(List<AnimeList_has_Anime> animeListHasAnimes) {
		this.animeListHasAnimes = animeListHasAnimes;
	}

	public AnimeList_has_Anime addAnimeListHasAnime(AnimeList_has_Anime animeListHasAnime) {
		getAnimeListHasAnimes().add(animeListHasAnime);
		animeListHasAnime.setAnime(this);

		return animeListHasAnime;
	}

	public AnimeList_has_Anime removeAnimeListHasAnime(AnimeList_has_Anime animeListHasAnime) {
		getAnimeListHasAnimes().remove(animeListHasAnime);
		animeListHasAnime.setAnime(null);

		return animeListHasAnime;
	}

	public List<Anime_has_Character> getAnimeHasCharacters() {
		return this.animeHasCharacters;
	}

	public void setAnimeHasCharacters(List<Anime_has_Character> animeHasCharacters) {
		this.animeHasCharacters = animeHasCharacters;
	}

	public Anime_has_Character addAnimeHasCharacter(Anime_has_Character animeHasCharacter) {
		getAnimeHasCharacters().add(animeHasCharacter);
		animeHasCharacter.setAnime(this);

		return animeHasCharacter;
	}

	public Anime_has_Character removeAnimeHasCharacter(Anime_has_Character animeHasCharacter) {
		getAnimeHasCharacters().remove(animeHasCharacter);
		animeHasCharacter.setAnime(null);

		return animeHasCharacter;
	}

	public List<Anime_has_Genre> getAnimeHasGenres() {
		return this.animeHasGenres;
	}

	public void setAnimeHasGenres(List<Anime_has_Genre> animeHasGenres) {
		this.animeHasGenres = animeHasGenres;
	}

	public Anime_has_Genre addAnimeHasGenre(Anime_has_Genre animeHasGenre) {
		getAnimeHasGenres().add(animeHasGenre);
		animeHasGenre.setAnime(this);

		return animeHasGenre;
	}

	public Anime_has_Genre removeAnimeHasGenre(Anime_has_Genre animeHasGenre) {
		getAnimeHasGenres().remove(animeHasGenre);
		animeHasGenre.setAnime(null);

		return animeHasGenre;
	}

	public List<Anime_has_Tag> getAnimeHasTags() {
		return this.animeHasTags;
	}

	public void setAnimeHasTags(List<Anime_has_Tag> animeHasTags) {
		this.animeHasTags = animeHasTags;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Anime_has_Tag addAnimeHasTag(Anime_has_Tag animeHasTag) {
		getAnimeHasTags().add(animeHasTag);
		animeHasTag.setAnime(this);

		return animeHasTag;
	}

	public Anime_has_Tag removeAnimeHasTag(Anime_has_Tag animeHasTag) {
		getAnimeHasTags().remove(animeHasTag);
		animeHasTag.setAnime(null);

		return animeHasTag;
	}

}