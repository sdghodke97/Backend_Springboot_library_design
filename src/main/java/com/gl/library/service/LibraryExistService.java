package com.gl.library.service;

public interface LibraryExistService {

	boolean checkLibraryExistByid(long id);

	boolean checkLibraryWithExample(String CommaSeperatedBookNames);

}