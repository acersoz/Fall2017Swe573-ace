package com.bookstore.servicelayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.datalayer.entity.Book;
import com.bookstore.datalayer.entity.Tag;
import com.bookstore.datalayer.repository.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;

	@Transactional
	public boolean insertTag(String tagName) {
		Tag tag = new Tag();
		tag.setName(tagName);

		tagRepository.save(tag);

		return true;
	}

	@Transactional
	public List<Tag> getAllTags() {

		List<Tag> tags = new ArrayList<Tag>();

		Iterator<Tag> iterator = tagRepository.findAll().iterator();

		while (iterator.hasNext()) {
			Tag tag = iterator.next();
			tags.add(tag);
		}

		return tags;
	}

	@Transactional
	public boolean isTagAdded(String tagName) {
		Tag tag = tagRepository.findByName(tagName);
		if(tag.getTagId() == null) {
			return false;
		}
		else {
			return true;
		}
	}
}
