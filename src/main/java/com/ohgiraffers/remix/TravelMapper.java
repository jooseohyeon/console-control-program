package com.ohgiraffers.remix;

import java.util.List;
import java.util.Map;

public interface TravelMapper {
    List<TravelDTO> selectAllTravel();

    List<TravelDTO> selectByBudget(Map<String, Integer> map);

    List<TravelDTO> searchTravel(SearchCriteria searchCriteria);

    int insertTravel(TravelDTO travel);

    int updateTravel(TravelDTO travel);

    int deleteTravel(int code);
}
