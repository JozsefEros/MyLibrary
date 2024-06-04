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

    @ManyToOne
    @JoinColumn(name = "reader")
    @NotNull(message = "Az olvasó azonosítója nem lehet üres!")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "book")
    @NotNull(message = "A könyv azonosítója nem lehet üres!")
    private Catalog book;


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

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Catalog getBook() {
        return book;
    }

    public void setBook(Catalog book) {
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
