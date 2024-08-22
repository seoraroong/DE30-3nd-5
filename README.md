# DE30-3nd-5
## 아이디어

여행을 떠나기 위해서는 어느 곳을 구경할 지, 어떤 것들을 경험할 지 꼼꼼히 계획해야 한다. 

이러한 과정은 많은 시간과 노력을 필요로 하며, 잘못된 선택은 여행의 질을 떨어뜨리기도 한다.

이번 스프링부트 프로젝트에서는 **효율적인 서울 여행 계획을 위한 서비스**를 제공한다.

서비스는 사용자의 여행 취향과 목적에 맞춘 맞춤형 여행지를 추천하고, 여행지에서 가장 합리적인 거리에 있는 숙소를 추천하는 기능을 담고 있다.


## 데이터

### 서울시 관광지 및 숙박 데이터

관광 타입 : 관광지 / 문화시설 / 레포츠 / 축제공연행사 / 쇼핑

출처 : TourAPI - 맞춤형 데이터 (https://api.visitkorea.or.kr/#/hubTourSearch)

### Maria DB에 데이터 적재

**tourspot 테이블(서울시 관광지 데이터)**

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/51840f7b-1177-4c81-8541-ca5835b9aa2f/Untitled.png)

placename(관광지 이름)

addr(주소)

mapx, mapy (위도, 경도)

overview (개요)

detail (설명)

tourtype (관광 타입)

**hotel 테이블(서울시 숙박 업소 데이터)**

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/ce96aed5-3878-41ac-8c2e-6be19a401ab2/Untitled.png)

placename(숙박 업소 이름)

addr(주소)

mapx, mapy (위도, 경도)

overview (개요)

detail (설명)

reservation (예약 정보)

tourtype (관광 타입)


## 관광지 추천 시스템 시나리오

### 메인 페이지

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/59cda75f-84e4-4d70-b32e-e5f1bdf642bc/Untitled.png)

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

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/464b191f-e30e-47db-a052-e69b3eb72306/Untitled.png)

입력필드 : 

- 이름 input
- 아이디 input
- 비밀번호 input
- 이메일 input

버튼 : 회원가입 완료 (로그인 페이지로 이동)

### 설문조사 페이지

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/99dbc002-755a-4fa3-8ca5-d87f1a39d01d/Untitled.png)

제목 : 당신의 여행 취향을 알려주세요

선택 항목 :

- 유명 관광지는 무조건 가야 해요
- 액티비티한 스포츠 활동을 좋아해요
- 쇼핑하는 것을 좋아해요
- 문화재 관람을 좋아해요
- 축제와 공연 관람을 좋아해요

버튼 : 여행지 추천 받기

### 여행지 추천 리스트

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/41f81cb5-52a1-4597-9f17-f18ced1af868/Untitled.png)

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

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/223a8f1d-95c8-4ef7-baad-76f5b8291fcb/Untitled.png)

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

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/528d41fb-3e51-4325-96f1-2e53360d8458/Untitled.png)

- 회원이 아닐 경우, 어떤 정보도 볼 수 없음
- SNS 로그인 연동(카카오, 네이버, 구글)


![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/2243fd29-0a9c-46b3-a9de-7783ddee90c6/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/368a82d1-d20a-4c66-a2f0-5b9cde4db3db/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/a9675a56-71d1-4af9-9d44-4839664cf950/Untitled.png)

소셜 로그인은 계정이 인증되면 바로 survey 페이지로 리다이렉트 된다

- 회원일 경우 Survey 페이지로
- 회원이 아닐 경우, Sign up (회원가입 유도) → register 페이지로 넘어감

**Seoul Tour Web Register page** 

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/52810854-572e-4809-88d1-848527ca8d12/Untitled.png)

- 이름, 아이디, 비밀번호, 비밀번호 확인, 이메일 정보를 입력받는다
- 아이디가 중복될 경우 회원가입 불가
- 비밀번호와 비밀번호 확인 입력값이 다르면 회원가입 불가
- SIGN UP 버튼을 눌렀을 때 MariaDB에 적재

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/eae92db6-0524-42c6-9e5f-8ee55da6dd24/Untitled.png)

- 회원가입 성공 시에 로그인 페이지로 이동

**Seoul Tour Web Survey page** 

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/ee3982d9-e62b-4049-98a2-16f9636eac4f/Untitled.png)

- 로그인이 완료되면 설문조사 페이지로 이동
- 사용자가 취향에 맞는 여행 스타일을 골라 체크 박스를 선택 후 찾기 버튼 클릭
- 데이터베이스에 있는 tourspot 테이블을 불러와 사용자가 선택한 tourtype에 맞는 데이터를 필터링

**Seoul Tour Web recommand page** 

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/54417143-a465-427d-ae76-08ce195ca7bb/b433feaa-e438-477d-aca9-275e775eae15/Untitled.png)

- 설문조사의 결과 페이지로 서울시 여행 추천 페이지로 이동
- 관광 타입 별로 서울시 추천 여행지 list 제공
- 지도(마커)버튼을 누르면 해당 여행지가 지도에 표시된다
- 지도에 표시된 선택한 여행지들의 여행 루트에 최적화된 숙소를 찾아 지도에 표시하고 리스트로 보여줄 예정
- 찜(별)버튼을 누르면 사용자의 찜 list에 추가하는 기능을 구현할 예정
