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
    private int getPriceRangeMax;

    private double northEastLatitude;
    private double northEastLongitude;

    private double southWestLatitude;
    private double southWestLongitude;

    public AccomodationRequestDto(LocalDate checkInDate, LocalDate checkOutDate,
                                  int adults, int children, int infants,
                                  int priceRangeMin, int getPriceRangeMax,
                                  double northEastLatitude, double northEastLongitude,
                                  double southWestLatitude, double southWestLongitude) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.adults = adults;
        this.children = children;
        this.infants = infants;
        this.priceRangeMin = priceRangeMin;
        this.getPriceRangeMax = getPriceRangeMax;
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
    public void setGetPriceRangeMax(int getPriceRangeMax) {
        this.getPriceRangeMax = getPriceRangeMax;
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

    public boolean isBoundaryLatitude(AccomodationResponseDto responseDto) {
        return (this.southWestLatitude <= responseDto.getLatitude()) &&
                (responseDto.getLatitude() <= this.northEastLatitude);
    }

    public boolean isBoundaryLongitude(AccomodationResponseDto responseDto) {
        return (this.southWestLatitude <= responseDto.getLongitude()) &&
                (responseDto.getLongitude() <= this.northEastLatitude);
    }

    public boolean isTotalMemberCount(AccomodationResponseDto responseDto) {
        return getTotalMemberCount() == responseDto.getMaxMemberCapacity();
    }

    private int getTotalMemberCount() {
        return this.adults + this.children + this.infants;
    }
}
