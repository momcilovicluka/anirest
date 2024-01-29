package com.luka.anirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luka.anirest.exception.PageDoesntExistException;
import com.luka.anirest.model.Tag;
import com.luka.anirest.repository.TagRepository;

@Service
public class TagService {

	@Autowired
	TagRepository tagRepository;

	public List<Tag> returnAll() {
		return tagRepository.findAll();
	}

	public List<Tag> returnPaginated(int page) {
		if(page < 1)
			throw new PageDoesntExistException(page, "Page " + page + " does not exist");
		List<Tag> tags = tagRepository.findAll();
		var tagovi = tags.subList((page-1)*10, page*10);
		if (tagovi.isEmpty())
			throw new PageDoesntExistException(page, "There are no entries on page " + page);
		return tagovi;
	}
}