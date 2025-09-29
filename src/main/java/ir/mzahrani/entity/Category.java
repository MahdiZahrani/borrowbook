package ir.mzahrani.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "categories")
    private Set<Book> books;
}
