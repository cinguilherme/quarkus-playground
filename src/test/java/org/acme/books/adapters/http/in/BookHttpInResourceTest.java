package org.acme.books.adapters.http.in;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class BookHttpInResourceTest {

    @Test
    public void testGetBookEndpoint() {
        given().when()
                .get("/book")
                .then()
                .statusCode(200);
    }

}
