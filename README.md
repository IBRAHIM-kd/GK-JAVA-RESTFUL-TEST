# GK-JAVA-RESTFUL-TEST
GK JAVA RESTFUL SERVICE TEST PROJECT 


---------------------------------------------------------------------------------
STEPS 1
---------------------------------------------------------------------------------       
       GK JAVA RESTFUL WEB SERVICE PROJECT 

       BELOW ARE THE  DETAILS AND DOCUMENTATION ON HOW TO RUN THIS PROJECT 

-----------------------------------------------------------------------------------
STEPS 2
-----------------------------------------------------------------------------------

       REQUIREMENTS FOR THIS PROJECT ARE LISTED BELOW ALSO......

IDE             Eclipse IDE

Build Tool   	Apache-maven-3.5.3 or higher

Web framework	Spring Boot 2.0.0.RELEASE

Dependency	  Spring security

Dependency	  H2database

Dependency	  Spring Data Jpa

Dependency      spring boot starter web

Dependency      spring boot maven plugin

Dependency      spring boot starter test

Dependency      io.jsonwebtoken

Version Control	GIT

Language        JAVA 1.8

-------------------------------------------------------------------------------------------
STEPS  3
--------------------------------------------------------------------------------------------

   YOU CAN RUN THIS APPLICATION BY BELOW STEPS,........

1. git clone https://github.com/IBRAHIM-kd/GK-JAVA-RESTFUL-TEST.git

2. cd GK-JAVA-RESTFUL-TEST

3. mvn clean install

4. mvn spring-boot:run 

-----------------------------------------------------------------------------------------
STEPS  4
-----------------------------------------------------------------------------------------

     TO ACCESS THE LINKS FOR THIS APPLICATION PERFORMS THIS STEPS BELOW.....

     I AM USING POSTMAN CLIENT FOR THIS APPLICATION


1.   FROM POSTMAN CLIENT : POST - http://localhost:8080/users/sign-up

     Body  JSON (application/json)

     example : { "username": "ibrahimkd", "phone": "0835593988", "password": "booking100" }

     THAN CLINK ON SEND BOTTON 


2.   FROM POSTMAN CLIENT : GET - http://localhost:8080/users/all-users

     Body 
     
     The output well be in json format..... ! YOU NEED A BASIC AUTHENTICATION AT THIS POINT KEEP NOTE ON THAT'S ETC ! TO ACCESS THE UNIQUES REGISTERED USERS

     THAN CLINK ON SEND BOTTON  

3.   FROM POSTMAN CLIENT : GET - http://localhost:8080/users/count

     Body 
     
     The output well be in json format.....

     THAN CLINK ON SEND BOTTON 

4.   FROM POSTMAN CLIENT : GET - http://localhost:8080/users/login

     Body 
     
     The output well be in json format..... E.g {"id": "id", "token": "session-token"}

     THAN CLINK ON SEND BOTTON 

4.   FROM POSTMAN CLIENT : GET - http://localhost:8080/users/logout/{id}

     Body 
     
     The output well be in json format..... E.g {"token": "session-token"}

     THAN CLINK ON SEND BOTTON 



