package org.acme.books.domain.logic;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;

public class BookLogicPresentation {

    public static Function<String, String> authorInBookName = (String name) -> {
        final String[] names = name.split(" ");
        final String last = names[names.length - 1];
        final Optional<String> reduced = Arrays.stream(
                        Arrays.copyOfRange(names, 0, names.length - 1))
                .map(it -> String.valueOf(it.charAt(0))
                        .toUpperCase(Locale.ROOT) + ". ")
                .reduce((acc, curr) -> acc += curr);

        return reduced.orElseGet(() -> "") + last;
    };

}
