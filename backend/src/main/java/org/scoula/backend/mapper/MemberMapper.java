package org.scoula.backend.mapper;

// MyBatis SQL과 연결괴는 Mapper 인터페이스

import org.apache.ibatis.annotations.Mapper;
import org.scoula.backend.dto.MemberDTO;

@Mapper // MyBatis 매퍼 인터페이스로 등록
public interface MemberMapper {
    void insertMember(MemberDTO member);         // 회원가입 (INSERT 쿼리 실행)
    MemberDTO findByUsername(String username);   // 아이디 중복 확인용 SELECT, username으로 회원 조회

}
