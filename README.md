# SES : Student Enrollment System
![Student Enrollment System Background](https://raw.githubusercontent.com/cedricknoyda/image-/main/Screenshot%202025-11-13%20210808.png)
<br/>
<br/>

## Description/Overview
<br/>
The Student Enrollment System is a console-based program that simplifies the student enrollment process for the "Batangas State University , College of Informatics and Computing Sciences." It collects essential student information such as name, age, and address. It also helps students choose their academic program (BSIT or BSCS) and year level, and assigns them to a proper class block with a set schedule. The key features include validating student data like name and age, showing course lists and block schedules specific to each program (including face-to-face and online classes), and generating a unique Student ID after successful registration. This system addresses the issues of manual and error-prone enrollment by offering a structured, interactive, and automated way to register students, giving them their complete class schedule and enrollment summary right away.
<br/>
<br/>



## OOP Concepts Applied
- **CLASSES and OBJECTS**
    - Classes
        - The ```Student``` acts as a guide for making personal student records.It defines the attributes such as ```name```,```age```, ```address```, ```enrollmentPeriod```, ```program```, ```yearLevel```, ```block```, and ```srCode```, and the methods (behavior) like ```displayDetails()```.
        - The ```EnrollmentSystem``` class serves as the main application container. It holds the core logic, utility methods (```printCenteredLine```,``` displayCourses```, etc.), and the main execution point (```main```).
    - Objects
        - In the ```main``` method, a new student object```newCicsStudent```, is created using the ``Student`` class's constructor: ```Student newCicsStudent = new Student(...)```.
        - This object holds all the specific data gathered during the enrollment process for that student.
**Student objects**.
<br>

- **ENCAPSULATION** - Encapsulation involves grouping data and the methods that work on that data within a class. It also controls how external entities can access that data.
   - Attributes like a student's ```name```, ```age```, and ```srCode``` are contained within the ```Student``` class
   - The program provides specific methods to interact with this data:
        - Getters (like ```getProgram()``` in the ```Student``` class) allow code to read a value.
        - Setters (like ```setBlock()``` in the ```Student``` class) allow code to write or modify a value in a controlled way.

- **INHERITANCE** - Inheritance involves creating a superclass. Specialized subclasses then take on its shared attributes and behaviors.
   - Superclass:
        - A base class, like ```Student``` (or a similar name), is created. It contains attributes that are common to all university members, such as ```name```, ```age```, and ```address```.
    - Subclasses:
        -  Include classes such as ```bsitStudent```, ```bscsStudent```, and ```mscsStudent``` (or the other two subclasses you added), which extend the ```Student``` superclass. They inherit common attributes and add their unique properties. For instance, the ```bsitStudent`` class adds ```srCode```, ```program```, and ```block```. This creates a clear relationship a **bsitStudent is an Student**.
          
- **POLYMORPHISM** - Polymorphism, which means "many forms," allows a common method to work differently depending on the specific type of the object.
    - Overridden Method: A method, such as ```displayCourses()```, is defined in the superclass (```Student```).
    - Dynamic Behavior: This method is overridden in each subclass (```bsitStudent```, ```bscsStudent```, ```mscsStudent```) to provide role-specific output.
        - The ```bsitStudent``` version might print: "Enrolled in BSIT - 1st Year 1st Sem."
        - The ```bscsStudent``` version might print: "Enrolled in BSCS - 2nd Year 1st Sem."
        - The ```mscsStudent``` version might print: "Enrolled in MSCS - 1st Year 1st Sem."
    - When a collection of ```Student``` references is processed, calling the common method runs the right, specialized version for each object at runtime. This shows dynamic polymorphism.
  
- **ABSTRACTION** - Abstraction shows only the essential information while hiding the complicated implementation details.
   - Methods like ```displayCourses()``` hide the vast ```if/else``` logic that determines which specific courses to list based on the program (BSIT/BSCS/MSCS) and year level.The calling code just needs to know the method name and the required parameters, which are ```program``` and ```yearLevel```.
   - The ```Student.displayDetails()``` This method offers a straightforward interface to print the student's complete enrollment summary. It removes the need for multiple calls to format and print each line.

## PROGRAM STRUCTURE

The project is built using two main parts, which are the main classes in the Java program. First, is the **EnrollmentSystem** class. This class is the main part of the program because it has the main method, which is where the program starts running. It handles everything the user sees, like asking for information like the name, age, and program, and displaying the course lists and the final summary. This class also makes sure the user enters the right data by including special checks (exception handling) and serves as the main controller, handling user input, managing the program's flow, and displaying the final enrollment details for a new student, showing how it manages multiple objects.
Second, there is the **Student** class. This class is like a blueprint for creating an actual student. Every time a new student enrolls, the EnrollmentSystem creates a new Student object to hold their information, like their generated ID, age, and chosen block. The Student class keeps the student's data safe inside it by using methods to set and get the details, which is an example of encapsulation. The main class calls a method in the Student class to print out the final enrollment summary.

## HOW TO RUN THE PROGRAM
To start, the user needs to use the command like command prompt or terminal and have java installed. First, they must compile the source code. The user should go to the folder where they saved the Java files (**EnrollmentSystem.java** and **Student.java**) and use the Java compiler command **“javac EnrollmentSystem.java”** Once the code is compiled successfully, the user can run the program. They should use the Java execution command to start the main class **“java EnrollmentSystem”** The program will then greet the user and start asking for their details right away.

## SAMPLE OUTPUT

![SAMPLE OUTPUT](https://github.com/cedricknoyda/image-/blob/main/581969051_1265517308925083_914414488596820509_n.png)
<br/>
![SAMPLE OUTPUT](https://github.com/cedricknoyda/image-/blob/main/582110359_2599652210398892_3482966512181459658_n.png)
<br/>
![SAMPLE OUTPUT](https://github.com/cedricknoyda/image-/blob/main/582111556_1538945017419883_4834425962798704109_n.png)
<br/>
![SAMPLE OUTPUT](https://github.com/cedricknoyda/image-/blob/main/582200834_1896306211097146_1638670185329471040_n.png)
<br/>
![SAMPLE OUTPUT](https://github.com/cedricknoyda/image-/blob/main/583872097_2051664858910692_3950559076868853180_n.png)
<br/>
![SAMPLE OUTPUT](https://github.com/cedricknoyda/image-/blob/main/44743494-ee73-43a4-b0c9-680e2e896aa0.jpg)

## AUTHOR AND ACKNOWLEDGEMENT
Our project **“SES: Student Enrollment System”** was done by our team **“Sesters”**. Our members’ name is listed here:
   - **_Ilagan, Krishylla Mae_**
   - **_Noyda, John Cedrick D._** 
   - **_Sto niño, Mary Grace A._**

Our team would like to thank our instructor, **_Mr. Emmanuel Charlie Enriquez_** for guiding us throughout the Final Project.

## REFERENCES 

   - BatState-U. (n.d.). Student Portal. Retrieved November 21, 2025, from:
      -   https://dione.batstate-u.edu.ph/student/#/

   - DataCamp. (n.d.). Java Abstraction. Retrieved November 21, 2025, from:
      -  https://www.datacamp.com/doc/java/abstraction

   - GeeksforGeeks. (2025, October 9). Encapsulation in Java.
      - https://www.geeksforgeeks.org/java/encapsulation-in-java/

   - Great Learning Editorial Team. (2025, January 6). Polymorphism in Java with Examples. MyGreatLearning. Retrieved November 21, 2025, from:
      -  https://www.mygreatlearning.com/blog/polymorphism-in-java/

   - Programiz. (n.d.). Java Inheritance (With Examples). Retrieved November 21, 2025, from:
      -  https://www.programiz.com/java-programming/inheritance
