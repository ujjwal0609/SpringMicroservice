package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.BookDAO;
import com.example.demo.entity.Book;

@Service
public class BookService {
	
	@Autowired
	BookDAO bookDAO;

	
	public List<Book> getAll(){
		List<Book> books = bookDAO.findAll();
		return books;
		
	}
	
	public Book getById(long id ) {
	Book book = bookDAO.findById(id).get();
		return book;
	}
	
	
	public Book addBook(Book book) {
		return bookDAO.save(book);
		
	}
	
	public Book updateBook(Book book , long bookId) {
		Book book1 =getById(bookId);
		book1.setAuthor(book.getAuthor());
		book1.setTitle(book.getTitle());
		bookDAO.saveAndFlush(book1);
		return book1;
		
	}
	
	public String deleteBook(long bookId) {
		Book b1 = getById(bookId);
		bookDAO.delete(b1);
		return"deleted";
	}
	
}
