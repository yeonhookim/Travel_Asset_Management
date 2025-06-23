package org.scoula.backend.service;

// 서비스 계층 인터페이스

import org.scoula.backend.dto.LoginRequest;
import org.scoula.backend.dto.MemberDTO;

public interface MemberService {
    void signup(MemberDTO memberDTO); // 회원가입 로직
    MemberDTO login(LoginRequest request); // 로그인 요청 처리

    // ID로 회원 조회
    MemberDTO findById(String username);

    // 회원 정보 수정
    void updateMember(MemberDTO member);
}
