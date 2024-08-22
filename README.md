# DE30-3nd-5
## 서울시 여행지 추천 웹 사이트 프로젝트



## 아이디어

여행을 떠나기 위해서는 어느 곳을 구경할 지, 어떤 것들을 경험할 지 꼼꼼히 계획해야 한다. 

이러한 과정은 많은 시간과 노력을 필요로 하며, 잘못된 선택은 여행의 질을 떨어뜨리기도 한다.

이번 스프링부트 프로젝트에서는 **효율적인 서울 여행 계획을 위한 서비스**를 제공한다.

서비스는 사용자의 여행 취향과 목적에 맞춘 장소를 보여주는 기능을 담고 있다.


## 데이터

### 서울시 관광지 및 숙박 데이터

관광 타입 : 관광지 / 문화시설 / 레포츠 / 축제공연행사 / 쇼핑

출처 : TourAPI - 맞춤형 데이터 (https://api.visitkorea.or.kr/#/hubTourSearch)

### Maria DB에 데이터 적재

**tourspot 테이블(서울시 관광지 데이터)**

![Untitled (8)](https://github.com/user-attachments/assets/bd5ef26e-ea2f-4b2e-873d-2862823a7a94)

placename(관광지 이름)

addr(주소)

mapx, mapy (위도, 경도)

overview (개요)

detail (설명)

tourtype (관광 타입)

**hotel 테이블(서울시 숙박 업소 데이터)**

![Untitled (9)](https://github.com/user-attachments/assets/be159a2e-b04b-4fed-b579-054a19aa862e)


placename(숙박 업소 이름)

addr(주소)

mapx, mapy (위도, 경도)

overview (개요)

detail (설명)

reservation (예약 정보)

tourtype (관광 타입)


## 관광지 추천 시스템 시나리오

### 메인 페이지

![Untitled (10)](https://github.com/user-attachments/assets/b4b084f8-2efc-4d94-a851-651ed5909413)

제목 : 서울시 관광지 숙박 예약

입력필드 : 

- 아이디 input
- 비밀번호 input

버튼 :

- 로그인
- 회원가입
- SNS 로그인

사진 : 서울시 전경 사진

### 회원가입 페이지

[Untitled (11)](https://github.com/user-attachments/assets/8f3d55f2-e7b2-4e14-bca6-6c2ce3c46af8)

입력필드 : 

- 이름 input
- 아이디 input
- 비밀번호 input
- 이메일 input

버튼 : 회원가입 완료 (로그인 페이지로 이동)

### 설문조사 페이지

![Untitled (12)](https://github.com/user-attachments/assets/ec8e0437-27bc-47f5-807b-c7b11cf35ac2)

제목 : 당신의 여행 취향을 알려주세요

선택 항목 :

- 유명 관광지는 무조건 가야 해요
- 액티비티한 스포츠 활동을 좋아해요
- 쇼핑하는 것을 좋아해요
- 문화재 관람을 좋아해요
- 축제와 공연 관람을 좋아해요

버튼 : 여행지 추천 받기

### 여행지 추천 리스트

![Untitled (13)](https://github.com/user-attachments/assets/f2ca7119-9890-456f-a2cc-764c832ae77d)

제목 : 당신에게 맞는 여행지 추천해줄게요

여행지 리스트 : 설문조사 결과에 따라 추천된 여행지들의 리스트

- 각 여행지에 대한 간단한 설명, 이미지, 링크 등
- 클릭 가능한 항목들로 구성

지도 : 지도에 여행지 리스트에서 선택된 항목을 핀으로 표시

- 인터랙티브 지도 기능 (확대/축소, 이동 등 가능)
- 핀을 클릭하면 해당 여행지의 자세한 정보 표시

숙소 리스트 : 

- 원하는 여행지 선택 시 근처의 숙소 보여주기
- 이미지, 가격, 링크 등

### 찜 리스트

![Untitled (14)](https://github.com/user-attachments/assets/7c936081-995d-454f-9b3a-916d7c6f7af1)
제목 : 찜 리스트

버튼 : 

- 전체선택
- 삭제

여행지 리스트 : 찜한 여행지 리스트

체크박스 : 항목을 선택하여 삭제하기

# **스프링 프로젝트 구조**

com.yourcompany.travelapp
├── TravelAppApplication.java
├── config
│   └── WebConfig.java
├── controller
│   ├── AccommodationController.java
│   ├── PlaceController.java
│   ├── ReservationController.java
│   ├── UserController.java
│   └── SurveyController.java
├── dto
│   ├── AccommodationDTO.java
│   ├── PlaceDTO.java
│   ├── ReservationDTO.java
│   ├── UserDTO.java
│   └── SurveyDTO.java
├── entity
│   ├── User.java
│   ├── Profile.java
│   ├── Place.java
│   ├── Accommodation.java
│   ├── Reservation.java
│   ├── Review.java
│   ├── Survey.java
│   ├── Favorite.java
│   └── Message.java
├── repository
│   ├── UserRepository.java
│   ├── ProfileRepository.java
│   ├── PlaceRepository.java
│   ├── AccommodationRepository.java
│   ├── ReservationRepository.java
│   ├── ReviewRepository.java
│   ├── SurveyRepository.java
│   ├── FavoriteRepository.java
│   └── MessageRepository.java
├── service
│   ├── UserService.java
│   ├── ProfileService.java
│   ├── PlaceService.java
│   ├── AccommodationService.java
│   ├── ReservationService.java
│   ├── ReviewService.java
│   ├── SurveyService.java
│   ├── FavoriteService.java
│   └── MessageService.java
└── util
└── GeocodingService.java

**Seoul Tour Web login page** 

![Untitled (15)](https://github.com/user-attachments/assets/e5237103-a1c8-4278-b910-e154cfb1fbd0)

- 회원이 아닐 경우, 어떤 정보도 볼 수 없음
- SNS 로그인 연동(카카오, 네이버, 구글)


![Untitled (16)](https://github.com/user-attachments/assets/691a93f9-13bd-429c-8bec-2708b758d7c9)

![Untitled (17)](https://github.com/user-attachments/assets/b811632a-aa37-42aa-9af8-238439a84ad6)
![Untitled (18)](https://github.com/user-attachments/assets/9d701e8d-4d95-444e-87b6-00f5c3f6d019)

소셜 로그인은 계정이 인증되면 바로 survey 페이지로 리다이렉트 된다

- 회원일 경우 Survey 페이지로
- 회원이 아닐 경우, Sign up (회원가입 유도) → register 페이지로 넘어감

**Seoul Tour Web Register page** 

![Untitled (19)](https://github.com/user-attachments/assets/2fe7a1db-8588-4f91-a3c6-cbd3d93b3f3c)

- 이름, 아이디, 비밀번호, 비밀번호 확인, 이메일 정보를 입력받는다
- 아이디가 중복될 경우 회원가입 불가
- 비밀번호와 비밀번호 확인 입력값이 다르면 회원가입 불가
- SIGN UP 버튼을 눌렀을 때 MariaDB에 적재

![Untitled (20)](https://github.com/user-attachments/assets/125cfcac-6c56-4811-b6ce-01f4b3ce46db)

- 회원가입 성공 시에 로그인 페이지로 이동

**Seoul Tour Web Survey page** 

![Untitled (21)](https://github.com/user-attachments/assets/f582539e-b287-46a4-b23c-cf3b5c14b9fd)


- 로그인이 완료되면 설문조사 페이지로 이동
- 사용자가 취향에 맞는 여행 스타일을 골라 체크 박스를 선택 후 찾기 버튼 클릭
- 데이터베이스에 있는 tourspot 테이블을 불러와 사용자가 선택한 tourtype에 맞는 데이터를 필터링

**Seoul Tour Web recommand page** 

![Untitled (22)](https://github.com/user-attachments/assets/d77d4c9a-9838-449b-92ab-b8e3f5cc7516)

- 설문조사의 결과 페이지로 서울시 여행 추천 페이지로 이동
- 관광 타입 별로 서울시 추천 여행지 list 제공
- 지도(마커)버튼을 누르면 해당 여행지가 지도에 표시된다
- 지도에 표시된 선택한 여행지들의 여행 루트에 최적화된 숙소를 찾아 지도에 표시하고 리스트로 보여줄 예정
- 찜(별)버튼을 누르면 사용자의 찜 list에 추가하는 기능을 구현할 예정
