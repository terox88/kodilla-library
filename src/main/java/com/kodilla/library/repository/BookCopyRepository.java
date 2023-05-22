package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.CopyStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookCopyRepository extends CrudRepository<BookCopy, Integer> {
    @Override
    List<BookCopy> findAll();
    List<BookCopy> findByStatus(CopyStatus status);

    Optional<BookCopy> findById(int id);


    @Override
    BookCopy save(BookCopy copy);

    void deleteById(int id);
    List<BookCopy> findByBookAndStatus(Book book, CopyStatus status);
}
