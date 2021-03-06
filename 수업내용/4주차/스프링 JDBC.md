## **๐ Spring JDBC(Java DataBase Connectivity)**

***

<br> 

### **:computer: ํ์ฌ PC ํ๊ฒฝ**

- STS4 4.9.0 RELEASE
- JavaSE-1.8 use
- MySQL 8.0.23
- MySQL DB ๋ช : spring
- MySQL spring DB ์คํค๋ง ๋ช : springdb
- MySQL springdb Table ๋ช : student

![asd](https://user-images.githubusercontent.com/55940552/112479659-9a783480-8db8-11eb-9e49-6f86d0e4ee20.PNG) 





<br> 

### **๐ Spring JDBC๋?**

- ๋ชจ๋  ์ ์์ค ์ฒ๋ฆฌ๋ฅผ ์คํ๋ง ํ๋ ์์ํฌ์ ์์

  - Connection ์ฐ๊ฒฐ ๊ฐ์ฒด ์์ฑ ๋ฐ ์ข๋ฃ
  - ResultSet ์ฒ๋ฆฌ ๋ฐ ์ข๋ฃ
  - ์์ธ ์ฒ๋ฆฌ
  - ํธ๋์ญ์

- ๋ฐ๋ณต๋๋ ์ฒ๋ฆฌ๋ฅผ ๊ฐ๋ฐ์๊ฐ ์๋ ํ๋ ์์ํฌ์ ์์ ํ๋ ๊ฒ

- **Spring JDBC๊ฐ ์ ๊ณตํ๋ ์ค์ ํํ๋ฆฟ**

  - **JdbcTemplate**

    - [**JdbcTemplate** ํด๋์ค ์ ๊ณต ๋ฉ์๋]

      - queryForObject : ํ๋์ ๊ฒฐ๊ณผ ๋ ์ฝ๋ ์ค ํ๋์ ์ปฌ๋ผ ๊ฐ์ ๊ฐ์ ธ์จ๋ค.

        > **RowMapper์ ํจ๊ป ์ฌ์ฉ ์** : ํ๋์ ๋ ์ฝ๋ ์ ๋ณด๋ฅผ ๊ฐ์ฒด์ ๋งคํ

        ```java
        // ๋ ์ฝ๋ ์ ๋๋ ํน์  ์ปฌ๋ผ๋ง ์ทจ๋
        // student ํ์ด๋ธ์ ์ปฌ๋ผ ๊ฐ์๋ฅผ ๋ฆฌํด ๋ฐ๋ ์ฝ๋
        // queryForObject์ ์ธ์ : SQL ๋ฌธ์์ด, ๋ฐํํ ํด๋์ค ์ค๋ธ์ ํธ(int)
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        int count = jdbcTemplate.queryForObject(
        	"SELECT COUNT(*) FROM STUDENT", Integer.class);
        ```

        ```java
        // ๋ ์ฝ๋ ์ ๋๋ ํน์  ์ปฌ๋๋ง ์ทจ๋
        // student ํ์ด๋ธ์ username์ ๋ฐํ๋ฐ๋๋ค.
        // queryForObject์ ์ธ์ : SQL ๋ฌธ์์ด, ๋ฐํํ ํด๋์ค ์ค๋ธ์ ํธ(string), ํ๋ผ๋ฏธํฐ ๊ฐ
        String name = jdbcTemplate.queryForObject(
        	"SELECT username FROM STUDENT WHERE id=?", String.class, id);
        ```

        

      - queryForMap : ํ๋์ ๊ฒฐ๊ณผ ๋ ์ฝ๋ ์ ๋ณด๋ฅผ Map ํํ๋ก ๋งคํ

        ```java
        // ์ทจ๋ ๊ฒฐ๊ณผ๊ฐ ํ ๋ ์ฝ๋ ๊ฐ์ ์ทจ๋ํ  ๊ฒฝ์ฐ
        // queryForMap ๋ฉ์๋ : ํ ๋ ์ฝ๋ ๊ฐ์ Map ๋ฐ์ดํฐ๋ก ๋งคํ
        // ์ปฌ๋ผ ์ด๋ฆ์ ํค๋ก ๊ฐ์ ์ ์ฅํ๋ค.
        // ํด๋น ์์ ์์๋ Student ํ์ด๋ธ์ username์ด๋ผ๋ ์ปฌ๋ผ ์ด๋ฆ์ ํค๋ก ๊ฐ์ ์ ์ฅํ๋ค.
        Map<String, Object> student = jdbcTemplate.queryForMap(
        	"SELECT * FROM STUDENT WHERE=?", id);
        String name = (String)student.get("username"); //username์ด๋ผ๋ ํค๋ฅผ ๊ฐ์ง ๊ฐ์ ๊ฐ์ ธ์จ๋ค.
        ```

        

      - queryForList : ์ฌ๋ฌ Map ํํ์ ๊ฒฐ๊ณผ ๋ ์ฝ๋๋ฅผ ๋ค๋ฃฌ๋ค.

        ```java
        // ์ฌ๋ฌ ๋ ์ฝ๋ ๊ฐ์ Map ๋ฐ์ดํฐ๋ก ๋งคํํ๋ค.
        List<Map<String, Object>> studentList = jdbcTemplate.queryForMap(
        	"SELECT * FROM STUDENT");
        ```

        

      - query : ์ฌ๋ฌ ๋ ์ฝ๋๋ฅผ ๊ฐ์ฒด๋ก ๋ณํ, ์ฒ๋ฆฌ

      - update : ๋ฐ์ดํฐ์ ๋ณ๊ฒฝ(insert, update, delete ์คํ ์)

  - NamedParameterTemplate

<br> 

### **๐ ๋ฐ์ดํฐ ์ก์ธ์ค ์ธต**

- **์ญํ **
  - ๋ฐ์ดํฐ ์ก์ธ์ค ์ฒ๋ฆฌ๋ฅผ ๋น์ฆ๋์ค ๋ก์ง ์ธต์์ ๋ถ๋ฆฌํ๋ค.
- **ํน์ง**
  - ์ธ๋ถ ํ๋ ์์ํฌ๋ฅผ ๊ฐ์ ธ๋ค ์ฐ๋๊ฒ ๋๋ถ๋ถ์ด๊ธฐ ๋๋ฌธ์ DI๋ฅผ ์ค์ ํ๋ ๋ถ๋ถ์ด ๋ง๋ค.
- **DAO(Data Access Object)**
  - ๋ฐ์ดํฐ ์ก์ธ์ค ์ฒ๋ฆฌ์ ํนํ๋ ๊ฐ์ฒด

- **DAO ํจํด**
  - ๋ฐ์ดํฐ ์ทจ๋, ๋ณ๊ฒฝ ๊ฐ์ ๋ฐ์ดํฐ ์ฒ๋ฆฌ๋ฅผ DAO ๊ฐ์ฒด๋ก ๋ถ๋ฆฌํ๋ ํจํด์ ์๋ฏธํ๋ค.
  - ๋น์ฆ๋์ค ๋ก์ง์ด ๋ชจ๋  ๋ฐ์ดํฐ์ ๋ํ **CRUD**๋ฅผ ๋ฐ์ดํฐ ์ก์ธ์ค ์ธต์ ๋งก๊ธด๋ค.
    - **CRUD๋** : Computer Software๊ฐ ๊ฐ์ง๋ ๊ธฐ๋ณธ์ ์ธ ๋ฐ์ดํฐ ์ฒ๋ฆฌ ๊ธฐ๋ฅ์ ์ผ์ปท๋ ๋ง
      - **C**(Create) ์์ฑ - insert
      - **R**(Read) ์ฝ๊ธฐ - select
      - **U**(Update) ๊ฐฑ์  - update
      - **D**(Deleate) ์ญ์  - delete
  - Spring์ ๋ฐ์ดํฐ ์ก์ธ์ค ๊ธฐ์ ์ ์ฝ๊ฒ ์ฌ์ฉํ๊ธฐ ์ํ ์ฐ๊ณ ๊ธฐ๋ฅ์ ์ ๊ณตํ๋ค.
  - ๋ฐ์ดํฐ ์ก์ธ์ค ์ฒ๋ฆฌ <u>๊ธฐ์ </u>
    - JDBC
    - MyBatis
    - Hybernate
    - JPA

![Untitled Diagram](https://user-images.githubusercontent.com/55940552/112473303-84b34100-8db1-11eb-8703-4c9830bead26.png) 

<br> 



### **๐ ๋ฐ์ดํฐ ์์ค(DataSource)**

- ๋ฐ์ดํฐ ์ก์ธ์ค ๊ธฐ์ (JDBC, MyBatis ๋ฑ) ์ข๋ฅ์ ์๊ด์์ด DB ์ ์์ ๊ด๋ฆฌํด์ฃผ๋ ์ธํฐํ์ด์ค
  - ์๋ฌด์ฉ ์ ํ๋ฆฌ์ผ์ด์์ **Connection pool**์ ์ํด Connection Object๋ฅผ ์ฌ์ฌ์ฉํ๋ค.
- **pom.xml** ํ์ผ์ dependency ์ค์ 
- ์๋ ํํฐ๊ฐ ์ ๊ณตํ๋ **๋ฐ์ดํฐ ์์ค** : Apache Commons DBCP

```xml
<beans>
	...
    
    <dependencies>
    	...
        
        <!-- ๋ฐ์ดํฐ ์์ค๋ฅผ ๊ตฌํํ๊ธฐ ์ํ dbcp DI ์ค์  -->
        <dependency>
        	<groupId>commons-dbcp</groupId>
            <artifactId>commons-dbcp</artifactId>
            <version>1.4</version>
        </dependency>
    	
    </dependencies>

</beans>
```

```xml
<!-- Bean ์ ์ ํ์ผ์ DBCP ๋ฐ์ดํฐ ์์ค ์ค์  -->

<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
	<property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://127.0.0.1:3306/์คํค๋ง ๋ช?
                                allowPublicKeyRetrieval=true&amp;useUnicode=true&amp;characterEncoding=utf8&amp;
                                useSSL=false&amp;serverTimezone=UTC"/>
    <property name="username" value="์ ์ ๋์ DB ์์ด๋"/>
    <property name="password" value="์ ์ ๋์ DB ๋น๋ฐ๋ฒํธ"/>
    <property name="maxActive" value="5" />
</bean>

<!-- ํํ๋ฆฟ ํด๋์ค์ ์ค๋ธ์ ํธ ์์ฑ -->
<!-- ํํ๋ฆฟ ํด๋์ค๋ฅผ xml ํ์ผ์ bean์ผ๋ก ์ ์ํด์ผ ํ๋ค. -->
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
	<constructor-arg ref="dataSource"></constructor-arg>
</bean>

<bean class="org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate">
	<constructor-arg ref="dataSource"></constructor-arg>
</bean>
```

<br> 

### **๐ Spring JDBC ํ๋ก์ ํธ ๋ง๋ค๊ธฐ**

1. **Project ๋ง๋ค๊ธฐ**

![1](https://user-images.githubusercontent.com/55940552/113386594-8ee2ca00-93c5-11eb-8482-7459d826285f.PNG) 

<br> 

2. **POM.xml ์ค์ **

```xml
<!-- jdbc 5.2.12 ๋ฒ์  ์ค์ -->
<dependency>
	<groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.12.RELEASE</version>
</dependency>

<!-- dbcp 1.4 ์ค์  -->
<dependency>
	<groupId>commons-dbcp</groupId>
    <artifactId>commons-dbcp</artifactId>
    <version>1.4</version>
</dependency>

<!-- mysql connector ์ค์  -->
<dependency>
	<groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.22</version>
</dependency>
```

<br> 

3. src/main/resources/applicationContext.xml ์์ฑ ๋ฐ ๋ค์์คํ์ด์ค ์ถ๊ฐ

![2](https://user-images.githubusercontent.com/55940552/113386975-51cb0780-93c6-11eb-8168-0adca72073a5.PNG) 

<br> 

***

**[์ถ์ฒ]**

[ํ๊ตญ์ฐ์๊ธฐ์ ๋ํ๊ต](https://portal.kpu.ac.kr/portal/default/stu)

[๋ธ๋ก๊ทธ - spring jdbc๋?](https://velog.io/@koseungbin/Spring-JDBC)