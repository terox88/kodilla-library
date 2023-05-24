package com.kodilla.library.mapper;

import com.kodilla.library.domain.BookLent;
import com.kodilla.library.domain.BookLentDtoIn;
import com.kodilla.library.domain.BookLentDtoOut;
import com.kodilla.library.domain.exeption.BookNotFoundException;
import com.kodilla.library.domain.exeption.ReaderNotFoundException;
import com.kodilla.library.repository.BookCopyRepository;
import com.kodilla.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLentMapper {
    private final BookCopyRepository bookCopyRepository;
    private final ReaderRepository readerRepository;
    public BookLent mapToBookLent(final BookLentDtoIn lentDto) throws BookNotFoundException, ReaderNotFoundException {
        return new BookLent(
                bookCopyRepository.findById(lentDto.getBookCopyId()).orElseThrow(BookNotFoundException:: new),
                readerRepository.findById(lentDto.getReaderId()).orElseThrow(ReaderNotFoundException :: new)
        );
    }
    public BookLentDtoOut mapToBookLentDto(final BookLent lent) {
        return new BookLentDtoOut(
                lent.getId(),
                lent.getCopy().getId(),
                lent.getReader().getId(),
                lent.getLentBegin(),
                lent.getLentEnd()
        );
    }
    public List<BookLentDtoOut> mapToBookLentDtoList(final List<BookLent> bookLentList) {
        return bookLentList.stream().map(this::mapToBookLentDto).toList();
    }
}
