## Useful Maven Terminal commands run in order:


| Phase    | Action                                                        |
|----------|--------------------------------------------------------------|
| clean    | Delete target directory.                                     |
| validate | Validate if the project is correct.                          |
| compile  | Compile source code, classes stored in target/classes.       |
| test     | Run tests.                                                   |
| package  | Take the compiled code and package it in its distributable format, e.g. JAR, WAR. |
| verify   | Run any checks to verify the MVN package is valid and meets quality criteria. |
| install  | Install the package into the local repository.                |
| deploy   | Copies the final MVN package to the remote repository.        |
---


## To run a Spring Boot application from the terminal using Maven, follow these steps:

> 1) Build the Project:
> 
Make sure you are in the root directory of your Spring Boot project, where the pom.xml file is located. Use the following command to build the project:

bash
```
mvn clean install
```
This command will compile the code, run tests, and package the application into a JAR file.

> 2) Run the Spring Boot Application:

Once the build is successful, you can use the spring-boot:run goal to start the application. Run the following command:

bash
```
mvn spring-boot:run
```
This command will start the embedded Tomcat server and deploy your Spring Boot application.

> 3) Access the Application:

Once the application is up and running, you can access it by opening a web browser and navigating to the URL specified in the console log. By default, it is usually ```http://localhost:8080```.

That's it! You have successfully run your Spring Boot application from the terminal using Maven. If you want to run the application as a standalone JAR file, you can find the JAR file in the ```target``` directory and execute it using the ```java -jar``` command:

bash
```
java -jar target/your-application.jar
```
Replace ```your-application.jar``` with the actual name of your generated JAR file.