package com.springRest.bookommerce.controller;

import com.springRest.bookommerce.model.BookModel;
import com.springRest.bookommerce.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public List<BookModel> getBookList(){
        return bookService.getBookList();
    }

    @PostMapping("/book")
    public BookModel addBook(@RequestBody BookModel bookModel){
        return  bookService.addBook(bookModel);
    }

    @DeleteMapping("/book/{bookId}")
    public String deleteBook(@PathVariable Long bookId){
        return bookService.deleteBook(bookId);
    }

    @PutMapping("/book/{bookId}")
    public BookModel editBook(@PathVariable Long bookId, @RequestBody BookModel bookModel){
        return bookService.editBook(bookId, bookModel);
    }

}
