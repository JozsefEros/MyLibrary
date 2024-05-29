package jozsef.eros.com.mylibrary.controller;

import jakarta.validation.Valid;
import jozsef.eros.com.mylibrary.model.Reader;
import jozsef.eros.com.mylibrary.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @GetMapping
    public List<Reader> getAllReaders() {
        return readerService.getAllReaders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReaderById(@PathVariable Long id) {
        Reader reader = readerService.getReaderById(id);
        if (reader != null) {
            return ResponseEntity.ok(reader);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Reader createReader(@Valid @RequestBody Reader reader) {
        reader.setCreatedAt(LocalDate.now());
        reader.setModifiedAt(LocalDate.now());
        return readerService.createReader(reader);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reader> updateReader(@PathVariable Long id, @Valid @RequestBody Reader readerDetails) {
        Reader updatedReader = readerService.updateReader(id, readerDetails);
        if (updatedReader != null) {
            return ResponseEntity.ok(updatedReader);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Reader> findReadersByName(@RequestParam String name) {
        return readerService.findReadersByName(name);
    }
}
