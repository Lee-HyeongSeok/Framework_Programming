

## **๐ Spring MVC**

***

<br> 

### **:pushpin: Spring MVC๋**

> **MVC ํจํด ๊ธฐ๋ฐ์ Web Framework**

- **M(Model)** : ์ ํ๋ฆฌ์ผ์ด์ ์ ๋ณด, ๋ฐ์ดํฐ ์ฒ๋ฆฌ ๊ด๋ฆฌ
- **V(View)** : ์ฌ์ฉ์ ์ธํฐํ์ด์ค(ํ๋ฉด)
- **C(Controller)** : Model๊ณผ View ๊ฐ ์ํธ๋์ ์กฐ์  

<br> 

### **:pushpin: Spring MVC ํน์ง**

- Front Controller ํจํด์ ๊ธฐ์ดํ mvc ํ๋ ์์ํฌ

- ๊ธฐ๋ณธ์ ์ธ ์๋ฐ ์น ์ดํ๋ฆฌ์ผ์ด์ ์ค๊ณ ๋ฐฉ์์๋ **3๊ฐ์ง ๋ฐฉ์** ์กด์ฌ

  - **๋ชจ๋ธ 1 ์ค๊ณ ๋ฐฉ์**

    - JSP๋ก๋ง ๊ตฌํํ๊ฑฐ๋ Java Bean์ ํฌํจํ์ฌ ๊ฐ๋ฐ
    - ํ๋ก์ ํธ๊ฐ ์์ ๊ท๋ชจ์์ ์ฌ์ฉ์ด ํธํ๋ค.
    - ํ๋ก์ ํธ ๊ท๋ชจ๊ฐ ์ปค์ง๋ฉด ๊ฒฐํฉ๋๊ฐ ๋์์ ธ์ ์ ์ง๋ณด์๊ฐ ์ด๋ ต๋ค.

  - **๋ชจ๋ธ 2 ์ค๊ณ ๋ฐฉ์**

    - MVC ํจํด์ด ์ ์ฉ๋์ด ์๋ค(Model, View, Controller)
    - ๋ทฐ์ ๋ฒ ์ด์ค ๋ก์ง์ ๋ถ๋ฆฌ์ํจ ๊ตฌ์กฐ๋ค.
    - ๋๊ท๋ชจ ํ๋ก์ ํธ์์๋ ํ์ฅ์ฑ์ด ์ฉ์ดํ๊ณ  ์ ์ง๋ณด์์ฑ์ด ๋๋ค.

  - **ํ๋ก ํธ ์ปจํธ๋กค๋ฌ ์ค๊ณ ๋ฐฉ์(= DispatcherServlet)**

    - ์คํ๋ง MVC์์๋ ๊ธฐ๋ณธ์ ์ผ๋ก ํ๋ก ํธ ์ปจํธ๋กค๋ฌ ํจํด ์ ์ฉ๋์ด์๋ค.

    - ํด๋ผ์ด์ธํธ ์์ฒญ์ ๋ณ๋์ Front Controller์ ์ง์ค

    - Tomcat์ด ๋ธ๋ผ์ฐ์ ๋ก๋ถํฐ ๋ฐ์ ์์ฒญ์ ํ๋ก ํธ ์ปจํธ๋กค๋ฌ์ ๋ชจ๋ ์์ํ๋ค.

      - ๋ชจ๋  ์์ฒญ์ ๊ณตํต ๋ถ๋ถ์ ํ๋ก ํธ ์ปจํธ๋กค๋ฌ๋ค๋ก ์ฒ๋ฆฌํ๋ค.

    - ๊ธฐ์กด **model 2 ๋ฐฉ์**์์๋ ํด๋ผ์ด์ธํธ์ ์์ฒญ๋ง๋ค ์๋ธ๋ฆฟ์ด ์์ฑ๋์๋ค.

    - **DispatcherServlet**์ด๋ผ ํ๋ค.

      > **Servlet Container์์ HTTP ํ๋กํ ์ฝ์ ํตํด ๋ค์ด์ค๋ ๋ชจ๋  ์์ฒญ์<br> ํ๋ ์  ํ์ด์ ๊ณ์ธต์ ์ ์ผ ์์ ์์น์์ผ์ ์ค์ ์ง์ค์์ผ๋ก ์ฒ๋ฆฌํด์ฃผ๋ <br> Front Controller**

