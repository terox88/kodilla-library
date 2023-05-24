package com.kodilla.library.controller;

import com.kodilla.library.domain.exeption.BookNotFoundException;
import com.kodilla.library.domain.exeption.CopyNotFoundException;
import com.kodilla.library.domain.exeption.LentNotFoundException;
import com.kodilla.library.domain.exeption.ReaderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ReaderNotFoundException.class)
    public ResponseEntity<Object> readerNotFoundHandler(ReaderNotFoundException e) {
        return new ResponseEntity<>("Reader with given id dosen't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> bookNotFoundHandler(BookNotFoundException e) {
        return new ResponseEntity<>("Book with given id dosen't exist", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CopyNotFoundException.class)
    public ResponseEntity<Object> copyNotFoundHandler(CopyNotFoundException e) {
        return new ResponseEntity<>("Copy with given id dosen't exist", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(LentNotFoundException.class)
    public ResponseEntity<Object> lentNotFoundHandler(LentNotFoundException e) {
        return new ResponseEntity<>("Lent with given id dosen't exist", HttpStatus.BAD_REQUEST);
    }


}
