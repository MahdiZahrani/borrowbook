package ir.mzahrani.service;

import ir.mzahrani.entity.Author;
import ir.mzahrani.repository.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final BaseRepository<Author> baseRepository;

    public AuthorService(BaseRepository<Author> baseRepository) {
        this.baseRepository = new BaseRepository<>(Author.class);
    }

    public void addAuthor(Author author) {
        baseRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return baseRepository.findAll();
    }

}
