package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Service.BookService;
import com.example.demo.entity.Book;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping()
	public List<Book> findallBooks(){
		return bookService.getAll();
	}
	
	
	@GetMapping("/{bookId}")
	public Book findBook (@PathVariable long bookId ) {
		return bookService.getById(bookId);
	}
	
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@DeleteMapping("/{bookId}")
	public String deleteBook(@PathVariable long  bookId) {
		return bookService.deleteBook(bookId);
	}
	
	@PutMapping("/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable long bookId) {
		return bookService.updateBook(book, bookId);
	}
	

}
