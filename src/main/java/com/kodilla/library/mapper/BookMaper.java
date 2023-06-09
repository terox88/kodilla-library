package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDtoIn;
import com.kodilla.library.domain.BookDtoOut;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookMaper {
    public Book mapToBook(final BookDtoIn bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublishYear()

        );
    }
    public BookDtoOut mapToBookDto(final Book book) {
        return new BookDtoOut(
                book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getCopies()
        );
    }
    public List<BookDtoOut> mapToBookDtoList(List<Book> bookList) {
        return bookList.stream().map(this::mapToBookDto).toList();
    }
}
