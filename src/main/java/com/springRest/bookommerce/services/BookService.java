package com.springRest.bookommerce.services;
import com.springRest.bookommerce.dto.ApiResponse;
import com.springRest.bookommerce.model.BookModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    ResponseEntity<ApiResponse<List<BookModel>>> getBookList();

    ResponseEntity<ApiResponse<BookModel>> addBook(BookModel bookModel);

    ResponseEntity<ApiResponse<String>> deleteBook(Long bookId);

    ResponseEntity<ApiResponse<BookModel>> editBook(Long bookId, BookModel bookModel);
}
