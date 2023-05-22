package com.kodilla.library.repository;

import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.BookLent;
import com.kodilla.library.domain.CopyStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookLentRepository extends CrudRepository<BookLent, Integer>{
    @Override
    List<BookLent> findAll();
       @Override
    BookLent save(BookLent lent);

    void deleteById(int id);

    Optional<BookLent> findById(int id);
}
