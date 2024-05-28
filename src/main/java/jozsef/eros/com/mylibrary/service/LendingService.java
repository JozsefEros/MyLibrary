package jozsef.eros.com.mylibrary.service;

import jozsef.eros.com.mylibrary.model.Lending;
import jozsef.eros.com.mylibrary.repository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendingService {

    @Autowired
    private LendingRepository lendingRepository;

    public List<Lending> getAllLendings() {
        return lendingRepository.findAll();
    }

    public Lending getLendingById(Long id) {
        return lendingRepository.findById(id).orElse(null);
    }

    public Lending createLending(Lending lending) {
        return lendingRepository.save(lending);
    }

    public Lending updateLending(Long id, Lending lendingDetails) {
        Lending lending = lendingRepository.findById(id).orElse(null);
        if (lending != null) {
            lending.setReader(lendingDetails.getReader());
            lending.setCatalog(lendingDetails.getCatalog());
            lending.setLendingDate(lendingDetails.getLendingDate());
            lending.setExpirationDate(lendingDetails.getExpirationDate());
            return lendingRepository.save(lending);
        }
        return null;
    }

    public void deleteLending(Long id) {
        lendingRepository.deleteById(id);
    }
}

