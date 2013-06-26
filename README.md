SimpleWebApp
============

Simple web application using Maven Spring MVC with security and hibernate.

1.  Create a database in MySQL
2.	Download user.sql from repositry and import it into your database
3.	user table have two records
-(a)- user with authority ROLL_NORMAL -(b)- admin with authority ROLL_ADMIN
4.	Browse src/main/webapp/WEB-INF/spring-database.xml in project and change database credentials

Setup the project into eclipse using following steps

1.	Go to File -> Import.
2.	Select Existing Projects into Workspace.
3.	Browse the location of your project and click finish.
4.	Right click on pom.xml select Run As-->Maven clean
5.	Start Tomcat and run your application
