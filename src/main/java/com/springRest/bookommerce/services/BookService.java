package com.springRest.bookommerce.services;
import com.springRest.bookommerce.model.BookModel;

import java.util.List;

public interface BookService {
    List<BookModel> getBookList();

    BookModel addBook(BookModel bookModel);

    String deleteBook(Long bookId);

    BookModel editBook(Long bookId, BookModel bookModel);
}
