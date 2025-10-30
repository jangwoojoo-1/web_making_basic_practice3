# MemberTest Version 2: Spring MVC 회원 관리 (CRUD + Service 계층 분리)

이 프로젝트는 `MemberTest_version1`에서 한 단계 더 나아가, 회원 관리의 기본적인 **CRUD(Create, Read, Update, Delete)** 기능을 모두 구현하고, **Controller-Service-Repository(DAO)**의 3계층 아키텍처를 적용하여 **Service 계층을 인터페이스 기반으로 명확하게 분리**한 버전입니다.

## 📚 상세 기능

* **회원 등록 폼 요청 (GET `/member/insert`)**:
    * `MemberController`의 `insertForm()` 메서드가 처리.
    * `WEB-INF/views/member/form.jsp` 뷰 페이지 반환 (등록/수정 공용 폼).
* **회원 등록 처리 (POST `/member/insert`)**:
    * `MemberController`의 `insert()` 메서드가 처리.
    * `MemberDTO` 파라미터 바인딩 후 `MemberService` 인터페이스의 `addMember()` 호출.
    * 처리 후 목록 페이지(`/member/list`)로 리다이렉트.
* **회원 목록 조회 (GET `/member/list`)**:
    * `MemberController`의 `list()` 메서드가 처리.
    * `MemberService`의 `listAll()` 호출하여 회원 목록 조회.
    * 조회 결과를 Model에 담아 `WEB-INF/views/member/list.jsp`로 전달.
* **회원 상세 조회 (GET `/member/detail`)**:
    * `MemberController`의 `detail()` 메서드가 처리.
    * `id` 파라미터를 받아 `MemberService`의 `getOne()` 호출.
    * 조회 결과를 Model에 담아 `WEB-INF/views/member/detail.jsp`로 전달.
* **회원 수정 폼 요청 (GET `/member/update`)**:
    * `MemberController`의 `updateForm()` 메서드가 처리.
    * `id` 파라미터로 기존 회원 정보를 조회하여 Model에 담아 `WEB-INF/views/member/form.jsp`로 전달 (폼 재활용).
* **회원 수정 처리 (POST `/member/update`)**:
    * `MemberController`의 `update()` 메서드가 처리.
    * `MemberDTO` 파라미터 바인딩 후 `MemberService`의 `modify()` 호출.
    * 처리 후 해당 회원의 상세 페이지(`/member/detail?id=...`)로 리다이렉트.
* **회원 삭제 처리 (POST `/member/delete`)**:
    * `MemberController`의 `delete()` 메서드가 처리.
    * `id` 파라미터를 받아 `MemberService`의 `remove()` 호출.
    * 처리 후 목록 페이지(`/member/list`)로 리다이렉트.

## 🛠️ 기술 스택 및 주요 설정

* **3-Tier Architecture**:
    * **Controller**: `MemberController` - 웹 요청 처리, Service 호출, 뷰 이름 반환.
    * **Service**: `MemberService` (Interface), `MemberServiceImpl` (Implementation) - 비즈니스 로직, 트랜잭션 처리(필요시), DAO 호출.
    * **Repository/DAO**: `MemberDAO` (Interface), `MemberDAOImpl` (Implementation) - 데이터베이스 접근 로직, MyBatis Mapper 호출.
    * **MyBatis Mapper**: `MemberMapper` (Interface) - MyBatis가 구현체를 자동 생성.
* **DI**: Controller는 Service 인터페이스에, ServiceImpl은 DAO 인터페이스에 의존하며, Spring 컨테이너가 `@Autowired`를 통해 의존성을 주입.
* **Formatter**: `LocalDateFormatter`를 사용하여 String 타입의 날짜 파라미터를 `LocalDate` 타입으로 변환. `servlet-context.xml`에 등록.
* **View**: JSP 파일들이 `WEB-INF/views/member/` 경로 아래로 구조화됨.
* **MyBatis**: `MemberMapper.xml`에 상세 조회(`selectOne`), 수정(`update`), 삭제(`delete`) SQL 추가.
* **기타**: Version 1과 동일한 Spring 설정, Lombok, Log4j2, JUnit 사용.

## 📝 개선 사항

* Version 1에 비해 Controller-Service-Repository(DAO) 구조가 명확해져 각 계층의 책임이 분리되었습니다.
* Service 계층이 인터페이스 기반으로 설계되어 유연성과 테스트 용이성이 향상되었습니다.
