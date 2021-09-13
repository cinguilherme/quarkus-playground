package org.acme.mocks;

import io.quarkus.test.Mock;
import org.acme.books.ports.repository.BookRepository;

@Mock
public interface BookRepositoryMock extends BookRepository {

    //    @Override
    //    Iterable<Book> findAll() {
    //        return List.of(Book.builder()
    //                               .name("test book name")
    //                               .build());
    //    }
}
