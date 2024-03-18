package com.gl.library.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.gl.library.entity.Library;
import com.gl.library.repository.LibraryRepository;
import com.gl.library.service.LibraryExistService;

@Service
public class LibraryExistServiceImpl implements LibraryExistService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public boolean checkLibraryExistByid(long id) {
		return libraryRepository.existsById(id);
	}

	@Override
	public boolean checkLibraryWithExample(String CommaSeperatedBookNames) {
		Library library = new Library();
		library.setCommaSeperatedBookName(CommaSeperatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("CommaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(library, exampleMatcher);
		return libraryRepository.exists(example);
	}
}
