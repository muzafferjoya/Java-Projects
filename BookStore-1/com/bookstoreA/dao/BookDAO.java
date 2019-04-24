package com.bookstoreA.dao;

import java.util.List;

import com.bookstoreA.model.Book;
import com.bookstoreA.model.Category;

public interface BookDAO {
	// listing all the books from the database
	List<Book> findAllBooks();

	// user to search books by keyword
	List<Book> searchBooksByKeyword(String keyword);

	// is required by the application to provide a categorized listing of books
	List<Category> findAllCategories();

	public void insert();

	public void delete();

	public void update();

}
