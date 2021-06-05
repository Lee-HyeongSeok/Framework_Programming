## :pushpin: Spring Security

***

<br> 

### :pushpin: 인터셉터(Interceptor)

> **"중간에서 가로채다"**

- 컨트롤러의 호출 이전과 이후에 추가적 기능 가능한 구조를 제공한다.
- DispatcherServlet와 Controller 사이에서 동작하며 Interceptor가 사용자의 요청이 <br> Controller를 수행할 수 있는지에 대한 권한을 검사하고 실행 여부를 결정한다.
- 스프링 MVC에서 사용
- 스프링의 context 내에서 존재하므로 context의 모든 객체를 활용 가능하다.
  - **Context란?**
    - Spring이 Bean을 다루기 쉽도록 기능들이 추가된 공간 
    - Spring Container 내부에 Context라는 공간이 포함되어 존재
    - Servlet Context와 Root Context로 나뉜다.
- **기능적 측면 유사성** 
  - AOP의 기능과 유사(범용성)
- **구조적 측면 유사성**
  - Filter와 유사하다.
  - 특정 URL의 접근제어 가능 

<br>



### :pushpin: 필터(Filter)

- 서블릿, JSP 에서 사용한다.
- 웹 애플리케이션 내에서 동작하여 스프링의 Context에 접근이 어렵다.
- 클라이언트 요청에 대한 인증, 권한 확인등을 하는데 사용된다.
- 클라이언트와 DispatcherServlet 중간에서 역할을 수행한다.

<br>



### :pushpin: AOP

-  Controller 처리 이후 비즈니스 로직에서 실행
- 로깅, 트랜잭션, 에러 처리 등에 사용된다.
- 메서드 전후 시점에서 자유롭게 설정이 가능하다.
- 주소, 파라미터, 애노테이션 등 다양한 방법으로 대상 지정 가능

<br> 

### :pushpin: 필터와 인터셉터의 차이

- 영역 제어 측면에서의 차이점
  - **인터셉터** : 스프링 빈으로 등록된 컨트롤러, 서비스 객체를 주입 받는다.
- 위치적 차이점
  - 스프링 context가 만들어지기 전과 후(DispatcherServlet 앞과 뒤를 의미)
  - **인터셉터** : Context 내에 존재, Context 내의 모든 객체 활용 가능
  - **필터** : 웹 애플리케이션 내에서 동작, Context 접근이 어렵다.
- 처리 순서
  - **인터셉터** : DispatcherServlet이 호출된 후에 동작
  - **필터** : DispatcherServlet 호출 전에 동작

<br> 

### :pushpin: AOP(Advice)와 인터셉터(HandlerInterceptor)의 차이

- 가장 큰 차이는 **파라미터**의 차이
  - **인터셉터** : HttpServletRequest, HttpServletResponse 파라미터 활용
  - **AOP** : JoinPoint, PreceedingJoinPoint 파라미터 활용
- 역할
  - **인터셉터** : DispatcherServlet이 Controller를 호출하기 전과 후에 요청과<br> 응답을 참조, 적용 가능
  - **AOP** : 특정 객체 동작의 사전, 사후 처리를 활용

<br> 

### :pushpin: HandlerInterceptor

- 요청 경로마다 접근 제어를 다르게 처리
- 특정 컨트롤러에 종속되지 않고 다양한 컨트롤러에 공통적으로 적용
- **HandlerInterceptorAdapter** : HandlerInterceptor 인터페이스를 구현한 추상 클래스
- HandlerInterceptorAdapter 추상 메서드들을 구현
  - 컨트롤러의 사전, 사후를 처리
