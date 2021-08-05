# 🏠 airbnb-team06

# 팀원 소개

### [BE] 🧑‍💻 [Cooper](https://github.com/pbg0205)

### [FE] 🧑‍💻 [Q](https://github.com/somedaycode)

### [iOS] 🧑‍💻 [BMO](https://github.com/BMO5)

<br><br>

## 프로젝트 목표

- airbnb 방식의 숙소 예약 서비스를 구현한다
- 가격 범위를 조정하는 차트를 구현한다
- 지도 API 사용

### 기술 스택

- React
- TypeScript
- Styled-components
- Recoil

## FE 시연

### 달력 컴포넌트

https://user-images.githubusercontent.com/71962505/127313343-45b9bb54-255b-4426-90a0-b79660579364.mp4

### SVG 요금 차트

https://user-images.githubusercontent.com/71962505/127313338-ee29a426-4b3a-48a2-9881-ecad042844b7.mp4

### 지도 API 활용

https://user-images.githubusercontent.com/71962505/127313333-f30267b8-4a67-400e-8341-c03902e3b750.mp4

## 주요 설명

- 라이브러리를 사용하지 않고 Date 객체로 달력 캐러셀 구현
- 멀티 슬라이더를 이용하여 SVG로 요금 그래프 구현
- 로딩시 스켈레톤 UI를 적용
- 카카오 지도 API 사용하여 기간/요금/인원에 따른 숙소 필터링 기능 구현
- 숙소 검색 조건에 따른 데이터 시각화 (지도에 숙소 표시)
- React.memo와 useMemo, useCallback을 사용하며 관련 Hook에 대해 공부하며 최적화에 대한 개념을 학습
- Recoil 상태 관리 라이브러리를 사용

## 협업 방식

- 매일 오전 10시 팀원들과의 스크럼을 통해 서로의 컨디션을 확인하고 개발 중 마주한 문제점을 공유하고 하루의 목표를 세움!
- 노션을 활용하여 요구사항을 함께 분석하고 기능별로 날짜를 정해 step by step으로 목적을 달성해나아감!
- 간단한 개발 진행사항 공유나 대화가 필요할 땐 슬랙으로 이야기 후 zoom, gatherTown을 이용해 화상회의 시간을 가짐!

## 개발 중 고민거리

**고민 1** - [가격 그래프를 만들기 위해 div, SVG 혹은 Canvas 어떤 것을 사용해야 좋을까?](https://github.com/somedaycode/airbnb/wiki/%EA%B0%80%EA%B2%A9-%EA%B7%B8%EB%9E%98%ED%94%84%EB%A5%BC-%EB%A7%8C%EB%93%A4%EA%B8%B0-%EC%9C%84%ED%95%B4-div,-SVG-%ED%98%B9%EC%9D%80-Canvas-%EC%96%B4%EB%96%A4-%EA%B2%83%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%B4%EC%95%BC-%EC%A2%8B%EC%9D%84%EA%B9%8C%3F)

- SVG 차트를 사용하여 가격 슬라이딩 그래프를 만들었다. div 태그로 가격 차트 프로토타입을 만들어본 결과로 사용자의 슬라이더 움직임에 따라 툭툭 끊기는 듯한 느낌을 지울 수 없었다. 이에 따라 polyline을 이용해 쉽게 선을 이을 수 있고 부드러운 움직임을 사용자에게 전달할 수 있는 SVG를 선택

**고민 2** - 마우스 움직임에 따른 지도 범위의 경도 위도 값으로 숙소를 렌더링

- 카카오 지도 API를 이용하여 onMouseUp 이벤트를 이용하여 지도 범위의 위도 경도를 구한 후 서버에 전달하였다.
- 카카오 지도 API 명세에 지도범위를 구할 수 있는 방법이 나와있다.

**고민 3** -[Recoil의 selector를 어떻게 활용할 수 있을까?](https://github.com/somedaycode/airbnb/wiki/Recoil%EC%9D%98-selector%EB%A5%BC-%EC%96%B4%EB%96%BB%EA%B2%8C-%ED%99%9C%EC%9A%A9%ED%95%A0-%EC%88%98-%EC%9E%88%EC%9D%84%EA%B9%8C%3F)

- 사용자의 숙소 조건 검색에 따른 상태를 selector 함수를 넘겨주어 조건이 변경 될 때마다 서버에 데이터를 요청하고 받았다.

**고민 4** - 무분별한 네트워크 요청을 최소화하려면? 

- 디바운스와 스로틀링을 활용

