package com.ohgiraffers.remix;

import java.util.List;

public class PrintResult {
    public void printTravelList(List<TravelDTO> travelList) {
        travelList.forEach(System.out::println);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode){
            case "selectList" : errorMessage = "여행 목록 조회에 실패했습니다."; break;
        }
        System.out.println(errorMessage);
    }
}
