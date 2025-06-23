package org.scoula.backend.mapper;

// MyBatis SQL과 연결괴는 Mapper 인터페이스

import org.apache.ibatis.annotations.Mapper;
import org.scoula.backend.dto.MemberDTO;

@Mapper // MyBatis 매퍼 인터페이스로 등록
public interface MemberMapper {
    void insertMember(MemberDTO member);         // 회원가입 (INSERT 쿼리 실행)
    MemberDTO findByUsername(String username);   // 아이디 중복 확인용 SELECT, username으로 회원 조회

    MemberDTO findById(String username); // 사용자의 ID(username)로 회원 정보를 조회하는 메서드
    void updateMember(MemberDTO member); // 회원 정보를 수정하는 메서드 (이름, 이메일 등)
}
