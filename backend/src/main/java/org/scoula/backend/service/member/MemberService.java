package org.scoula.backend.service.member;

import org.scoula.backend.dto.member.MemberRequest;
import org.scoula.backend.dto.member.MemberResponse;

public interface MemberService {
    void signup(MemberRequest request);
    MemberResponse login(String username, String password);
    MemberResponse findById(Long id);
}