- ์คํ๋ง MVC๋ ๊ธฐ๋ณธ์ ์ผ๋ก MVC ํจํด์ด ์ ์ฉ๋์ด ์๋ค.

  - ๋ทฐ์ ๋ฒ ์ด์ค ๋ก์ง ๊ฐ์ ์ฝํ ๊ฒฐํฉ๋๋ก ๊ตฌ์ฑ๋์ด ์์ด์ ํ์ฅ, ์ ์ง๋ณด์๊ฐ ์ฝ๋ค.

- model, view, controller ๊ฐ๊ฐ์ ์ธํฐํ์ด์ค ์ ์
  - ๊ตฌํ์ ์์กด์ ์ด์ง ์์
  - ์ฝํ ๊ฒฐํฉ๋๋ก ๊ตฌ์ฑ๋์ด ์ ์ฐํ๊ณ  ํ์ฅ์ด ์ฝ๋ค.
  
- ๋ค์ํ **์๋ ํํฐ ๋ผ์ด๋ธ๋ฌ๋ฆฌ** ์ฐ๊ณ ์ง์(๋ทฐ ํ๋ ์์ํฌ)
  - Jackson, Google Gson, Google Protocol Buffers, Apache Tile, FreeMakers, Rome
  - JasperReports, ApachePOI, Hibernate Validators, Joda-Time, Thymeleaf, HDIV
  
- Annotation์ ๋์์ผ๋ก ์ฝ๋ฉ์ด ๊ฐ๋จํด์ก๋ค.
  
  - @Controller, @RequestMapping ๋ฑ

<br> 

### **:pushpin: DispatcherServlet**

> **Spring MVC์์ Front Controller ์ญํ ์ ํ๋ค.**

<br> 

### **:pushpin: Front Controller ํจํด์ ์ฒ๋ฆฌ ๋ฐฉ์(์ํ ํ๋ฆ)**

1. Tomcat์ด ๋ธ๋ผ์ฐ์ ๋ก๋ถํฐ ๋ฐ์ ์์ฒญ์ DispatcherServlet์๊ฒ ์ ๋ฌ
2. Dispatcher Servlet์ ๊ฐ๋ฐ์๊ฐ ๊ฐ๋ฐํ ์๋ธ ์ปจํธ๋กค๋ฌ์ ๋ธ๋ผ์ฐ์  ์์ฒญ์ ์์
   - ์ด ๋จ๊ณ์์ **DispatcherServlet**์ ์๋ธ ์ปจํธ๋กค๋ฌ๋ฅผ Spring Bean์ผ๋ก ๋ฑ๋กํ๋<br> ๊ณผ์ ์ด ์์ด์ผ ํ๋ค.
3. ์๋ธ ์ปจํธ๋กค๋ฌ๋ DAO ๊ฐ์ฒด๋ฅผ ํธ์ถ, ๊ฒฐ๊ณผ๋ฅผ ์ฒ๋ฆฌํด์ ๊ฒฐ๊ณผ ๊ฐ์ Model ๊ฐ์ฒด์ ์ ์ฅ ํ <br> View ์ ๋ณด๋ฅผ **DispatcherServlet**์ ๋ฆฌํด
   - VO๋ค์ Model ๊ฐ์ฒด๋ฅผ ํตํด ์ ๋ฌํ๋ ํํ๊ฐ ๋๋ค.
4. ์ด๋ ๊ฒ ์ํ๋ ๊ฒฐ๊ณผ๋ฅผ **DispatcherServlet**์ ํ๋ฉด์ ์ฒ๋ฆฌํด์ผ ํ๋ฏ๋ก ์ด๋ค ํ๋ฉด์ ์ฒ๋ฆฌ ํ <br> ๊ฐ์ฒด์ธ์ง ์์๋ด๊ธฐ ์ํด **View Resolver**์ ํ๋ฉด ์ฒ๋ฆฌ ์์ฒญ
5. **View Resolver**๋ ์ ๋นํ ๊ฐ์ฒด๋ฅผ **DispatcherServlet**์๊ฒ ๋ฆฌํด
6. **DispatcherServlet**์ ํด๋น ๊ฒฐ๊ณผ ํ๋ฉด์ **Model** ๊ฐ์ฒด๋ฅผ ๊ฐ์ ธ์ ํ๋ฉด์ ์ฒ๋ฆฌํ๋๋ก ์์ฒญ
7. ์ด ๊ฒฐ๊ณผ๋ฅผ ์์ฒญํ๋ ๋ธ๋ผ์ฐ์ ์ ์๋ต

<br>

