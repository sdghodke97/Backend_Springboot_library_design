package com.gl.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.gl.library.entity.Library;
import com.gl.library.service.LibraryCountService;
import com.gl.library.service.LibraryCreateService;
import com.gl.library.service.LibraryDeleteService;
import com.gl.library.service.LibraryExistService;
import com.gl.library.service.LibraryReadService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	@Autowired
	LibraryReadService libraryReadServiceImpl;

	@Autowired
	LibraryCreateService CreateServiceImpl;

	@Autowired
	LibraryCountService countServiceImpl;

	@Autowired
	LibraryExistService existServiceImpl;

	@Autowired
	LibraryDeleteService deleteServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("hello shubh");
	}

	@Override
	public void run(String... args) throws Exception {

//		List<Library> libraries = libraryReadServiceImpl.getAllLibrary();    boiler plate code hence it is done in one line given below
//		readServiceImplMethodsExecution();

//		createServiceImplMethodsExecution();

//		countServiceImplMethodsExecution();

//		existServiceImplMethodsExecution();

//		log.info("Deleted one Library -> {}", deleteServiceImpl.deleteOneLibrary(
//				Library.builder().id(10l).CommaSeperatedBookName("ABC,XYZ,PQR").name("C Library").build()));
//		log.info("Implement Prune Library table -> {}", deleteServiceImpl.pruneTable());

//		List<Library> libraries = new ArrayList<Library>();
//		libraries.add(Library.builder().id(3l).CommaSeperatedBookName("").name("Si-Fi").build());
//		libraries.add(Library.builder().id(4l).CommaSeperatedBookName("").name("GeoPolitics").build());
//		log.info("Delete with all These -> {}", deleteServiceImpl.deleteAllThese(libraries));
//		
//		log.info("Delete All in batch -> {}", deleteServiceImpl.deleteAllInBatch());
		
//		log.info("Delete library by Id -> {}", deleteServiceImpl.deleteLibraryById(2l));
		
//		List<Library> libraries = new ArrayList<Library>();
//		libraries.add(Library.builder().id(3l).CommaSeperatedBookName("").name("Si-Fi").build());
//		libraries.add(Library.builder().id(4l).CommaSeperatedBookName("").name("GeoPolitics").build());
//		log.info("Delete all these In batch -> {}", deleteServiceImpl.deleteAllTheseInBatchList(libraries));
		
		
	}

	/**
	 * 
	 */
	private void existServiceImplMethodsExecution() {
		log.info("Check if library exists by id -> {}", existServiceImpl.checkLibraryExistByid(11l));

		log.info("Check if Library exists by Example -> {}", existServiceImpl.checkLibraryWithExample("ABC,XYZ,PQR"));
	}

	/**
	 * 
	 */
	private void countServiceImplMethodsExecution() {
		log.info("Count the libraries -> {}", countServiceImpl.countLibraries());

		log.info("Count Libraries with no books -> {}", countServiceImpl.countlibrariesWithNoBooks());
	}

	/**
	 * 
	 */
	private void createServiceImplMethodsExecution() {
		log.info("Persist a single Library -> {}", CreateServiceImpl.addSingleLibrary(
				Library.builder().id(11l).name("E Library").CommaSeperatedBookName("ABC,XYZ").build()));

		List<Library> libraries = new ArrayList<Library>();
		libraries.add(Library.builder().id(12l).name("F Library").CommaSeperatedBookName("ABC,EFG").build());
		libraries.add(Library.builder().id(13l).name("G Library").CommaSeperatedBookName("ABC").build());
		log.info("Persist all Libraries -> {}", CreateServiceImpl.addAllLibraries(libraries));

		log.info("Persist LIbrary With Save and Flush combine -> {}",
				CreateServiceImpl.addLibraryWithSaveAndFlush(Library.builder().id(14l).name("E-Commerce Library")
						.CommaSeperatedBookName("Amazon path, Flipkart Strategies").build()));
	}

	/**
	 * 
	 */
	private void readServiceImplMethodsExecution() {
		log.info("Fetch all libraries -> {}", libraryReadServiceImpl.getAllLibrary());
		log.info("Fetch all libraries with no books -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());
		log.info("Fetch Libraries in Page format -> {}",
				libraryReadServiceImpl.getLibrariesPaged().get().collect(Collectors.toList()));
		log.info("Fetch Libraries in custom page format -> {}",
				libraryReadServiceImpl.getLibrariesCustomPaged(2, 2).get().collect(Collectors.toList()));
		log.info("Fetch Libraries with latest added order -> {}",
				libraryReadServiceImpl.getLibrariesWithLatestAddedOrder());
		log.info("Fetch Libraries custom sorted by id -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.DESC));
		log.info("Fetch Libraries custom sorted by name -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.DESC));
		log.info("Fetch Libraries default paged, sorted and with these books -> {}", libraryReadServiceImpl
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("ABC,XYZ,PQR").get().collect(Collectors.toList()));
		log.info("Fetch Libraries custom paged and default sorted by name and with these books -> {}",
				libraryReadServiceImpl
						.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks("ABC,XYZ,PQR", 1, 2)
						.get().collect(Collectors.toList()));

		log.info("Fetch libraries with default sorted by name -> {}",
				libraryReadServiceImpl.getSortedByNameAndWithTheseBooks("ABC,XYZ,PQR"));
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);

		log.info("Fetch Libraries by ids -> {}", libraryReadServiceImpl.getLibrariesByIds(ids));
		long id = 12l;
		Optional<Library> optionalLibrary = libraryReadServiceImpl.getALibraryById(id);
		if (optionalLibrary.isPresent()) {
			log.info("Fetch Library by Id -> {}", optionalLibrary.get());
		} else {
			log.info("No matching library with this id " + id + " was found in the DB");
		}

		Optional<Library> optionalSingleLibrary = libraryReadServiceImpl
				.getALibraryWithTheseBooks("The age of AI,Tech burner");
		if (optionalSingleLibrary.isPresent()) {
			log.info("Fetch Library with these books -> {}", optionalSingleLibrary.get());
		} else {
			log.info("No matching library with this id " + id + " was found in the DB");
		}
	}

}
