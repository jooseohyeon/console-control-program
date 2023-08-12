package com.ohgiraffers.remix;

import java.util.Scanner;

public class Application {
//    Application -> controller -> service -> mapper -> xml

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelController travelController = new TravelController();

        do{
            System.out.println("=============== 여행 관리 ===============");
            System.out.println("1. 여행 전체 조회");
            System.out.println("2. 검색으로 여행 목록 조회");
            System.out.println("3. 새로운 여행 추가");
            System.out.println("4. 여행 수정");
            System.out.println("5. 여행 삭제");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택하세요 : ");
            int no = sc.nextInt();

            switch (no){
                case 1 : travelController.selectAllMenu(); break;
                case 2 : travelController.break;
                case 3 : break;
                case 4 : break;
                case 5 : break;
                case 9 :
                    System.out.println("프로그램을 종료합니다."); return;
            }

        }while(true);
    }
}
