package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookMaper {
    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublishYear(),
                bookDto.getCopies()
        );
    }
    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(), book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getCopies()
        );
    }
    public List<BookDto> mapToBookDtoList(List<Book> bookList) {
        return bookList.stream().map(this::mapToBookDto).toList();
    }
}
