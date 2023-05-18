package com.kodilla.library.repository;

import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.CopyStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BookCopyRepository extends CrudRepository<BookCopy, Integer> {
    @Override
    List<BookCopy> findAll();
    List<BookCopy> findByStatus(CopyStatus status);
    @Override
    BookCopy save(BookCopy copy);

    void deleteById(int id);
}
