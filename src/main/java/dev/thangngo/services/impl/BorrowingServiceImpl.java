package dev.thangngo.services.impl;

import dev.thangngo.dtos.requests.borrowing.BorrowingCreateRequest;
import dev.thangngo.dtos.requests.borrowing.BorrowingUpdateRequest;
import dev.thangngo.dtos.responses.borrowing.BorrowingDetailResponse;
import dev.thangngo.dtos.responses.borrowing.BorrowingResponse;
import dev.thangngo.entities.Book;
import dev.thangngo.entities.Borrowing;
import dev.thangngo.entities.Member;
import dev.thangngo.mappers.BorrowingMapper;
import dev.thangngo.repositories.BookRepository;
import dev.thangngo.repositories.BorrowingRepository;
import dev.thangngo.repositories.MemberRepository;
import dev.thangngo.services.BorrowingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BorrowingServiceImpl implements BorrowingService {

    private final BorrowingRepository borrowingRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final BorrowingMapper borrowingMapper;

    public BorrowingServiceImpl(BorrowingRepository borrowingRepository,
                                MemberRepository memberRepository,
                                BookRepository bookRepository,
                                BorrowingMapper borrowingMapper) {
        this.borrowingRepository = borrowingRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
        this.borrowingMapper = borrowingMapper;
    }

    @Override
    public BorrowingResponse createBorrowing(BorrowingCreateRequest request) {
        Borrowing borrowing = borrowingMapper.toEntity(request);

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        borrowing.setMember(member);
        borrowing.setBook(book);

        borrowingRepository.save(borrowing);
        return borrowingMapper.toResponse(borrowing);
    }

    @Override
    public BorrowingResponse updateBorrowing(int id, BorrowingUpdateRequest request) {
        Borrowing borrowing = borrowingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));

        borrowingMapper.updateEntity(borrowing, request);

        if (request.getMemberId() != null) {
            Member member = memberRepository.findById(request.getMemberId())
                    .orElseThrow(() -> new RuntimeException("Member not found"));
            borrowing.setMember(member);
        }

        if (request.getBookId() != null) {
            Book book = bookRepository.findById(request.getBookId())
                    .orElseThrow(() -> new RuntimeException("Book not found"));
            borrowing.setBook(book);
        }

        borrowingRepository.save(borrowing);
        return borrowingMapper.toResponse(borrowing);
    }

    @Override
    public BorrowingDetailResponse getBorrowingById(int id) {
        Borrowing borrowing = borrowingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));
        return borrowingMapper.toDetailResponse(borrowing);
    }

    @Override
    public List<BorrowingResponse> getAllBorrowings() {
        return borrowingRepository.findAll()
                .stream()
                .map(borrowingMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteBorrowing(int id) {
        if (!borrowingRepository.existsById(id)) {
            throw new RuntimeException("Borrowing not found");
        }
        borrowingRepository.deleteById(id);
    }
}
