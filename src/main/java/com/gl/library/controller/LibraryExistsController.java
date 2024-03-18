package com.gl.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.library.service.LibraryExistService;

@RestController
@RequestMapping("/checkLibrary")
public class LibraryExistsController {

	@Autowired
	LibraryExistService existService;

	@GetMapping("/checkLibraryExestsById")
	public boolean checkLibraryExestsById(Long id) {
		return existService.checkLibraryExistByid(id);
	}
	
	@GetMapping("/checkLibraryExistByExample")
	public boolean checkLibraryExistByExample(String CommaSeperatedBookNames) {
		return existService.checkLibraryWithExample(CommaSeperatedBookNames);
	}

}
