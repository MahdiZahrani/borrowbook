package ir.mzahrani.repository;

import ir.mzahrani.entity.Book;
import ir.mzahrani.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository extends BaseRepository<Book> {

    public BookRepository() {
        super(Book.class);
    }

    public List<Book> findByTitle(String keyword) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Book> query = builder.createQuery(Book.class);
            Root<Book> root = query.from(Book.class);
            query.select(root).where(builder.like(root.get("title"), "%" + keyword + "%"));
            List<Book> books = session.createQuery(query).getResultList();
            session.close();
            return books;
        }
    }
}
