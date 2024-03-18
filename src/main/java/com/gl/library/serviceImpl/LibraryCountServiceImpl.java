package com.gl.library.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.gl.library.entity.Library;
import com.gl.library.repository.LibraryRepository;
import com.gl.library.service.LibraryCountService;

@Service
public class LibraryCountServiceImpl implements LibraryCountService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public long countLibraries() {
		return libraryRepository.count();
	}

	@Override
	public long countlibrariesWithNoBooks() {
		Library library = new Library();
		library.setCommaSeperatedBookName("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("CommaSeperatedBookName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(library, exampleMatcher);
		return libraryRepository.count(example);
	}
}
