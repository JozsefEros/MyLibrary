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
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Reader reader;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Catalog catalog;

    @Column(nullable = false)
    private LocalDate lendingDate;

    @Column()
    private LocalDate expirationDate;

    @Column()
    private LocalDate returnDate;

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Reader getReader() {
        return reader;
    }

    public void setReader(@NotNull Reader reader) {
        this.reader = reader;
    }

    public @NotNull Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(@NotNull Catalog catalog) {
        this.catalog = catalog;
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
}
