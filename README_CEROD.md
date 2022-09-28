SQLITE-JDBC fork with support for CEROD
========================================
Why ? 
====
I made this pretty generic, but since cerod.c is comercial license, it was not possible to do automation testing and I cancel my merge request.  

How ?
====
you need to build this.   I cannot provide a repository (like maven style) since that would require me to put the cerod.c into this code and you need to purchase the license to cerod.c.   
My intent is to make it super easy and save you a lot of time to make sqlite-jdbc work with Cerod. 
You can contact me for help or support at coolShark200@gmail.com if you need any help.

How to add the SQLite Compressed and Encrypted Read-Only Database (CEROD) Extension
===================================================================================

* Put cerod.c in the src/main/ext folder which already exists in the sqlite-jdbc source code.
* Add your Cerod key to the EXTENTION_ENV file as CEROD_EXT_KEY := < YourCerodKey >
* NOTE: YourCerodKey is really your own key string (confusing, but true); but it is used in the java JNI and cerod.c, to make it really hard to hack your own cerod DB your distributing. This is why I think it is useful to have this sqlite-jdbc fork; it'll make your life easier to keep up with latest versions of sqlite-jdbc driver. 

Then follow directions for a normal build as described in [building SQLITE-JDBC driver from scratch (CONTRIBUTING.md)](CONTRIBUTING.md)

How to use CEROD encoded DB:
=====================================

To open up a CEROD encoded SQlite file, use the following:
  
* For compressed only DB with no password:
    * Connection conn = DriverManager.getConnection("jdbc:sqlite::cerod::cerod.db");
* For compressed DB protected by password, for example if the password is abc123
    * Connection conn = DriverManager.getConnection("jdbc:sqlite::cerod:abc123:cerod.db");
