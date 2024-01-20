package com.luka.anirest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ListAnime {
	@NotNull(message = "id liste ne sme biti prazan")
	private int listId;
	@NotNull(message = "id anime-a ne sme biti prazan")
	private int animeId;
}