package org.acme.books.orchestrator;

import org.acme.books.diplomat.wire.BookDTO;
import org.acme.books.domain.models.Book;
import org.acme.books.ports.repository.BookRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@ApplicationScoped
public class BooksOrchestratorService {

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

    public Book newBook(final Book book) {
        Book saved = bookRepository.save(book);
        System.out.println(saved);

        return book;
    }

    public BookDTO replaceBook(Integer index, BookDTO book) {

        return book;
    }
}
