package jozsef.eros.com.mylibrary.service;

import jakarta.validation.Valid;
import jozsef.eros.com.mylibrary.model.Lending;
import jozsef.eros.com.mylibrary.repository.CatalogRepository;
import jozsef.eros.com.mylibrary.repository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LendingService {

    @Autowired
    private LendingRepository lendingRepository;
    @Autowired
    private CatalogRepository catalogRepository;

    public List<Lending> getAllLendings() {
        return lendingRepository.findAll();
    }

    public Lending getLendingById(Long id) {
        return lendingRepository.findById(id).orElse(null);
    }

    public Lending createLending(Lending lending) {
        return lendingRepository.save(lending);
    }

    @Transactional
    public Lending updateLending(Long id, @Valid Lending lendingDetails) {
        Lending lending = lendingRepository.findById(id).orElse(null);
        if (lending != null) {
            lending.setReader(lendingDetails.getReader());
            lending.setBook(lendingDetails.getBook());
            lending.setLendingDate(lendingDetails.getLendingDate());
            lending.setExpirationDate(lendingDetails.getExpirationDate());
            /*catalogRepository.updateAvailabilityToNot(lendingDetails.getBook());*/
            return lendingRepository.save(lending);

        }
        return null;
    }

    public void deleteLending(Long id) {
        lendingRepository.deleteById(id);
    }
}