![Untitled Diagram](https://user-images.githubusercontent.com/55940552/113391064-e38a4300-93cd-11eb-92b6-6fe1927c3f35.png) 

<br>

### **:pushpin: Spring MVC ๊ตฌ์ฑ ์์**

-  **DispatcherServlet**
  - ํ๋ก ํธ ์ปจํธ๋กค๋ฌ ๋ด๋น
  - ํด๋ผ์ด์ธํธ์ HTTP ์์ฒญ์ ๋ฐ์์ Controller์๊ฒ ์ ๋ฌํ๋ค.
  - ๋ฆฌํด ๊ฒฐ๊ณผ๊ฐ์ View Resolver์ ์ ๋ฌํ์ฌ ์๋ง์ ์๋ต ์์ฑ

- **HandlerMapping**
  - URL๊ณผ ์์ฒญ ์ ๋ณด๋ฅผ ๊ธฐ์ค์ผ๋ก ์ด๋ค Controller๋ฅผ ์คํํ ์ง ๊ฒฐ์ ํ๋ ๊ฐ์ฒด
  - DispatcherServl et์ ํ๋ ์ด์์ HandlerMapping์ ๊ฐ์ง ์ ์๋ค.
  - Annotation์ ์ด์ฉํ  ๋๋ <u>mvc:annotation-driven</u> ํ๊ทธ ์ค์  ํ์

- **Controller**
  - ํด๋ผ์ด์ธํธ ์์ฒญ์ ์ฒ๋ฆฌํ ๋ค ๊ฒฐ๊ณผ๋ฅผ DispatcherServlet์๊ฒ ์๋ ค์ค๋ค.

- **Model**
  - Controller๊ฐ View์๊ฒ ๋๊ฒจ์ค ๋ฐ์ดํฐ๋ฅผ ์ ์ฅํ๊ธฐ ์ํ ๊ฐ์ฒด

- **ViewResolver**
  - Controller๊ฐ ๋ฆฌํดํ View ์ด๋ฆ์ ๊ธฐ๋ฐ์ผ๋ก Controller ์ฒ๋ฆฌ ๊ฒฐ๊ณผ๋ฅผ ์์ฑํ  ๋ทฐ ๊ฒฐ์ 

- **View**
  - Controller์ ์ฒ๋ฆฌ ๊ฒฐ๊ณผ ํ๋ฉด์ ์์ฑ 

<br> 

### **:pushpin: Spring MVC Annotation**

> **Spring์ด ๊ด๋ฆฌํ๋ ์ปดํฌ๋ํธ๋ฅผ ๋ํ๋ด๋ ์ผ๋ฐ์ ์ธ ์คํ๋ ์ค ํ์**

- **@Component** : ์ผ๋ฐ์ ์ธ ์ปดํฌ๋ํธ
- **@Component์ ์ ๋ฌธํ๋ ํ์**
  - **@Repository** : Persistence ๊ณ์ธต ์ปดํฌ๋ํธ
  - **@Service** : Business(service) ๊ณ์ธต ์ปดํฌ๋ํธ
  - **@Controller** : Presentation ๊ณ์ธต ์ปดํฌ๋ํธ
- **@RestController** : @Controller + @ResponseBody(Spring 4.0 ์ดํ)
  - Controller๊ฐ Rest API ํํ๋ก JSON ํฌ๋งท์ ๋ณด๋ด๊ณ  ๊ฒฐ๊ณผ ๊ฐ์ ๋ง๋ค์ด์ฃผ๊ธฐ ์ํด<br> ๋ณ๋๋ก ์ ๋ธํ์ด์์ ๊ตฌ์ฒดํ ์ํจ ๊ฒ์ด๋ค.

<br> 

### **:pushpin: Spring MVC Library ์ค์ **

- **spring-webmvc**

  - pom.xml์ ์ค์ 
  - ์ค์  ์ spring-web๊ณผ ๊ธฐํ ์คํ๋ง ํ๋ ์์ํฌ์ ์์กด ๋ชจ๋์ ๋ํ ์์กด๊ด๊ณ๋ ํจ๊ป ์ฒ๋ฆฌ

  ```xml
  <dependency>
  	<groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.2.12.RELEASE</version>
  </dependency>
  ```

- **hibernate-validator**

  - pom.xml์ ์ค์ 
  - ์๋ ฅ ๊ฐ์ ์ ์์ฑ์ ๊ฒ์ฆํ๊ธฐ ์ํ ๋ผ์ด๋ธ๋ฌ๋ฆฌ
- hibernate-validator(Bean Validation ๊ตฌ์กฐ์ฒด)๋ฅผ ์ด์ฉํด ์๋ฐ ๋น(VO) ๊ฐ์ ์ ํจ์ฑ์ Annotation์ ํตํด ๊ฒ์ฆ
  
  ```xml
  <dependency>
  	<groupId>org.hibernate</groupId>
      <artifactId>hibernate-validator</artifactId>
      <version>6.1.2.Final</version>
  </dependency>
  ```



  <br> 

### **:pushpin: WebApplicationContext ๋ฑ๋ก ์ค์ (web.xml)**

- ContextLoaderListener, DispatcherServlet ์ด **web.xml**์ ๋ฑ๋ก๋์ด ์์ด์ผ<br> ์ด ๋ ํด๋์ค๊ฐ Web Application Context๋ฅผ ๋ง๋๋ ๊ณผ์ ์ ์ํํ๋ค.

- **ContextLoadListener**
  - **Servlet Container(Tomcat)**์ด ์์ฑ๋  ๋ ๊ทธ ์ด๋ฒคํธ๋ฅผ ๋ฐ์์ ์ฒ๋ฆฌํ๋ ๊ฒ์ด **ContextLoaderListener Class**
  - **Servlet Container(Tomcat)**์ ContextLoadListener ํด๋์ค ๋ฑ๋ก
  - ์๋น์ค ๊ณ์ธต ์ดํ์ ๋น์ ๋ฑ๋กํ๊ธฐ ์ํ ํด๋์ค
    - **@Service, @Repository ๋ฑ**
- **DispatcherServlet**
  - **Servlet Container(Tomcat)**์ ํ๋ก ํธ ์ปจํธ๋กค๋ฌ์ธ DispatcherServlet ํด๋์ค ๋ฑ๋ก
  - ๊ฐ๋ฐ์๊ฐ ๊ฐ๋ฐํ๋ ์ปจํธ๋กค๋ฌ๋ค์ ์คํ๋ง ๋น์ผ๋ก ๋ฑ๋กํ๋ค.
  - ์ปจํธ๋กค๋ฌ ๋น์ ๋ฑ๋กํ๊ธฐ ์ํ ํด๋์ค
    - **@Controller, @Component**

<br>

### **:pushpin: Controller ๊ธฐ๋ณธ ๊ตฌ์กฐ**

- ๋ชจ๋  Controller Class์๋ **@Controller** ์ ๋ธํ์ด์ ์ค์ 

- ๋ฉ์๋ ๋ฐํ์ผ๋ก๋ view ์ด๋ฆ์ ๋ฐํ

- **@Controller**

  - URL์ ์ฑ์์ง๊ณ  ๋ถ๋ ค์ง๋ Servlet

  - Controller ๊ด๋ จ ์ ๋ณด๋ servlet-context.xml์ ์ค์ ๋๋ค.

    - Controller ํจํค์ง ๋ด๋ถ์ **@Controller ์ ๋ธํ์ด์**์ด ์ง์ ๋ ํด๋์ค๋ฅผ ์ฐพ๋๋ค.

      ```xml
      <context:component-scan base-package="ํจํค์ง ๋ช"/>
      ```
    
    - ํด๋น๋๋ Controller๊ฐ URL์ ๋งคํ์ํค๊ธฐ ์ํด ํ์ํ ์ค์ 
    
      ```xml
      <mvc:annotation-driven>
      	<!-- ํจํค์ง ๋ด๋ถ์์ ์ฐพ์ Bean(Controller)๊ณผ URL์ ๋งคํ-->
      </mvc:annotation-driven>
      ```
    
    - DispatcherServlet์ด Controller์์ ์ธ์งํด์ Spring Bean์ผ๋ก ๋ฑ๋กํ๋ค.

- **@RequestMapping ์ ๋ธํ์ด์** : ์ฒ๋ฆฌ ํ  URL์ ๋ช์ํ๋ค.

  - ๋ฐฐ์ด ํํ์ ๊ฐ ์ง์  ๊ฐ๋ฅ<br> ex) @RequestMapping(value={"view1", "view2"}), view1๊ณผ view2 ์์ชฝ URL์ ๋์ํ๋ ๋ฉ์๋ ์ ์
  - **์์ฑ๊ณผ ๊ฐ์ ์ฌ์ฉํด์ URL์ ์ค์ ํ๋ค.**
    - **value** : URL ์์ฒญ๊ฒฝ๋ก
      - @RequestMapping("/view")
      - @RequestMapping(value="/view")
    - **method** : HTTP ๋ฉ์๋(GET or POST)
      - @RequestMapping(method = RequestMethod.GET)
    - **params** : ์์ฒญ ํ๋ผ๋ฏธํฐ ์ ๋ฌด or ํ๋ผ๋ฏธํฐ ๊ฐ
      - @RequestMapping(params = "action-new")
      - @RequestMapping(params = "forbidden")
      - @RequestMapping(params = {"action=edit", "userId"})

