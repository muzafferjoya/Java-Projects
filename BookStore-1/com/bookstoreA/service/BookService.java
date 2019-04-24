package com.bookstoreA.service;

import java.util.List;

import com.bookstoreA.model.Book;
import com.bookstoreA.model.Category;

public interface BookService {

	List<Book> findAll();

	List<Category> findAllCategories();

	List<Book> searchBooksByKeyword(String keyWord);

}
