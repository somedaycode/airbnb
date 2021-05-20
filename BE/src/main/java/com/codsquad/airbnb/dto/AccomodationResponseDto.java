package com.codsquad.airbnb.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

public class AccomodationResponseDto {
    private String area;
    private String imageUrl;

    private String residentialType;
    private String reservationName;

    private int maxMemberCapacity;

    private int bedCount;
    private int bathRoomCount;
    private String option;

    private int pricePerDay;
    private int totalPrice;

    private double star;
    private int reviewCount;

    private double latitude;
    private double longitude;

    public AccomodationResponseDto(String area, String imageUrl, String residentialType, String reservationName,
                                   int maxMemberCapacity, int bedCount, int bathRoomCount, String option,
                                   int pricePerDay, int totalPrice,
                                   double star, int reviewCount,
                                   double latitude, double longitude) {
        this.area = area;
        this.imageUrl = imageUrl;
        this.residentialType = residentialType;
        this.reservationName = reservationName;
        this.maxMemberCapacity = maxMemberCapacity;
        this.bedCount = bedCount;
        this.bathRoomCount = bathRoomCount;
        this.option = option;
        this.pricePerDay = pricePerDay;
        this.totalPrice = totalPrice;
        this.star = star;
        this.reviewCount = reviewCount;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @JsonSetter("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonSetter("residential_type")
    public void setResidentialType(String residentialType) {
        this.residentialType = residentialType;
    }

    @JsonSetter("reservation_name")
    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    @JsonSetter("max_member_capacity")
    public void setMaxMemberCapacity(int maxMemberCapacity) {
        this.maxMemberCapacity = maxMemberCapacity;
    }

    @JsonSetter("bed_count")
    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    @JsonSetter("bath_room_count")
    public void setBathRoomCount(int bathRoomCount) {
        this.bathRoomCount = bathRoomCount;
    }

    @JsonSetter("option")
    public void setOption(String option) {
        this.option = option;
    }

    @JsonSetter("price_per_day")
    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @JsonSetter("total_price")
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStar(double star) {
        this.star = star;
    }

    @JsonSetter("review_count")
    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    @JsonSetter("lat")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @JsonSetter("lng")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getMaxMemberCapacity() {
        return maxMemberCapacity;
    }
}
