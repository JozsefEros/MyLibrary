package jozsef.eros.com.mylibrary.controller;

import jakarta.validation.Valid;
import jozsef.eros.com.mylibrary.model.Catalog;
import jozsef.eros.com.mylibrary.model.Lending;
import jozsef.eros.com.mylibrary.service.LendingService;
import jozsef.eros.com.mylibrary.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lendings")
public class LendingController {

    @Autowired
    private LendingService lendingService;

    @Autowired
    private CatalogService catalogService;

    @GetMapping
    public List<Lending> getAllLendings() {
        return lendingService.getAllLendings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lending> getLendingById(@PathVariable Long id) {
        Lending lending = lendingService.getLendingById(id);
        if (lending != null) {
            return ResponseEntity.ok(lending);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Lending createLending(@Valid @RequestBody Lending lending) {
        return lendingService.createLending(lending);
    }

    @PostMapping("/lend")
    public void lendBook(@RequestParam Long bookId, Catalog catalog) {
        catalogService.lendBook(bookId, catalog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lending> updateLending(@PathVariable Long id, @Valid @RequestBody Lending lendingDetails) {
        Lending updateLending = lendingService.updateLending(id, lendingDetails);
        if (updateLending != null) {
            return ResponseEntity.ok(updateLending);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLending(@PathVariable Long id) {
        lendingService.deleteLending(id);
        return ResponseEntity.noContent().build();
    }
}
