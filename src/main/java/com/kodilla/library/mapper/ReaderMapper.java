package com.kodilla.library.mapper;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.ReaderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderMapper {
    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getName(),
                readerDto.getLastname()

        );
    }
    public ReaderDto mapToReaderDto(final Reader reader){
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getLastname(),
                reader.getCreated(),
                reader.getLents()
        );
    }
    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
       return readerList.stream().map(this::mapToReaderDto).toList();
    }
}
