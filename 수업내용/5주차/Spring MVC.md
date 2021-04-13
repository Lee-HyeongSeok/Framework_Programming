

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

- 기본적인 자바 웹 어플리케이션 설계 방식에는 **3가지 방식** 존재

  - **모델 1 설계 방식**

    - JSP로만 구현하거나 Java Bean을 포함하여 개발
    - 프로젝트가 작은 규모에서 사용이 편하다.
    - 프로젝트 규모가 커지면 결합도가 높아져서 유지보수가 어렵다.

  - **모델 2 설계 방식**

    - MVC 패턴이 적용되어 있다(Model, View, Controller)
    - 뷰와 베이스 로직을 분리시킨 구조다.
    - 대규모 프로젝트에서는 확장성이 용이하고 유지보수성이 높다.

  - **프론트 컨트롤러 설계 방식(= DispatcherServlet)**

    - 스프링 MVC에서는 기본적으로 프론트 컨트롤러 패턴 적용되어있다.

    - 클라이언트 요청을 별도의 Front Controller에 집중

    - Tomcat이 브라우저로부터 받은 요청을 프론트 컨트롤러에 모두 위임한다.

      - 모든 요청의 공통 부분을 프론트 컨트롤러들로 처리한다.

    - 기존 **model 2 방식**에서는 클라이언트의 요청마다 서블릿이 생성되었다.

    - **DispatcherServlet**이라 한다.

      > **Servlet Container에서 HTTP 프로토콜을 통해 들어오는 모든 요청을<br> 프레젠테이션 계층의 제일 앞에 위치시켜서 중앙 집중식으로 처리해주는 <br> Front Controller**

- 스프링 MVC는 기본적으로 MVC 패턴이 적용되어 있다.

  - 뷰와 베이스 로직 간에 약한 결합도로 구성되어 있어서 확장, 유지보수가 쉽다.

- model, view, controller 각각의 인터페이스 정의
  - 구현에 의존적이지 않음
  - 약한 결합도로 구성되어 유연하고 확장이 쉽다.
  
- 다양한 **서드 파티 라이브러리** 연계 지원(뷰 프레임워크)
  - Jackson, Google Gson, Google Protocol Buffers, Apache Tile, FreeMakers, Rome
  - JasperReports, ApachePOI, Hibernate Validators, Joda-Time, Thymeleaf, HDIV
  
- Annotation의 도입으로 코딩이 간단해졌다.
  
  - @Controller, @RequestMapping 등

<br> 

### **:pushpin: DispatcherServlet**

> **Spring MVC에서 Front Controller 역할을 한다.**

<br> 

### **:pushpin: Front Controller 패턴의 처리 방식(수행 흐름)**

1. Tomcat이 브라우저로부터 받은 요청을 DispatcherServlet에게 전달
2. Dispatcher Servlet은 개발자가 개발한 서브 컨트롤러에 브라우저 요청을 위임
   - 이 단계에서 **DispatcherServlet**은 서브 컨트롤러를 Spring Bean으로 등록하는<br> 과정이 있어야 한다.
3. 서브 컨트롤러는 DAO 객체를 호출, 결과를 처리해서 결과 값을 Model 객체에 저장 후 <br> View 정보를 **DispatcherServlet**에 리턴
   - VO들은 Model 객체를 통해 전달하는 형태가 된다.
4. 이렇게 수행된 결과를 **DispatcherServlet**은 화면을 처리해야 하므로 어떤 화면을 처리 할<br> 객체인지 알아내기 위해 **View Resolver**에 화면 처리 요청
5. **View Resolver**는 적당한 객체를 **DispatcherServlet**에게 리턴
6. **DispatcherServlet**은 해당 결과 화면에 **Model** 객체를 가져와 화면을 처리하도록 요청
7. 이 결과를 요청했던 브라우저에 응답

<br>

