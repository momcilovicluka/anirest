package com.luka.anirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luka.anirest.model.Tag;
import com.luka.anirest.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {

	@Autowired
	TagService tagService;
	
	@GetMapping("/all")
	public List<Tag> returnAllTags() {
		return tagService.returnAll();
	}
	
	@GetMapping("/page/{page}")
	public List<Tag> returnTagsPaginated(@PathVariable int page) {
		return tagService.returnPaginated(page);
	}
}