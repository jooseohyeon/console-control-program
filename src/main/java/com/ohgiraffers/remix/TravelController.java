package com.ohgiraffers.remix;

import java.util.List;

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
}
