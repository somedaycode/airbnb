package com.codsquad.airbnb.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccomodationRequestDto {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private int adults;
    private int children;
    private int infants;

    private int priceRangeMin;
    private int priceRangeMax;

    private double northEastLatitude;
    private double northEastLongitude;

    private double southWestLatitude;
    private double southWestLongitude;

    public AccomodationRequestDto(LocalDate checkInDate, LocalDate checkOutDate,
                                  int adults, int children, int infants,
                                  int priceRangeMin, int priceRangeMax,
                                  double northEastLatitude, double northEastLongitude,
                                  double southWestLatitude, double southWestLongitude) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.adults = adults;
        this.children = children;
        this.infants = infants;
        this.priceRangeMin = priceRangeMin;
        this.priceRangeMax = priceRangeMax;
        this.northEastLatitude = northEastLatitude;
        this.northEastLongitude = northEastLongitude;
        this.southWestLatitude = southWestLatitude;
        this.southWestLongitude = southWestLongitude;
    }

    @JsonSetter("check_in")
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = parseToLocalDate(checkInDate);
    }

    @JsonSetter("check_out")
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = parseToLocalDate(checkOutDate);
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setInfants(int infants) {
        this.infants = infants;
    }

    @JsonSetter("price_range_min")
    public void setPriceRangeMin(int priceRangeMin) {
        this.priceRangeMin = priceRangeMin;
    }

    @JsonSetter("price_range_max")
    public void setPriceRangeMax(int priceRangeMax) {
        this.priceRangeMax = priceRangeMax;
    }


    @JsonSetter("ne_lat")
    public void setNorthEastLatitude(double northEastLatitude) {
        this.northEastLatitude = northEastLatitude;
    }

    @JsonSetter("ne_lng")
    public void setNorthEastLongitude(double northEastLongitude) {
        this.northEastLongitude = northEastLongitude;
    }

    @JsonSetter("sw_lat")
    public void setSouthWestLatitude(double southWestLatitude) {
        this.southWestLatitude = southWestLatitude;
    }

    @JsonSetter("sw_lng")
    public void setSouthWestLongitude(double southWestLongitude) {
        this.southWestLongitude = southWestLongitude;
    }

    private LocalDate parseToLocalDate(String dateAsString) {
        return LocalDate.parse(dateAsString, DateTimeFormatter.ISO_DATE);
    }

    public double getNorthEastLatitude() {
        return northEastLatitude;
    }

    public double getNorthEastLongitude() {
        return northEastLongitude;
    }

    public double getSouthWestLatitude() {
        return southWestLatitude;
    }

    public double getSouthWestLongitude() {
        return southWestLongitude;
    }

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    public boolean isBoundaryLatitude(AccomodationResponseDto responseDto) {
        if (northEastLatitude < southWestLatitude) {
            throw new RuntimeException("남서쪽 위도 > 북동쪽 위도");
        }

        return (this.southWestLatitude <= responseDto.getLatitude()) &&
                (responseDto.getLatitude() <= this.northEastLatitude);
    }

    public boolean isBoundaryLongitude(AccomodationResponseDto responseDto) {
        if(northEastLongitude < southWestLongitude) {
            throw new RuntimeException("남서쪽 경도 > 북서쪽 경도");
        }

        return (this.southWestLatitude <= responseDto.getLongitude()) &&
                (responseDto.getLongitude() <= this.northEastLatitude);
    }

    public boolean isTotalMemberCount(AccomodationResponseDto responseDto) {
        return getTotalMemberCount() <= responseDto.getMaxMemberCapacity();
    }

    private int getTotalMemberCount() {
        return this.adults + this.children + this.infants;
    }

    public boolean isBoundaryPrice(AccomodationResponseDto responseDto) {
        if(!responseDto.isBoundaryPrice(this)) {
            throw new RuntimeException("가격 범위를 벗어났습니다.");
        }

        return responseDto.isBoundaryPrice(this);
    }

    @Override
    public String toString() {
        return "AccomodationRequestDto{" +
                "checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", adults=" + adults +
                ", children=" + children +
                ", infants=" + infants +
                ", priceRangeMin=" + priceRangeMin +
                ", getPriceRangeMax=" + priceRangeMax +
                ", northEastLatitude=" + northEastLatitude +
                ", northEastLongitude=" + northEastLongitude +
                ", southWestLatitude=" + southWestLatitude +
                ", southWestLongitude=" + southWestLongitude +
                '}';
    }
}
