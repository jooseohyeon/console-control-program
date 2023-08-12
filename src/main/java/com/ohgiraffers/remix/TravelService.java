package com.ohgiraffers.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.remix.Template.getSqlSession;

public class TravelService {

    private TravelMapper travelMapper;

    public List<TravelDTO> selectAllTravel() {

        SqlSession sqlSession = getSqlSession();

        travelMapper = sqlSession.getMapper(TravelMapper.class);
        List<TravelDTO> travelList = travelMapper.selectAllTravel();

        sqlSession.close();

        return travelList;
    }
}
