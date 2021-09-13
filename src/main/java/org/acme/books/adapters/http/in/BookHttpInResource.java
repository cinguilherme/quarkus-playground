package org.acme.books.adapters.http.in;

import org.acme.books.diplomat.BookDiplomat;
import org.acme.books.diplomat.wire.BookDTO;
import org.acme.books.orchestrator.BooksOrchestratorService;

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
import java.util.stream.Stream;

@Path("/book")
public class BookHttpInResource {

    @Inject
    BooksOrchestratorService booksOrchestratorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDTO> getBooks() {
        return booksOrchestratorService.allBooks()
                .stream()
                .map(BookDiplomat::fromBook)
                .collect(Collectors.toList());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public BookDTO addBook(BookDTO newBook) {
        return Stream.of(BookDiplomat.fromBookDTO(newBook))
                .map(booksOrchestratorService::newBook)
                .map(BookDiplomat::fromBook)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("unsable to save book"));
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookDTO updateBook(@PathParam("id") Integer index, BookDTO book) {
        return booksOrchestratorService.replaceBook(index, book);
    }
}
