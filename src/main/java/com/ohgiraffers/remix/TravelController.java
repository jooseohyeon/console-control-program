package com.ohgiraffers.remix;

import java.util.List;
import java.util.Map;

public class TravelController {
   private final TravelService travelService;
   private final PrintResult printResult;

   public TravelController(){
       travelService = new TravelService();
       printResult = new PrintResult();
   }

    public void selectAllMenu() {
       List<TravelDTO> travelList = travelService.selectAllTravel();

       if(travelList != null){
           printResult.printTravelList(travelList);
       } else {
           printResult.printErrorMessage("selectList");
       }
    }

    public void registTravel(Map<String, String> parameter) {

       String name = parameter.get("name");
       String location = parameter.get("location");
       int day = Integer.parseInt(parameter.get("day"));
       int continentCode = Integer.parseInt(parameter.get("continentCode"));
       int budget = Integer.parseInt(parameter.get("budget"));
       String registStatus = parameter.get("registStatus");

       TravelDTO travel = new TravelDTO();
       travel.setCountry(name);
       travel.setLocation(location);
       travel.setDay(day);
       travel.setContinentCode(continentCode);
       travel.setBudget(budget);
       travel.setRegistStatus(registStatus);

        if(travelService.registTravel(travel)){
            printResult.printSuccessMessage("insert");
        }else{
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyTravel(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        String location = parameter.get("location");
        int day = Integer.parseInt(parameter.get("day"));
        int continentCode = Integer.parseInt(parameter.get("continentCode"));
        int budget = Integer.parseInt(parameter.get("budget"));
        String registStatus = parameter.get("registStatus");

        TravelDTO travel = new TravelDTO();
        travel.setCode(code);
        travel.setCountry(name);
        travel.setLocation(location);
        travel.setDay(day);
        travel.setContinentCode(continentCode);
        travel.setBudget(budget);
        travel.setRegistStatus(registStatus);

        if(travelService.modifyTravel(travel)){
            printResult.printSuccessMessage("update");
        }else{
            printResult.printErrorMessage("update");
        }
    }

    public void deleteTravel(Map<String, String> parameter) {

       int code = Integer.parseInt(parameter.get("code"));

       if(travelService.deleteTravel(code)){
           printResult.printSuccessMessage("delete");
       } else{
           printResult.printErrorMessage("delete");
       }
    }
}
