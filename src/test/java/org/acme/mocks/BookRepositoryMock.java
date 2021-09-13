package org.acme.mocks;

import io.quarkus.test.Mock;
import org.acme.books.domain.models.Book;
import org.acme.books.ports.repository.BookRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mock
@ApplicationScoped
public class BookRepositoryMock implements BookRepository {

    @Override
    public List<Book> findByAuthor(String author) {
        return null;
    }

    @Override
    public <S extends Book> S save(S s) {
        return null;
    }

    @Override
    public <S extends Book> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Book> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public Iterable<Book> findAll() {
        return List.of(Book.builder()
                               .name("LOTR")
                               .author("Tolkein")
                               .build());
    }

    @Override
    public Iterable<Book> findAllById(Iterable<UUID> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public void deleteAll(Iterable<? extends Book> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
