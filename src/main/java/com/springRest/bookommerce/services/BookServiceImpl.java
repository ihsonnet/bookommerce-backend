package com.springRest.bookommerce.services;

import com.springRest.bookommerce.model.BookModel;
import com.springRest.bookommerce.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookModel> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public BookModel addBook(BookModel bookModel) {
        bookRepository.save(bookModel);
        return bookModel;
    }

    @Override
    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "Book Deleted Successful!";
    }

    @Override
    public BookModel editBook(Long bookId, BookModel bookModel) {
        BookModel objectBookModel = bookRepository.findById(bookId).get();

        if (Objects.nonNull(bookModel.getBookName()) && !"".equalsIgnoreCase(bookModel.getBookName())){
            objectBookModel.setBookName(bookModel.getBookName());
        }
        if (Objects.nonNull(bookModel.getAuthorName()) && !"".equalsIgnoreCase(bookModel.getAuthorName())){
            objectBookModel.setAuthorName(bookModel.getAuthorName());
        }
        if (Objects.nonNull(bookModel.getBookPrice()) && 0!= bookModel.getBookPrice()){
            objectBookModel.setBookPrice(bookModel.getBookPrice());
        }

        return bookRepository.save(objectBookModel);
    }
}
