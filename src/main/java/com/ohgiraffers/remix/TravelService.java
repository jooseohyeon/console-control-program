package com.ohgiraffers.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void selectByBudget(int budget) {
        SqlSession sqlSession = getSqlSession();
        travelMapper = sqlSession.getMapper(TravelMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("budget", budget);

        List<TravelDTO> travelList = travelMapper.selectByBudget(map);

        if (travelList != null && travelList.size() > 0) {
            travelList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public void searchTravel(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        travelMapper = sqlSession.getMapper(TravelMapper.class);

        List<TravelDTO> travelList = travelMapper.searchTravel(searchCriteria);

        if (travelList != null && travelList.size() > 0) {
            travelList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public boolean registTravel(TravelDTO travel) {

        SqlSession sqlSession = getSqlSession();
        travelMapper = sqlSession.getMapper(TravelMapper.class);

        int result = travelMapper.insertTravel(travel);

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0;
    }

    public boolean modifyTravel(TravelDTO travel) {

        SqlSession sqlSession = getSqlSession();
        travelMapper = sqlSession.getMapper(TravelMapper.class);

        int result = travelMapper.updateTravel(travel);

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0;
    }

    public boolean deleteTravel(int code) {

        SqlSession sqlSession = getSqlSession();
        travelMapper = sqlSession.getMapper(TravelMapper.class);

        int result = travelMapper.deleteTravel(code);

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0;
    }
}
