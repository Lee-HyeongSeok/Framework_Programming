## **🎈 의존성 주입(DI, Dependency Injection)**

***

<br> 

### **📌 Dependency**

- 객체 간의 **의존 관계**를 의미한다.

<br>

### **📌 Dependency Injection**

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

- **종류**

  - BeanFactory(org.springframework.beans.factory.BeanFactory)

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

  - ApplicationContext(org.springframework.context.ApplicationContext)

    - BeanFactory Container의 기능을 확장한 컨테이너
      - BeanFactory 인터페이스를 상속받은 하위 인터페이스로 확장되었다.
      - Internationalization, AOP, Transaction Management 기능 추가
    - 일반적인 Spring Container
    - XML 파일로부터 설정 정보를 활용하고 가장 많이 사용된다.
    - 만들어지는 객체가 ApplicationContext로 변환된다.

    ```java
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    MyBean myBean = (MyBean)context.getBean("myBean");
    ```

    <br> 

  - WebApplicationContext(org.springframework.web.context.support.XmlWebApplicationContext)

    - 웹 애플리케이션을 위한 **ApplicationContext**
    - ApplicationContext에 MVC 패턴을 사용할 때 사용된다.
    - XML 파일로부터 설정 정보를 활용하고 가장 많이 사용된다.
    - **WebApplicationContext (WAC)종류**
      1. **ContextLoaderListener에 의해 생성되는 WAC**
         - 웹 애플리케이션 전체에서 사용할 WAC 객체 생성
      2. **DispatcherServlet에 의해 생성되는 WAC**
         - 해당 서블릿 마다 사용할 WAC 객체 생성 

### **📌 Spring Bean**

> **Spring Container가 관리하는 객체를 의미**



