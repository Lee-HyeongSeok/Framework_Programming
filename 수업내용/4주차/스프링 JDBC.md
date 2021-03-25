## **🎈 Spring JDBC(Java DataBase Connectivity)**

***

<br> 

### **:computer: 현재 PC 환경**

- STS4 4.9.0 RELEASE
- MySQL 8.0.23
- MySQL DB 명 : spring
- MySQL spring DB 스키마 명 : springdb
- MySQL springdb Table 명 : student

![asd](https://user-images.githubusercontent.com/55940552/112479659-9a783480-8db8-11eb-9e49-6f86d0e4ee20.PNG) 





<br> 

### **📌 Spring JDBC란?**

- 모든 저수준 처리를 스프링 프레임워크에 위임

  - Connection 연결 객체 생성 및 종료
  - ResultSet 처리 및 종료
  - 예외 처리
  - 트랜잭션

- 반복되는 처리를 개발자가 아닌 프레임워크에 위임 하는 것

- **Spring JDBC가 제공하는 중요 템플릿**

  - **JdbcTemplate**

    - [**JdbcTemplate** 클래스 제공 메서드]

      - queryForObject : 하나의 결과 레코드 중 하나의 컬럼 값을 가져온다.

        > **RowMapper와 함께 사용 시** : 하나의 레코드 정보를 객체에 매핑

        ```java
        // 레코드 수 또는 특정 컬럼만 취득
        // student 테이블의 컬럼 개수를 리턴 받는 코드
        // queryForObject의 인수 : SQL 문자열, 반환형 클래스 오브젝트(int)
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        int count = jdbcTemplate.queryForObject(
        	"SELECT COUNT(*) FROM STUDENT", Integer.class);
        ```

        ```java
        // 레코드 수 또는 특정 컬람만 취득
        // student 테이블의 username을 반환받는다.
        // queryForObject의 인수 : SQL 문자열, 반환형 클래스 오브젝트(string), 파라미터 값
        String name = jdbcTemplate.queryForObject(
        	"SELECT username FROM STUDENT WHERE id=?", String.class, id);
        ```

        

      - queryForMap : 하나의 결과 레코드 정보를 Map 형태로 매핑

        ```java
        // 취득 결과가 한 레코드 값을 취득할 경우
        // queryForMap 메서드 : 한 레코드 값을 Map 데이터로 매핑
        // 컬럼 이름을 키로 값을 저장한다.
        // 해당 예제에서는 Student 테이블의 username이라는 컬럼 이름을 키로 값을 저장했다.
        Map<String, Object> student = jdbcTemplate.queryForMap(
        	"SELECT * FROM STUDENT WHERE=?", id);
        String name = (String)student.get("username"); //username이라는 키를 가진 값을 가져온다.
        ```

        

      - queryForList : 여러 Map 형태의 결과 레코드를 다룬다.

        ```java
        // 여러 레코드 값을 Map 데이터로 매핑한다.
        List<Map<String, Object>> studentList = jdbcTemplate.queryForMap(
        	"SELECT * FROM STUDENT");
        ```

        

      - query : 여러 레코드를 객체로 변환, 처리

      - update : 데이터의 변경(insert, update, delete 실행 시)

  - NamedParameterTemplate

<br> 

### **📌 데이터 액세스 층**

- **역할**
  - 데이터 액세스 처리를 비즈니스 로직 층에서 분리한다.
- **특징**
  - 외부 프레임워크를 가져다 쓰는게 대부분이기 때문에 DI를 설정하는 부분이 많다.
- **DAO(Data Access Object)**
  - 데이터 액세스 처리에 특화된 객체

- **DAO 패턴**
  - 데이터 취득, 변경 같은 데이터 처리를 DAO 객체로 분리하는 패턴을 의미한다.
  - 비즈니스 로직이 모든 데이터에 대한 **CRUD**를 데이터 액세스 층에 맡긴다.
    - **CRUD란** : Computer Software가 가지는 기본적인 데이터 처리 기능을 일컷는 말
      - **C**(Create) 생성 - insert
      - **R**(Read) 읽기 - select
      - **U**(Update) 갱신 - update
      - **D**(Deleate) 삭제 - delete
  - Spring은 데이터 액세스 기술을 쉽게 사용하기 위한 연계 기능을 제공한다.
  - 데이터 액세스 처리 <u>기술</u>
    - JDBC
    - MyBatis
    - Hybernate
    - JPA

![Untitled Diagram](https://user-images.githubusercontent.com/55940552/112473303-84b34100-8db1-11eb-8703-4c9830bead26.png) 

<br> 



### **📌 데이터 소스(DataSource)**

- 데이터 액세스 기술(JDBC, MyBatis 등) 종류와 상관없이 DB 접속을 관리해주는 인터페이스
  - 업무용 애플리케이션은 **Connection pool**에 의해 Connection Object를 재사용한다.
- **pom.xml** 파일에 dependency 설정
- 서드 파티가 제공하는 **데이터 소스** : Apache Commons DBCP

```xml
<beans>
	...
    
    <dependencies>
    	...
        
        <!-- 데이터 소스를 구현하기 위한 dbcp DI 설정 -->
        <dependency>
        	<groupId>commons-dbcp</groupId>
            <artifactId>commons-dbcp</artifactId>
            <version>1.4</version>
        </dependency>
    	
    </dependencies>

</beans>
```

```xml
<!-- Bean 정의 파일에 DBCP 데이터 소스 설정 -->

<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
	<property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://127.0.0.1:3306/스키마 명?
                                allowPublicKeyRetrieval=true&amp;useUnicode=true&amp;characterEncoding=utf8&amp;
                                useSSL=false&amp;serverTimezone=UTC"/>
    <property name="username" value="접속 대상 DB 아이디"/>
    <property name="password" value="접속 대상 DB 비밀번호"/>
    <property name="maxActive" value="5" />
</bean>

<!-- 템플릿 클래스의 오브젝트 생성 -->
<!-- 템플릿 클래스를 xml 파일에 bean으로 정의해야 한다. -->
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
	<constructor-arg ref="dataSource"></constructor-arg>
</bean>

<bean class="org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate">
	<constructor-arg ref="dataSource"></constructor-arg>
</bean>
```

<br> 

### **📌 Spring JDBC 프로젝트 만들기**



<br> 

***

**[출처]**

[한국산업기술대학교](https://portal.kpu.ac.kr/portal/default/stu)

[블로그 - spring jdbc란?](https://velog.io/@koseungbin/Spring-JDBC)