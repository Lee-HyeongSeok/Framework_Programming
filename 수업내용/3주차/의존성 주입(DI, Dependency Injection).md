## **๐ ์์กด์ฑ ์ฃผ์(DI, Dependency Injection)**

***

<br> 

### **๐ ์์กด์ฑ(Dependency)**

- ๊ฐ์ฒด ๊ฐ์ **์์กด ๊ด๊ณ**๋ฅผ ์๋ฏธํ๋ค.

<br>

### **๐ ์์กด์ฑ ์ฃผ์(DI, Dependency Injection)**

> **์ธํฐํ์ด์ค ๊ธฐ๋ฐ์ ์ปดํฌ๋ํธํ**

- ๊ฐ์ฒด๋ค ๊ฐ์ **์์กด ๊ด๊ณ๋ฅผ ์ค์ **ํ๋ ๊ฒ์ ์๋ฏธํ๋ค.
- ๊ธฐ์ ์ ํ๋ฆฌ์ผ์ด์ ๊ฐ๋ฐ ์ ํ๋์ ๊ธฐ๋ฅ์ ์ฒ๋ฆฌํ๊ธฐ ์ํด<br> ์ฌ๋ฌ ์ปดํฌ๋ํธ๋ฅผ ์กฐํฉํด์ ๊ตฌํํ๋ ๊ฒฝ์ฐ๊ฐ ์ผ๋ฐ ์ ์ด๋ค.
- ์ฌ๋ฌ ์ปดํฌ๋ํธ๋ฅผ ํตํฉํ  ๋ **์์กด ๊ด๊ณ ์ฃผ์(DI)** ๋์์ธ ํจํด์ด ํจ๊ณผ์ ์ด๋ค.
- ๊ธฐ์กด์ ์๋ฐ์์๋ new ํค์๋๋ฅผ ํตํด ๊ฐ์ฒด๋ฅผ ์์ฑํ์์ง๋ง, <br> **DI ๋์์ธ ํจํด**์ ์ ์ฉํ๋ฉด **์ธํฐํ์ด์ค ํ์**๋ง ์์ฑํ๋ฉด ์ค ๊ฐ์ฒด์ ์ ๊ทผ ๊ฐ๋ฅ
- ํ๋ก๊ทธ๋จ **Run time** ์ ์ค์ ํ ์์กด ๊ด๊ณ๊ฐ ์ฃผ์๋๋ค.
- ํ์ํ ์๋น์ค A, B๋ฅผ Spring Container๊ฐ A, B๋ฅผ ์์ฑํด์ค๋ค.
  - ์ฆ, ์์กด ๊ด๊ณ๋ฅผ ์ฃผ์ํ๋ ์ฃผ์ฒด๋ **Spring Container**
  - ๊ฐ์ฒด ๊ฐ์ ๊ฒฐํฉ๋๋ฅผ ๋ฎ์ถฐ์ค๋ค.

<br>

### **๐ ์์กด ๊ด๊ณ ์ฃผ์ ์ค์  ๋ฐฉ๋ฒ(DI setting)**

