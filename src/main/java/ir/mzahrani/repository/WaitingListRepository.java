package ir.mzahrani.repository;

import ir.mzahrani.entity.Book;
import ir.mzahrani.entity.Member;
import ir.mzahrani.entity.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaitingListRepository extends JpaRepository<WaitingList, Long> {

    List<WaitingList> findByBookOrderByRequestDateAsc(Book book);

    boolean existsByBookAndMember(Book book, Member member);

}
