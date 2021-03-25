## **🎈 의존성 주입(DI, Dependency Injection)**

***

<br> 

### **📌 의존성(Dependency)**

- 객체 간의 **의존 관계**를 의미한다.

<br>

### **📌 의존성 주입(DI, Dependency Injection)**

> **인터페이스 기반의 컴포넌트화**

- 객체들 간의 **의존 관계를 설정**하는 것을 의미한다.
- 기업 애플리케이션 개발 시 하나의 기능을 처리하기 위해<br> 여러 컴포넌트를 조합해서 구현하는 경우가 일반 적이다.
- 여러 컴포넌트를 통합할 때 **의존 관계 주입(DI)** 디자인 패턴이 효과적이다.
- 기존의 자바에서는 new 키워드를 통해 객체를 생성했었지만, <br> **DI 디자인 패턴**을 적용하면 **인터페이스 타입**만 생성하면 실 객체에 접근 가능
- 프로그램 **Run time** 시 설정한 의존 관계가 주입된다.
- 필요한 서비스 A, B를 Spring Container가 A, B를 생성해준다.
  - 즉, 의존 관계를 주입하는 주체는 **Spring Container**
  - 객체 간의 결합도를 낮춰준다.

<br>

### **📌 의존 관계 주입 설정 방법(DI setting)**

1. **XML 기반 설정**

   - xml 파일에 사용하는 **Bean 요소**를 정의

   - bean 태그의 속성

     - |     ***속성***     | ***의미***                                                   |
       | :----------------: | ------------------------------------------------------------ |
       |       **id**       | 객체를 유일하게 하는 id                                      |
       |      **name**      | 객체 명을 정의, 객체에 여러 이름 설정할 때, id에 설정 불가한 이름 지정 시 |
       |     **class**      | id의 실체로 패키지명과 클래스명으로 구성 <br> **ex) org.kpu.di.persistence.StudentDAOImpl** |
       |     **scope**      | 객체의 범위 설정 <br> **singleton** : spring container 내에 단 하나의 객체만 존재<br> **prototype** : 다수의 객체 존재 가능<br> **request** : 하나의 http request 생명주기 내 단 하나의 객체만 존재<br> **session** : 하나의 http session 생명주기 내 단 하나의 객체만 존재<br> **global session** : global http session 생명주기 내 단 하나의 객체만 존재 |
       |     **parent**     | 설정을 물려받을 객체명 지정                                  |
       |    **abstract**    | **true 설정 시** : 인스턴스를 만들지 않고 공통 설정 정의<br> **false 설정 시** : 기본 값, 인스턴스를 만들 때 지정 |
       |   **singleton**    | **true 설정 시** : 기본 값, getBean 메서드로 얻는 인스턴스는 싱글턴이다.<br> **false 설정 시** : getBean 메서드로 얻는 인스턴스는 매번 인스턴스화 된 것 |
       |   **lazy-init**    | **true 설정 시** : 인스턴스 생성 지연<br> **false 설정 시** : 기본 값, BeanFactory 시작 시 인스턴스 생성 |
       |   **depend-on**    | 의존 관계 대상 객체 존재 검사                                |
       |  **init-method**   | 지정 대상 메서드는 인수가 없고 void 형이된다, 인스턴스 변수 설정 후 호출 |
       | **destroy-method** | 시스템 종료 시 호출되는 메서드 지정, 인수가 없고 void 형이여야 한다.<br> 메서드를 가진 객체는 싱글턴이다. |
       |     **parent**     | 설정을 물려받을 객체명 지정                                  |
       |    **autowire**    | **no** : 기본 값, property 태그에 ref 태그로 지정된 객체가 인스턴스 변수로 설정<br> **byName** : property 명과 일치하는 객체 명의 Bean이 자동으로 주입된다.<br> **byType** : property 형과 일치하는 Bean이 주입된다.<br> **constructor** : 생성자를 이용해 주입 |

       

   - DI를 이용한 인터페이스 기반의 컴포넌트화 

   - 컴포넌트화를 통해 클래스의 변경 또는 확장 시 해당 클래스를 이용하는 <br> 다른 클래스에 영향 범위를 최소화할 수 있다.

   - **XML 기반 설정 DI 방식 2가지**

     - ***✅ 생성자 기반 의존성 주입(Constructor Based Dependency Injection)***

       - 생성자의 인수를 사용해 의존성 주입

       - xml 설정 파일에 **< contructor-arg >** 태그를 사용, 주입할 **컴포넌트** 설정 

         ```xml
         <bean id="studentDAO" class="org.kpu.di.persistence.StudentDAOImpl"></bean>
         
         <bean id="studentService" class="org.kpu.di.service.StudentServiceImpl">
         	<constructor-arg ref="studentDAO"/>
         </bean>
         ```

         

         ```java
         // 각 클래스 import 부분 
         
         // StudentService 인터페이스 구현
         public class StudentServiceImpl implements StudentService{
             private StudentDAO studentDAO;
             // 생성자의 인수를 사용하여 의존성을 주입한다.
             // 의존성 주입 대상 컴포넌트는 studentDAO
             public StudentServiceImpl(StudentDAO studentDAO){
                 this.studentDAO = studentDAO;
             }
         }
         ```

         

     - ***✅ 설정자 기반 의존성 주입(Setter Based Dependency Injection)***

       - 메서드의 인수를 통해 의존성 주입

       - xml 설정 파일에 **< property >** 요소의 **name** 속성에 주입할 **컴포넌트 이름** 설정

         ```xml
         <bean id="studentDAO" class="org.kpu.di.persistence.StudentDAOImpl"></bean>
         
         <bean id="studentService" class="org.kpu.di.service.StudentServiceImpl">
         	<property name="studentDAO" ref="studentDAO"/>
         </bean>
         ```

         

         ```java
         // StudentService 인터페이스 구현
         public class StudentServiceImpl implements StudentService{
             private StudentDAO studentDAO;
             // 설정자(setter 함수)의 인수를 사용하여 의존성 주입
             // 의존성 주입 대상 컴포넌트는 studentDAO
             public setStudentDAO(StudentDAO studentDAO){
                 this.studentDAO = studentDAO;
             }
         }
         ```

         <br> 

