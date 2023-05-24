package com.kodilla.library.mapper;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.ReaderDtoIn;
import com.kodilla.library.domain.ReaderDtoOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderMapper {
    public Reader mapToReader(final ReaderDtoIn readerDto) {
        return new Reader(
                readerDto.getName(),
                readerDto.getLastname()

        );
    }
    public ReaderDtoOut mapToReaderDto(final Reader reader){
        return new ReaderDtoOut(
                reader.getId(),
                reader.getName(),
                reader.getLastname(),
                reader.getCreated(),
                reader.getLents()
        );
    }
    public List<ReaderDtoOut> mapToReaderDtoList(final List<Reader> readerList) {
       return readerList.stream().map(this::mapToReaderDto).toList();
    }
}
