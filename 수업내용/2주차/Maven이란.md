## **🎈 *Maven이란?***

***

<br>

### **📌 Maven이란?**

> **스프링 프로젝트 관리 툴을 말한다.**

<br>

### **📌 Maven의 기능**

- **프로젝트 관리 - 의존성 관리 기능**

  - **Maven**을 사용하여 프로젝트의 라이브러리 의존성 관리
  - 실제 .jar 파일들을 관리할 필요 없이 **pom.xml** 파일만 관리한다.
  - 프로젝트 내에서 사용할 외부 라이브러리들을 **pom.xml**에 정의 후 관리하는 기능
  - pom.xml 내부에는 **dependencies** 안에 **dependency**로 작성

  ```xml
  <dependencies>
  	<dependency>
      	<groupId>javax.servlet</groupId>
          <artifacId>javax.servlet-api</artifacId>
          <version>3.1.0</version>
      </dependency>
  </dependencies>
  ```

  

- **프로젝트 빌드 - 빌드 자동화(컴파일, 실행, 배포 등)**
  
  - 빌드 기능을 제공하지만 설정을 통해 빌드할 수 있는 환경을 구성해주는 역할을 한다.
  - Maven 자체가 직접 프로젝트를 빌드하는 것이 아니다.

<br>  

### **📌 Maven의 pom.xml 파일**

- 프로젝트 디렉터리 구조와 그 안에 필요한 라이브러리들을 pom.xml에 설정해서 관리한다.

- 라이브러리 의존관계를 설정한다.

- 모든 pom.xml은 Super pom.xml으로부터 상속받는다.

  - pom.xml을 수정해서 오버라이드를 함으로써 객체 지향 특성인 재정의를 통해 사용자가 원하는<br> 환경으로 빌드 및 사용이 가능해진다.

  - 기본 설정 이외에 필요한 라이브러리들을 추가하여 사용한다.

  - 보통 **<u>Maven Repository</u>**에서 필요한 라이브러리에 대한 정보를 얻을 수 있다.

    [📃 Maven Repository 사이트](https://mvnrepository.com/)

<br>

### **📌 Maven - Scope 설정**

> **의존 라이브러리 적용 시점을 제한한다.**

- **compile** : 기본 스코프
- **provided** : **컴파일 시** 직접 의존성 참조, **런타임 시** 다른 환경에서 의존성 제공 받음
- **runtime** : 애플리케이션 실행 시 사용되는 라이브러리에 경우 설정
- **test** : 테스트 시점에만 사용하는 라이브러리에 경우 설정
- **system** : 개발자가 직접 jar 파일을 제공해야 하는 provided 스코프
- **import** : 다른 POM 설정 파일에 정의 되어 있는 의존 관계 설정을 현 프로젝트로 가져온다.
  - **import**는 **<dependencyManagement/>** 엘리먼트에서만 사용가능
  - **POM** : 프로젝트 디렉터리 구조와 그 안에 필요한 라이브러리 의존 관계를 설정하는 xml 파일

<br> 

### **📌 Maven Build Life Cycle**

- **Goal** : 빌드 시 기본적으로 해야 할 작업이다.

  - **각 빌드 단계에서 수행되는 작업을 Goal이라 한다.**
  - <u>컴파일 -> 테스트 -> 패키지</u> 순으로 작업 수행
  - 컴파일, 테스트, 패키지는 각각의 페이즈로 나뉜다.
  - 각 단계의 페이즈를 앞 단계 페이즈까지 작업을 수행해야 한다.
  - 이를 ***빌드 라이프 사이클***이라 한다.
  - **각 단계에서의 Maven Plug-In** 

  > **Compile Phase** : compiler:compile
  >
  > **Test Phase** : surefire:test
  >
  > **Package Phase** : jar:jar 

  <br>  

- **Plug-In** : Goal을 수행하는 주체다.

  - 해당되는 Goal과 Plug-in을 매칭시켜준다.
  - 실제 Goal은 해당 단계에 연결된 Plug-in에 의해 실행된다.

<br> 

### **📌 Maven Build의 3가지 라이프 사이클**

1. **빌드 라이프 사이클**

   - **[1] 리소스 준비**

   - **[2] 컴파일 페이즈** : 컴파일 수행(Source Code를 Byte Code로 변환)
   - **[3] 테스트 페이즈** : 컴파일 -> 테스트 수행(Source Code 수행)
   - **[4] 패키지 페이즈** : 컴파일 -> 테스트 -> 패키지 수행(웹 아카이브를 자바 아카이브 파일로 변환)
   - **[5] 인스톨 **(로컬 레파지토리에 저장)
   - **[6] 배포** (원격 레파지토리에 배포)

   ![Untitled Diagram](https://user-images.githubusercontent.com/55940552/110914423-b233cf80-8359-11eb-9068-3e3b856d52a4.png) 

   <br> 

2. **클린 라이프 사이클**

   - Clean 페이즈를 이용

   - Maven Build 이후, target에 존재하는 모든 아카이브 파일을 삭제한다.<br> 

3. **사이트 라이프 사이클**

   - 특정 위치에 만든 것을 배포하는 것
   - site, site-deploy 페이즈를 이용

<br> 

### **📌 Maven Plug-in**

- **clean** : 빌드 이후 target 디렉토리 내용 모두 삭제
- **compiler** : 자바 소스 컴파일
- **surefire** : JUnit 단위 테스트 실행, 리포트 생성
- **jar** : 현 프로젝트의 JAR file 생성
- **war** : 현 프로젝트의 WAR file 생성
- **javadoc** : 프로젝트의 Javadoc 문서 생성
- **antrun** : 빌드 페이지 단계에서 특정 ant 작업 실행

> **ex) maven-compiler-plugin**
>
> **ex) maven-clean-plugin**
>
> **ex) maven-surefire-plugin**

<br> 

