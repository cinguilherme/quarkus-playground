package org.acme.books.adapters.http.in;

import io.quarkus.runtime.StartupEvent;
import org.acme.books.diplomat.BookDiplomat;
import org.acme.books.diplomat.wire.BookDTO;
import org.acme.books.orchestrator.BooksOrchestratorService;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/book")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookHttpInResource {

    private final Logger LOGGER = Logger.getLogger(this.getClass()
                                                           .getName());

    @Inject
    BooksOrchestratorService booksOrchestratorService;

    public void onStart(
            @Observes
                    StartupEvent startupEvent) {
        
    }

    @GET
    public Response getBooks() {
        LOGGER.info("Accepting getBooks request");
        List<BookDTO> dtoList = booksOrchestratorService.allBooks()
                .stream()
                .map(BookDiplomat::fromBook)
                .collect(Collectors.toList());
        return Response.ok(dtoList)
                .build();
    }

    @POST
    @Transactional
    public Response addBook(@Valid BookDTO newBook) {
        BookDTO book = Stream.of(BookDiplomat.fromBookDTO(newBook))
                .map(booksOrchestratorService::newBook)
                .map(BookDiplomat::fromBook)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("unable to save book"));

        LOGGER.info(String.format("Accepting new Book request: %s", book));
        return Response.status(201)
                .entity(book)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateBook(
            @PathParam("id")
                    Integer index, BookDTO book) {
        BookDTO bookDTO = booksOrchestratorService.replaceBook(index, book);
        return Response.ok(bookDTO)
                .build();
    }
}
