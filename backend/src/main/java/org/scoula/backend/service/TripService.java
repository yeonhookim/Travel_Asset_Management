package org.scoula.backend.service;

import org.scoula.backend.dto.TripDTO;

import java.util.List;

public interface TripService {
    List<TripDTO> getTripsByMemberId(int memberId);

    void addTrip(TripDTO tripDTO); // 여행 등록 메서드
}