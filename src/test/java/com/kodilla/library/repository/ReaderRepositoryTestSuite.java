package com.kodilla.library.repository;

import com.kodilla.library.domain.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReaderRepositoryTestSuite {
    @Autowired
    private ReaderRepository repository;

    @Test
    void saveReaderTestSuite() {
        //Given
        Reader reader = new Reader("Adam", "Smith");

        //When
        repository.save(reader);
        int id = reader.getId();

        //Then
        Assertions.assertNotEquals(0,id);

        //Clean up
        //repository.deleteById(id);
    }

}

