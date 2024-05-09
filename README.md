# Scalable E-Commerce Application

## Description
This project is a Java-based e-commerce application designed for scalability and efficiency, using
Java Swing for the graphical user interface. This application includes an advanced shopping cart
system that allows users to manage their shopping items dynamically.

Key functionalities include adding and removing items, updating quantities, viewing a detailed
order summary at checkout, and handling order confirmations. This system has a strong backend 
that handles product stocks and user transactions well. It is thoroughly tested and includes 
robust error handling to ensure the application is reliable and stable.

## Java Installation
Most versions of Java will be able to run this program, but JDK 11 or higher is recommended for optimal performance. You can download it using the link below:

https://www.oracle.com/java/technologies/downloads/#java11

For those new to Java development or needing an IDE, Eclipse or IntelliJ IDEA   
are recommended as well.

If you don't have Eclipse or IntelliJ installed, you can follow the step-by-step  
instructions provided in the links below to install them on various operating systems:

**Eclipse Installation:** https://www.eclipse.org/downloads/packages/installer

**IntelliJ Installation:** https://www.jetbrains.com/idea/download

## Maven Installation
**Step 1:** If you don't have Maven installed, then you can install it here:
https://maven.apache.org/download.cgi

**Step 2:** Extract the downloaded zip file to a directory on your system.

**Step 3:** After it is successfully installed on your system, set up Maven in the system path.

**Step 4:** Open the Start Search, type in "Environment Variables", and select "Edit the system environment variables".

**Step 5:** In the System Properties window, click on the "Environment Variables" button.

**Step 6:** In the Environment Variables window, under the "System variables" section, locate and
select the "Path" variable, then click on "Edit".

**Step 7:** Click "New" and add the path to the Maven "bin" directory.

**Step 8:** Apply those settings by clicking "OK".

**Step 9:** Ensure Maven is successfully installed by opening a new command prompt and typing
`mvn -v`, which should not result in any errors if these steps are followed correctly.


## Usage
**Step 1:** Clone the repository:
```
git clone https://github.com/YashKapoor1102/E-Commerce-Application.git
```
**Step 2:** Navigate to the project directory:
```
cd E-Commerce-Application
```
**Step 3:** Use Maven to compile and package the application into a runnable jar file
with Maven:
```
mvn package
```
**Step 4:** Run the JAR file:
```
java -jar target/E-Commerce-Application-1.0-SNAPSHOT.jar
```

## Credits
- Yash Kapoor
