package com.springRest.bookommerce.controller;

import com.springRest.bookommerce.dto.ApiResponse;
import com.springRest.bookommerce.model.BookModel;
import com.springRest.bookommerce.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<ApiResponse<List<BookModel>>> getBookList(){
        return bookService.getBookList();
    }

    @PostMapping("/admin/book")
    public ResponseEntity<ApiResponse<BookModel>> addBook(@RequestBody BookModel bookModel){
       return bookService.addBook(bookModel);
    }

    @DeleteMapping("/admin/book/{bookId}")
    public ResponseEntity<ApiResponse<String>>  deleteBook(@RequestHeader(name = "Authorization") @PathVariable Long bookId){
        return bookService.deleteBook(bookId);
    }

    @PutMapping("/admin/book/{bookId}")
    public ResponseEntity<ApiResponse<BookModel>> editBook(@RequestHeader(name = "Authorization") @PathVariable Long bookId, @RequestBody BookModel bookModel){
        return bookService.editBook(bookId, bookModel);
    }

}
