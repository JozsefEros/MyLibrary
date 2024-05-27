package jozsef.eros.com.mylibrary.service;

import jozsef.eros.com.mylibrary.model.Reader;
import jozsef.eros.com.mylibrary.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader getReaderById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public Reader createReader(Reader reader) {
        reader.setCreatedAt(LocalDate.now());
        reader.setModifiedAt(LocalDate.now());
        return readerRepository.save(reader);
    }

    public Reader updateReader(Long id, Reader readerDetails) {
        Reader reader = readerRepository.findById(id).orElse(null);
        if (reader != null) {
            reader.setFirstName(readerDetails.getFirstName());
            reader.setMiddleName(readerDetails.getMiddleName());
            reader.setLastName(readerDetails.getLastName());
            reader.setYearOfBirth(readerDetails.getYearOfBirth());
            reader.setRegistrationDate(readerDetails.getRegistrationDate());
            reader.setModifiedAt(LocalDate.now());
            return readerRepository.save(reader);
        }
        return null;
    }

    public void deleteReader(Long id) {
        readerRepository.deleteById(id);
    }
}
