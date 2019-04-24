package com.bookstoreA.main;

import java.util.List;

import com.bookstoreA.model.Book;
import com.bookstoreA.service.BookService;
import com.bookstoreA.service.BookServiceImpl;

public class Main {
	private static BookService bookService = new BookServiceImpl();

	public static void main(String[] args) {

		// List All Books
		System.out.println("Listing All Books : ");
		findAllBooks();
		System.out.println("+++++++++++++++++++");
		System.out.println("Searching Books Ny Keywod: JAVA ");
		searchBooksByKeyword("java");

	}

	private static void searchBooksByKeyword(String keyWord) {
		List<Book> books = bookService.searchBooksByKeyword(keyWord);
		for (Book book : books) {
			System.out.println(book);
		}

	}

	private static void findAllBooks() {
		List<Book> books = bookService.findAll();
		for (Book book : books) {
			System.out.println(book);
		}

	}

}
