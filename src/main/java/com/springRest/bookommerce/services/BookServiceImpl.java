package com.springRest.bookommerce.services;

import com.springRest.bookommerce.dto.ApiResponse;
import com.springRest.bookommerce.model.BookModel;
import com.springRest.bookommerce.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseEntity<ApiResponse<List<BookModel>>> getBookList() {
        List<BookModel> bookModelList = bookRepository.findAll();
        if (bookModelList.isEmpty()){
            return new ResponseEntity<>(new ApiResponse<>(200,"No Book Found",bookModelList), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new ApiResponse<>(200,"Book Found",bookModelList), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<ApiResponse<BookModel>> addBook(BookModel bookModel) {
        BookModel book = bookRepository.save(bookModel);
        return new ResponseEntity<>(new ApiResponse<>(201,"Book Added",book),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse<String>> deleteBook(Long id) {
        Optional<BookModel> bookModelOptional = bookRepository.findById(id);
        if (bookModelOptional.isPresent()){
            bookRepository.deleteById(id);
            return new ResponseEntity<>(new ApiResponse<>(200,"Book Deleted Successfully!",null),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new ApiResponse<>(200,"Book Id Not Found!",null),HttpStatus.OK);
        }


    }

    @Override
    public ResponseEntity<ApiResponse<BookModel>> editBook(Long bookId, BookModel bookModel) {
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

        Optional<BookModel> bookModelOptional = bookRepository.findById(bookId);
        if (bookModelOptional.isPresent()){
            bookRepository.save(objectBookModel);
            return new ResponseEntity<>(new ApiResponse<>(200,"Book Edit Successful!",objectBookModel),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new ApiResponse<>(200,"Book Id Not Found!",null),HttpStatus.OK);
        }

    }
}
