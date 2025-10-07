package ir.mzahrani.service;

import ir.mzahrani.dto.BorrowRequestDTO;
import ir.mzahrani.dto.BorrowResponseDTO;
import ir.mzahrani.entity.Borrow;

public interface BorrowServiceInterface  {
    BorrowResponseDTO borrowBook(BorrowRequestDTO borrowBook);

}