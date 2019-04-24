package com.bookstoreA.service;

import java.util.List;

import com.bookstoreA.dao.BookDAO;
import com.bookstoreA.dao.BookDAOImpl;
import com.bookstoreA.model.Book;
import com.bookstoreA.model.Category;

public class BookServiceImpl implements BookService {
	private static BookDAO bookDao=new BookDAOImpl();

	@Override
	public List<Book> findAll() {
		List<Book> list  = bookDao.findAllBooks();
		return list;
	}

	@Override
	public List<Category> findAllCategories() {
		List<Category> list  = bookDao.findAllCategories();
		return list;
	}

	@Override
	public List<Book> searchBooksByKeyword(String keyWord) {
		List<Book> list  = bookDao.searchBooksByKeyword(keyWord);
		return list;
	}

}
