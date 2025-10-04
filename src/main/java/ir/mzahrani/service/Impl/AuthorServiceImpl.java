package ir.mzahrani.service.Impl;

import ir.mzahrani.entity.Author;
import ir.mzahrani.repository.AuthorRepository;
import ir.mzahrani.service.AuthorServiceInterface;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AuthorServiceImpl implements AuthorServiceInterface {

    private final AuthorRepository authorRepository;


    @Override
    public Author create(Author entity) {
        return null;
    }

    @Override
    public Author update(Author entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Author get(Long aLong) {
        return null;
    }

//    @Override
//    public List<Author> getAll() {
//        return List.of();
//    }
}
