package org.scoula.backend.dto;

// DB의 member 테이블과 매핑되는 데이터 전송 객체

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data // Getter, Setter, toString 등을 자동 생성
public class MemberDTO {
    private int memberId;                // 회원 고유 ID (Auto Increment)
    private String username;             // 로그인용 사용자명
    private String password;             // 암호화된 비밀번호
    private String nickname;             // 사용자 표시 이름
    private LocalDateTime createdAt;     // 가입일
    private LocalDateTime updatedAt;     // 마지막 수정일
}
