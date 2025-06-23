package org.scoula.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.scoula.backend.dto.TripDTO;

import java.util.List;

@Mapper
public interface TripMapper {
    List<TripDTO> findTripsByMemberId(int memberId);
}