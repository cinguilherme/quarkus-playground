package org.acme.books.domain.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Indexed
public class Author extends PanacheEntityBase {

    @FullTextField(analyzer = "english")
    @KeywordField(name = "firstName_sort",
                  sortable = Sortable.YES,
                  normalizer = "sort")
    String firstName;

    @FullTextField(analyzer = "english")
    @KeywordField(name = "lastName_sort",
                  sortable = Sortable.YES,
                  normalizer = "sort")
    String lastName;

    LocalDateTime birthDate;


    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.EAGER,
               orphanRemoval = true,
               mappedBy = "author")
    @IndexedEmbedded
    private List<Book> listOfBooks;

    @Id
    @GeneratedValue
    private UUID id;

}
