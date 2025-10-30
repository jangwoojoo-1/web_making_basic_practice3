# 웹 프로그래밍 기초 실습 3: Spring MVC 회원 관리

이 레포지토리는 Spring MVC 프레임워크를 사용하여 회원 관리 기능을 구현하는 연습 프로젝트(`MemberTest`)의 두 가지 버전을 포함하고 있습니다.

각 버전은 점진적으로 기능을 추가하고 개선하는 과정을 보여줍니다.

## 📚 프로젝트 구성

자세한 내용은 각 버전 폴더의 README 파일을 참고하세요.

* **[MemberTest_version1](./MemberTest_version1/README.md)**: Spring MVC와 MyBatis를 이용한 기본적인 회원 등록 및 목록 조회 기능 구현.
* **[memberTest_version2](./memberTest_version2/README.md)**: Version 1에 회원 상세 조회, 수정, 삭제 기능을 추가하고 Service 계층을 분리한 버전. 강사님의 코드를 클론한 것을 바탕으로 추가적인 작업을 진행

## ⚙️ 주요 학습 내용

* Spring MVC 프레임워크 설정 및 기본 구조 이해
* MyBatis를 이용한 데이터베이스 연동 (Mapper 인터페이스 및 XML)
* MVC 패턴 (Controller, Service, Repository/DAO) 적용
* 의존성 주입(DI) 활용 (`@Autowired`, `@RequiredArgsConstructor`)
* DTO(Data Transfer Object) 사용
* JSP와 JSTL을 이용한 뷰 구현
* 단위 테스트 (JUnit) 작성

## ▶️ 실행 방법

각 프로젝트는 독립적인 Spring MVC 웹 애플리케이션입니다. Gradle 빌드 도구와 Tomcat 같은 웹 서버를 사용하여 각 프로젝트를 빌드하고 배포하여 실행할 수 있습니다. 데이터베이스 설정은 각 프로젝트의 `root-context.xml` 파일을 참고하세요.
