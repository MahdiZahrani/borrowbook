package ir.mzahrani.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

}
