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
    public ResponseEntity getAccomodationList(AccomodationRequestDto requestDto) {
        LOGGER.debug("AccomodationRequestDto : {}", requestDto);
        return new ResponseEntity(accomodationService.getAccomodationResponseDtoList(requestDto), HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity getPrices() {
        return new ResponseEntity(accomodationService.getPrices(), HttpStatus.OK);
    }
}
