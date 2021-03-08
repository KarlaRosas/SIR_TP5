# Project  TP 5 Partie 1 JPA 2021 UniR

**Application of Kanban Board**
 
# **Prerequisites for Users**

JRE >= 1.8
* java IDE (Eclispe,Intelliji Idea etc..)
* WAMPServer
* Database phpmyadmin
* Jetty Server  HTTP

# **Getting Started**

1. Clone https://github.com/KarlaRosas/SIR_TP5.git  for development and testing purposes.
2. Start WAMP server and database
3. persistence.xml file configuration:

    * Configurer path, username and password of the database
    * Verify that the 'create' parameter is enabled: property name="hibernate.hbm2ddl.auto" value="create"
    
4. Jetty Server Configuration in IntelliJ
    * File -> Setting -> Plugins -> Install IDEA Jetty Runner
    * File -> Setting -> Plugins -> Install Maven Runner
    * Run  -> Run/Debug Configurations -> New Maven Name 'Jetty' -> Commande line: jetty:run
    * Run  -> Run/Debug Configurations -> Runner -> WM Options: -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8081
        
    
    
# **How it works**

1. Run the JpaTest file
2. View the creation and population of the database
3. In the JpaTest file, you will be able to configure the DAO file queries. 
   The results will be visible on the console. 
4. Run Server Jetty
5. Test the urls in your internet browser:

# URLS

* Add a user to the MySQL database:
http://localhost:8080/myformutilisateur.html

* Add a Kanban board to the MySQL database:
http://localhost:8080/myformtableau.html


* Add a card to the Backend table in the "To do B" section in DB MySQL:
http://localhost:8080/myformfiche.html

# Returns information from the database:

* Users
http://localhost:8080/Utilisateurs

* Kanban boards
http://localhost:8080/Tableaux

* Cards:
http://localhost:8080/Fiches


# Part 2 of this project:

* You can find the part 2 of this project in the following link :
https://github.com/KarlaRosas/SIR__TP5_P2_JaxRSOpenAPI

   
# **Authors**
* Karla ROSAS 
* Rabeaa KESSAL
* Léo VARIERAS


