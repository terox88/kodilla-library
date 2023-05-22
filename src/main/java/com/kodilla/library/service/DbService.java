package com.kodilla.library.service;

import com.kodilla.library.domain.*;
import com.kodilla.library.domain.exeption.BookNotFoundException;
import com.kodilla.library.domain.exeption.CopyNotFoundException;
import com.kodilla.library.domain.exeption.LentNotFoundException;
import com.kodilla.library.domain.exeption.ReaderNotFoundException;
import com.kodilla.library.repository.BookCopyRepository;
import com.kodilla.library.repository.BookLentRepository;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {
    private final BookRepository bookRepository;
    private final BookCopyRepository bookCopyRepository;
    private final ReaderRepository readerRepository;
    private final BookLentRepository bookLentRepository;

    public Reader addReader(final Reader reader) {
      return  readerRepository.save(reader);
    }
    public Book addBook(final Book book) {
        return bookRepository.save(book);
    }
    public BookCopy addBookCopy(final BookCopy copy) {
        return bookCopyRepository.save(copy);
    }
    public BookCopy changeBookCopyStatus(int bookCopyId, CopyStatus status) throws CopyNotFoundException {
        BookCopy changingCopy = bookCopyRepository.findById(bookCopyId).orElseThrow(CopyNotFoundException::new);
        changingCopy.setStatus(status);
        return bookCopyRepository.save(changingCopy);
    }
    public List<BookCopy> findAvailable(int bookId) throws BookNotFoundException {
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        CopyStatus status = CopyStatus.AVAILABLE;
        return bookCopyRepository.findByBookAndStatus(book,status);
    }
    public BookLent createLent(int bookCopyId, int readerId) throws CopyNotFoundException, ReaderNotFoundException {
        BookCopy copy = bookCopyRepository.findById(bookCopyId).orElseThrow(CopyNotFoundException::new);
        Reader reader = readerRepository.findById(readerId).orElseThrow(ReaderNotFoundException :: new);
        BookLent bookLent = new BookLent(copy, reader);
        copy.setLent(bookLent);
        copy.setStatus(CopyStatus.LENT);
        reader.getLents().add(bookLent);
        bookCopyRepository.save(copy);
        readerRepository.save(reader);
        return bookLentRepository.save(bookLent);
    }
    public void deleteLent(int lentId) throws LentNotFoundException {
        try {
            bookLentRepository.deleteById(lentId);
        } catch (IllegalArgumentException e) {
            throw new LentNotFoundException();
        }

    }


}
