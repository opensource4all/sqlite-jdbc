SQLITE-JDBC CEROD Fork 
========================================
SQLite version used 3.41.2 . 
This fork was updated with the original (xerial/sqlite-jdbc) upstream as of 05/11/2023 

Why am I doing this? 
====
I wanted to use the sqlite-jdbc project to access a sqlite3 DB that is compressed and encrypted with the CEROD extention (which is written in C.) I made the changes pretty generic and carefully so future merges could be done easily.
However, since CEROD (cerod.c) is commercial license (meaning, not free) the merge request could not accepted by the xerial/sqlite-jdbc folks, understandingly so, since I could not provide them the cerod.c and 
therefore they did not have a reliable way to test it; 

I have decided to keep a fork and synchronize it at least once a year with the upstream project.   


How ?
==== 
If you're a user of CEROD, you need to clone the source and build it yourself. 
My intent is to make it super easy and save you a lot of time to make sqlite-jdbc work with your own licenced Cerod.c. 
You can contact me for help or support at coolShark200@gmail.com if you have any questions.

How to add the SQLite Compressed and Encrypted Read-Only Database (CEROD) Extension
===================================================================================

* Place your licenced cerod.c in the src/main/ext folder. 
* Add your Cerod key to the EXTENTION_ENV file as CEROD_EXT_KEY := < YourCerodKey >
* NOTE: YourCerodKey is really your own made-up key string (confusing at first, at least for me, but true);  It is baked in the java JNI and cerod.c after everything is compiled here. 

Then follow directions for a normal build as described in [building SQLITE-JDBC driver from scratch (CONTRIBUTING.md)](CONTRIBUTING.md)

TL;DR version:
====
## Prerequisites

1. JDK 8
2. Perl
3. Maven
4. make
5. gcc
6. curl
7. unzip
8. Docker (for cross-compilation only)

Make sure you have your DOCKER DESKTOP running. <br>
Then: clone this project:

1. git clone https://github.com/opensource4all/sqlite-jdbc.git
2. cd sqlite-jdbc
3. make native 
4. mvn package  <-- creates the package (jar maven library)
5. mvn install  <-- if you use maven, this will package it and install it in your local maven repo. 

How to use CEROD encoded DB:
=====================================

To open up a CEROD encoded SQlite file, use the following:
  
* For compressed only DB with no password:
```java 
Connection conn = DriverManager.getConnection("jdbc:sqlite::cerod::cerod.db"); 
```
* For compressed DB protected by password, for example if the password is abc123
```java 
Connection conn = DriverManager.getConnection("jdbc:sqlite::cerod:abc123:cerod.db");
```
