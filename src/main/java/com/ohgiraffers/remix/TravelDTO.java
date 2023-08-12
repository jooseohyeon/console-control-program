package com.ohgiraffers.remix;

public class TravelDTO {
    private int code;
    private int day;
    private String country;
    private String loca;
    private int continentCode;

    public TravelDTO() {
    }

    public TravelDTO(int code, int day, String country, String loca, int continentCode) {
        this.code = code;
        this.day = day;
        this.country = country;
        this.loca = loca;
        this.continentCode = continentCode;
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

    public String getLoca() {
        return loca;
    }

    public void setLoca(String loca) {
        this.loca = loca;
    }

    public int getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(int continentCode) {
        this.continentCode = continentCode;
    }

    @Override
    public String toString() {
        return "TravelDTO{" +
                "code=" + code +
                ", day=" + day +
                ", country='" + country + '\'' +
                ", loca='" + loca + '\'' +
                ", continentCode=" + continentCode +
                '}';
    }
}
