package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given().when()
                .get("/hello")
                .then()
                .statusCode(200)
                .body(is(
                        "The number is 1 Mr. test_hello! Country information of br with code: 55. The base64 property is hello"));
    }

}
