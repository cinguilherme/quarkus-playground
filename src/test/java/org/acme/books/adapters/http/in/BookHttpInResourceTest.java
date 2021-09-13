package org.acme.books.adapters.http.in;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.books.diplomat.wire.BookDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookHttpInResourceTest {

    @Test
    public void testGetBookEndpoint() {
        given().when()
                .get("/book")
                .then()
                .statusCode(200)
                .body(is(List.of(BookDTO.builder()
                                         .name("test name")
                                         .build())));
    }

}
