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
            case "insert" : errorMessage = "여행 등록에 실패했습니다."; break;
            case "update" : errorMessage = "여행 수정에 실패했습니다."; break;
            case "delete" : errorMessage = "여행 삭제에 실패했습니다."; break;
        }
        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode){
            case "insert" : successMessage = "여행 등록이 완료 되었습니다."; break;
            case "update" : successMessage = "여행 수정이 완료 되었습니다."; break;
            case "delete" : successMessage = "여행 삭제가 완료 되었습니다."; break;
        }
        System.out.println(successMessage);
    }
}
