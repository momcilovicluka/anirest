package com.luka.anirest.exception;

import java.time.Instant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ErrorDetails {
	
	private final String message;
	private final Instant time;
	private final String stackTrace;

}