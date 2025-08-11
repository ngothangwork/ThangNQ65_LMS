package dev.thangngo.controllers;

import dev.thangngo.dtos.requests.member.MemberCreateRequest;
import dev.thangngo.dtos.requests.member.MemberUpdateRequest;
import dev.thangngo.dtos.responses.member.MemberDetailResponse;
import dev.thangngo.dtos.responses.member.MemberResponse;
import dev.thangngo.services.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberResponse> createMember(
            @Valid @RequestBody MemberCreateRequest request) {
        return ResponseEntity.ok(memberService.createMember(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponse> updateMember(
            @PathVariable("id") int id,
            @Valid @RequestBody MemberUpdateRequest request) {
        return ResponseEntity.ok(memberService.updateMember(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDetailResponse> getMemberById(@PathVariable int id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable("id") int id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
