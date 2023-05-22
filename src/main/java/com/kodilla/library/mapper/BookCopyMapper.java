package com.kodilla.library.mapper;

import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.BookCopyDto;
import com.kodilla.library.domain.exeption.BookNotFoundException;
import com.kodilla.library.domain.exeption.LentNotFoundException;
import com.kodilla.library.repository.BookLentRepository;
import com.kodilla.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookCopyMapper {
    private BookRepository bookRepository;
    private BookLentRepository bookLentRepository;
    public BookCopy mapToBookCopy(final BookCopyDto copyDto) throws BookNotFoundException, LentNotFoundException {
        return new BookCopy(
                copyDto.getId(),
                copyDto.getStatus(),
                bookRepository.findById(copyDto.getBookId()).orElseThrow(BookNotFoundException::new),
                bookLentRepository.findById(copyDto.getLentId()).orElseThrow(LentNotFoundException::new)
        );
    }
    public BookCopyDto mapToBookCopyDto(final BookCopy copy) {
        return new BookCopyDto(
                copy.getId(),
                copy.getStatus(),
                copy.getBook().getId(),
                copy.getLent().getId()
        );
    }
    public List<BookCopyDto> mapToBookCopyDtoList(List<BookCopy> bookList) {
        return bookList.stream().map(this::mapToBookCopyDto).toList();
    }
}