<br> 

### **:pushpin: Controller Method ๋งค๊ฐ๋ณ์**

> **Controller method์ ์ต์๋จ์ ์์นํ RequestMapping ์ ๋ธํ์ด์์ด <br>URL ๊ฒฝ๋ก ๋ด์ ๋ณ์ ๊ฐ์ ๊ฐ Controller Method ๋งค๊ฐ๋ณ์์๊ฒ ์ ๋ฌํ๋ค.**

- **RequestParam ๋งค๊ฐ๋ณ์**

  - ์์ฒญ URL์์ ๋ณ์๋ช๊ณผ ๊ฐ ๋ช์ ํํ๊ฐ **๊ฒฝ๋ก?๋ณ์๋ช=๋ณ์๊ฐ**์ด๋ค.

  ```java
  // ์์ฒญ URL : http://localhost:port/web/view?๋ณ์๋ช=๋ณ์๊ฐ, ๊ฒฝ๋ก ๋ค์ ?๋ณ์๋ช์ ํตํด ๊ฐ์ ๋ช์
  /* 
  1. @RequestMapping์ด value๋ก view๋ฅผ ์ง์ ํ์ผ๋ฏ๋ก URL์์ view๋ค์ ๋ณ์ ๊ฐ์ 
  2. @RequestParam ๋งค๊ฐ๋ณ์์์ ์ง์ ํ "msg"์ ์ ๋ฌ
  3. @RequestParam ๋งค๊ฐ๋ณ์๋ @RequestParam("msg") ์ค๋ฅธ์ชฝ์ ์ ์ธ๋ String msg์ ๋ณ์๊ฐ์ ์ ์ฅ
  */
  @RequestMapping(value="view", method=RequestMethod.GET)
  public String getURL(@RequestParam("msg") String msg){return "view";}
  ```

