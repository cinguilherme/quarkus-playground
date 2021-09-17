package org.acme.books.domain.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@ToString
@EqualsAndHashCode
@Indexed
public class Book extends PanacheEntityBase {


    @Id
    @GeneratedValue
    public UUID id;

    @FullTextField(analyzer = "english")
    public String name;

    @ManyToOne
    @JsonbTransient
    public Author author;

    public String coAuthor;
    public Long edition;
    public String publisher;

    public LocalDateTime datePublished;

}