2. **Annotation 기반 설정**

   - **@Component Annotation**이 부여된 클래스를 DI Container가 자동으로 등록

   - 소스 코드에 **@애노테이션** 형태로 표현

   - 클래스, 메서드, 필드 선언부에 표현하여 특정 기능이 적용되었음을 알려준다.

   - xml 파일에 이미 등록된 빈들의 Annotation 기능을 적용한다.

   - **Annotation 설정**에는 2가지 방법이 있다.

     1. < context:**annotation-config** />
     2. < context:**component-scan** />

   - **📃 Annotation 종류**

     - **✅ @Autowired**
       - **Container**가 Bean과 다른 Bean과의 의존성을 자동으로 연결하도록 하는 수단

       - **유사한 기능** : @Inject, @Resource

       - 해당 타입의 컴포넌트를 찾아 그 인스턴스를 주입시켜준다.

       - < context:annotation-config /> 설정이 필요**(context:component-scan 설정 시 생략 가능하다.)**

         <br>

     - **✅ @Component**
       
       - **Container**가 주입을 위한 인스턴스를 설정하는 수단
       - **@Component**를 클래스 앞에 선언 시 컨테이너가 찾아서 관리하고<br> **@Autowired**가 붙은 인스턴스 변수에 주입시켜준다.
       - <context:component-scan base-package="패키지 이름"/> 선언 : <br> **@Component** 애노테이션이 붙은 클래스를 자동으로 빈으로 등록한다.
       - 특정 패키지 안에 클래스 검색, 빈을 자동으로 찾아서 **DI Container**에 등록
       - **@Component 확장 Annotation**
         - **@Controller** : <u>Presentation Layer</u> 스프링 MVC용 Annotation
         - **@Service** : <u>Business Logic Layer</u> Service용 Annotation
         - **@Repository** : <u>Data Access Layer</u>의 DAO용 Annotation
         - **@Configuration** : Bean정의를 자바 프로그램에서 실행하는 JavaConfig용 Annotation<br> <br> 

     - **✅ 🖇 < context:annotation-config >** 설정 시 **ApplicationContext.xml** 설정 **

       ```xml
       <bean id="studentDAO" class="org.kpu.di.persistence.StudentDAOImpl"></bean>
       <bean id="studentService" class="org.kpu.di.service.StudentServiceImpl"></bean>
       <context:annotation-config/>
       ```

       ```java
       // <context:annotation-config> 설정 시 StudentDAOImpl.java 설정
       
       package org.kpu.di.persistence;
       import java.util.HashMap;
       import java.util.Map;
       import org.kpu.di.domain.StudentVO;
       
       public class StudentDAOImpl implements StudentDAO{
           private Map<String, StudentVO> storage = new HashMap<String, StudentVO>();
           
           public StudentVO read(String id) throws Exception{
               return storage.get(id);
           }
           public void add(StudentVO student) throws Exception{
               storage.put(student.getId(), student);
           }
       }
       ```

       ```java
       // <context:annotation-config> 설정 시 StudentServiceImpl.java 설정
       
       package org.kpu.di.service;
       import org.kpu.di.domain.StudentVO;
       import org.kpu.di.persistence.StudentDAO;
       import org.springframework.beans.factory.annotation.Autowired;
       
       public class StudentServiceImpl implements StudentService{
           @Autowired
           private StudentDAO studentDAO;
           
           public StudentVO readStudent(String id) throws Exception{
               return studentDAO.read(id);
           }
           public void addStudent(StudentVO student) throws Exception{
               studentDAO.add(student);
           }
       }
       ```

     - **✅ < context:component-scan /> 설정 시 java 파일에 @Component를 설정해야 함**

       ```xml
       <!-- context:component-scan 설정 시 bean에 대한 context:annotation-config 설정이 필요 없다. -->
       <!-- 대신 java 파일에 @Component를 설정해서 해당 클래스가 컴포넌트라는 것을 알려줘야 한다.-->
       
       <context:component-scan base-package="org.kpu.di.persistence"></context:component-scan>
       <context:component-scan base-package="org.kpu.di.service"></context:component-scan>
       ```

       ```java
       // <context:component-scan/> 설정 시 StudentDAOImpl.java 설정
       package org.kpu.di.persistence;
       import java.util.HashMap;
       import java.util.Map;
       import org.kpu.di.domain.StudentVO;
       import org.springframework.stereotype.Component;
       
       @Component
       public class StudentDAOImpl implements StudentDAO{
           private Map<String, StudentVO> storage = new HashMap<String, StudentVO>();
           
           public StudentVO read(String id) throws Exception{
               return storage.get(id);
           }
           public void add(StudentVO student) throws Exception{
               storage.put(student.getId(), student);
           }
       }
       ```

       ```java
       // <context:component-scan/> 설정 시 StudentServiceImpl.java 설정
       package org.kpu.di.service;
       import org.kpu.di.domain.StudentVO;
       import org.kpu.di.persistence.StudentDAO;
       import org.springframework.beans.factory.annotation.Autowired;
       import org.springframework.stereotype.Component;
       
       @Component
       public class StudentServiceImpl implements StudentService{
           @Autowired
           private StudentDAO studentDAO;
           
           public StudentVO readStudent(String id) throws Exception{
               return studentDAO.read(id);
           }
           public void addStudent(StudentVO student) throws Exception{
               studentDAO.add(student);
           }
       }
       ```

       <br> 

