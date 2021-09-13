package org.acme.books.ports.repository;

import org.acme.books.domain.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends CrudRepository<Book, UUID> {

    List<Book> findByAuthor(String author);
}
