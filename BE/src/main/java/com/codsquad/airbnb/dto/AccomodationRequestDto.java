package com.codsquad.airbnb.dto;

import java.beans.ConstructorProperties;
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

    @ConstructorProperties({"check_in", "check_out", "adults", "children", "infants",
    "price_range_min", "price_range_max", "ne_lat", "ne_lng", "sw_lat", "sw_lng"})
    public AccomodationRequestDto(String checkInDate, String checkOutDate,
                                  int adults, int children, int infants,
                                  int priceRangeMin, int priceRangeMax,
                                  double northEastLatitude, double northEastLongitude,
                                  double southWestLatitude, double southWestLongitude) {
        this.checkInDate = parseToLocalDate(checkInDate);
        this.checkOutDate = parseToLocalDate(checkOutDate);
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

    private LocalDate parseToLocalDate(String dateAsString) {
        return LocalDate.parse(dateAsString, DateTimeFormatter.ISO_DATE);
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
