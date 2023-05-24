package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    @Override
    List<Book> findAll();
    Optional<Book> findByTitle(String title);
    @Override
    Book save(Book book);
    void deleteById(int id);
    Optional<Book> findById(int id);



}
