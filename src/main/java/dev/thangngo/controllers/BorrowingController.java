package dev.thangngo.controllers;

import dev.thangngo.dtos.requests.borrowing.BorrowingCreateRequest;
import dev.thangngo.dtos.requests.borrowing.BorrowingUpdateRequest;
import dev.thangngo.dtos.responses.borrowing.BorrowingDetailResponse;
import dev.thangngo.dtos.responses.borrowing.BorrowingResponse;
import dev.thangngo.services.BorrowingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @PostMapping
    public ResponseEntity<BorrowingResponse> createBorrowing(
            @Valid @RequestBody BorrowingCreateRequest request) {
        return ResponseEntity.ok(borrowingService.createBorrowing(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowingResponse> updateBorrowing(
            @PathVariable int id,
            @Valid @RequestBody BorrowingUpdateRequest request) {
        return ResponseEntity.ok(borrowingService.updateBorrowing(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingDetailResponse> getBorrowingById(@PathVariable int id) {
        return ResponseEntity.ok(borrowingService.getBorrowingById(id));
    }

    @GetMapping
    public ResponseEntity<List<BorrowingResponse>> getAllBorrowings() {
        return ResponseEntity.ok(borrowingService.getAllBorrowings());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowing(@PathVariable int id) {
        borrowingService.deleteBorrowing(id);
        return ResponseEntity.noContent().build();
    }
}
