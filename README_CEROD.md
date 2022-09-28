SQLITE-JDBC fork with support for CEROD
========================================
Why ? 
====
I made this pretty generic, but since cerod.c is comercial license, it was not possible to do automation testing and I cancel my pull request.  

How ?
====
you need to build this.   I cannot provide a repository since that would require me to put the cerod.c into this repository.   I just make it super easy and save you a lot of time to figure things out. 


How to add the SQLite Compressed and Encrypted Read-Only Database (CEROD) Extension
===================================================================================

* Put cerod.c in the src/main/ext folder which already exists.
* Add your Cerod key to the EXTENTION_ENV file as CEROD_EXT_KEY := < YourCerodKey >
* NOTE: CEROD_EXT_KEY is really your own key, but it is used in the code java and cerod.c, so cerod.c source code to make it really hard to use it, 

Then follow directions for a normal build as described in [building SQLITE-JDBC driver from scratch (CONTRIBUTING.md)](CONTRIBUTING.md)

How to use CEROD encoded DB:
=====================================

To open up a CEROD encoded SQlite file, use the following:
  
* For compressed only DB with no password:
    * Connection conn = DriverManager.getConnection("jdbc:sqlite::cerod::cerod.db");
* For compressed DB protected by password, for example if the password is abc123
    * Connection conn = DriverManager.getConnection("jdbc:sqlite::cerod:abc123:cerod.db");