1. **XML ๊ธฐ๋ฐ ์ค์ **

   - xml ํ์ผ์ ์ฌ์ฉํ๋ **Bean ์์**๋ฅผ ์ ์

   - bean ํ๊ทธ์ ์์ฑ

     - |     ***์์ฑ***     | ***์๋ฏธ***                                                   |
       | :----------------: | ------------------------------------------------------------ |
       |       **id**       | ๊ฐ์ฒด๋ฅผ ์ ์ผํ๊ฒ ํ๋ id                                      |
       |      **name**      | ๊ฐ์ฒด ๋ช์ ์ ์, ๊ฐ์ฒด์ ์ฌ๋ฌ ์ด๋ฆ ์ค์ ํ  ๋, id์ ์ค์  ๋ถ๊ฐํ ์ด๋ฆ ์ง์  ์ |
       |     **class**      | id์ ์ค์ฒด๋ก ํจํค์ง๋ช๊ณผ ํด๋์ค๋ช์ผ๋ก ๊ตฌ์ฑ <br> **ex) org.kpu.di.persistence.StudentDAOImpl** |
       |     **scope**      | ๊ฐ์ฒด์ ๋ฒ์ ์ค์  <br> **singleton** : spring container ๋ด์ ๋จ ํ๋์ ๊ฐ์ฒด๋ง ์กด์ฌ<br> **prototype** : ๋ค์์ ๊ฐ์ฒด ์กด์ฌ ๊ฐ๋ฅ<br> **request** : ํ๋์ http request ์๋ช์ฃผ๊ธฐ ๋ด ๋จ ํ๋์ ๊ฐ์ฒด๋ง ์กด์ฌ<br> **session** : ํ๋์ http session ์๋ช์ฃผ๊ธฐ ๋ด ๋จ ํ๋์ ๊ฐ์ฒด๋ง ์กด์ฌ<br> **global session** : global http session ์๋ช์ฃผ๊ธฐ ๋ด ๋จ ํ๋์ ๊ฐ์ฒด๋ง ์กด์ฌ |
       |     **parent**     | ์ค์ ์ ๋ฌผ๋ ค๋ฐ์ ๊ฐ์ฒด๋ช ์ง์                                   |
       |    **abstract**    | **true ์ค์  ์** : ์ธ์คํด์ค๋ฅผ ๋ง๋ค์ง ์๊ณ  ๊ณตํต ์ค์  ์ ์<br> **false ์ค์  ์** : ๊ธฐ๋ณธ ๊ฐ, ์ธ์คํด์ค๋ฅผ ๋ง๋ค ๋ ์ง์  |
       |   **singleton**    | **true ์ค์  ์** : ๊ธฐ๋ณธ ๊ฐ, getBean ๋ฉ์๋๋ก ์ป๋ ์ธ์คํด์ค๋ ์ฑ๊ธํด์ด๋ค.<br> **false ์ค์  ์** : getBean ๋ฉ์๋๋ก ์ป๋ ์ธ์คํด์ค๋ ๋งค๋ฒ ์ธ์คํด์คํ ๋ ๊ฒ |
       |   **lazy-init**    | **true ์ค์  ์** : ์ธ์คํด์ค ์์ฑ ์ง์ฐ<br> **false ์ค์  ์** : ๊ธฐ๋ณธ ๊ฐ, BeanFactory ์์ ์ ์ธ์คํด์ค ์์ฑ |
       |   **depend-on**    | ์์กด ๊ด๊ณ ๋์ ๊ฐ์ฒด ์กด์ฌ ๊ฒ์ฌ                                |
       |  **init-method**   | ์ง์  ๋์ ๋ฉ์๋๋ ์ธ์๊ฐ ์๊ณ  void ํ์ด๋๋ค, ์ธ์คํด์ค ๋ณ์ ์ค์  ํ ํธ์ถ |
       | **destroy-method** | ์์คํ ์ข๋ฃ ์ ํธ์ถ๋๋ ๋ฉ์๋ ์ง์ , ์ธ์๊ฐ ์๊ณ  void ํ์ด์ฌ์ผ ํ๋ค.<br> ๋ฉ์๋๋ฅผ ๊ฐ์ง ๊ฐ์ฒด๋ ์ฑ๊ธํด์ด๋ค. |
       |     **parent**     | ์ค์ ์ ๋ฌผ๋ ค๋ฐ์ ๊ฐ์ฒด๋ช ์ง์                                   |
       |    **autowire**    | **no** : ๊ธฐ๋ณธ ๊ฐ, property ํ๊ทธ์ ref ํ๊ทธ๋ก ์ง์ ๋ ๊ฐ์ฒด๊ฐ ์ธ์คํด์ค ๋ณ์๋ก ์ค์ <br> **byName** : property ๋ช๊ณผ ์ผ์นํ๋ ๊ฐ์ฒด ๋ช์ Bean์ด ์๋์ผ๋ก ์ฃผ์๋๋ค.<br> **byType** : property ํ๊ณผ ์ผ์นํ๋ Bean์ด ์ฃผ์๋๋ค.<br> **constructor** : ์์ฑ์๋ฅผ ์ด์ฉํด ์ฃผ์ |

       

   - DI๋ฅผ ์ด์ฉํ ์ธํฐํ์ด์ค ๊ธฐ๋ฐ์ ์ปดํฌ๋ํธํ 

   - ์ปดํฌ๋ํธํ๋ฅผ ํตํด ํด๋์ค์ ๋ณ๊ฒฝ ๋๋ ํ์ฅ ์ ํด๋น ํด๋์ค๋ฅผ ์ด์ฉํ๋ <br> ๋ค๋ฅธ ํด๋์ค์ ์ํฅ ๋ฒ์๋ฅผ ์ต์ํํ  ์ ์๋ค.

   - **XML ๊ธฐ๋ฐ ์ค์  DI ๋ฐฉ์ 2๊ฐ์ง**

     - ***โ ์์ฑ์ ๊ธฐ๋ฐ ์์กด์ฑ ์ฃผ์(Constructor Based Dependency Injection)***

       - ์์ฑ์์ ์ธ์๋ฅผ ์ฌ์ฉํด ์์กด์ฑ ์ฃผ์

       - xml ์ค์  ํ์ผ์ **< contructor-arg >** ํ๊ทธ๋ฅผ ์ฌ์ฉ, ์ฃผ์ํ  **์ปดํฌ๋ํธ** ์ค์  

         ```xml
         <bean id="studentDAO" class="org.kpu.di.persistence.StudentDAOImpl"></bean>
         
         <bean id="studentService" class="org.kpu.di.service.StudentServiceImpl">
         	<constructor-arg ref="studentDAO"/>
         </bean>
         ```

         

         ```java
         // ๊ฐ ํด๋์ค import ๋ถ๋ถ 
         
         // StudentService ์ธํฐํ์ด์ค ๊ตฌํ
         public class StudentServiceImpl implements StudentService{
             private StudentDAO studentDAO;
             // ์์ฑ์์ ์ธ์๋ฅผ ์ฌ์ฉํ์ฌ ์์กด์ฑ์ ์ฃผ์ํ๋ค.
             // ์์กด์ฑ ์ฃผ์ ๋์ ์ปดํฌ๋ํธ๋ studentDAO
             public StudentServiceImpl(StudentDAO studentDAO){
                 this.studentDAO = studentDAO;
             }
         }
         ```

         

     - ***โ ์ค์ ์ ๊ธฐ๋ฐ ์์กด์ฑ ์ฃผ์(Setter Based Dependency Injection)***

       - ๋ฉ์๋์ ์ธ์๋ฅผ ํตํด ์์กด์ฑ ์ฃผ์

       - xml ์ค์  ํ์ผ์ **< property >** ์์์ **name** ์์ฑ์ ์ฃผ์ํ  **์ปดํฌ๋ํธ ์ด๋ฆ** ์ค์ 

         ```xml
         <bean id="studentDAO" class="org.kpu.di.persistence.StudentDAOImpl"></bean>
         
         <bean id="studentService" class="org.kpu.di.service.StudentServiceImpl">
         	<property name="studentDAO" ref="studentDAO"/>
         </bean>
         ```

         

         ```java
         // StudentService ์ธํฐํ์ด์ค ๊ตฌํ
         public class StudentServiceImpl implements StudentService{
             private StudentDAO studentDAO;
             // ์ค์ ์(setter ํจ์)์ ์ธ์๋ฅผ ์ฌ์ฉํ์ฌ ์์กด์ฑ ์ฃผ์
             // ์์กด์ฑ ์ฃผ์ ๋์ ์ปดํฌ๋ํธ๋ studentDAO
             public setStudentDAO(StudentDAO studentDAO){
                 this.studentDAO = studentDAO;
             }
         }
         ```

         <br> 

