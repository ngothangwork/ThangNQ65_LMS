package dev.thangngo.mappers;

import dev.thangngo.dtos.requests.borrowing.BorrowingCreateRequest;
import dev.thangngo.dtos.requests.borrowing.BorrowingUpdateRequest;
import dev.thangngo.dtos.responses.borrowing.BorrowingDetailResponse;
import dev.thangngo.dtos.responses.borrowing.BorrowingResponse;
import dev.thangngo.entities.Borrowing;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BorrowingMapper {

    @Mapping(target = "member", ignore = true)
    @Mapping(target = "book", ignore = true)
    Borrowing toEntity(BorrowingCreateRequest request);

    BorrowingResponse toResponse(Borrowing entity);

    BorrowingDetailResponse toDetailResponse(Borrowing entity);

    void updateEntity(@MappingTarget Borrowing entity, BorrowingUpdateRequest request);
}
