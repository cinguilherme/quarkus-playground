package org.acme.books.diplomat;

import org.acme.books.diplomat.wire.BookDTO;
import org.acme.books.domain.models.Author;
import org.acme.books.domain.models.Book;

import java.util.UUID;

public class BookDiplomat {

    public static Book fromBookDTO(BookDTO book) {
        return Book.builder()
                .id(book.getId())
                .author(Author.builder()
                                .firstName(book.getAuthor())
                                .id(UUID.fromString(book.getAuthor_id()))
                                .build())
                .name(book.getName())
                .build();
    }

    public static BookDTO fromBook(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .author(book.getAuthor()
                                .getFirstName() + book.getAuthor()
                        .getLastName())
                .name(book.getName())
                .build();
    }

}
