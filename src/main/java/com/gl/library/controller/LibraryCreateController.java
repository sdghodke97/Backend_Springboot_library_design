package com.gl.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.library.entity.Library;
import com.gl.library.service.LibraryCreateService;

@RestController
@RequestMapping("/createService")
public class LibraryCreateController {
	@Autowired
	LibraryCreateService CreateService;
	
	@PostMapping("/addSingliLibrary")
	public String addSingleLibrary(Library library) {
		return CreateService.addSingleLibrary(library);
	}
	
	@PostMapping("/insertAllLibraries")
	public String insertAllLibraries(@RequestBody List<Library> libraries) {
		return CreateService.addAllLibraries(libraries);
	}
	
	@PostMapping("/addLibraryWithSaveAndFlush")
	public Library addLibraryWithSaveAndFlush(Library library) {
		return CreateService.addLibraryWithSaveAndFlush(library);
	}

}
