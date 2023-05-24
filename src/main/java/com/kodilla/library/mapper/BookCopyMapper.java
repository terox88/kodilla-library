package com.kodilla.library.mapper;

import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.BookCopyDto;
import com.kodilla.library.domain.exeption.BookNotFoundException;
import com.kodilla.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookCopyMapper {
    private final BookRepository bookRepository;
    public BookCopy mapToBookCopy(final BookCopyDto copyDto) throws BookNotFoundException {
        return new BookCopy(
                copyDto.getId(),
                copyDto.getStatus(),
                bookRepository.findById(copyDto.getBookId()).orElseThrow(BookNotFoundException::new)

        );
    }
    public BookCopyDto mapToBookCopyDto(final BookCopy copy) {
        return new BookCopyDto(
                copy.getId(),
                copy.getStatus(),
                copy.getBook().getId()
        );
    }
    public List<BookCopyDto> mapToBookCopyDtoList(List<BookCopy> bookList) {
        return bookList.stream().map(this::mapToBookCopyDto).toList();
    }
}
