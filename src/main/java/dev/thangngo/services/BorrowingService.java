package dev.thangngo.services;

import dev.thangngo.dtos.requests.borrowing.BorrowingCreateRequest;
import dev.thangngo.dtos.requests.borrowing.BorrowingUpdateRequest;
import dev.thangngo.dtos.responses.borrowing.BorrowingDetailResponse;
import dev.thangngo.dtos.responses.borrowing.BorrowingResponse;

import java.util.List;

public interface BorrowingService {
    BorrowingResponse createBorrowing(BorrowingCreateRequest request);
    BorrowingResponse updateBorrowing(int id, BorrowingUpdateRequest request);
    BorrowingDetailResponse getBorrowingById(int id);
    List<BorrowingResponse> getAllBorrowings();
    void deleteBorrowing(int id);
}
