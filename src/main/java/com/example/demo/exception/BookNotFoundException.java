package com.example.demo.exception;

public class BookNotFoundException extends Exception {
	private long id;
	public BookNotFoundException(long id) {
	        super(String.format("Book is not found with id : '%s'", id));
	        }

}