2. **Annotation ๊ธฐ๋ฐ ์ค์ **

   - **@Component Annotation**์ด ๋ถ์ฌ๋ ํด๋์ค๋ฅผ DI Container๊ฐ ์๋์ผ๋ก ๋ฑ๋ก

   - ์์ค ์ฝ๋์ **@์ ๋ธํ์ด์** ํํ๋ก ํํ

   - ํด๋์ค, ๋ฉ์๋, ํ๋ ์ ์ธ๋ถ์ ํํํ์ฌ ํน์  ๊ธฐ๋ฅ์ด ์ ์ฉ๋์์์ ์๋ ค์ค๋ค.

   - xml ํ์ผ์ ์ด๋ฏธ ๋ฑ๋ก๋ ๋น๋ค์ Annotation ๊ธฐ๋ฅ์ ์ ์ฉํ๋ค.

   - **Annotation ์ค์ **์๋ 2๊ฐ์ง ๋ฐฉ๋ฒ์ด ์๋ค.

     1. < context:**annotation-config** />
     2. < context:**component-scan** />

   - **๐ Annotation ์ข๋ฅ**

     - **โ @Autowired**
       - **Container**๊ฐ Bean๊ณผ ๋ค๋ฅธ Bean๊ณผ์ ์์กด์ฑ์ ์๋์ผ๋ก ์ฐ๊ฒฐํ๋๋ก ํ๋ ์๋จ

       - **์ ์ฌํ ๊ธฐ๋ฅ** : @Inject, @Resource

       - ํด๋น ํ์์ ์ปดํฌ๋ํธ๋ฅผ ์ฐพ์ ๊ทธ ์ธ์คํด์ค๋ฅผ ์ฃผ์์์ผ์ค๋ค.

       - < context:annotation-config /> ์ค์ ์ด ํ์**(context:component-scan ์ค์  ์ ์๋ต ๊ฐ๋ฅํ๋ค.)**

         <br>

     - **โ @Component**
       
       - **Container**๊ฐ ์ฃผ์์ ์ํ ์ธ์คํด์ค๋ฅผ ์ค์ ํ๋ ์๋จ
       - **@Component**๋ฅผ ํด๋์ค ์์ ์ ์ธ ์ ์ปจํ์ด๋๊ฐ ์ฐพ์์ ๊ด๋ฆฌํ๊ณ <br> **@Autowired**๊ฐ ๋ถ์ ์ธ์คํด์ค ๋ณ์์ ์ฃผ์์์ผ์ค๋ค.
       - <context:component-scan base-package="ํจํค์ง ์ด๋ฆ"/> ์ ์ธ : <br> **@Component** ์ ๋ธํ์ด์์ด ๋ถ์ ํด๋์ค๋ฅผ ์๋์ผ๋ก ๋น์ผ๋ก ๋ฑ๋กํ๋ค.
       - ํน์  ํจํค์ง ์์ ํด๋์ค ๊ฒ์, ๋น์ ์๋์ผ๋ก ์ฐพ์์ **DI Container**์ ๋ฑ๋ก
       - **@Component ํ์ฅ Annotation**
         - **@Controller** : <u>Presentation Layer</u> ์คํ๋ง MVC์ฉ Annotation
         - **@Service** : <u>Business Logic Layer</u> Service์ฉ Annotation
         - **@Repository** : <u>Data Access Layer</u>์ DAO์ฉ Annotation
         - **@Configuration** : Bean์ ์๋ฅผ ์๋ฐ ํ๋ก๊ทธ๋จ์์ ์คํํ๋ JavaConfig์ฉ Annotation<br> <br> 

     - **โ ๐ < context:annotation-config >** ์ค์  ์ **ApplicationContext.xml** ์ค์  **

       ```xml
       <bean id="studentDAO" class="org.kpu.di.persistence.StudentDAOImpl"></bean>
       <bean id="studentService" class="org.kpu.di.service.StudentServiceImpl"></bean>
       <context:annotation-config/>
       ```

       ```java
       // <context:annotation-config> ์ค์  ์ StudentDAOImpl.java ์ค์ 
       
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
       // <context:annotation-config> ์ค์  ์ StudentServiceImpl.java ์ค์ 
       
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

     - **โ < context:component-scan /> ์ค์  ์ java ํ์ผ์ @Component๋ฅผ ์ค์ ํด์ผ ํจ**

       ```xml
       <!-- context:component-scan ์ค์  ์ bean์ ๋ํ context:annotation-config ์ค์ ์ด ํ์ ์๋ค. -->
       <!-- ๋์  java ํ์ผ์ @Component๋ฅผ ์ค์ ํด์ ํด๋น ํด๋์ค๊ฐ ์ปดํฌ๋ํธ๋ผ๋ ๊ฒ์ ์๋ ค์ค์ผ ํ๋ค.-->
       
       <context:component-scan base-package="org.kpu.di.persistence"></context:component-scan>
       <context:component-scan base-package="org.kpu.di.service"></context:component-scan>
       ```

       ```java
       // <context:component-scan/> ์ค์  ์ StudentDAOImpl.java ์ค์ 
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
       // <context:component-scan/> ์ค์  ์ StudentServiceImpl.java ์ค์ 
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