- **PathVariable ๋งค๊ฐ๋ณ์**

  - ์์ฒญ URL์์ ๋ณ์๋ช๊ณผ ๊ฐ ๋ช์ ํํ๊ฐ **๊ฒฝ๋ก/๋ณ์๊ฐ**์ด๋ค.

  ```java
  // ์์ฒญ URL : http://localhost:port/web/view/๋ณ์๊ฐ
  /*
  1. @RequestMapping์ด value๋ก view๋ฅผ ์ง์ ํ์ผ๋ฏ๋ก URL์์ view๋ค์ ๋ณ์ ๊ฐ์ 
  2. @PathVariable ๋งค๊ฐ๋ณ์์์ ์ง์ ํ "msg"์ ์ ๋ฌ
  3. @RequestParam ๋งค๊ฐ๋ณ์๋ @PathVariable("msg") ์ค๋ฅธ์ชฝ์ ์ ์ธ๋ String msg์ ๋ณ์๊ฐ์ ์ ์ฅ
  */
  @RequestMapping(value="view/{msg}", method=RequestMethod.GET)
  public String getURL(@PathVariable("msg") String msg){ return "view"; }
  ```

- **ModelAttribute ๋งค๊ฐ๋ณ์**

  - ์์ฒญ URL์์ ๋ณ์๋ช๊ณผ ๊ฐ ๋ช์ ํํ๊ฐ **๊ฒฝ๋ก?๋ณ์๋ช=๋ณ์๊ฐ**์ด๋ค.

  ```java
  // ์์ฒญ URL : http://localhost:port/web/view?๋ณ์๋ช=๋ณ์๊ฐ
  /* 
  1. @RequestMapping์ด value๋ก view๋ฅผ ์ง์ ํ์ผ๋ฏ๋ก URL์์ view๋ค์ ๋ณ์ ๊ฐ์ 
  2. @ModelAttribute ๋งค๊ฐ๋ณ์์์ ์ง์ ํ "msg"์ ์ ๋ฌ
  3. @RequestParam ๋งค๊ฐ๋ณ์๋ @ModelAttribute("msg") ์ค๋ฅธ์ชฝ์ ์ ์ธ๋ String msg์ ๋ณ์๊ฐ์ ์ ์ฅ
  */
  @RequestMapping(value="/view", method=ReqeustMethod.GET)
  public String getURL(@ModelAttribute("msg") String msg){ return "view"; }
  ```

