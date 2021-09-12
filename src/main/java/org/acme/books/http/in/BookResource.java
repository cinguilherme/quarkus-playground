package org.acme.books.http.in;

import org.acme.books.diplomat.BookDiplomat;
import org.acme.books.http.wire.BookDTO;
import org.acme.books.services.BookService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/book")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDTO> getBooks() {
        return bookService.allBooks()
                .stream()
                .map(BookDiplomat::fromBook)
                .collect(Collectors.toList());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public BookDTO addBook(BookDTO newBook) {
        return bookService.newBook(newBook);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookDTO updateBook(@PathParam("id") Integer index, BookDTO book) {
        return bookService.replaceBook(index, book);
    }
}