3. **Java ๊ธฐ๋ฐ ์ค์ **

   - ์๋ฐ ํด๋์ค์ **@Configuration Annotation**, ๋ฉ์๋์ **@Bean Annotation** ์ฌ์ฉ<br> ํ์ฌ Bean์ ๋ฑ๋ก
     - **Configuration** : ๋น ์ค์  ๋ฉํ ์ ๋ณด๋ฅผ ๋ด๊ณ  ์๋ ํด๋์ค ์ ์ธ
     - **Bean** : ํด๋์ค ๋ด์ ๋ฉ์๋๋ฅผ ์ ์ํ์ฌ ๋น ๊ฐ์ฒด ์ ์ ์ ์ ์ธ
   - ์๋ฐ ์ฝ๋๋ก ๋น์ ์ค์ ํ๋ฉฐ, xml ํ์ผ์ ์ฌ์ฉํ์ง ์๋๋ค.
     - ์ง์  ์์กด ๊ฐ์ฒด๋ฅผ ์ฃผ์ํด์ผ ํ๋ค.
   - ํ๋์ ํด๋์ค ๋ด์ ๋ณต์์ ๋น ๋ฑ๋ก ๊ฐ๋ฅ
   - **TypeSafe**, **Refactoring**์ ๋งค์ฐ ์ ํฉํ๋ค.
   - ์์ฑ ๋ช์ด๋ ํด๋์ค ๋ช์ด ํ๋ ธ์ ๊ฒฝ์ฐ ์ปดํ์ผ ์๋ฌ ๋ฐ์
   - **Container ์์ฑ ํด๋์ค** : AnnotationConfigApplicationContext
   
   ```java
   // JavaConfig.java ํ์ผ ์ค์ 
   
   package org.kpu.di.config;
   
   import org.kpu.di.persistence.*;
   import org.kpu.di.service.*;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   
   // @Configuration Annotation ์ค์ 
   // ๋น ์ค์  ๋ฉํ ์ ๋ณด๋ฅผ ๋ด๊ณ  ์๋ ํด๋์ค ์ ์ธ
   @Configuration
   public class JavaConfig{
       // @Bean Annotation ์ค์ 
       // ํด๋์ค ๋ด์ ๋ฉ์๋ ์ ์
       // ๋น๊ฐ์ฒด ์ ์ ์ ์ ์ธํ๋ค.
       // xml ํ์ผ์ ์ค์ ํ  ํ์๊ฐ ์๋ค.
       @Bean
       public MemberDAO memberDAO(){
           return new MemberDAOImpl();
       }
       
       // @Bean Annotation ์ค์ 
       // ํด๋์ค ๋ด์ ๋ฉ์๋ ์ ์
       // ๋น๊ฐ์ฒด ์ ์ ์ ์ ์ธํ๋ค.
       // xml ํ์ผ์ ์ค์ ํ  ํ์๊ฐ ์๋ค.
       // Bean name์ ์ง์ ํด์ ๋ค๋ฅธ java ํ์ผ์์ ์์ฑ์๊ฐ ํธ์ถ๋๋๋ก id๋ฅผ ๋ง๋ค์ด์ค๋ค.
       @Bean(name="service")
       public MemberService memberService(){
           return new MemberServiceImpl(memberDAO());
       }
   }
   ```
   
   ```java
   package org.kpu.di.main;
   
   import org.kpu.di.config.JavaConfig; // JavaConfig ํ์ผ ์ํฌํธ
   import org.kpu.di.domain.StudentVO;
   import org.kpu.di.service.MemberService;
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.annotation.AnnotationConfigApplicationContext;
   
   public class MemberSampleMain{
       private static ApplicationContext ctx = null;
       public static void main(String[] args) throws Exception{
           System.out.println("์๋ DI-JavaConfig");
           
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

### **๐ ์ญ์  ์ ์ด(IoC, Inversion of Control)**

- ์ธ์คํด์ค๋ฅผ ์ ์ดํ๋ ์ฃผ๋๊ถ์ด ์ญ์ ๋๋ค๋ ์๋ฏธ

  - ๊ธฐ์กด์๋ ๊ฐ์ฒด ๊ฐ์ ๊ด๊ณ๋ฅผ ๊ฐ๋ฐ์๊ฐ ๊ฒฐ์ 

  - IoC ๊ฐ๋์ ๋์ํ๋ฉด **Spring framework**์ **Spring Container**๊ฐ ๊ฐ์ฒด๋ฅผ ์์ฑ ํด๋๊ณ <br> ํ์ ์์ ์ ์ฃผ์ํ๋ค.

  - ์ฆ, ๊ฐ์ฒด ์์ฑ์ ๋ํ ์ฃผ๋๊ถ์ด **Spring Container**์ ์กด์ฌ

    <br> 

### **๐ ์ญ์  ์ ์ด ์ปจํ์ด๋(IoC Container)**

- ๊ฐ์ฒด๋ฅผ ์์ฑ ํ ํ์ ์์ ์ **Dependency Injection**์ ์ํํ๋ **Spring Container**
- Spring framework์ **IoC Container** ๋๋ **DI Container**๋ผ ๋ถ๋ฅธ๋ค.
- ๊ฐ์ฒด(์คํ๋ง ๋น)์ ์์ฑ, ๊ด๊ณ, ์กฐ๋ฆฝ, ์๋ช์ฃผ๊ธฐ๋ฅผ ๊ด๋ฆฌํ๋ค.
- **์์กด ๊ด๊ณ ์ค์  ๋ฐฉ๋ฒ**
  - pom.xml ์ค์ 
  - Annotation ์ค์ 
  - Java Code ์ค์ 

<br> 

### **๐ Spring Container**

- Spring Container๊ฐ ๊ด๋ฆฌํ๋ ๊ฐ์ฒด์ธ Spring Bean์ ์์ฑ, ๊ด๊ณ, ์กฐ๋ฆฝ, ์๋ช์ฃผ๊ธฐ<br> ๋ฅผ ๊ด๋ฆฌํ๋ Spring Framework์ ํต์ฌ์ด๋ค.

- **Spring Container ์ข๋ฅ**

  - **โ BeanFactory(org.springframework.beans.factory.BeanFactory)**

    - ์ด์ฐฝ๊ธฐ ์ปจํ์ด๋
    - Bean์ ์์ฑ, ์์กด๊ด๊ณ ๊ด๋ฆฌ ๋ฑ์ DI ๊ธฐ๋ณธ ๊ธฐ๋ฅ๋ง ์ ๊ณต
    - ๊ฒฝ๋ ์ปจํ์ด๋๋ก ์์ํ  ๋ ํ์ฉ
    - ๊ฐ๋ฐ์๊ฐ xml ํ์ผ๋ก๋ถํฐ ์ค์ , BeanFactory๊ฐ ํด์ํด์ ์์กด๊ด๊ณ๋ฅผ <br> ์ ์ํ๊ณ  ๊ฐ๋ฐ์๋ ๋ฑ๋ก๋ Bean์ ํธ์ถํ์ฌ ์ฌ์ฉํ๋ค.
    - ๊ฐ์ฅ ๋ง์ด ์ฌ์ฉ๋๋ ํด๋์ค

    ```java
    import org.springframework.beans.factory.xml.XmlBeanFactory;
    
    Resource xmlFile = new ClassPathResource("applicationContext.xml");
    
    // XmlBeanFactory() : ์ค์  ์ปจํ์ด๋ ๊ฐ์ฒด๋ฅผ ์์ฑํ๋ ํจ์
    BeanFactory beanFactory = new XmlBeanFactory(xmlFile);
    
    // beanFactory.getBean() : myBean์ด๋ผ๋ ์ด๋ฆ์ ๊ฐ์ง ๊ฐ์ฒด๋ฅผ ๋ถ๋ฌ์ค๋ ํจ์
    MyBean myBean = (MyBean)beanFactory.getBean("myBean");
    ```

    <br> 

  - **โ ApplicationContext(org.springframework.context.ApplicationContext)**

    - **BeanFactory Container**์ ๊ธฐ๋ฅ์ ํ์ฅํ ์ปจํ์ด๋
      
      - **BeanFactory** ์ธํฐํ์ด์ค๋ฅผ ์์๋ฐ์ ํ์ ์ธํฐํ์ด์ค๋ก ํ์ฅ๋์๋ค.
      - **Internationalization**, **AOP**, **Transaction Management** ๊ธฐ๋ฅ ์ถ๊ฐ
      
    - Bean ์ ์ ํ์ผ ์ฃผ์ ์คํค๋ง๋ฅผ **ApplicationContext.xml**์ ๋ฑ๋กํด์ผ ํ๋ค.

      | ์คํค๋ง ๋ช์นญ | ์คํค๋ง ํ์ผ        | URL             | ์๋ฏธ                         |
      | :---------: | ------------------ | --------------- | ---------------------------- |
      |  **bean**   | spring-beans.xsd   | /schema/beans   | bean(์ปดํฌ๋ํธ) ์ค์           |
      | **context** | spring-context.xsd | /schema/context | bean ๊ฒ์ &  Annotation ์ค์  |
      |  **lang**   | spring-lang.xsd    | /schema/lang    | Script ์ธ์ด ์ฌ์ฉ์ ์ค์       |
      |   **aop**   | spring-aop.xsd     | /schema/aop     | AOP ์ค์                      |
      |   **tx**    | spring-tx.xsd      | /schema/tx      | ํธ๋์ญ์ ์ค์                 |
      |   **mvc**   | spring-mvc.xsd     | /schema/mvc     | Spring MVC ์ค์               |
    
      
    
    - ์ผ๋ฐ์ ์ธ Spring Container
    
    - XML ํ์ผ๋ก๋ถํฐ ์ค์  ์ ๋ณด๋ฅผ ํ์ฉํ๊ณ  ๊ฐ์ฅ ๋ง์ด ์ฌ์ฉ๋๋ค.
    
    - ๋ง๋ค์ด์ง๋ ๊ฐ์ฒด๊ฐ ApplicationContext๋ก ๋ณํ๋๋ค.
    
    ```java
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    MyBean myBean = (MyBean)context.getBean("myBean"); 
    ```
    
    <br> 
    
  - **โ WebApplicationContext(org.springframework.web.context.support.XmlWebApplicationContext)**
  
    - ์น ์ ํ๋ฆฌ์ผ์ด์์ ์ํ **ApplicationContext**
  
    - ApplicationContext์ MVC ํจํด์ ์ฌ์ฉํ  ๋ ์ฌ์ฉ๋๋ค.
  
    - XML ํ์ผ๋ก๋ถํฐ ์ค์  ์ ๋ณด๋ฅผ ํ์ฉํ๊ณ  ๊ฐ์ฅ ๋ง์ด ์ฌ์ฉ๋๋ค.
  
    - **web.xml**์์ **ContextLoaderListener**, **DispatcherServlet**์ ์ฌ์ฉํ์ฌ **ApplicationContext** ์์ฑ
  
      ```xml
      <context-param>
      	<param-name>contextConfigLocation</param-name>
          <!-- ContextLoaderListener์ ์ํด ์์ฑ๋๋ WAC ์ค์  -->
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
              <!-- DispatcherServlet์ ์ํด ์์ฑ๋๋ WAC ์ค์  -->
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
  
      1. **ContextLoaderListener์ ์ํด ์์ฑ๋๋ WAC**
         - ์น ์ ํ๋ฆฌ์ผ์ด์ ์ ์ฒด์์ ์ฌ์ฉํ  WAC ๊ฐ์ฒด ์์ฑ
         - **root-context.xml** ํ์ผ์ ์ค์ ํ๋ค.
         - DAO, Service ๊ด๋ จ ์คํ๋ง ๋น๋ค์ ๋ฑ๋กํ๋ค.
      2. **DispatcherServlet์ ์ํด ์์ฑ๋๋ WAC**
         - ํด๋น ์๋ธ๋ฆฟ ๋ง๋ค ์ฌ์ฉํ  WAC ๊ฐ์ฒด ์์ฑ 
         - **servlet-context.xml** ํ์ผ์ ์ค์ ํ๋ค.
         - Controler์ ๊ฐ์ ์๋ธ๋ฆฟ ๊ด๋ จ ๋น์ ๋ฑ๋กํ๋ค.

