package org.scoula.backend.dto;

import lombok.Data;

/**
 * 로그인 시 사용자로부터 받은 ID와 비밀번호를 담는 DTO
 */
@Data
public class LoginRequest {
    private String username; // 사용자 로그인 ID
    private String password; // 사용자 입력 비밀번호
}