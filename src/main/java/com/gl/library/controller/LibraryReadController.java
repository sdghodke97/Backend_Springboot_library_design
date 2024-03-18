package com.gl.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.library.entity.Library;
import com.gl.library.service.LibraryReadService;

@RestController
@RequestMapping("/readService")
public class LibraryReadController {

	@Autowired
	LibraryReadService readService;
	
	@GetMapping("/getAllLibrary")
	public List<Library> getAllLibrary() {
		return readService.getAllLibrary();
	}
	
	@GetMapping("/getAllLibrariesWithNoBooks")
	public List<Library> getAllLibrariesWithNoBooks() {
		return readService.getAllLibrariesWithNoBooks();
	}
	
	@GetMapping("getLibrariesPaged")
	public Page<Library> getLibrariesPaged() {
		return readService.getLibrariesPaged();
	}
	
	@GetMapping("/getLibrariesCustomPaged")
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		return readService.getLibrariesCustomPaged(pageNumber, numberOfRecordsOnAPage);
	}
	
	@GetMapping("/getLibrariesWithLAtestAddedOrder")
	public List<Library> getLibrariesWithLAtestAddedOrder() {
		return readService.getLibrariesWithLatestAddedOrder();
	}
	
	@GetMapping("/getLibrariesCustomSortedById")
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readService.getLibrariesCustomSortedById(direction);
	}
	
	@GetMapping("/getLibrariesCustomSortedByName")
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readService.getLibrariesCustomSortedByName(direction);
	}
	
	@GetMapping("/getLibrariesPagedAndSortedByNameAndWithTheseBooks")
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getLibrariesPagedAndSortedByNameAndWithTheseBooks(commaSeperatedBookNames);
	}
	
	@GetMapping("/getLibrariesCustomPagedAndSortedWithDefaultOrderByName")
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByName(String commaSeperatedBookNames, int pageNumber, int numberOfRecordsOnAPage) {
		return readService.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(commaSeperatedBookNames, pageNumber, numberOfRecordsOnAPage);
	}
	
	@GetMapping("/getSortedByNamesAndWithTheseBooks")
	public List<Library> getSortedByNamesAndWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getSortedByNameAndWithTheseBooks(commaSeperatedBookNames);
	}
	
	@PostMapping("/getLibrariesById")
	public List<Library> getLibrariesById(@RequestBody List<Long> id) {
		return readService.getLibrariesByIds(id);
	}
	
	@GetMapping("/getALibraryById")
	public Optional<Library> getALibraryById(Long id) {
		return readService.getALibraryById(id);
	}
	
	@GetMapping("/getALibraryWithTheseBooks")
	public Optional<Library> getALibraryWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getALibraryWithTheseBooks(commaSeperatedBookNames);
	}
	
	@GetMapping("/getLibrariesPagedAndSortedByName")
	public Page<Library> getLibrariesPagedAndSortedByName() {
		return readService.getLibrariesPagedAndSortedByName();
	}
}
