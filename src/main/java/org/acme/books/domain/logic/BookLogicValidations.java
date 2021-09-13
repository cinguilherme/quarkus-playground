package org.acme.books.domain.logic;

import java.util.function.Function;

public class BookLogicValidations {

    public static Function<String, Boolean> validBookName = (String name) -> name.length() > 3;

    
}
