package com.luka.anirest.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luka.anirest.exception.BadAnilistRequestException;
import com.luka.anirest.model.Anime;
import com.luka.anirest.model.Format;
import com.luka.anirest.model.Genre;
import com.luka.anirest.model.Season;
import com.luka.anirest.model.Status;
import com.luka.anirest.model.Tag;
import com.luka.anirest.model.Type;
import com.luka.anirest.repository.AnimeHasGenreRepository;
import com.luka.anirest.repository.AnimeHasTagRepository;
import com.luka.anirest.repository.AnimeRepository;
import com.luka.anirest.repository.FormatRepository;
import com.luka.anirest.repository.GenreRepository;
import com.luka.anirest.repository.SeasonRepository;
import com.luka.anirest.repository.StatusRepository;
import com.luka.anirest.repository.TagRepository;
import com.luka.anirest.repository.TypeRepository;

@Service
public class AnimeService {

	@Autowired
	AnimeRepository animeRepository;

	@Autowired
	SeasonRepository seasonRepository;

	@Autowired
	TypeRepository typeRepository;

	@Autowired
	FormatRepository formatRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	GenreRepository genreRepository;

	@Autowired
	TagRepository tagRepository;

	@Autowired
	AnimeHasGenreRepository animeHasGenreRepository;

	@Autowired
	AnimeHasTagRepository animeHasTagRepository;

	String animeQuery = """
			query ($name: String) {
			  Media (search: $name, type: ANIME) {
			    id
			    idMal
			    startDate {
			    	year
			    	month
			    	day
			    }
			    endDate {
			   		year
			   		month
			   		day
			    }
				season
				seasonYear
				type
				format
				status
				episodes
				duration
				genres
				tags {
					id
					name
					description
					category
					rank
					isGeneralSpoiler
					isMediaSpoiler
					isAdult
					userId
				}
				averageScore
				popularity
			    title {
			      romaji
			      english
			      native
			    }
			  }
			}
			""";

	String url = "https://graphql.anilist.co";

	HttpClient httpClient = HttpClient.newHttpClient();

	ObjectMapper objectMapper = new ObjectMapper();

	public HttpResponse<String> returnAnimefromAnilist(String name) throws BadAnilistRequestException {

		// Define query variables and values
		Map<String, Object> variables = new HashMap<>();
		variables.put("name", name);

		String payload = null;
		try {
			payload = objectMapper.writeValueAsString(Map.of("query", animeQuery, "variables", variables));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create an HttpRequest
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(payload)).build();

		// Send the request and get the response
		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

			// if response contains error throw exception
			if (response.body().contains("errors"))
				throw new BadAnilistRequestException(response.body(), "Bad request to anilist api");
		}
		catch (IOException ioe) {
			// TODO: handle exception
		} catch (InterruptedException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
		System.out.println(response.body());

		return response;
	}

