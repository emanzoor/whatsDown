<b>WhatsDown</b> is simplest chat application in RESTful web based category.<br> It covers following steps<br> 
1>Signup/Sginin<br> 
2>Listing of all users  <br>
3>See messages from specific user/send message to specific user<br> 

<br> 
<br> 
To get code working some prerequisites are to be taken into account.Firstly as code is done struts2 framework struts2.1 common libraries
and core jar is required. JSTL 1.2 lib, derbyclient jar for DB and tomcat 8.5 run time libraries are also part of needed package. For java 
compatibility JRE 1.5 libraries must be added to class path.<br>

For installation DB path and Deriver class name must be updated in CONSTANTS.java plus following create table DDL must be executed<br>
To create user table to keep data of added users <br>

    create table "CLASSICCARS"."USERS"( 
        "USERNAME" VARCHAR(50) not null,
       "ID" INTEGER not null generated always as identity,
       "PASSWORD" VARCHAR(8) not null,
       "EMAIL" VARCHAR(20) not null unique,
       "LOCATION" VARCHAR(25) default 'NO LOCATION HINT' not null,
        constraint "SQL170520031007300" primary key ("ID")
    );

    create unique index "SQL170527144718360" on "CLASSICCARS"."USERS"("EMAIL");
    create unique index "SQL170527144718370" on "CLASSICCARS"."USERS"("ID");
    
    and for record of messages sent and received<br>
    
    create table "CLASSICCARS"."MESSAGES"(
        "SENGER_ID" VARCHAR(50) not null,
       "RECEIVER_ID" VARCHAR(50) not null,
       "ID" INTEGER not null generated always as identity,
       "MESSAGE" VARCHAR(500),
       "RECEIVER_NAME" VARCHAR(50),
       "SENDER_NAME" VARCHAR(50),
       "TIME" VARCHAR(50),
        constraint "SQL170520031007350" primary key ("ID")
    );

    create unique index "SQL170527222108690" on "CLASSICCARS"."MESSAGES"("ID");
    
    
    
