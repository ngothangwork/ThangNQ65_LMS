package dev.thangngo.mappers;

import dev.thangngo.dtos.requests.member.MemberCreateRequest;
import dev.thangngo.dtos.requests.member.MemberUpdateRequest;
import dev.thangngo.dtos.responses.member.MemberDetailResponse;
import dev.thangngo.dtos.responses.member.MemberResponse;
import dev.thangngo.entities.Member;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member toEntity(MemberCreateRequest request);

    MemberResponse toResponse(Member entity);

    MemberDetailResponse toDetailResponse(Member entity);

    void updateEntity(@MappingTarget Member entity, MemberUpdateRequest request);
}
