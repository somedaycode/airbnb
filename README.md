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

### 기술 스택

- React
- TypeScript
- Styled-components
- Recoil

## 기타 기능 목록

- 로그인
- 헤더와 메뉴는 호버 효과만 준다. (기능 X)
- 캘린더 모달
  - 화살표 클릭시 두 달 간격으로 캘린더가 슬라이딩
  - 선택 날짜에 따라 효과 변경
- 요금 (금액대 조정) 모달
- 선택 영역은 색칠
- 범위 밖 영역은 회색으로 처리
- 검색바에서 인원 영역 클릭 시 게스트 인원을 입력할 수 있는 모달창이 뜬다.
- 성인이 0인 상태에서 유아의 인원 수를 늘릴 시 성인의 인원수가 1로 변경된다.
- 검색 결과 및 지도
  - 검색바에서 입력한 조건으로 검색결과가 보여진다.
  - 지도는 드래그가 가능하다.
  - 지도의 움직임에 따라 숙소의 리스트가 변경된다.
