# springmvc5-hibernate-without-xml

Technology stack:

* Spring 5 MVC 
* Spring Security 
* Spring Data JPA
* Hibernate 5.3
* Lombok
* H2 database

## Usage

1. Account (data.sql)
    ```
    Admin - admin:admin
    User - user:password
    Disabled - disabled:password (this user is disabled)
    ```

2. API

    1. Login
    ```
    POST /auth/login
    {
        "username": "admin",
        "password": "admin"
    }
    ```
    2. Check Token
    ```
    GET  /auth/checkToken 
    Authorization:Bearer TOKEN 
    ```
    3. Create User
    ```
    POST /user
    Authorization:Bearer TOKEN 
    {
        "username": "test",
        "password": "123456"
    }
    ```
    4. User List
    ```
    GET  /user/list 
    Authorization:Bearer TOKEN 
    ```
    5. Get User by ID
    ```
    GET  /user/{id} 
    Authorization:Bearer TOKEN 
    ```
## Run this project

1. Clone the codes.

   ```
    git clone https://github.com/JasonChang/springmvc5-hibernate-without-xml
   ```
  
2. And enter the root folder, run `mvn tomcat7:run` to start up an embedded tomcat7 to serve this application.
  
   ```
    mvn tomcat7:run
   ```

3. Go to [http://localhost:8080/api/list](http://localhost:8080/api/list) to test it.


## Reference
https://github.com/szerhusenBC/jwt-spring-security-demo