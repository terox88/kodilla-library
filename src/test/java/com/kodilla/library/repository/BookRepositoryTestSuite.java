package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.CopyStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTestSuite {
    @Autowired
    private BookRepository repository;

    @Test
    void saveBookTest() {
        //Given
        Book book = new Book("Diune", "Frank Herbert", 2019);
        //When
        repository.save(book);
        int id = book.getId();
        //Then
        Assertions.assertNotEquals(0,id);
        //Clean up
        repository.deleteById(id);
    }
    @Test
    void saveBookWithCopiesTest() {
        //Given
        Book book1 = new Book("Diune", "Frank Herbert", 2019);
        Book book2 = new Book("1984", "George Orwell", 1997);
        BookCopy copy1 = new BookCopy(CopyStatus.AVAILABLE,book1);
        BookCopy copy2 = new BookCopy(CopyStatus.LENT, book1);
        BookCopy copy3 = new BookCopy(CopyStatus.LOST, book2);
        BookCopy copy4 = new BookCopy(CopyStatus.AVAILABLE, book2);
        BookCopy copy5 = new BookCopy(CopyStatus.LENT, book2);
        book1.getCopies().add(copy1);
        book1.getCopies().add(copy2);
        book2.getCopies().add(copy3);
        book2.getCopies().add(copy4);
        book2.getCopies().add(copy5);

        //When
        repository.save(book1);
        repository.save(book2);
        int book1Id = book1.getId();
        int book2Id = book2.getId();
        int book1Copies = book1.getCopies().size();
        int book2Copies = book2.getCopies().size();
        //Then
        Assertions.assertEquals(2, book1Copies);
        Assertions.assertEquals(3, book2Copies);
        Assertions.assertNotEquals(0,book1Id);
        Assertions.assertNotEquals(0,book2Id);

        //Clean up
        repository.deleteById(book1Id);
        repository.deleteById(book2Id);
    }
}
