package com.gl.library.service;

import java.util.List;

import com.gl.library.entity.Library;

public interface LibraryCreateService {

	String addSingleLibrary(Library library);

	String addAllLibraries(List<Library> libraries);

	Library addLibraryWithSaveAndFlush(Library library);

}