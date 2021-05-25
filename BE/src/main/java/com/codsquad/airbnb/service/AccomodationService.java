package com.codsquad.airbnb.service;

import com.codsquad.airbnb.dto.AccomodationRequestDto;
import com.codsquad.airbnb.dto.AccomodationResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccomodationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccomodationService.class);

    public List<AccomodationResponseDto> getAccomodationResponseDtoList(AccomodationRequestDto requestDto) {
        List<AccomodationResponseDto> responseDtoList = findByAccomodations(requestDto);
        LOGGER.debug("AccomodationResponseDtoList : {}", responseDtoList);

        return findByAccomodations(requestDto);
    }

    private List<AccomodationResponseDto> findByAccomodations(AccomodationRequestDto requestDto) {

        List<AccomodationResponseDto> list = getAccomodationFromDb();

        return list.stream().filter(responseDto -> requestDto.isBoundaryLatitude(responseDto)
                && requestDto.isBoundaryLongitude(responseDto)
                && requestDto.isTotalMemberCount(responseDto)
                && requestDto.isBoundaryPrice(responseDto))
                .collect(Collectors.toList());
    }

    private List<AccomodationResponseDto> getAccomodationFromDb() {
        List<AccomodationResponseDto> list = new ArrayList<>();

        list.add(new AccomodationResponseDto("서울","/url/1","아파트 전체","제목1",1,4,2,"헤어드라이기",98065,392260,2,1,1.1,1));
        list.add(new AccomodationResponseDto("서울","/url/2","아파트 전체","제목2",1,8,2,"헤어드라이기",79376,317504,1,2,2.1,2));
        list.add(new AccomodationResponseDto("서울","/url/3","아파트 전체","제목3",1,2,1,"헤어드라이기",68482,273928,3,3,3.1,3));
        list.add(new AccomodationResponseDto("서울","/url/4","아파트 전체","제목4",1,8,1,"헤어드라이기",21692,86768,3,4,4.1,4));
        list.add(new AccomodationResponseDto("서울","/url/5","아파트 전체","제목5",1,10,2,"헤어드라이기",45522,182088,4,5,5.1,5));
        list.add(new AccomodationResponseDto("서울","/url/6","아파트 전체","제목6",1,6,2,"헤어드라이기",94407,377628,1,6,6.1,6));
        list.add(new AccomodationResponseDto("서울","/url/7","아파트 전체","제목7",1,1,2,"헤어드라이기",35004,140016,4,7,7.1,7));
        list.add(new AccomodationResponseDto("서울","/url/8","아파트 전체","제목8",1,7,2,"헤어드라이기",58680,234720,3,8,8.1,8));
        list.add(new AccomodationResponseDto("서울","/url/9","아파트 전체","제목9",1,8,2,"헤어드라이기",56034,224136,5,9,9.1,9));
        list.add(new AccomodationResponseDto("서울","/url/10","아파트 전체","제목10",1,9,2,"헤어드라이기",26707,106828,5,10,10.1,10));
        list.add(new AccomodationResponseDto("서울","/url/11","아파트 전체","제목11",2,1,2,"헤어드라이기",42815,171260,1,11,11.1,11));
        list.add(new AccomodationResponseDto("서울","/url/12","아파트 전체","제목12",2,6,1,"헤어드라이기",10449,41796,4,12,12.1,12));
        list.add(new AccomodationResponseDto("서울","/url/13","아파트 전체","제목13",2,6,1,"헤어드라이기",44079,176316,1,13,13.1,13));
        list.add(new AccomodationResponseDto("서울","/url/14","아파트 전체","제목14",2,5,2,"헤어드라이기",72658,290632,1,14,14.1,14));
        list.add(new AccomodationResponseDto("서울","/url/15","아파트 전체","제목15",2,1,2,"헤어드라이기",4985,19940,1,15,15.1,15));
        list.add(new AccomodationResponseDto("서울","/url/16","아파트 전체","제목16",2,2,1,"헤어드라이기",92277,369108,3,16,16.1,16));
        list.add(new AccomodationResponseDto("서울","/url/17","아파트 전체","제목17",2,7,2,"헤어드라이기",17952,71808,5,17,17.1,17));
        list.add(new AccomodationResponseDto("서울","/url/18","아파트 전체","제목18",2,6,2,"헤어드라이기",49132,196528,3,18,18.1,18));
        list.add(new AccomodationResponseDto("서울","/url/19","아파트 전체","제목19",2,5,2,"헤어드라이기",44323,177292,4,19,19.1,19));
        list.add(new AccomodationResponseDto("서울","/url/20","아파트 전체","제목20",2,2,1,"헤어드라이기",37663,150652,4,20,20.1,20));
        list.add(new AccomodationResponseDto("경기","/url/21","아파트 전체","제목21",3,2,2,"헤어드라이기",81805,327220,1,21,21.1,21));
        list.add(new AccomodationResponseDto("경기","/url/22","아파트 전체","제목22",3,2,1,"헤어드라이기",90411,361644,3,22,22.1,22));
        list.add(new AccomodationResponseDto("경기","/url/23","아파트 전체","제목23",3,5,1,"헤어드라이기",3722,14888,2,23,23.1,23));
        list.add(new AccomodationResponseDto("경기","/url/24","아파트 전체","제목24",3,6,1,"헤어드라이기",22036,88144,2,24,24.1,24));
        list.add(new AccomodationResponseDto("경기","/url/25","아파트 전체","제목25",3,5,1,"헤어드라이기",47177,188708,4,25,25.1,25));
        list.add(new AccomodationResponseDto("경기","/url/26","아파트 전체","제목26",3,2,2,"헤어드라이기",50984,203936,3,26,26.1,26));
        list.add(new AccomodationResponseDto("경기","/url/27","아파트 전체","제목27",3,3,2,"헤어드라이기",26883,107532,1,27,27.1,27));
        list.add(new AccomodationResponseDto("경기","/url/28","아파트 전체","제목28",3,9,1,"헤어드라이기",64727,258908,4,28,28.1,28));
        list.add(new AccomodationResponseDto("경기","/url/29","아파트 전체","제목29",3,4,1,"헤어드라이기",99655,398620,4,29,29.1,29));
        list.add(new AccomodationResponseDto("경기","/url/30","아파트 전체","제목30",3,8,1,"헤어드라이기",26003,104012,2,30,30.1,30));
        list.add(new AccomodationResponseDto("경기","/url/31","아파트 전체","제목31",4,4,1,"헤어드라이기",78154,312616,3,31,31.1,31));
        list.add(new AccomodationResponseDto("경기","/url/32","아파트 전체","제목32",4,10,1,"헤어드라이기",71016,284064,4,32,32.1,32));
        list.add(new AccomodationResponseDto("경기","/url/33","아파트 전체","제목33",4,5,1,"헤어드라이기",69522,278088,2,33,33.1,33));
        list.add(new AccomodationResponseDto("경기","/url/34","아파트 전체","제목34",4,7,2,"헤어드라이기",89528,358112,4,34,34.1,34));
        list.add(new AccomodationResponseDto("경기","/url/35","아파트 전체","제목35",4,5,2,"헤어드라이기",99999,399996,2,35,35.1,35));
        list.add(new AccomodationResponseDto("경기","/url/36","아파트 전체","제목36",4,1,1,"헤어드라이기",53511,214044,2,36,36.1,36));
        list.add(new AccomodationResponseDto("경기","/url/37","아파트 전체","제목37",4,2,2,"헤어드라이기",36587,146348,1,37,37.1,37));
        list.add(new AccomodationResponseDto("경기","/url/38","아파트 전체","제목38",4,6,1,"헤어드라이기",42238,168952,1,38,38.1,38));
        list.add(new AccomodationResponseDto("경기","/url/39","아파트 전체","제목39",4,5,2,"헤어드라이기",64519,258076,1,39,39.1,39));
        list.add(new AccomodationResponseDto("경기","/url/40","아파트 전체","제목40",4,3,2,"헤어드라이기",2699,10796,5,40,40.1,40));
        list.add(new AccomodationResponseDto("충청","/url/41","아파트 전체","제목41",5,9,2,"헤어드라이기",58879,235516,4,41,41.1,41));
        list.add(new AccomodationResponseDto("충청","/url/42","아파트 전체","제목42",5,2,1,"헤어드라이기",54866,219464,2,42,42.1,42));
        list.add(new AccomodationResponseDto("충청","/url/43","아파트 전체","제목43",5,8,1,"헤어드라이기",61481,245924,1,43,43.1,43));
        list.add(new AccomodationResponseDto("충청","/url/44","아파트 전체","제목44",5,3,1,"헤어드라이기",60175,240700,3,44,44.1,44));
        list.add(new AccomodationResponseDto("충청","/url/45","아파트 전체","제목45",5,3,2,"헤어드라이기",52486,209944,4,45,45.1,45));
        list.add(new AccomodationResponseDto("충청","/url/46","아파트 전체","제목46",5,1,1,"헤어드라이기",91415,365660,5,46,46.1,46));
        list.add(new AccomodationResponseDto("충청","/url/47","아파트 전체","제목47",5,9,2,"헤어드라이기",79485,317940,4,47,47.1,47));
        list.add(new AccomodationResponseDto("충청","/url/48","아파트 전체","제목48",5,5,1,"헤어드라이기",84894,339576,2,48,48.1,48));
        list.add(new AccomodationResponseDto("충청","/url/49","아파트 전체","제목49",5,7,2,"헤어드라이기",65517,262068,5,49,49.1,49));
        list.add(new AccomodationResponseDto("충청","/url/50","아파트 전체","제목50",5,7,2,"헤어드라이기",97057,388228,3,50,50.1,50));
        list.add(new AccomodationResponseDto("충청","/url/51","아파트 전체","제목51",6,1,2,"헤어드라이기",79155,316620,5,51,51.1,51));
        list.add(new AccomodationResponseDto("충청","/url/52","아파트 전체","제목52",6,3,1,"헤어드라이기",92714,370856,1,52,52.1,52));
        list.add(new AccomodationResponseDto("충청","/url/53","아파트 전체","제목53",6,9,1,"헤어드라이기",83041,332164,3,53,53.1,53));
        list.add(new AccomodationResponseDto("충청","/url/54","아파트 전체","제목54",6,5,2,"헤어드라이기",39640,158560,4,54,54.1,54));
        list.add(new AccomodationResponseDto("충청","/url/55","아파트 전체","제목55",6,6,2,"헤어드라이기",27692,110768,2,55,55.1,55));
        list.add(new AccomodationResponseDto("충청","/url/56","아파트 전체","제목56",6,4,1,"헤어드라이기",92578,370312,3,56,56.1,56));
        list.add(new AccomodationResponseDto("충청","/url/57","아파트 전체","제목57",6,1,1,"헤어드라이기",71834,287336,4,57,57.1,57));
        list.add(new AccomodationResponseDto("충청","/url/58","아파트 전체","제목58",6,4,1,"헤어드라이기",850,3400,5,58,58.1,58));
        list.add(new AccomodationResponseDto("충청","/url/59","아파트 전체","제목59",6,4,2,"헤어드라이기",62617,250468,2,59,59.1,59));
        list.add(new AccomodationResponseDto("충청","/url/60","아파트 전체","제목60",6,4,2,"헤어드라이기",38871,155484,2,60,60.1,60));
        list.add(new AccomodationResponseDto("강원","/url/61","아파트 전체","제목61",7,9,1,"헤어드라이기",23811,95244,4,61,61.1,61));
        list.add(new AccomodationResponseDto("강원","/url/62","아파트 전체","제목62",7,3,2,"헤어드라이기",23331,93324,1,62,62.1,62));
        list.add(new AccomodationResponseDto("강원","/url/63","아파트 전체","제목63",7,2,1,"헤어드라이기",79226,316904,1,63,63.1,63));
        list.add(new AccomodationResponseDto("강원","/url/64","아파트 전체","제목64",7,4,2,"헤어드라이기",68792,275168,3,64,64.1,64));
        list.add(new AccomodationResponseDto("강원","/url/65","아파트 전체","제목65",7,8,1,"헤어드라이기",85323,341292,4,65,65.1,65));
        list.add(new AccomodationResponseDto("강원","/url/66","아파트 전체","제목66",7,7,2,"헤어드라이기",33433,133732,1,66,66.1,66));
        list.add(new AccomodationResponseDto("강원","/url/67","아파트 전체","제목67",7,10,1,"헤어드라이기",91052,364208,2,67,67.1,67));
        list.add(new AccomodationResponseDto("강원","/url/68","아파트 전체","제목68",7,1,2,"헤어드라이기",96054,384216,1,68,68.1,68));
        list.add(new AccomodationResponseDto("강원","/url/69","아파트 전체","제목69",7,3,1,"헤어드라이기",65771,263084,3,69,69.1,69));
        list.add(new AccomodationResponseDto("강원","/url/70","아파트 전체","제목70",7,1,2,"헤어드라이기",75795,303180,4,70,70.1,70));
        list.add(new AccomodationResponseDto("강원","/url/71","아파트 전체","제목71",8,8,2,"헤어드라이기",95530,382120,2,71,71.1,71));
        list.add(new AccomodationResponseDto("강원","/url/72","아파트 전체","제목72",8,5,2,"헤어드라이기",87742,350968,3,72,72.1,72));
        list.add(new AccomodationResponseDto("강원","/url/73","아파트 전체","제목73",8,5,1,"헤어드라이기",3512,14048,5,73,73.1,73));
        list.add(new AccomodationResponseDto("강원","/url/74","아파트 전체","제목74",8,9,2,"헤어드라이기",15557,62228,1,74,74.1,74));
        list.add(new AccomodationResponseDto("강원","/url/75","아파트 전체","제목75",8,3,2,"헤어드라이기",88123,352492,1,75,75.1,75));
        list.add(new AccomodationResponseDto("강원","/url/76","아파트 전체","제목76",8,7,1,"헤어드라이기",59908,239632,3,76,76.1,76));
        list.add(new AccomodationResponseDto("강원","/url/77","아파트 전체","제목77",8,5,1,"헤어드라이기",29599,118396,4,77,77.1,77));
        list.add(new AccomodationResponseDto("강원","/url/78","아파트 전체","제목78",8,7,2,"헤어드라이기",86770,347080,4,78,78.1,78));
        list.add(new AccomodationResponseDto("강원","/url/79","아파트 전체","제목79",8,1,1,"헤어드라이기",7282,29128,5,79,79.1,79));
        list.add(new AccomodationResponseDto("강원","/url/80","아파트 전체","제목80",8,3,2,"헤어드라이기",89245,356980,4,80,80.1,80));
        list.add(new AccomodationResponseDto("전북","/url/81","아파트 전체","제목81",9,4,1,"헤어드라이기",10649,42596,1,81,81.1,81));
        list.add(new AccomodationResponseDto("전북","/url/82","아파트 전체","제목82",9,5,2,"헤어드라이기",91465,365860,2,82,82.1,82));
        list.add(new AccomodationResponseDto("전북","/url/83","아파트 전체","제목83",9,8,1,"헤어드라이기",59959,239836,1,83,83.1,83));
        list.add(new AccomodationResponseDto("전북","/url/84","아파트 전체","제목84",9,9,1,"헤어드라이기",53167,212668,1,84,84.1,84));
        list.add(new AccomodationResponseDto("전북","/url/85","아파트 전체","제목85",9,1,1,"헤어드라이기",70950,283800,5,85,85.1,85));
        list.add(new AccomodationResponseDto("전북","/url/86","아파트 전체","제목86",9,10,2,"헤어드라이기",82817,331268,5,86,86.1,86));
        list.add(new AccomodationResponseDto("경남","/url/87","아파트 전체","제목87",9,3,2,"헤어드라이기",72740,290960,1,87,87.1,87));
        list.add(new AccomodationResponseDto("경남","/url/88","아파트 전체","제목88",9,7,2,"헤어드라이기",78657,314628,3,88,88.1,88));
        list.add(new AccomodationResponseDto("경남","/url/89","아파트 전체","제목89",9,9,1,"헤어드라이기",90904,363616,2,89,89.1,89));
        list.add(new AccomodationResponseDto("경북","/url/90","아파트 전체","제목90",9,7,1,"헤어드라이기",97985,391940,4,90,90.1,90));

        return list;
    }

    public List<Integer> getPrices() {
        List<AccomodationResponseDto> list = getAccomodationFromDb();

        return list.stream().map(accomodation -> accomodation.getPricePerDay())
                .collect(Collectors.toList());
    }
}
