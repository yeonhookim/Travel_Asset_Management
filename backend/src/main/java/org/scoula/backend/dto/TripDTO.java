package org.scoula.backend.dto;

import lombok.Data;

@Data
public class TripDTO {
    private int id;             // 여행 ID
    private int memberId;       // 여행을 등록한 회원 ID
    private String title;       // 여행 제목
    private String destination; // 여행지
    private String startDate;   // 시작 날짜
    private String endDate;     // 종료 날짜
}