![Untitled Diagram](https://user-images.githubusercontent.com/55940552/113391064-e38a4300-93cd-11eb-92b6-6fe1927c3f35.png) 

<br>

### **:pushpin: Spring MVC 구성 요소**

-  **DispatcherServlet**
  - 프론트 컨트롤러 담당
  - 클라이언트의 HTTP 요청을 받아서 Controller에게 전달한다.
  - 리턴 결과값을 View Resolver에 전달하여 알맞은 응답 생성

- **HandlerMapping**
  - URL과 요청 정보를 기준으로 어떤 Controller를 실행할지 결정하는 객체
  - DispatcherServl et은 하나 이상의 HandlerMapping을 가질 수 있다.
  - Annotation을 이용할 때는 <u>mvc:annotation-driven</u> 태그 설정 필요

- **Controller**
  - 클라이언트 요청을 처리한 뒤 결과를 DispatcherServlet에게 알려준다.

- **Model**
  - Controller가 View에게 넘겨줄 데이터를 저장하기 위한 객체

- **ViewResolver**
  - Controller가 리턴한 View 이름을 기반으로 Controller 처리 결과를 생성할 뷰 결정

- **View**
  - Controller의 처리 결과 화면을 생성 

<br> 

### **:pushpin: Spring MVC Annotation**

> **Spring이 관리하는 컴포넌트를 나타내는 일반적인 스테레오 타입**

- **@Component** : 일반적인 컴포넌트
- **@Component의 전문화된 타입**
  - **@Repository** : Persistence 계층 컴포넌트
  - **@Service** : Business(service) 계층 컴포넌트
  - **@Controller** : Presentation 계층 컴포넌트
- **@RestController** : @Controller + @ResponseBody(Spring 4.0 이후)
  - Controller가 Rest API 형태로 JSON 포맷을 보내고 결과 값을 만들어주기 위해<br> 별도로 애노테이션을 구체화 시킨 것이다.

<br> 

### **:pushpin: Spring MVC Library 설정**

- **spring-webmvc**

  - pom.xml에 설정
  - 설정 시 spring-web과 기타 스프링 프레임워크의 의존 모듈에 대한 의존관계도 함께 처리

  ```xml
  <dependency>
  	<groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.2.12.RELEASE</version>
  </dependency>
  ```

- **hibernate-validator**

  - pom.xml에 설정
  - 입력 값의 유예성을 검증하기 위한 라이브러리
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

- ContextLoaderListener, DispatcherServlet 이 **web.xml**에 등록되어 있어야<br> 이 두 클래스가 Web Application Context를 만드는 과정을 수행한다.

- **ContextLoadListener**
  - **Servlet Container(Tomcat)**이 생성될 때 그 이벤트를 받아서 처리하는 것이 **ContextLoaderListener Class**
  - **Servlet Container(Tomcat)**에 ContextLoadListener 클래스 등록
  - 서비스 계층 이하의 빈을 등록하기 위한 클래스
    - **@Service, @Repository 등**
- **DispatcherServlet**
  - **Servlet Container(Tomcat)**에 프론트 컨트롤러인 DispatcherServlet 클래스 등록
  - 개발자가 개발하는 컨트롤러들을 스프링 빈으로 등록한다.
  - 컨트롤러 빈을 등록하기 위한 클래스
    - **@Controller, @Component**

<br>

### **:pushpin: Controller 기본 구조**

- 모든 Controller Class에는 **@Controller** 애노테이션 설정

- 메소드 반환으로는 view 이름을 반환

- **@Controller**

  - URL을 책임지고 불려지는 Servlet

  - Controller 관련 정보는 servlet-context.xml에 설정된다.

    - Controller 패키지 내부에 **@Controller 애노테이션**이 지정된 클래스를 찾는다.

      ```xml
      <context:component-scan base-package="패키지 명"/>
      ```
    
    - 해당되는 Controller가 URL을 매핑시키기 위해 필요한 설정
    
      ```xml
      <mvc:annotation-driven>
      	<!-- 패키지 내부에서 찾은 Bean(Controller)과 URL을 매핑-->
      </mvc:annotation-driven>
      ```
    
    - DispatcherServlet이 Controller임을 인지해서 Spring Bean으로 등록한다.

- **@RequestMapping 애노테이션** : 처리 할 URL을 명시한다.

  - 배열 형태의 값 지정 가능<br> ex) @RequestMapping(value={"view1", "view2"}), view1과 view2 양쪽 URL에 대응하는 메서드 정의
  - **속성과 값을 사용해서 URL을 설정한다.**
    - **value** : URL 요청경로
      - @RequestMapping("/view")
      - @RequestMapping(value="/view")
    - **method** : HTTP 메서드(GET or POST)
      - @RequestMapping(method = RequestMethod.GET)
    - **params** : 요청 파라미터 유무 or 파라미터 값
      - @RequestMapping(params = "action-new")
      - @RequestMapping(params = "forbidden")
      - @RequestMapping(params = {"action=edit", "userId"})

<br> 

### **:pushpin: Controller Method 매개변수**

> **Controller method에 최상단에 위치한 RequestMapping 애노테이션이 <br>URL 경로 내의 변수 값을 각 Controller Method 매개변수에게 전달한다.**

- **RequestParam 매개변수**

  - 요청 URL에서 변수명과 값 명시 형태가 **경로?변수명=변수값**이다.

  ```java
  // 요청 URL : http://localhost:port/web/view?변수명=변수값, 경로 뒤에 ?변수명을 통해 값을 명시
  /* 
  1. @RequestMapping이 value로 view를 지정했으므로 URL에서 view뒤에 변수 값을 
  2. @RequestParam 매개변수에서 지정한 "msg"에 전달
  3. @RequestParam 매개변수는 @RequestParam("msg") 오른쪽에 선언된 String msg에 변수값을 저장
  */
  @RequestMapping(value="view", method=RequestMethod.GET)
  public String getURL(@RequestParam("msg") String msg){return "view";}
  ```

