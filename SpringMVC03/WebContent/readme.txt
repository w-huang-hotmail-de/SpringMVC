This project is copied from SpringMVC02.

SpringMVC02 is builded under Tomcat 8.0.5 (JSP 2.3 and above).  Since JSP 2.3 (the change applies to Tomcat 8 onwards) only the request method GET, POST and HEAD are supported. 
The behaviour for other HTTP method, for example PUT and DELETE, result in the error 405 - Method Not Allowed.

In order to follow the course of SpringMVC which still explain RESTful with Request method PUT and so on, I create the project SpringMVC03 under Tomcat 7.0.108 and copy all the file from SpringMVC02.

If you copy the whole project SpringMVC02 direct, it cannot work, because SpringMVC02 has the web module 3.1 which does not apply to Tomcat 7. For Tomcat 7 you should create the SpringMVC03 with
web Module 3.0. 