- **HandlerInterceptorAdapter 추상 메서드**
  - **컨트롤러 실행 전** : preHandle(request, response, handler)
    - 컨트롤러 객체 실행 전 필요 기능 구현에 사용
    - 접근 권한에 따른 실행 여부 결정, 필요 정보 생성 등
    - 리턴 타입은 boolean, false 리턴시 컨트롤러 실행 안함
  - **컨틀롤러 실행 후** : postHandle(request, response, handler, modelAndView)
    - 컨트롤러 객체 정상 실행 후 필요 기능 구현에 사용
    - 아직 결과가 뷰에 처리되지 않은 상태
    - 추가적인 데이터나 로직 추가 가능
    - 컨트롤러에서 Exception 발생시 실행 안함
  - **뷰 실행 후** : afterCompletion(request, response, handler, exception)
    - 클라이언트에 뷰 전송 뒤(화면 처리 후) 실행
    - 화면 처리 후 처리 시간 기록 등에 적합한 메서드
    - 컨트롤러에서 Exception 발생시 exception 파라미터를 통해 예외 값 전달, <br> Exception 미발생시 null

<br> 

### :pushpin: Interceptor 설정 - [servlet-context.xml]

```xml
<!-- 어떤 컨트롤러 호출 시 해당 인터셉터 빈에 의존성을 주입할지 설정 -->
<beans>
	<bean id="simpleInterceptor" class="org.kpu.interweb.interceptor.SimpleInterceptor">
    	<!-- HandlerInterceptor 설정, 경로 설정 함께 설정, 태그 내부의 빈을 핸들러 인터셉터로 사용-->
        <interceptors> 
        	<interceptor> <!-- 특정 요청 경로에 대해 특정 핸들러 인터셉터 적용 -->
            	<mapping path="특정 핸들러 인터셉터가 반응할 사용자의 컨트롤러 요청 경로 명시"/>
                <mapping path="/doInterB"/>
                <beans:ref bean="simpleIterceptor"></beans:ref>
            </interceptor>
            
            <interceptor>
            	<mapping path="/doInterB"/>
                <beans:ref bean="measureInterceptor"/> <!-- 웹 처리 시간 측정 인터셉터 -->
            </interceptor>
        </interceptors>
    </bean>
</beans>
```

```java
// HomeController.java
@RequestMapping(value="/doInterB", method=RequestMethod.GET)
public String interB(Locale locale, Model model){
    ... // 개발자 구현 코드
}
```

<br>

### :pushpin: 스프링 Security

- 애플리케이션 보안 기능 구현에 사용하는 프레임워크
- **기본적 보안 기능**으로는 **인증, 인가**를 제공 -> 다양한 필터 클래스 제공
  - **인증(Authentication)** : 애플리케이션에 접근하는 사용자를 특정(로그인)
  - **인가(Authorize)** : 특정 사용자에 대해 정보, 기능의 접근을 제한(관리자 페이지, 사용자 페이지)
- **강화된 보안 기능**으로는 **세션 관리, CSRF, 브라우저 보안기능 연계**를 제공
  - **세션 관리** : 세션 라이프사이클 관리
  - **CSRF(Cross Site Request Forgery)** : 크로스 사이트 요청 변조 공격으로부터 사용자 보호
  - **브라우저 보안기능 연계** : 브라우저 기능을 악용한 공격에서 사용자 보호

<br> 

### :pushpin: 스프링 Security 특징

- xml 파일에서 DB 리소스로부터 인증, 인가 정보 취득 가능
- HTML form 인증 지원
- 인가 정보에 기반한 화면 제어를 위한 JSP 태그 라이브러리 제공
- 메서드 호출에 대한 접근 제어에 AOP 사용 가능
- **spring-security-oauth2** 라이브러리 제공
  - 하나의 ID로 여러 사이트에 로그인 가능한 체계
  - API 인가 기능 구현 가능

<br> 

### :pushpin: 스프링 Security 라이브러리 구성

- spring-security-**core** : 인증, 인가 기능 구현 컴포넌트
- spring-security-**web** : 웹 애플리케이션 보안 기능 구현 컴포넌트
- spring-security-**config** : 각 모듈에서 제공하는 컴포넌트 설정 지원 컴포넌트
- spring-security-**taglibs** : JSP 태그 라이브러리

<br> 

### :pushpin: Spring Security 아키텍처 - 인증 처리 방식 제공

- **FilterChainProxy**
  - 전체 흐름 제어
  - 보안 기능과 같은 추가 기능을 Security Filter에 위임
