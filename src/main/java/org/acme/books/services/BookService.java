package org.acme.books.services;

import org.acme.books.db.models.Book;
import org.acme.books.db.repository.BookRepository;
import org.acme.books.http.wire.BookDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@ApplicationScoped
public class BookService {

    @Inject
    BookRepository bookRepository;

    public List<Book> allBooks() {
        Iterable<Book> all = bookRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toUnmodifiableList());
    }

    private BookDTO toDto(Iterable<Book> books) {
        return null;
    }

    public BookDTO newBook(final BookDTO book) {
        final BookDTO newBook = book.toBuilder()
                .id(UUID.randomUUID())
                .build();

        final Book newBookDB = new Book(book.getName(), book.getAuthor());
        Book saved = bookRepository.save(newBookDB);
        System.out.println(saved);

        return newBook;
    }

    public BookDTO replaceBook(Integer index, BookDTO book) {

        return book;
    }
}
