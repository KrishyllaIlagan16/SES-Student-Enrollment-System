  Include classes such as ```bsitStudent```, ```bscsStudent```, and ```Administrator``` (or the other two subclasses you added), which extend the ```Student``` superclass. They inherit common attributes and add their unique properties. For instance, the ```bsitStudent`` class adds ```srCode```, ```program```, and ```block```. This creates a clear relationship a **bsitStudent is an Student**.
          
- **POLYMORPHISM** - Polymorphism, which means "many forms," allows a common method to work differently depending on the specific type of the object.
    - Overridden Method: A method, such as ```displayCourses()```, is defined in the superclass (```Student```).
    - Dynamic Behavior: This method is overridden in each subclass (```bsitStudent```, ```bscsStudent```, etc.) to provide role-specific output.
        - The ```bsitStudent``` version might print: "Enrolled in BSIT - 1st Year 1st Sem."
        - The ```bscsStudent``` version might print: "Teaching in the Computer Science Department."
    - When a collection of ```Student``` references is processed, calling the common method runs the right, specialized version for each object at runtime. This shows dynamic polymorphism.
  
- **ABSTRACTION** - Abstraction shows only the essential information while hiding the complicated implementation details.
   - Methods like ```displayCourses()``` hide the vast ```if/else``` logic that determines which specific courses to list based on the program (BSIT/BSCS) and year level.The calling code just needs to know the method name and the required parameters, which are ```program``` and ```yearLevel```.
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

