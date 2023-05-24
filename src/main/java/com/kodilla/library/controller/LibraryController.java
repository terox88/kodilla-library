package com.kodilla.library.controller;

import com.kodilla.library.domain.*;
import com.kodilla.library.domain.exeption.BookNotFoundException;
import com.kodilla.library.domain.exeption.CopyNotFoundException;
import com.kodilla.library.domain.exeption.LentNotFoundException;
import com.kodilla.library.domain.exeption.ReaderNotFoundException;
import com.kodilla.library.mapper.BookCopyMapper;
import com.kodilla.library.mapper.BookLentMapper;
import com.kodilla.library.mapper.BookMaper;
import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/library")
public class LibraryController {
    private final DbService service;
    private final BookMaper bookMaper;
    private final BookCopyMapper bookCopyMapper;
    private final BookLentMapper bookLentMapper;
    private final ReaderMapper readerMapper;

@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/reader")
    public ResponseEntity<Void> addReader(@RequestBody ReaderDtoIn readerDtoIn) {
    Reader reader = readerMapper.mapToReader(readerDtoIn);
    service.addReader(reader);
    return ResponseEntity.ok().build();
}
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/book")
    public ResponseEntity<Void> addBook(@RequestBody BookDtoIn bookDtoIn) {
    Book book = bookMaper.mapToBook(bookDtoIn);
    service.addBook(book);
    return ResponseEntity.ok().build();
}
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/copy")
    public ResponseEntity<Void> addBookCopy(@RequestBody BookCopyDto bookCopyDto) throws BookNotFoundException {
    BookCopy bookCopy = bookCopyMapper.mapToBookCopy(bookCopyDto);
    service.addBookCopy(bookCopy);
    return ResponseEntity.ok().build();
}

@PutMapping(value = "/copy")
    public ResponseEntity<Void> changeCopyStatus(@RequestParam int copyId, @RequestParam CopyStatus status) throws CopyNotFoundException {
    service.changeBookCopyStatus(copyId,status);
    return ResponseEntity.ok().build();
}
@GetMapping(value = "/copy")
    public ResponseEntity<List<BookCopyDto>> getAvailableCopies (@RequestParam int bookId) throws BookNotFoundException{
    return ResponseEntity.ok(bookCopyMapper.mapToBookCopyDtoList(service.findAvailable(bookId)));
}

@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/lent")
    public ResponseEntity<Void> createLent(@RequestBody BookLentDtoIn bookLentDtoIn) throws BookNotFoundException, ReaderNotFoundException {
    service.createLent(bookLentMapper.mapToBookLent(bookLentDtoIn));
    return ResponseEntity.ok().build();
}
@DeleteMapping(value = "/lent/{lentId}")
    public ResponseEntity<Void> deleteLent(@PathVariable int lentId) throws LentNotFoundException, CopyNotFoundException {
    service.deleteLent(lentId);
    return ResponseEntity.ok().build();
}
@DeleteMapping(value = "/reader/{readerId}")
    public ResponseEntity<Void> deleteReader(@PathVariable int readerId)throws ReaderNotFoundException {
    service.deleteReader(readerId);
    return ResponseEntity.ok().build();
}
@GetMapping(value = "/reader")
    public ResponseEntity<List<ReaderDtoOut>> getReaders() {
    return ResponseEntity.ok(readerMapper.mapToReaderDtoList(service.getAllReaders()));
}
@GetMapping(value = "/book")
    public ResponseEntity<List<BookDtoOut>> getBooks() {
    return ResponseEntity.ok(bookMaper.mapToBookDtoList(service.getaAllBooks()));
    }

}
