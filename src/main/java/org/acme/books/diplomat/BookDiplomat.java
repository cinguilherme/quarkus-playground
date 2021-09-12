package org.acme.books.diplomat;

import org.acme.books.db.models.Book;
import org.acme.books.http.wire.BookDTO;

public class BookDiplomat {

    public static Book fromBookDTO(BookDTO book) {
        return Book.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .name(book.getName())
                .build();
    }

    public static BookDTO fromBook(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .name(book.getName())
                .build();
    }

}
