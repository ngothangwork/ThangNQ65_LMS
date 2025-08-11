package dev.thangngo.services.impl;

import dev.thangngo.dtos.requests.member.MemberCreateRequest;
import dev.thangngo.dtos.requests.member.MemberUpdateRequest;
import dev.thangngo.dtos.responses.member.MemberDetailResponse;
import dev.thangngo.dtos.responses.member.MemberResponse;
import dev.thangngo.entities.Member;
import dev.thangngo.mappers.MemberMapper;
import dev.thangngo.repositories.MemberRepository;
import dev.thangngo.services.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    @Override
    public MemberResponse createMember(MemberCreateRequest request) {
        Member member = memberMapper.toEntity(request);
        memberRepository.save(member);
        return memberMapper.toResponse(member);
    }

    @Override
    public MemberResponse updateMember(int id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        memberMapper.updateEntity(member, request);
        memberRepository.save(member);
        return memberMapper.toResponse(member);
    }

    @Override
    public MemberDetailResponse getMemberById(int id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return memberMapper.toDetailResponse(member);
    }

    @Override
    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll()
                .stream()
                .map(memberMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteMember(int id) {
        if (!memberRepository.existsById(id)) {
            throw new RuntimeException("Member not found");
        }
        memberRepository.deleteById(id);
    }
}