- **PathVariable 매개변수**

  - 요청 URL에서 변수명과 값 명시 형태가 **경로/변수값**이다.

  ```java
  // 요청 URL : http://localhost:port/web/view/변수값
  /*
  1. @RequestMapping이 value로 view를 지정했으므로 URL에서 view뒤에 변수 값을 
  2. @PathVariable 매개변수에서 지정한 "msg"에 전달
  3. @RequestParam 매개변수는 @PathVariable("msg") 오른쪽에 선언된 String msg에 변수값을 저장
  */
  @RequestMapping(value="view/{msg}", method=RequestMethod.GET)
  public String getURL(@PathVariable("msg") String msg){ return "view"; }
  ```

- **ModelAttribute 매개변수**

  - 요청 URL에서 변수명과 값 명시 형태가 **경로?변수명=변수값**이다.

  ```java
  // 요청 URL : http://localhost:port/web/view?변수명=변수값
  /* 
  1. @RequestMapping이 value로 view를 지정했으므로 URL에서 view뒤에 변수 값을 
  2. @ModelAttribute 매개변수에서 지정한 "msg"에 전달
  3. @RequestParam 매개변수는 @ModelAttribute("msg") 오른쪽에 선언된 String msg에 변수값을 저장
  */
  @RequestMapping(value="/view", method=ReqeustMethod.GET)
  public String getURL(@ModelAttribute("msg") String msg){ return "view"; }
  ```

- **Model 객체**

<br> 

### **:pushpin: Controller Method의 반환 값**

- **forward** : 서버 내 페이지 전환

  ```java
  @RequestMapping(value="/view")
  public String setURL(@ModelAttribute("msg") String msg){ return "forward:/otherPage"; }
  ```

- **redirect** : 브라우저 경우

  ```java
  @RequestMapping(value="/view")
  public String setURL(@ModelAttribute("msg") String msg){ return "redirect:/view"; }
  ```

  <br> 



### **:pushpin: REST 아키텍처 배경**

- 클라이언트와 서버 사이 데이터 연동을 위한 아키텍처 스타일
- 이전 웹 서버는 클라이언트 요청을 받으면 문서의 구조를 구성한 html 형태로 결과를 리턴
  - 그러다보니 다양한 클라이언트가 등장했다(pc, 모바일, 디바이스 등)
- 웹 서버가 범용성에 대한 needs가 늘어나기 시작했다.
  - 그래서 나온게 REST 아키텍처이다.

<br> 

### **:pushpin: REST 아키텍처 특징**

- 웹 서버 리소스를 URI를 할당해서 리소스를 지정
- 지정된 리소스에 대해 HTTP Method로 리소스를 조작
- Rest 서버는 json, xml 같은 표현 방식으로 전송
  - **json**
    - 키에 대한 값으로 저장
    - xml보다 데이터 크기가 작다.
    - json 사용 범위가 늘어나는 추세이다.
  - **xml**
    - 시작 태그, 엔드 태그로 값을 저장

<br>



### **:pushpin: REST Controller 사용을 위한 라이브러리 설정**

- 리소스 형식을 JSON(Java Script Object Notation)으로 사용

```xml
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.8</version>
</dependency>
```

<br> 

### **:pushpin: Rest Controller에 사용되는 Annotation**

- **@RestController**
  - 해당 컨트롤러가 Rest Controller 임을 선언하기 위함
  - Controller + Responsebody 의미를 합침
- **@RequestBody**
  - 클라이언트 정보가 서버로 넘어올 때 json, xml 포맷을 해당되는 매개변수 객체로<br> 바인딩하기 위해 사용 
- **@ResponseBody**
  - 서버에서 만들어진 결과를 클라이언트에게 전달할 때 ResponseBody를 선언해주면<br> 자동으로 json 포맷으로 변환시켜서 전송
- **@ResponseEntity**
  - 결과 값 뿐만 아니라 결과를 수행했던 상태 값, 헤더에 별도 정보를 넣을 때 묶어서<br> 지정해서 클라이언트에게 결과 값을 보낼 때 사용

<br> 

### **:pushpin: Spring MVC 예외처리**

