# online-perfume-store-spring-project (on the seller OR consumer side)

This web application is slightly more complex than [online-perfume-store-project](https://github.com/marta-liushniak/online-perfume-store-project), as some actions are limited to the user with **SELLER** or **CONSUMER** role:

![](https://scontent.fifo4-1.fna.fbcdn.net/v/t1.15752-9/325856415_530845959024525_3672892406146189178_n.png?_nc_cat=108&ccb=1-7&_nc_sid=ae9488&_nc_ohc=xuT4lwzz_LYAX9zU9Rp&tn=VDsiF8AS3-pY8jOb&_nc_ht=scontent.fifo4-1.fna&oh=03_AdTOYQcbOqBP4dOMz7WRRmN7FM3YJaTQ3LxqCHCu1m2Rxg&oe=63F663B0)

The project structure itself is more extensive and contains a wider range of functionality. **Spring Framework** & **HQL** were used to develop it. 

In order to test the requests and responses, please, feel free to use **Postman API Platform** (JSON format) and already initialized user with seller role from **DataInit** class (config package):

![](https://scontent.fifo4-1.fna.fbcdn.net/v/t1.15752-9/326746147_2989967961312992_6827525216394447570_n.png?_nc_cat=102&ccb=1-7&_nc_sid=ae9488&_nc_ohc=C5ZSYv-RZW4AX-hmhMV&_nc_ht=scontent.fifo4-1.fna&oh=03_AdTwfc-JByA-B1BcgGM8-1pmB8bb7DJUFfUxDnqx4P3meQ&oe=63F65F6B)
Of course, you can also register a new user with a consumer role as well.


But first and foremost, you need to install JDK (11 or higher), Apache Maven, Apache Tomcat (recommended version 9.0.65), and MySQL (+ MySQL Workbench). Then clone this project to your IDE: `git clone https://github.com/marta-liushniak/online-perfume-store-spring-project` and set up a connection to your DB in db.properties (resources package) - put the values after **=** without **" "**.

IMPORTANT: while configuring Tomcat, please, go to the Deployment tab, select **war exploded artifact**, and change the application context to */* as follows:
![](https://scontent.fifo4-1.fna.fbcdn.net/v/t1.15752-9/323008351_554805376572493_2863545099693500338_n.png?_nc_cat=105&ccb=1-7&_nc_sid=ae9488&_nc_ohc=SOpSAKee-sMAX_yAJQZ&_nc_ht=scontent.fifo4-1.fna&oh=03_AdTtiv-SrCudLgq2X2jqH57ZF4wMFZvCGgeP4Gca4D20Qg&oe=63EE11E2)

