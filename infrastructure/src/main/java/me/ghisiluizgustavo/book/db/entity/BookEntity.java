package me.ghisiluizgustavo.book.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.ghisiluizgustavo.ID;
import me.ghisiluizgustavo.book.model.Book;
import me.ghisiluizgustavo.book.model.Isbn;
import me.ghisiluizgustavo.rental.db.entity.RentalEntity;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String isbn;
    private String name;
    private String author;
    private Boolean available;

    @OneToMany(mappedBy = "book")
    private List<RentalEntity> rentals;

    public BookEntity(Book book) {
        this.isbn = book.isbn().value();
        this.name = book.name();
        this.available = book.available();
        this.author = book.author();
    }


    public Book toBook() {
        return new Book(
                new ID(this.id),
                new Isbn(this.isbn),
                this.name,
                this.author,
                this.available
        );
    }
}
