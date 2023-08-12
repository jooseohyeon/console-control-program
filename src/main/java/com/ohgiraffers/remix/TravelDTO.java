package com.ohgiraffers.remix;

public class TravelDTO {
  private int code;
  private int day;
  private String country;
  private String location;
  private int continentCode;
  private int budget;
  private String registStatus;

    public TravelDTO() {
    }

    public TravelDTO(int code, int day, String country, String location, int continentCode, int budget, String registStatus) {
        this.code = code;
        this.day = day;
        this.country = country;
        this.location = location;
        this.continentCode = continentCode;
        this.budget = budget;
        this.registStatus = registStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(int continentCode) {
        this.continentCode = continentCode;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getRegistStatus() {
        return registStatus;
    }

    public void setRegistStatus(String registStatus) {
        this.registStatus = registStatus;
    }

    @Override
    public String toString() {
        return "TravelDTO{" +
                "code=" + code +
                ", day=" + day +
                ", country='" + country + '\'' +
                ", location='" + location + '\'' +
                ", continentCode=" + continentCode +
                ", budget=" + budget +
                ", registStatus='" + registStatus + '\'' +
                '}';
    }
}
