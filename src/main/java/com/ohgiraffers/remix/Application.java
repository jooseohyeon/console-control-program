package com.ohgiraffers.remix;

import java.util.*;

public class Application {
//    Application -> controller -> service -> mapper -> xml

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelController travelController = new TravelController();

        do {
            System.out.println("=============== 여행 관리 ===============");
            System.out.println("1. 여행 전체 조회");
            System.out.println("2. 검색으로 여행 목록 조회");
            System.out.println("3. 새로운 여행 추가");
            System.out.println("4. 여행 수정");
            System.out.println("5. 여행 삭제");
            System.out.println("6. 랜덤으로 여행 5개 조회하기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    travelController.selectAllMenu();
                    break;
                case 2:
                    ifSubMenu();
                    break;
                case 3:
                    travelController.registTravel(inputTravel());
                    break;
                case 4:
                    travelController.modifyTravel(inputModifyTravel());
                    break;
                case 5:
                    travelController.deleteTravel(inputTravelCode());
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }

        } while (true);
    }

    private static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        TravelService travelService = new TravelService();

        do {
            System.out.println("=========== 검색으로 여행 목록 조회 ==========");
            System.out.println("1. 원하는 예산에 맞춰 여행 추천받기");
            System.out.println("2. 대륙 혹은 나라이름으로 여행 검색하기");
            System.out.println("9. 이전 목록으로");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    travelService.selectByBudget(inputBudget());
                    break;
                case 2:
                    travelService.searchTravel(inputSearchCriteria());
                    break;
                case 9:
                    return;
            }
        } while (true);
    }

    private static int inputBudget() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색하실 예산의 최대 금액을 입력하세요 : ");
        int budget = sc.nextInt();

        return budget;
    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner sc = new Scanner(System.in);

        System.out.print("검색 기준을 입력해주세요(대륙 or 나라이름) : ");
        String condition = sc.nextLine();
        System.out.print("검색하실 단어를 입력해주세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

    private static Map<String, String> inputTravel() {

        Scanner sc = new Scanner(System.in);
        System.out.println("=============== 여행 수정하기 ===============");
        System.out.println("(1.남미 2.북미 3.아시아 4.아프리카 5.오세아니아 6.유럽)");
        System.out.print("여행한 나라의 대륙코드 입력하세요 : ");
        String continentCode = sc.nextLine();
        System.out.print("여행한 나라 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("여행한 지역 이름을 입력하세요 : ");
        String location = sc.nextLine();
        System.out.print("여행한 일 수를 입력하세요 : ");
        String day = sc.nextLine();
        System.out.print("여행에 든 예산을 입력해주세요 : ");
        String budget = sc.nextLine();
        System.out.print("여행을 공개하시겠습니까? (Y/N) : ");
        String registStatus = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("location", location);
        parameter.put("day", day);
        parameter.put("continentCode", continentCode);
        parameter.put("budget", budget);
        parameter.put("registStatus", registStatus);

        return parameter;
    }

    private static Map<String, String> inputModifyTravel() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 여행 코드를 입력해주세요 : ");
        String code = sc.nextLine();
        System.out.println("(1.남미 2.북미 3.아시아 4.아프리카 5.오세아니아  6.유럽)");
        System.out.print("수정할 나라의 대륙코드 입력하세요 : ");
        String continentCode = sc.nextLine();
        System.out.print("수정할 나라 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("수정할 지역 이름을 입력하세요 : ");
        String location = sc.nextLine();
        System.out.print("수정할 일 수를 입력하세요 : ");
        String day = sc.nextLine();
        System.out.print("수정할 예산을 입력해주세요 : ");
        String budget = sc.nextLine();
        System.out.print("여행을 공개하시겠습니까? (Y/N) : ");
        String registStatus = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("location", location);
        parameter.put("day", day);
        parameter.put("continentCode", continentCode);
        parameter.put("budget", budget);
        parameter.put("registStatus", registStatus);

        return parameter;
    }

    private static Map<String, String> inputTravelCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }
}

