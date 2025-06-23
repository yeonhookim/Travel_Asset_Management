package org.scoula.backend.service;

// 실제 비즈니스 로직 구현체

import org.scoula.backend.dto.LoginRequest;
import org.scoula.backend.dto.MemberDTO;
import org.scoula.backend.mapper.MemberMapper;
import org.scoula.backend.util.PasswordEncoderUtil; // ← 암호화 유틸 import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServicelmpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void signup(MemberDTO memberDTO) {

        // 회원가입 시 암호화 적용
        String encodedPw = PasswordEncoderUtil.encode(memberDTO.getPassword());
        memberDTO.setPassword(encodedPw);

        // 비밀번호 암호화는 추후 추가
        memberMapper.insertMember(memberDTO); // 회원정보 저장
    }

    // 로그인 로직 구현
    @Override
    public MemberDTO login(LoginRequest request) {
        // DB에서 username으로 회원 정보 조회
        MemberDTO member = memberMapper.findByUsername(request.getUsername());

        // 조회된 회원이 있고, 비밀번호가 일치하는 경우
        if (member != null && PasswordEncoderUtil.matches(request.getPassword(), member.getPassword())) {
            return member; // 로그인 성공
        }
        return null; // 로그인 실패
    }

    // username으로 회원 조회
    @Override
    public MemberDTO findById(String username) {
        return memberMapper.findById(username);
    }

    // 회원 정보 수정 처리
    @Override
    public void updateMember(MemberDTO member) {
        memberMapper.updateMember(member);
    }


}