- 스프링 MVC에서 예외처리를 하기 위해서는 2가지 애노테이션이 필요하다.

  - **@ControllerAdvice 애노테이션**

    - 어떤 컨트롤러에도 예외가 발생하면,<br> 예외처리 클래스가 있으면 해당 예외처리 클래스의 메소드를 호출한다.
    - @Component 애노테이션을 붙이는 이유
      - 해당 클래스도 스프링 빈으로 등록해야 되므로
      - DispatcherServlet가 해당 되는 @ControllerAdvice도 스프링 빈으로 등록해야되기 때문
      - component-scan을 통해 예외처리 클래스를 빈으로 등록해야 한다.

  - **@ExceptionHandler 애노테이션**

    - 예외처리 클래스 내 특정 예외에 대해 처리할 메소드에는<br> @ExceptionHandler 애노테이션 설정

    - 각 메소드는 어떤 예외에 대해 처리할 것인지 속성 지정 필요

      > **ex) @ExceptionHandler(DataNotFoundException.class)**

    - 메소드에서는 주로 예외 처리 페이지를 반환한다.

<br> 

### **:pushpin: REST Controller 설정 JAXB**

- XML 형식의 HTTP 메시지를 JAXB(Java Architecture for XML Binding)로 변환

- **servlet-context.xml**

```xml
<annotation-driven validator="validator">
	<message-converters>
    	<beans:bean class="org.springframework.http.converter.xml.
                           Jaxb2RootElementHttpMessageConverter"/>
    </message-converters>
</annotation-driven>
```

- **root-context.xml**

```xml
<bean id="validator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean">
	
</bean>
```

<br> 

### **:pushpin: REST Controller Response Message [HTTP Message : GET 방식]**

- **Get 방식**으로 클라이언트로부터 URL 요청을 받았을 때 - **json 응답**

  - **MemberRestController.java 내부 readMember() 메서드**

  ```java
  @RestController
  @RequestMapping("/member/rest")
  public class MemberRestController {
  
  	@Autowired(required=true)
      private MemberService memberService;
  	
  	private static final Logger logger = LoggerFactory.getLogger(MemberRestController.class);
  	
      // ResponseEntity 애노테이션을 사용
      // 응답 메시지 형식 지정 가능 
      // 요청 메소드 GET으로 지정
      @RequestMapping(value = "/{id}", method = RequestMethod.GET)
      public ResponseEntity<StudentVO> readMember(@PathVariable String id) throws Exception {
      	StudentVO student = memberService.readMember(id);
      	
  		logger.info(" /member/rest/{id} REST-API GET method called. then readMember method executed.");
  		HttpHeaders headers = new HttpHeaders();
          // HTTP 응답 메시지 설정
          // HTTP 응답 메시지 타입 설정 : URL 요청에 대한 메시지 내용을 json 형태로 변환(키, 값) 쌍
  		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
  		headers.set("My-Header", "MyHeaderValue");
  		return new ResponseEntity<StudentVO>(student, headers, HttpStatus.OK);
      }
  }
  
  ```

   ![post](https://user-images.githubusercontent.com/55940552/114511899-756a3980-9c73-11eb-84a6-80f95767d992.PNG) 

- **GET 방식**으로 클라이언트로부터 URL 요청을 받았을 때 - **xml 응답**

  - **MemberRestController.java 내부 readMember() 메서드**

  ```java
  @RestController
  @RequestMapping("/member/rest")
  public class MemberRestController {
  
  	@Autowired(required=true)
      private MemberService memberService;
  	
  	private static final Logger logger = LoggerFactory.getLogger(MemberRestController.class);
  	
      // ResponseEntity 애노테이션을 사용
      // 응답 메시지 형식 지정 가능 
      // 요청 메소드 POST으로 지정
      @RequestMapping(value = "/{id}", method = RequestMethod.POST)
      public ResponseEntity<StudentVO> readMember(@PathVariable String id) throws Exception {
      	StudentVO student = memberService.readMember(id);
      	
  		logger.info(" /member/rest/{id} REST-API GET method called. then readMember method executed.");
  		HttpHeaders headers = new HttpHeaders();
          // HTTP 응답 메시지 설정
          // HTTP 응답 메시지 타입 설정 : URL 요청에 대한 메시지 내용을 xml 형태로 변환
  		headers.setContentType(new MediaType("application", "xml", Charset.forName("UTF-8")));
  		headers.set("My-Header", "MyHeaderValue");
  		return new ResponseEntity<StudentVO>(student, headers, HttpStatus.OK);
      }
  }
  
  ```

  ![get](https://user-images.githubusercontent.com/55940552/114511894-74390c80-9c73-11eb-87d2-82257ed214e8.PNG) 

### **:pushpin: Spring 디렉터리 구조**

![Untitled Diagram](https://user-images.githubusercontent.com/55940552/113396277-3a941600-93d6-11eb-8548-2ee7ae55c8de.png) 

***

**[출처]**

[한국산업기술대학교](http://www.kpu.ac.kr/index.do?sso=ok)

[naver 블로그 - spring mvc란?](https://m.blog.naver.com/PostView.nhn?blogId=kksssii&logNo=220658615169&proxyReferer=https:%2F%2Fwww.google.com%2F)

[mvc 프로젝트 기본 구조](https://devpad.tistory.com/24)

