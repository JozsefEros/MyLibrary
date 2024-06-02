package jozsef.eros.com.mylibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "lending")
public class Lending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer reader;

    @NotNull
    private Integer book;

    @Column(nullable = false)
    private LocalDate lendingDate;

    @Column()
    private LocalDate expirationDate;

    @Column()
    private LocalDate returnDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public Integer getReader() {
        return reader;
    }

    public void setReader(@NotNull Integer reader) {
        this.reader = reader;
    }

    public @NotNull Integer getBook() {
        return book;
    }

    public void setBook(@NotNull Integer book) {
        this.book = book;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public void setLendingDate(LocalDate lendingDate) {
        this.lendingDate = lendingDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
