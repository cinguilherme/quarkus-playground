package org.acme.books.domain.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@ToString
public class Book extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue
    public UUID id;
    public String name;
    public String author;

    public String coAuthor;
    public Long edition;
    public String publisher;

    public LocalDateTime datePublished;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

}