3. **Java 기반 설정**

   - 자바 클래스에 **@Configuration Annotation**, 메서드에 **@Bean Annotation** 사용<br> 하여 Bean을 등록
     - **Configuration** : 빈 설정 메타 정보를 담고 있는 클래스 선언
     - **Bean** : 클래스 내의 메서드를 정의하여 빈 객체 정의 시 선언
   - 자바 코드로 빈을 설정하며, xml 파일을 사용하지 않는다.
     - 직접 의존 객체를 주입해야 한다.
   - 하나의 클래스 내에 복수의 빈 등록 가능
   - **TypeSafe**, **Refactoring**에 매우 적합하다.
   - 속성 명이나 클래스 명이 틀렸을 경우 컴파일 에러 발생
   - **Container 생성 클래스** : AnnotationConfigApplicationContext
   
   ```java
   // JavaConfig.java 파일 설정
   
   package org.kpu.di.config;
   
   import org.kpu.di.persistence.*;
   import org.kpu.di.service.*;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   
   // @Configuration Annotation 설정
   // 빈 설정 메타 정보를 담고 있는 클래스 선언
   @Configuration
   public class JavaConfig{
       // @Bean Annotation 설정
       // 클래스 내의 메서드 정의
       // 빈객체 정의 시 선언한다.
       // xml 파일을 설정할 필요가 없다.
       @Bean
       public MemberDAO memberDAO(){
           return new MemberDAOImpl();
       }
       
       // @Bean Annotation 설정
       // 클래스 내의 메서드 정의
       // 빈객체 정의 시 선언한다.
       // xml 파일을 설정할 필요가 없다.
       // Bean name을 지정해서 다른 java 파일에서 생성자가 호출되도록 id를 만들어준다.
       @Bean(name="service")
       public MemberService memberService(){
           return new MemberServiceImpl(memberDAO());
       }
   }
   ```
   
   ```java
   package org.kpu.di.main;
   
   import org.kpu.di.config.JavaConfig; // JavaConfig 파일 임포트
   import org.kpu.di.domain.StudentVO;
   import org.kpu.di.service.MemberService;
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.annotation.AnnotationConfigApplicationContext;
   
   public class MemberSampleMain{
       private static ApplicationContext ctx = null;
       public static void main(String[] args) throws Exception{
           System.out.println("안녕 DI-JavaConfig");
           
           ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
           MemberService memberService = ctx.getBean("service", MemberService.class);
           
           StudentVO vo = new StudentVO();
           vo.setId("kanadara");
           
           memberService.addMember(vo);
           
           StudentVO member = memberService.readMember("kanadara");
           System.out.println(member);
       }
   }
   ```
   
   <br> 

