package com.codsquad.airbnb.controller;

import com.codsquad.airbnb.dto.AccomodationRequestDto;
import com.codsquad.airbnb.service.AccomodationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/accomodation")
public class AccomodationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccomodationController.class);

    private AccomodationService accomodationService;

    public AccomodationController(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @GetMapping("/search")
    public ResponseEntity getAccomodationList(@RequestParam("check_in")
                                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkIn,
                                              @RequestParam("check_out")
                                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOut,
                                              @RequestParam int adult,
                                              @RequestParam int children,
                                              @RequestParam int infants,
                                              @RequestParam("price_range_min") int priceRangeMin,
                                              @RequestParam("price_range_max") int priceRangeMax,
                                              @RequestParam("ne_lat") double northEastLatitude,
                                              @RequestParam("ne_lng") double northEastLongitude,
                                              @RequestParam("sw_lat") double southWestLatitude,
                                              @RequestParam("sw_lng") double southWestLongitude) {

        AccomodationRequestDto requestDto = new AccomodationRequestDto(checkIn, checkOut,
                adult, children, infants,
                priceRangeMin, priceRangeMax,
                northEastLatitude, northEastLongitude,
                southWestLatitude, southWestLongitude);

        LOGGER.debug("AccomodationRequestDto : {}", requestDto);

        return new ResponseEntity(accomodationService.getAccomodationResponseDtoList(requestDto), HttpStatus.OK);
    }
}
