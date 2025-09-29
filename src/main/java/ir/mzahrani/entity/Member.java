package ir.mzahrani.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
