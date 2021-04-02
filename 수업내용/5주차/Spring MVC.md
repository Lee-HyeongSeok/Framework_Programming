## **🎈 Spring MVC**

***

<br> 

### **:pushpin: Spring MVC란**

> **MVC 패턴 기반의 Web Framework**

- **M(Model)** : 애플리케이션 정보, 데이터 처리 관리
- **V(View)** : 사용자 인터페이스(화면)
- **C(Controller)** : Model과 View 간 상호동작 조정 

<br> 

### **:pushpin: Spring MVC 특징**

- Front Controller 패턴에 기초한 mvc 프레임워크
- model, view, controller 각각의 인터페이스 정의
  - 구현에 의존적이지 않음
  - 약한 결합도로 구성되어 유연하고 확장이 쉽다.
- 다양한 **서드 파티 라이브러리** 연계 지원
  - Jackson, Google Gson, Google Protocol Buffers, Apache Tile, FreeMakers, Rome
  - JasperReports, ApachePOI, Hibernate Validators, Joda-Time, Thymeleaf, HDIV
- Annotation의 도입으로 코딩이 간단해졌다.
  - @Controller, @RequestMapping 등

<br> 

### **:pushpin: Spring MVC  어플리케이션 설계 방식**

- **Model 1 방식**

  - JSP만 사용하여 개발 또는 Java bean을 포함하여 개발
  - JSP에 View와 Model 로직이 혼재
  - 복잡도가 높고, 유지보수가 어렵다.

- **Model 2 방식**

  - Model, View, Controller로 분리
    - **model** : View에 필요한 비즈니스 데이터 
    - **view** : 화면상의 처리
    - **controller** : 데이터 처리, 화면의 분기 담당 
  - View와 Model 로직의 분리
  - 유지보수 및 확장 용이

- **Front Controller 패턴 방식(Spring MVC)**

  - 클라이언트 요청을 별도의 Front Controller에 집중

  - 뷰에서 들어오는 모든 요청을 담당하여 웹 애플리케이션을 실행하는<br> 모든 요청을 일괄적으로 처리

  - 기존 model 2 방식에서는 클라이언트의 요청마다 서블릿이 생성되었다.

  - **Dispatcher-Servlet이라 한다.**

    > **Servlet Container에서 HTTP 프로토콜을 통해 들어오는 모든 요청을<br> 프레젠테이션 계층의 제일 앞에 위치시켜서 중앙 집중식으로 처리해주는 <br> Front Controller**

<br> 

### **:pushpin: Front Controller(DispatcherServlet) 흐름**

![Untitled Diagram](https://user-images.githubusercontent.com/55940552/113391064-e38a4300-93cd-11eb-92b6-6fe1927c3f35.png) 

<br> **DispatcherServlet**

- 프론트 컨트롤러 담당
- 클라이언트의 HTTP 요청을 받아서 Controller에게 전달한다.
- 리턴 결과값을 View Resolver에 전달하여 알맞은 응답 생성

**HandlerMapping**

- URL과 요청 정보를 기준으로 어떤 Controller를 실행할지 결정하는 객체
- DispatcherServlet은 하나 이상의 HandlerMapping을 가질 수 있다.
- Annotation을 이용할 때는 <u>mvc:annotation-driven</u> 태그 설정 필요

**Controller**

- 클라이언트 요청을 처리한 뒤 결과를 DispatcherServlet에게 알려준다.

**Model**

- Controller가 View에게 넘겨줄 데이터를 저장하기 위한 객체

**ViewResolver**

- Controller가 리턴한 View 이름을 기반으로 Controller 처리 결과를 생성할 뷰 결정

**View**

- Controller의 처리 결과 화면을 생성 

<br> 

### **:pushpin: Spring MVC Annotation**

> Spring이 관리하는 컴포넌트를 나타내는 일반적인 스테레오 타입

- **@Component** : 일반적인 컴포넌트
- **@Repository** : Persistence 계층 컴포넌트
- **@Service** : Business(service) 계층 컴포넌트
- **@Controller** : Presentation 계층 컴포넌트
- **@RestController** : @Controller + @ResponseBody(Spring 4.0 이후)

<br> 

### **:pushpin: Spring MVC Library 설정**

- spring-webmvc

  - pom.xml에 설정
  - 설정 시 spring-web과 기타 스프링 프레임워크의 의존 모듈에 대한 의존관계도 함께 처리

  ```xml
  <dependency>
  	<groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.2.12.RELEASE</version>
  </dependency>
  ```

- hibernate

  - pom.xml에 설정
  - hibernate-validator(Bean Validation 구조체)를 이용해 자바 빈(VO) 값의 유효성을 Annotation을 통해 검증

  ```xml
  <dependency>
  	<groupId>org.hibernate</groupId>
      <artifactId>hibernate-validator</artifactId>
      <version>6.1.2.Final</version>
  </dependency>
  ```

  <br> 

### **:pushpin: WebApplicationContext 등록 설정(web.xml)**

- **ContextLoadListener**
  - Servlet Container(Tomcat)에 ContextLoadListener 클래스 등록
  - 서비스 계층 이하의 빈을 등록하기 위한 클래스
    - **@Service, @Repository 등**
- **DispatcherServlet**
  - Servlet Container(Tomcat)에 프론트 컨트롤러인 DispatcherServlet 클래스 등록
  - 컨트롤러 빈을 등록하기 위한 클래스
    - **@Controller, @Component**

<br> 

### **:pushpin: Spring 디렉터리 구조**

![Untitled Diagram](https://user-images.githubusercontent.com/55940552/113396277-3a941600-93d6-11eb-8548-2ee7ae55c8de.png) 

***

**[출처]**

[한국산업기술대학교](http://www.kpu.ac.kr/index.do?sso=ok)

[naver 블로그 - spring mvc란?](https://m.blog.naver.com/PostView.nhn?blogId=kksssii&logNo=220658615169&proxyReferer=https:%2F%2Fwww.google.com%2F)

[mvc 프로젝트 기본 구조](https://devpad.tistory.com/24)

