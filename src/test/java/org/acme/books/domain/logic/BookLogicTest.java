package org.acme.books.domain.logic;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class BookLogicTest {

    @Test
    void testValidBookName() {
        Assertions.assertEquals(true,
                                BookLogicValidations.validBookName.apply("The Lord Of the Rings"));
    }

    @Test
    void testInvalidBookName() {
        Assertions.assertEquals(false, BookLogicValidations.validBookName.apply("LOD"));
    }

    @Test
    void testAuthorPresentable() {
        Assertions.assertEquals("J. K. Tolkein",
                                BookLogicPresentation.authorInBookName.apply("John Klein Tolkein"));
    }

}
