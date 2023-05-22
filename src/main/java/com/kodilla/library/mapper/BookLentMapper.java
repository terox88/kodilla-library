package com.kodilla.library.mapper;

import com.kodilla.library.domain.BookLent;
import com.kodilla.library.domain.BookLentDto;
import com.kodilla.library.domain.exeption.BookNotFoundException;
import com.kodilla.library.domain.exeption.ReaderNotFoundException;
import com.kodilla.library.repository.BookCopyRepository;
import com.kodilla.library.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLentMapper {
    private BookCopyRepository bookCopyRepository;
    private ReaderRepository readerRepository;
    public BookLent mapToBookLent(final BookLentDto lentDto) throws BookNotFoundException, ReaderNotFoundException {
        return new BookLent(
                bookCopyRepository.findById(lentDto.getBookCopyId()).orElseThrow(BookNotFoundException:: new),
                readerRepository.findById(lentDto.getReaderId()).orElseThrow(ReaderNotFoundException :: new)
        );
    }
    public BookLentDto mapToBookLentDto(final BookLent lent) {
        return new BookLentDto(
                lent.getId(),
                lent.getCopy().getId(),
                lent.getReader().getId(),
                lent.getLentBegin(),
                lent.getLentEnd()
        );
    }
    public List<BookLentDto> mapToBookLentDtoList(final List<BookLent> bookLentList) {
        return bookLentList.stream().map(this::mapToBookLentDto).toList();
    }
}
