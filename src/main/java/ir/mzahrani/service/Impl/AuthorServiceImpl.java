package ir.mzahrani.service.Impl;

import ir.mzahrani.entity.Author;
import ir.mzahrani.repository.AuthorRepository;
import ir.mzahrani.service.AuthorServiceInterface;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl extends BaseService<Author,Long> implements AuthorServiceInterface {

    private final AuthorRepository authorRepository;

    AuthorServiceImpl(AuthorRepository authorRepository) {
        super(authorRepository);
        this.authorRepository = authorRepository;
    }

}