- **HttpFirewall**
  - 방화벽 기능을 추가하기 위한 인터페이스
  - 기본적으로 **DefaultHttpFirewall** 클래스가 사용된다.
    - 인가되지 않은 요청 차단 역할
- **SecurityFilterChain**
  - Security Filter 목록을 관리하기 위한 인터페이스
- **Security Filter**
  - 보안 기능을 제공하는 Servlet Filter 클래스
  - 인증, 인가 등 <br> 

![Untitled Diagram](https://user-images.githubusercontent.com/55940552/120886726-5b712580-c62a-11eb-8db0-cdb286143081.png) 

<br>

### :pushpin: Spring Security - 인증 처리 기능 제공

![Untitled Diagram](https://user-images.githubusercontent.com/55940552/120888855-8c0a8c80-c635-11eb-83ab-1079a94eb765.png) 

<br> 

1. **Security Filter** 중 **Security AuthenticationFilter**는 **AuthenticationManager**를 통해 인증을 수행한다.
   - **Security AuthenticationFilter**
     - 인증 처리 방식에 대한 구현을 제공하는 서블릿 필터
     - UsernamePasswordAuthenticationFilter, basic 인증, Digest 인증, Remember Me 인증 등
   - **Authentication Manager 인터페이스**
     - 인증 처리 수행 인터페이스
     - 실제 인증 처리는 ProviderManager를 통해 Authentication Provider에게 위임
2. **Authentication Manager**는 **Provider Manager**로 구현, **Provider Manager**는 **Authentication Provider**에 <br>인증을 위임한다.
   - **Authentication Provider**
     - 인증 처리 기능 구현 인터페이스
     - 실제 인증 처리는 DAO Authentication Provider에 의해 수행
3. **Authentication Provider** 인터페이스에서 호출된 구현 클래스인 **DAO Authentication Provider**에서 인증<br> 성공 시 **Provider Manager**에게 인증된 **Authentication** 객체 반환**(4번 과정 포함)**
4. event 기반으로 **Authentication Filter**에 전송된다.

<br> 

### :pushpin: Spring Security 설정(web.xml)

```xml
<!-- /WEB-INF/spring 폴더에 인증에 사용할 Security Filter 파일 생성 -->
<!-- security Filter 파일 지정-->
<context-param>
	<param-name>contextConfigLocation</param-name>
    <param-value>/WEB-INF/spring/root-context.xml,
    /WEB-INF/spring/security-context-mem.xml
    </param-value>
</context-param>

<!-- spring security filter 설정 -->
<filter>
	<filter-name>springSecurityFilterChain</filter-name>
    <!-- spring은 여러 filter 중 Servlet Container Lifecycle과 ApplicationContext
사이에 연결 가능한 DelegatingFilterProxy라는 Filter를 제공한다.-->
    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
</filter>

<filter-mapping>
    <!-- spring security Filter 매핑을 웹 전체로 설정 -->
	<filter-name>springSecurityFilterChain</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

<br> 

### :pushpin: Spring Security 설정(security-context-mem.xml)

```xml
<!-- 메모리에서 인증 정보를 관리하는 경우 -->
<!-- 검사 URL 설정 -->
<http xmlns="http://www.springframework.org/schema/security">
    <!-- USER 권한을 가져야 액세스 가능하다. -->
	<intercept-url pattern="/**" access="hasRole('USER')"/>
    <form-login/>
    <logout/>
</http>

<!-- 메모리를 통한 인증 정보 관리 -->
<!-- Authentication Manager 객체 생성 -->
<authentication-manager xmlns="http://www.springframework.org/schema/security">
	<!-- DAOAuthenticationProvider 객체 생성 -->
    <authentication-provider>
    	<user-service>
            <!-- user, password라는 계정에게 USER 권한 부여-->
        	<user name="user" password="password" authorities="ROLE_USER"/>
        </user-service>
    </authentication-provider>
</authentication-manager>
```



<br> 

***

<br> 

### 출처

[한국산업기술대학교](www.kpu.ac.kr)

[Spring Security + JWT를 통해 프로젝트에 인증 구현하기 블로그](https://imbf.github.io/spring/2020/06/29/Spring-Security-with-JWT.html) 