### **📌 역전 제어(IoC, Inversion of Control)**

- 인스턴스를 제어하는 주도권이 역전된다는 의미

  - 기존에는 객체 간의 관계를 개발자가 결정

  - IoC 개념을 도입하면 **Spring framework**의 **Spring Container**가 객체를 생성 해놓고<br> 필요 시점에 주입한다.

  - 즉, 객체 생성에 대한 주도권이 **Spring Container**에 존재

    <br> 

### **📌 역전 제어 컨테이너(IoC Container)**

- 객체를 생성 후 필요 시점에 **Dependency Injection**을 수행하는 **Spring Container**
- Spring framework의 **IoC Container** 또는 **DI Container**라 부른다.
- 객체(스프링 빈)의 생성, 관계, 조립, 생명주기를 관리한다.
- **의존 관계 설정 방법**
  - pom.xml 설정
  - Annotation 설정
  - Java Code 설정

<br> 

### **📌 Spring Container**

- Spring Container가 관리하는 객체인 Spring Bean의 생성, 관계, 조립, 생명주기<br> 를 관리하는 Spring Framework의 핵심이다.

- **Spring Container 종류**

  - **✅ BeanFactory(org.springframework.beans.factory.BeanFactory)**

    - 초창기 컨테이너
    - Bean의 생성, 의존관계 관리 등의 DI 기본 기능만 제공
    - 경량 컨테이너로 작업할 때 활용
    - 개발자가 xml 파일로부터 설정, BeanFactory가 해석해서 의존관계를 <br> 정의하고 개발자는 등록된 Bean을 호출하여 사용한다.
    - 가장 많이 사용되는 클래스

    ```java
    import org.springframework.beans.factory.xml.XmlBeanFactory;
    
    Resource xmlFile = new ClassPathResource("applicationContext.xml");
    
    // XmlBeanFactory() : 실제 컨테이너 객체를 생성하는 함수
    BeanFactory beanFactory = new XmlBeanFactory(xmlFile);
    
    // beanFactory.getBean() : myBean이라는 이름을 가진 객체를 불러오는 함수
    MyBean myBean = (MyBean)beanFactory.getBean("myBean");
    ```

    <br> 

  - **✅ ApplicationContext(org.springframework.context.ApplicationContext)**

    - **BeanFactory Container**의 기능을 확장한 컨테이너
      
      - **BeanFactory** 인터페이스를 상속받은 하위 인터페이스로 확장되었다.
      - **Internationalization**, **AOP**, **Transaction Management** 기능 추가
      
    - Bean 정의 파일 주요 스키마를 **ApplicationContext.xml**에 등록해야 한다.

      | 스키마 명칭 | 스키마 파일        | URL             | 의미                         |
      | :---------: | ------------------ | --------------- | ---------------------------- |
      |  **bean**   | spring-beans.xsd   | /schema/beans   | bean(컴포넌트) 설정          |
      | **context** | spring-context.xsd | /schema/context | bean 검색 &  Annotation 설정 |
      |  **lang**   | spring-lang.xsd    | /schema/lang    | Script 언어 사용시 설정      |
      |   **aop**   | spring-aop.xsd     | /schema/aop     | AOP 설정                     |
      |   **tx**    | spring-tx.xsd      | /schema/tx      | 트랜잭션 설정                |
      |   **mvc**   | spring-mvc.xsd     | /schema/mvc     | Spring MVC 설정              |
    
      
    
    - 일반적인 Spring Container
    
    - XML 파일로부터 설정 정보를 활용하고 가장 많이 사용된다.
    
    - 만들어지는 객체가 ApplicationContext로 변환된다.
    
    ```java
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    MyBean myBean = (MyBean)context.getBean("myBean"); 
    ```
    
    <br> 
    
  - **✅ WebApplicationContext(org.springframework.web.context.support.XmlWebApplicationContext)**
  
    - 웹 애플리케이션을 위한 **ApplicationContext**
  
    - ApplicationContext에 MVC 패턴을 사용할 때 사용된다.
  
    - XML 파일로부터 설정 정보를 활용하고 가장 많이 사용된다.
  
    - **web.xml**에서 **ContextLoaderListener**, **DispatcherServlet**을 사용하여 **ApplicationContext** 생성
  
      ```xml
      <context-param>
      	<param-name>contextConfigLocation</param-name>
          <!-- ContextLoaderListener에 의해 생성되는 WAC 설정 -->
          <param-value>/WEB-INF/spring/root-context.xml</param-value>
      </context-param>
      
      <listener>
      	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
      </listener>
      
      <servlet>
          <servlet-name>appServlet</servlet-name>
      	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
          <init-param>
          	<param-name>contextConfigLocation</param-name>
              <!-- DispatcherServlet에 의해 생성되는 WAC 설정 -->
              <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
          </init-param>
          <load-on-startup>1</load-on-startup>
      </servlet>
      
      <servlet-mapping>
      	<servlet-name>appServlet</servlet-name>
          <url-pattern>/</url-pattern>
      </servlet-mapping>
      ```
  
      
  
    - **WebApplicationContext (WAC)**
  
      1. **ContextLoaderListener에 의해 생성되는 WAC**
         - 웹 애플리케이션 전체에서 사용할 WAC 객체 생성
         - **root-context.xml** 파일에 설정한다.
         - DAO, Service 관련 스프링 빈들을 등록한다.
      2. **DispatcherServlet에 의해 생성되는 WAC**
         - 해당 서블릿 마다 사용할 WAC 객체 생성 
         - **servlet-context.xml** 파일에 설정한다.
         - Controler와 같은 서블릿 관련 빈을 등록한다.