### **๐ Spring Bean**

> **Spring Container๊ฐ ๊ด๋ฆฌํ๋ ๊ฐ์ฒด๋ฅผ ์๋ฏธ**

<br> 

### **๐ Bean ๊ฐ์ฒด์ Scope**

- **singleton** : ๊ธฐ๋ณธ ์ค์ , ์ปจํ์ด๋ ๋น ํ๋์ ๋น ๊ฐ์ฒด๋ง ์์ฑ

- **prototype** : ๋น ์์ฒญ ๋๋ง๋ค ๋น ๊ฐ์ฒด ์์ฑ

- **WebApplicationContext**์๋ง ์ ์ฉ๋๋ Scope

  - **request** : ๊ฐ ์์ฒญ์ฉ์ผ๋ก ํ๋์ ๋น ๊ฐ์ฒด ์์ฑ
  - **session** : ๊ฐ ์ธ์์ฉ์ผ๋ก ํ๋์ ๋น ๊ฐ์ฒด ์์ฑ
  - **application** : ์๋ธ๋ฆฟ ์ปจํ์คํธ ์์ฑ ์ ๋น ๊ฐ์ฒด ์์ฑ 

  ```xml
  <!-- applicationContext.xml ์ค์  -->
  <bean id="memberDAO" class="org.kpu.di.persistence.MemberDAOImpl"
  	scope="singleton">
  </bean>
  
  <bean id="memberService" class="org.kpu.di.service.MemberServiceImpl">
  	<property name="memberDAO" ref = "memberDAO"/>
  </bean>
  ```

  <br> 

### **๐ Bean ๊ฐ์ฒด์ Lifecycle**

- ์ด๊ธฐํ(Initialization) - ์ด์ฉ(use) - ์ข๋ฃ(Destruction)

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