- **Model ๊ฐ์ฒด**

<br> 

### **:pushpin: Controller Method์ ๋ฐํ ๊ฐ**

- **forward** : ์๋ฒ ๋ด ํ์ด์ง ์ ํ

  ```java
  @RequestMapping(value="/view")
  public String setURL(@ModelAttribute("msg") String msg){ return "forward:/otherPage"; }
  ```

- **redirect** : ๋ธ๋ผ์ฐ์  ๊ฒฝ์ฐ

  ```java
  @RequestMapping(value="/view")
  public String setURL(@ModelAttribute("msg") String msg){ return "redirect:/view"; }
  ```

  <br> 



### **:pushpin: REST ์ํคํ์ฒ ๋ฐฐ๊ฒฝ**

- ํด๋ผ์ด์ธํธ์ ์๋ฒ ์ฌ์ด ๋ฐ์ดํฐ ์ฐ๋์ ์ํ ์ํคํ์ฒ ์คํ์ผ
- ์ด์  ์น ์๋ฒ๋ ํด๋ผ์ด์ธํธ ์์ฒญ์ ๋ฐ์ผ๋ฉด ๋ฌธ์์ ๊ตฌ์กฐ๋ฅผ ๊ตฌ์ฑํ html ํํ๋ก ๊ฒฐ๊ณผ๋ฅผ ๋ฆฌํด
  - ๊ทธ๋ฌ๋ค๋ณด๋ ๋ค์ํ ํด๋ผ์ด์ธํธ๊ฐ ๋ฑ์ฅํ๋ค(pc, ๋ชจ๋ฐ์ผ, ๋๋ฐ์ด์ค ๋ฑ)
- ์น ์๋ฒ๊ฐ ๋ฒ์ฉ์ฑ์ ๋ํ needs๊ฐ ๋์ด๋๊ธฐ ์์ํ๋ค.
  - ๊ทธ๋์ ๋์จ๊ฒ REST ์ํคํ์ฒ์ด๋ค.

<br> 

### **:pushpin: REST ์ํคํ์ฒ ํน์ง**

- ์น ์๋ฒ ๋ฆฌ์์ค๋ฅผ URI๋ฅผ ํ ๋นํด์ ๋ฆฌ์์ค๋ฅผ ์ง์ 
- ์ง์ ๋ ๋ฆฌ์์ค์ ๋ํด HTTP Method๋ก ๋ฆฌ์์ค๋ฅผ ์กฐ์
- Rest ์๋ฒ๋ json, xml ๊ฐ์ ํํ ๋ฐฉ์์ผ๋ก ์ ์ก
  - **json**
    - ํค์ ๋ํ ๊ฐ์ผ๋ก ์ ์ฅ
    - xml๋ณด๋ค ๋ฐ์ดํฐ ํฌ๊ธฐ๊ฐ ์๋ค.
    - json ์ฌ์ฉ ๋ฒ์๊ฐ ๋์ด๋๋ ์ถ์ธ์ด๋ค.
  - **xml**
    - ์์ ํ๊ทธ, ์๋ ํ๊ทธ๋ก ๊ฐ์ ์ ์ฅ

<br>



### **:pushpin: REST Controller ์ฌ์ฉ์ ์ํ ๋ผ์ด๋ธ๋ฌ๋ฆฌ ์ค์ **

- ๋ฆฌ์์ค ํ์์ JSON(Java Script Object Notation)์ผ๋ก ์ฌ์ฉ

```xml
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.8</version>
</dependency>
```

<br> 

### **:pushpin: Rest Controller์ ์ฌ์ฉ๋๋ Annotation**

- **@RestController**
  - ํด๋น ์ปจํธ๋กค๋ฌ๊ฐ Rest Controller ์์ ์ ์ธํ๊ธฐ ์ํจ
  - Controller + Responsebody ์๋ฏธ๋ฅผ ํฉ์นจ