### **📌 Spring Bean**

> **Spring Container가 관리하는 객체를 의미**

<br> 

### **📌 Bean 객체의 Scope**

- **singleton** : 기본 설정, 컨테이너 당 하나의 빈 객체만 생성

- **prototype** : 빈 요청 떄마다 빈 객체 생성

- **WebApplicationContext**에만 적용되는 Scope

  - **request** : 각 요청용으로 하나의 빈 객체 생성
  - **session** : 각 세션용으로 하나의 빈 객체 생성
  - **application** : 서블릿 컨텍스트 생성 시 빈 객체 생성 

  ```xml
  <!-- applicationContext.xml 설정 -->
  <bean id="memberDAO" class="org.kpu.di.persistence.MemberDAOImpl"
  	scope="singleton">
  </bean>
  
  <bean id="memberService" class="org.kpu.di.service.MemberServiceImpl">
  	<property name="memberDAO" ref = "memberDAO"/>
  </bean>
  ```

  <br> 

### **📌 Bean 객체의 Lifecycle**

- 초기화(Initialization) - 이용(use) - 종료(Destruction)

```java
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyBeanImpl implements LifeBean, InitializingBean, DisposableBean{
    @Override
    public void afterPropertiesSet() throws Exception{
        ...
    }
    
    @Override
    public void destroy() throws Exception{
        ...
    }
}
```



