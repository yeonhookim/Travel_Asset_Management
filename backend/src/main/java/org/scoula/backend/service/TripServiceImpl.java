package org.scoula.backend.service;

import org.scoula.backend.dto.TripDTO;
import org.scoula.backend.mapper.TripMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripMapper tripMapper;

    @Override
    public List<TripDTO> getTripsByMemberId(int memberId) {
        return tripMapper.findTripsByMemberId(memberId);
    }

    @Override
    public void addTrip(TripDTO tripDTO) {
        tripMapper.insertTrip(tripDTO); // DB에 여행 추가
    }
}