- **@RequestBody**
  - ํด๋ผ์ด์ธํธ ์ ๋ณด๊ฐ ์๋ฒ๋ก ๋์ด์ฌ ๋ json, xml ํฌ๋งท์ ํด๋น๋๋ ๋งค๊ฐ๋ณ์ ๊ฐ์ฒด๋ก<br> ๋ฐ์ธ๋ฉํ๊ธฐ ์ํด ์ฌ์ฉ 
- **@ResponseBody**
  - ์๋ฒ์์ ๋ง๋ค์ด์ง ๊ฒฐ๊ณผ๋ฅผ ํด๋ผ์ด์ธํธ์๊ฒ ์ ๋ฌํ  ๋ ResponseBody๋ฅผ ์ ์ธํด์ฃผ๋ฉด<br> ์๋์ผ๋ก json ํฌ๋งท์ผ๋ก ๋ณํ์์ผ์ ์ ์ก
- **@ResponseEntity**
  - ๊ฒฐ๊ณผ ๊ฐ ๋ฟ๋ง ์๋๋ผ ๊ฒฐ๊ณผ๋ฅผ ์ํํ๋ ์ํ ๊ฐ, ํค๋์ ๋ณ๋ ์ ๋ณด๋ฅผ ๋ฃ์ ๋ ๋ฌถ์ด์<br> ์ง์ ํด์ ํด๋ผ์ด์ธํธ์๊ฒ ๊ฒฐ๊ณผ ๊ฐ์ ๋ณด๋ผ ๋ ์ฌ์ฉ

<br> 

### **:pushpin: Spring MVC ์์ธ์ฒ๋ฆฌ**

- ์คํ๋ง MVC์์ ์์ธ์ฒ๋ฆฌ๋ฅผ ํ๊ธฐ ์ํด์๋ 2๊ฐ์ง ์ ๋ธํ์ด์์ด ํ์ํ๋ค.

  - **@ControllerAdvice ์ ๋ธํ์ด์**

    - ์ด๋ค ์ปจํธ๋กค๋ฌ์๋ ์์ธ๊ฐ ๋ฐ์ํ๋ฉด,<br> ์์ธ์ฒ๋ฆฌ ํด๋์ค๊ฐ ์์ผ๋ฉด ํด๋น ์์ธ์ฒ๋ฆฌ ํด๋์ค์ ๋ฉ์๋๋ฅผ ํธ์ถํ๋ค.
    - @Component ์ ๋ธํ์ด์์ ๋ถ์ด๋ ์ด์ 
      - ํด๋น ํด๋์ค๋ ์คํ๋ง ๋น์ผ๋ก ๋ฑ๋กํด์ผ ๋๋ฏ๋ก
      - DispatcherServlet๊ฐ ํด๋น ๋๋ @ControllerAdvice๋ ์คํ๋ง ๋น์ผ๋ก ๋ฑ๋กํด์ผ๋๊ธฐ ๋๋ฌธ
      - component-scan์ ํตํด ์์ธ์ฒ๋ฆฌ ํด๋์ค๋ฅผ ๋น์ผ๋ก ๋ฑ๋กํด์ผ ํ๋ค.

  - **@ExceptionHandler ์ ๋ธํ์ด์**

    - ์์ธ์ฒ๋ฆฌ ํด๋์ค ๋ด ํน์  ์์ธ์ ๋ํด ์ฒ๋ฆฌํ  ๋ฉ์๋์๋<br> @ExceptionHandler ์ ๋ธํ์ด์ ์ค์ 

    - ๊ฐ ๋ฉ์๋๋ ์ด๋ค ์์ธ์ ๋ํด ์ฒ๋ฆฌํ  ๊ฒ์ธ์ง ์์ฑ ์ง์  ํ์

      > **ex) @ExceptionHandler(DataNotFoundException.class)**

    - ๋ฉ์๋์์๋ ์ฃผ๋ก ์์ธ ์ฒ๋ฆฌ ํ์ด์ง๋ฅผ ๋ฐํํ๋ค.

<br> 

### **:pushpin: REST Controller ์ค์  JAXB**

- XML ํ์์ HTTP ๋ฉ์์ง๋ฅผ JAXB(Java Architecture for XML Binding)๋ก ๋ณํ

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

### **:pushpin: REST Controller Response Message [HTTP Message : GET ๋ฐฉ์]**

