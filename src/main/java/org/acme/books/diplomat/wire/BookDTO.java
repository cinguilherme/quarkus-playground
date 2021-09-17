package org.acme.books.diplomat.wire;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BookDTO {

    private UUID id;

    @NotBlank
    @Length(min = 3,
            message = "Book name has to have at least 3 letters.")
    private String name;

    //@NotBlank
    private String author;

    private String author_id;

    private Optional<LocalDateTime> releaseDate;

}
