# MemberTest Version 1: Spring MVC & MyBatis 기본 회원 관리

이 프로젝트는 Spring MVC 프레임워크와 MyBatis 연동의 기초를 다루며, 회원 **등록**과 **목록 조회**라는 기본적인 웹 애플리케이션 기능을 구현하는 데 중점을 둡니다. 

## 📚 상세 기능

* **회원 등록 폼 요청 (GET `/member/insert`)**:
    * `MemberController`의 `insertGET()` 메서드가 처리합니다.
    * `WEB-INF/views/insert.jsp` 뷰 페이지를 반환하여 사용자에게 회원 정보 입력 폼을 보여줍니다.
* **회원 등록 처리 (POST `/member/insert`)**:
    * `MemberController`의 `insertPOST()` 메서드가 처리합니다.
    * 폼에서 전송된 데이터를 `MemberDTO` 객체로 자동 바인딩합니다.
    * `MemberServiceMybatis` (실질적으로 Mapper 호출 역할) 를 통해 `MemberMapper`의 `insert()` 메서드를 호출하여 DB에 회원 정보를 저장합니다.
    * 등록 완료 후 회원 목록 페이지(`/member/list`)로 리다이렉트합니다.
* **회원 목록 조회 (GET `/member/list`)**:
    * `MemberController`의 `list()` 메서드가 처리합니다.
    * `MemberServiceMybatis` 를 통해 `MemberMapper`의 `selectAll()` 메서드를 호출하여 모든 회원 정보를 조회합니다.
    * 조회된 회원 목록(`List<MemberDTO>`)을 `Model` 객체에 담아 `WEB-INF/views/list.jsp` 뷰 페이지로 전달합니다.
    * JSTL의 `<c:forEach>` 태그를 사용하여 목록을 화면에 출력합니다.

## 🛠️ 기술 스택 및 주요 설정

* **Spring MVC**: `servlet-context.xml`에서 컴포넌트 스캔(`com.ssg.membertest`), ViewResolver 설정 (`/WEB-INF/views/`, `.jsp`).
* **MyBatis**:
    * `root-context.xml`에서 `DataSource` (HikariCP), `SqlSessionFactoryBean` (MyBatis 설정 파일 및 Mapper XML 경로 지정), `MapperScannerConfigurer` (`com.ssg.membertest.tMember.mapper` 패키지 스캔) 설정.
    * `MemberMapper.java` 인터페이스와 `MemberMapper.xml` 파일에 SQL 쿼리 작성 (namespace 일치 중요).
* **데이터베이스**: `root-context.xml`의 `hikariConfig` 빈 설정을 통해 DB 연결 정보(driver, url, username, password) 관리.
* **DTO**: `MemberDTO` 클래스 사용 (Lombok `@Data` 어노테이션 활용).
* **Test**: `MemberTests.java`에서 JUnit과 Spring TestContext Framework를 사용하여 `MemberServiceMybatis`와 `MemberMapper`의 기능 테스트. `@ExtendWith(SpringExtension.class)`, `@ContextConfiguration` 어노테이션 사용.

## 📝 참고 사항

* 이 버전에서는 Controller(`MemberController`)가 비즈니스 로직 처리 객체(`MemberServiceMybatis`)를 직접 주입받아 사용합니다.
* JDBC 기반의 DAO (`MemberDAOImpl`, `MemberDaoJdbc`) 및 Service (`MemberServiceImpl`) 코드도 포함되어 있지만, 이는 Mybatis를 활용한 방법과 차이를 비교하기 위한 것으로 현재 설정(`root-context.xml`)상 MyBatis 기반의 `MemberServiceMybatis`가 `@Service`로 등록되어 사용됩니다.