- **Get ๋ฐฉ์**์ผ๋ก ํด๋ผ์ด์ธํธ๋ก๋ถํฐ URL ์์ฒญ์ ๋ฐ์์ ๋ - **json ์๋ต**

  - **MemberRestController.java ๋ด๋ถ readMember() ๋ฉ์๋**

  ```java
  @RestController
  @RequestMapping("/member/rest")
  public class MemberRestController {
  
  	@Autowired(required=true)
      private MemberService memberService;
  	
  	private static final Logger logger = LoggerFactory.getLogger(MemberRestController.class);
  	
      // ResponseEntity ์ ๋ธํ์ด์์ ์ฌ์ฉ
      // ์๋ต ๋ฉ์์ง ํ์ ์ง์  ๊ฐ๋ฅ 
      // ์์ฒญ ๋ฉ์๋ GET์ผ๋ก ์ง์ 
      @RequestMapping(value = "/{id}", method = RequestMethod.GET)
      public ResponseEntity<StudentVO> readMember(@PathVariable String id) throws Exception {
      	StudentVO student = memberService.readMember(id);
      	
  		logger.info(" /member/rest/{id} REST-API GET method called. then readMember method executed.");
  		HttpHeaders headers = new HttpHeaders();
          // HTTP ์๋ต ๋ฉ์์ง ์ค์ 
          // HTTP ์๋ต ๋ฉ์์ง ํ์ ์ค์  : URL ์์ฒญ์ ๋ํ ๋ฉ์์ง ๋ด์ฉ์ json ํํ๋ก ๋ณํ(ํค, ๊ฐ) ์
  		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
  		headers.set("My-Header", "MyHeaderValue");
  		return new ResponseEntity<StudentVO>(student, headers, HttpStatus.OK);
      }
  }
  
  ```

   ![post](https://user-images.githubusercontent.com/55940552/114511899-756a3980-9c73-11eb-84a6-80f95767d992.PNG) 

- **GET ๋ฐฉ์**์ผ๋ก ํด๋ผ์ด์ธํธ๋ก๋ถํฐ URL ์์ฒญ์ ๋ฐ์์ ๋ - **xml ์๋ต**

  - **MemberRestController.java ๋ด๋ถ readMember() ๋ฉ์๋**

  ```java
  @RestController
  @RequestMapping("/member/rest")
  public class MemberRestController {
  
  	@Autowired(required=true)
      private MemberService memberService;
  	
  	private static final Logger logger = LoggerFactory.getLogger(MemberRestController.class);
  	
      // ResponseEntity ์ ๋ธํ์ด์์ ์ฌ์ฉ
      // ์๋ต ๋ฉ์์ง ํ์ ์ง์  ๊ฐ๋ฅ 
      // ์์ฒญ ๋ฉ์๋ POST์ผ๋ก ์ง์ 
      @RequestMapping(value = "/{id}", method = RequestMethod.POST)
      public ResponseEntity<StudentVO> readMember(@PathVariable String id) throws Exception {
      	StudentVO student = memberService.readMember(id);
      	
  		logger.info(" /member/rest/{id} REST-API GET method called. then readMember method executed.");
  		HttpHeaders headers = new HttpHeaders();
          // HTTP ์๋ต ๋ฉ์์ง ์ค์ 
          // HTTP ์๋ต ๋ฉ์์ง ํ์ ์ค์  : URL ์์ฒญ์ ๋ํ ๋ฉ์์ง ๋ด์ฉ์ xml ํํ๋ก ๋ณํ
  		headers.setContentType(new MediaType("application", "xml", Charset.forName("UTF-8")));
  		headers.set("My-Header", "MyHeaderValue");
  		return new ResponseEntity<StudentVO>(student, headers, HttpStatus.OK);
      }
  }
  
  ```

  ![get](https://user-images.githubusercontent.com/55940552/114511894-74390c80-9c73-11eb-87d2-82257ed214e8.PNG) 

### **:pushpin: Spring ๋๋ ํฐ๋ฆฌ ๊ตฌ์กฐ**

![Untitled Diagram](https://user-images.githubusercontent.com/55940552/113396277-3a941600-93d6-11eb-8548-2ee7ae55c8de.png) 

***

**[์ถ์ฒ]**

[ํ๊ตญ์ฐ์๊ธฐ์ ๋ํ๊ต](http://www.kpu.ac.kr/index.do?sso=ok)

[naver ๋ธ๋ก๊ทธ - spring mvc๋?](https://m.blog.naver.com/PostView.nhn?blogId=kksssii&logNo=220658615169&proxyReferer=https:%2F%2Fwww.google.com%2F)

[mvc ํ๋ก์ ํธ ๊ธฐ๋ณธ ๊ตฌ์กฐ](https://devpad.tistory.com/24)

