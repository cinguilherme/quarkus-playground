package org.acme.books.db.repository;

import org.acme.books.db.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends CrudRepository<Book, UUID> {

    List<Book> findByAuthor(String author);
}
