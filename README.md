# online-perfume-store-spring-project (on the seller OR consumer side)

This web application is slightly more complex than [online-perfume-store-project](https://github.com/marta-liushniak/online-perfume-store-project), as some actions are limited to the user with **SELLER** or **CONSUMER** role & the project structure itself is more extensive and contains a wider range of functionality. 

**Spring MVC**, **Spring ORM**, **Spring Security** & **Hibernate Framework** with powerful query language (**HQL**) were used to develop it. 

To test the requests and responses of the online-perfume-store-spring-project, please feel free to use the **Postman API Platform** in JSON format. You can authenticate as the initialized *seller* user from the **DataInit** class in the config package, or register a new user with a *consumer* role.

But first and foremost, you need to install:
- **JDK** (11 or higher)
- **Apache Maven** 
- **Apache Tomcat** (recommended version 9.0.65)
- **MySQL** (+ MySQL Workbench). 

Then clone this project to your IDE: `git clone https://github.com/marta-liushniak/online-perfume-store-spring-project` and set up a connection to your DB in **db.properties** in the resources package - put the values after **=** without **" "**.

IMPORTANT: while configuring Tomcat, please, go to the Deployment tab, select **war exploded artifact**, and change the application context to */*.
