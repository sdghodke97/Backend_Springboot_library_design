package com.gl.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.library.entity.Library;
import com.gl.library.repository.LibraryRepository;
import com.gl.library.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public String deleteOneLibrary(Library library) {

		libraryRepository.delete(library);
		return "Deleted Library :" + library;
	}
	
	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "Prune Complete";
	}
	
	@Override
	public String deleteAllThese(List<Library> Libraries) {
		 libraryRepository.deleteAll(Libraries);
		 return "Delete All Complete";
	}
	
	@Override
	public String deleteAllInBatch() {
		libraryRepository.deleteAllInBatch();
		return "Deleted all in batch";
	}
	
	@Override
	public String deleteLibraryById(Long id) {
		libraryRepository.deleteById(id);
		return "library with id "+id+"  is deleted";
	}
	
	@Override
	public String deleteAllTheseInBatchList(List<Library> Libraries) {
		libraryRepository.deleteInBatch(Libraries);
		return "Deleted all the Libraries in the list in Batch Mode";
		
	}
	
	
}
