package dev.thangngo.services;

import dev.thangngo.dtos.requests.member.MemberCreateRequest;
import dev.thangngo.dtos.requests.member.MemberUpdateRequest;
import dev.thangngo.dtos.responses.member.MemberDetailResponse;
import dev.thangngo.dtos.responses.member.MemberResponse;

import java.util.List;

public interface MemberService {
    MemberResponse createMember(MemberCreateRequest request);
    MemberResponse updateMember(int id, MemberUpdateRequest request);
    MemberDetailResponse getMemberById(int id);
    List<MemberResponse> getAllMembers();
    void deleteMember(int id);
}