	public String returnAnimeString(String name) throws BadAnilistRequestException {
		HttpResponse<String> response = returnAnimefromAnilist(name);

		// Use Jackson ObjectMapper to parse the JSON string
		JsonNode root = null;
		try {
			root = objectMapper.readTree(response.body());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Access the parsed data using path
		int id = root.path("data").path("Media").path("id").asInt();
		int idMal = root.path("data").path("Media").path("idMal").asInt();
		LocalDate startDate = LocalDate.of(root.path("data").path("Media").path("startDate").path("year").asInt(),
				root.path("data").path("Media").path("startDate").path("month").asInt(),
				root.path("data").path("Media").path("startDate").path("day").asInt());
		LocalDate endDate = LocalDate.of(root.path("data").path("Media").path("endDate").path("year").asInt(),
				root.path("data").path("Media").path("endDate").path("month").asInt(),
				root.path("data").path("Media").path("endDate").path("day").asInt());
		String season = root.path("data").path("Media").path("season").asText();
		int seasonYear = root.path("data").path("Media").path("seasonYear").asInt();
		String type = root.path("data").path("Media").path("type").asText();
		String format = root.path("data").path("Media").path("format").asText();
		String status = root.path("data").path("Media").path("status").asText();
		int episodes = root.path("data").path("Media").path("episodes").asInt();
		int duration = root.path("data").path("Media").path("duration").asInt();
		String[] genres = objectMapper.convertValue(root.path("data").path("Media").path("genres"), String[].class);

		JsonNode tagsNode = root.path("data").path("Media").path("tags");
		String[] tags = new String[tagsNode.size()];
		for (int i = 0; i < tagsNode.size(); i++) {
			tags[i] = tagsNode.get(i).path("name").asText();
		}
		int averageScore = root.path("data").path("Media").path("averageScore").asInt();
		int popularity = root.path("data").path("Media").path("popularity").asInt();
		String romajiTitle = root.path("data").path("Media").path("title").path("romaji").asText();
		String englishTitle = root.path("data").path("Media").path("title").path("english").asText();
		String nativeTitle = root.path("data").path("Media").path("title").path("native").asText();

		StringBuilder retString = new StringBuilder();
		retString.append("Media ID: ").append(id).append("\n");
		retString.append("MyAnimeList ID: ").append(idMal).append("\n");
		retString.append("Start Date: ").append(startDate).append("\n");
		retString.append("End Date: ").append(endDate).append("\n");
		retString.append("Season: ").append(season).append("\n");
		retString.append("Season Year: ").append(seasonYear).append("\n");
		retString.append("Type: ").append(type).append("\n");
		retString.append("Format: ").append(format).append("\n");
		retString.append("Status: ").append(status).append("\n");
		retString.append("Episodes: ").append(episodes).append("\n");
		retString.append("Duration: ").append(duration).append("\n");
		retString.append("Genres: ").append(Arrays.toString(genres)).append("\n");
		retString.append("Tags: ").append(Arrays.toString(tags)).append("\n");
		retString.append("Average Score: ").append(averageScore).append("\n");
		retString.append("Popularity: ").append(popularity).append("\n");
		retString.append("English Title: ").append(englishTitle).append("\n");
		retString.append("Romaji Title: ").append(romajiTitle).append("\n");
		retString.append("Native Title: ").append(nativeTitle).append("\n");

		return retString.toString();
	}

	public Anime returnAnime(String name) throws BadAnilistRequestException {

		Anime anime = animeRepository.findByTitle(name);
		if (anime != null)
			return anime;
		anime = new Anime();

		HttpResponse<String> response = returnAnimefromAnilist(name);

		// Use Jackson ObjectMapper to parse the JSON string
		JsonNode root = null;
		try {
			root = objectMapper.readTree(response.body());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		anime.setIdAnime(root.path("data").path("Media").path("id").asInt());
		anime.setIdMal(root.path("data").path("Media").path("idMal").asInt());
		anime.setStartDate(
				Date.valueOf(LocalDate.of(root.path("data").path("Media").path("startDate").path("year").asInt(),
						root.path("data").path("Media").path("startDate").path("month").asInt(),
						root.path("data").path("Media").path("startDate").path("day").asInt())));
		anime.setEndDate(Date.valueOf(LocalDate.of(root.path("data").path("Media").path("endDate").path("year").asInt(),
				root.path("data").path("Media").path("endDate").path("month").asInt(),
				root.path("data").path("Media").path("endDate").path("day").asInt())));
		String seasonString = root.path("data").path("Media").path("season").asText();
		Season season = seasonRepository.findByName(seasonString);
		anime.setSeason(season);
		anime.setSeasonYear(root.path("data").path("Media").path("seasonYear").asInt());
		String typeString = root.path("data").path("Media").path("type").asText();
		Type type = typeRepository.findByName(typeString);
		anime.setType(type);
		String formatString = root.path("data").path("Media").path("format").asText();
		Format format = formatRepository.findByName(formatString);
		anime.setFormat(format);
		String statusString = root.path("data").path("Media").path("status").asText();
		Status status = statusRepository.findByName(statusString);
		anime.setStatus(status);
		anime.setEpisodes(root.path("data").path("Media").path("episodes").asInt());
		anime.setDuration(root.path("data").path("Media").path("duration").asInt());
		String[] genresStrings = objectMapper.convertValue(root.path("data").path("Media").path("genres"),
				String[].class);
		for (String genreString : genresStrings) {
			Genre genre = genreRepository.findByName(genreString);
			if (genre == null) {
				genre = new Genre();
				genre.setName(genreString);
				genreRepository.save(genre);
			}
			if (anime.getGenres() == null)
				anime.setGenres(new ArrayList<Genre>());
			if (!anime.getGenres().contains(genre)) {
				anime.getGenres().add(genre);
				// Anime_has_Genre anime_has_Genre = new Anime_has_Genre();
				// anime_has_Genre.setAnime(anime);
				// anime_has_Genre.setGenre(genre);
				// animeHasGenreRepository.save(anime_has_Genre);
			}
		}
		JsonNode tagsNode = root.path("data").path("Media").path("tags");
		JsonNode[] tagsNodes = new JsonNode[tagsNode.size()];
		for (int i = 0; i < tagsNode.size(); i++)
			tagsNodes[i] = tagsNode.get(i);
		for (JsonNode tagNode : tagsNodes) {
			String tagName = tagNode.path("name").asText();
			Tag tag = tagRepository.findByName(tagName);
			if (tag == null) {
				tag = new Tag();
				tag.setIdTag(tagNode.path("id").asInt());
				tag.setName(tagName);
				tag.setDescription(tagNode.path("description").asText());
				tag.setCategory(tagNode.path("category").asText());
				tag.setRank(tagNode.path("rank").asInt());
				tag.setIsGeneralSpoiler((byte) (tagNode.path("isGeneralSpoiler").asBoolean() ? 1 : 0));
				tag.setIsMediaSpoiler((byte) (tagNode.path("isMediaSpoiler").asBoolean() ? 1 : 0));
				tag.setIsAdult((byte) (tagNode.path("isAdult").asBoolean() ? 1 : 0));
				tag.setUserId(tagNode.path("userId").asInt());
				tagRepository.save(tag);
			}
			if (anime.getTags() == null)
				anime.setTags(new ArrayList<Tag>());
			if (!anime.getTags().contains(tag)) {
				anime.getTags().add(tag);
				// Anime_has_Tag anime_has_Tag = new Anime_has_Tag();
				// anime_has_Tag.setAnime(anime);
				// anime_has_Tag.setTag(tag);
				// animeHasTagRepository.save(anime_has_Tag);
			}
		}
		anime.setAverageScore(root.path("data").path("Media").path("averageScore").asInt());
		anime.setPopularity(root.path("data").path("Media").path("popularity").asInt());
		anime.setTitle(root.path("data").path("Media").path("title").path("english").asText());
		anime.setTitleRomaji(root.path("data").path("Media").path("title").path("romaji").asText());
		anime.setTitleNative(root.path("data").path("Media").path("title").path("native").asText());

		return anime;
	}

	public Anime addAnime(String name) throws BadAnilistRequestException {

		Anime anime = returnAnime(name);

		Optional<Anime> repoAnime = animeRepository.findById(anime.getIdAnime());
		if (repoAnime.isEmpty())
			animeRepository.save(anime);

		return anime;
	}
}