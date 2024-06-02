package jozsef.eros.com.mylibrary.service;

import jozsef.eros.com.mylibrary.model.Catalog;
import jozsef.eros.com.mylibrary.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;

    public List<Catalog> getAllCatalog() {
        return catalogRepository.findAll();
    }

    public Catalog getCatalogById(Long id) {
        return catalogRepository.findById(id).orElse(null);
    }

    public Catalog createCatalog(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    public Catalog updateCatalog(Long id, Catalog catalogDetails) {
        Catalog catalog = catalogRepository.findById(id).orElse(null);
        if (catalog != null) {
            catalog.setTitle(catalogDetails.getTitle());
            catalog.setAuthor(catalogDetails.getAuthor());
            catalog.setGenre(catalogDetails.getGenre());
            catalog.setPublished(catalogDetails.getPublished());
            catalog.setPublisher(catalogDetails.getPublisher());
            catalog.setLanguage(catalogDetails.getLanguage());
            catalog.setAvailable(catalogDetails.getAvailable());
            return catalogRepository.save(catalog);
        }
        return null;
    }

    public Catalog lendBook(Long id, Catalog catalog) {
        Catalog lend = catalogRepository.findById(id).orElse(null);
        if (lend != null) {
            lend.setAvailable(catalog.getAvailable());
            return catalogRepository.save(lend);
        }
        return null;
    }

    public void deleteCatalog(Long id) {
        catalogRepository.deleteById(id);
    }

    public List<Catalog> findBooksByTitle(String title) {
        return catalogRepository.findByTitleContaining(title);
    }

    public List<Catalog> findBooksByAuthor(String author) {
        return catalogRepository.findByAuthorContaining(author);
    }
}
