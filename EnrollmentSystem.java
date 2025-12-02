import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class EnrollmentSystem {
    
    private static final int insideWidth = 93;
    public static final String borderLine = "+-" + "-".repeat(insideWidth) + "-+";
    private static final String emptyLine = "| " + " ".repeat(insideWidth) + " |";

    public static void printCenteredLine(String text) {
        if (text.length() > insideWidth) {
            text = text.substring(0, insideWidth);
        }
        int paddingSize = (insideWidth - text.length()) / 2;
        String leftPadding = " ".repeat(paddingSize);
        String rightPadding = " ".repeat(insideWidth - text.length() - paddingSize);
        System.out.println("| " + leftPadding + text + rightPadding + " |");
    }

    public static void printBoxLine(String text) {
        String paddedText = String.format("%-" + insideWidth + "s", text);
        System.out.println("| " + paddedText + " |");
    }

    public static void printBoxLine(String time, String subject ) {
        String timeCol = String.format("%-28s", time);
        String subjectCol = String.format("%-" + (insideWidth - 28) + "s", subject);
        System.out.println("| " + timeCol + subjectCol + " |");
    }
    
    public static void printSummaryLine(String title, String value) {
        String line = "   " + title + ": " + value;
        if (line.length() > insideWidth) {
             line = line.substring(0, insideWidth - 3) + "...";
        }
        String paddedText = String.format("%-" + insideWidth + "s", line);
        System.out.println("| " + paddedText + " |");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(borderLine);
        System.out.println(emptyLine);
        printCenteredLine("College of Informatics and Computing Sciences");
        System.out.println(emptyLine);
        System.out.println(borderLine);
        printCenteredLine("Welcome to the University of Spartans!");
        printCenteredLine("Enroll Now!");
        System.out.println(borderLine);
        printCenteredLine("In enrolling in the university, you should provide the required information below:");
        System.out.println(borderLine);
        System.out.println();

        String name = "";
        while (true) {
            System.out.print("  Name: ");
            name = scanner.nextLine();
            if (isValidName(name)) {
                break; 
            }
        }

        int age = 0;
        while (age == 0) {
            try {
                System.out.print("  Age: ");
                age = scanner.nextInt();
                if (age < 16) {
                    System.out.println("    Age must be 16 and above. Thank you!");
                    System.out.println();
                    age = 0; 
                }
            } catch (InputMismatchException e) {
                System.out.println("    Error! Please enter a number.");
                System.out.println();
                scanner.next(); 
            }
        }
        scanner.nextLine(); 

        System.out.print("  Address: ");
        String address = scanner.nextLine();

        String enrollmentPeriod = "";
        while (enrollmentPeriod.isEmpty()) {
            System.out.println("\n" + borderLine);
            printBoxLine(" Date of enrollment:");
            printBoxLine("   A. August 20, 2025 to September 20, 2025 (First Semester)");
            printBoxLine("   B. January 20, 2026 to February 20, 2026 (Second Semester)");
            System.out.println(borderLine);
            System.out.print("  Choose (A/B): ");
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("A")) {
                enrollmentPeriod = "First Semester 2025-2026";
            } else if (choice.equals("B")) {
                System.out.println("    Sorry, Second Semester enrollment is not yet available. Thank you!");
            } else {
                System.out.println("    Error! Please select A or B.");
            }
            System.out.println();
        }

        String program = "";
        while (!program.equals("BSIT") && !program.equals("BSCS") && !program.equals("MSCS")) {
            System.out.println(borderLine);
            printBoxLine(" Program:");
            printBoxLine("   BSIT - Bachelor of Science in Information Technology");
            printBoxLine("   BSCS - Bachelor of Science in Computer Science");
            printBoxLine("   MSCS - Master of Science in Computer Science"); 
            System.out.println(borderLine);
            System.out.print("Enter Program (ex. BSIT): ");
            program = scanner.nextLine().toUpperCase();

            if (!program.equals("BSIT") && !program.equals("BSCS") && !program.equals("MSCS")) {
                System.out.println("    Error! Please enter BSIT, BSCS, or MSCS.");
            }
        }
        
        System.out.println();

        String yearLevel= "";
        int chosenYear = 0;
        while (chosenYear < 1 || chosenYear > 4) {
            try {
                System.out.println(borderLine);
                printBoxLine(" What year are you in?");
                printBoxLine("   1. 1st Year 1st Semester");
                printBoxLine("   2. 2nd Year 1st Semester");
                printBoxLine("   3. 3rd Year 1st Semester");
                printBoxLine("   4. 4th Year 1st Semester");
                System.out.println(borderLine);
                System.out.print("  Enter a number (1-4): ");
                chosenYear = scanner.nextInt();
                scanner.nextLine(); 

                if (program.equals("MSCS") && (chosenYear == 3 || chosenYear == 4)) {
                    System.out.println("    Error! MSCS program is only available for 1st and 2nd Year.");
                    System.out.println("    Please select 1 or 2.");
                    System.out.println();
                    chosenYear = 0;
                    continue;
                }

                switch (chosenYear) {
                    case 1: yearLevel= "1st Year 1st Semester"; break;
                    case 2: yearLevel= "2nd Year 1st Semester"; break;
                    case 3: yearLevel= "3rd Year 1st Semester"; break;
                    case 4: yearLevel= "4th Year 1st Semester"; break;
                    default:
                        System.out.println("    Error! Please enter a number from 1 to 4.");
                        System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("    Error! Please enter a number.");
                System.out.println();
                scanner.next(); 
            }
        }

        System.out.println("\n" + borderLine);
        printBoxLine(" Note: Second Semester and Midterm Semester enrollment");
        printBoxLine("       is not available at this time.");
        printBoxLine("       Please wait for the update.");
        System.out.println(borderLine);
        
        Student newCicsStudent;

        if (program.equals("BSIT")) {
            newCicsStudent = new bsitStudent(name, age, address, enrollmentPeriod, yearLevel);
        } else if (program.equals("BSCS")) {
            newCicsStudent = new bscsStudent(name, age, address, enrollmentPeriod, yearLevel);
        } else {
            newCicsStudent = new mscsStudent(name, age, address, enrollmentPeriod, yearLevel);
        }

         newCicsStudent.displayCourses();
        
        String block =  newCicsStudent.chooseBlock(scanner);
         newCicsStudent.setBlock(block); 

        System.out.println("\n" + borderLine);
        System.out.println(emptyLine);
        printCenteredLine("You are now Enrolled in the University of Spartan!");
        System.out.println(emptyLine);
        System.out.println(borderLine);
         newCicsStudent.displayDetails();
        
        System.out.println(borderLine);
        printCenteredLine("For more inquiries kindly email: spartan.cics@gmail.com");
        System.out.println(borderLine);

        scanner.close();
    }

    private static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("    A name must be provided. Kindly complete this for student information. Thank you!");
            System.out.println();
            return false;
        }
        if (name.matches(".*\\d.*")) {
            System.out.println("    Error! A name cannot contain numbers. Please provide your name..");
            System.out.println();
            return false;
        }
        return true; 
    }
}

abstract class Student {
    protected String name;
    protected int age;
    protected String address;
    protected String enrollmentPeriod;
    protected String program;
    protected String yearLevel;
    protected String block;
    protected String srCode;

    public Student(String name, int age, String address, String enrollmentPeriod, String program, String yearLevel) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.enrollmentPeriod = enrollmentPeriod;
        this.program = program;
        this.yearLevel= yearLevel;
        this.srCode = generatesrCode();
    }

    private String generatesrCode() {
        int year = 2025; 
        int randomNum = ThreadLocalRandom.current().nextInt(1000, 9999);
        return year + "-" + randomNum;
    }

    public void displayDetails() {
        System.out.println("\n" + EnrollmentSystem.borderLine);
        EnrollmentSystem.printCenteredLine("Student Enrollment Summary");
        System.out.println(EnrollmentSystem.borderLine);
        EnrollmentSystem.printSummaryLine("Student ID", this.srCode);
        EnrollmentSystem.printSummaryLine("Name", this.name);
        EnrollmentSystem.printSummaryLine("Age", String.valueOf(this.age));
        EnrollmentSystem.printSummaryLine("Address", this.address);
        EnrollmentSystem.printSummaryLine("Period", this.enrollmentPeriod);
        EnrollmentSystem.printSummaryLine("Program", this.program);
        EnrollmentSystem.printSummaryLine("Year Level", this.yearLevel);
        EnrollmentSystem.printSummaryLine("Block", this.block);
        System.out.println(EnrollmentSystem.borderLine);
    }

    public String getProgram() { return program; }
    public String getYearLevel() { return yearLevel; }
    public void setBlock(String block) { this.block = block; }

    public abstract void displayCourses();

    public abstract String chooseBlock(Scanner scanner);
}

class bsitStudent extends Student {

    public bsitStudent(String name, int age, String address, String enrollmentPeriod, String yearLevel) {
        super(name, age, address, enrollmentPeriod, "BSIT", yearLevel);
    }

    @Override
    public void displayCourses() {
        System.out.println("\n" + EnrollmentSystem.borderLine);
        EnrollmentSystem.printBoxLine(" Courses in the program of " + program + " for " + yearLevel+ ":");
        EnrollmentSystem.printBoxLine("");
        
        if (yearLevel.equals("1st Year 1st Semester")) {
            EnrollmentSystem.printBoxLine(" - IT 111: Introduction to Computing");
            EnrollmentSystem.printBoxLine(" - GEd 102: Mathematics in the Modern World");
            EnrollmentSystem.printBoxLine(" - GEd 108: Art Appreciation");
            EnrollmentSystem.printBoxLine(" - FILI 101: Kontekstwalisadong Komunikasyon sa Filipino");
            EnrollmentSystem.printBoxLine(" - PE 101: Physical Fitness, Gymnastics and Aerobics");
            EnrollmentSystem.printBoxLine(" - NSTP 111: National Service Training Program 1");
            EnrollmentSystem.printBoxLine(" - GEd 103: The Life and Works of Rizal");
            EnrollmentSystem.printBoxLine(" - GEd 104: The Contemporary World");
        } else if (yearLevel.equals("2nd Year 1st Semester")) {
            EnrollmentSystem.printBoxLine(" - CS 121: Advanced Computer Programming");
            EnrollmentSystem.printBoxLine(" - IT 211: Database Management System");
            EnrollmentSystem.printBoxLine(" - CS 211: Object-Oriented Programming");
            EnrollmentSystem.printBoxLine(" - LITR 102: ASEAN Literature");
            EnrollmentSystem.printBoxLine(" - CpE 405: Discrete Mathematics");
            EnrollmentSystem.printBoxLine(" - PHY 101: Calculus Based Physics");
            EnrollmentSystem.printBoxLine(" - IT 212: Computer Networking 1");
            EnrollmentSystem.printBoxLine(" - PE 103: Individual and Dual Sports");
        } else if (yearLevel.equals("3rd Year 1st Semester")) {
            EnrollmentSystem.printBoxLine(" - IT 311: Systems Administration and Maintenance");
            EnrollmentSystem.printBoxLine(" - IT 312: System Integration and Architecture");
            EnrollmentSystem.printBoxLine(" - NTT 401: Computer Networking 3 (Network Track)");
            EnrollmentSystem.printBoxLine(" - NTT 402: Internet of Things (IoT) (Network Track)");
            EnrollmentSystem.printBoxLine(" - IT 313: System Analysis and Design");
            EnrollmentSystem.printBoxLine(" - IT 314: Web Systems and Technologies");
            EnrollmentSystem.printBoxLine(" - GEd 107: Ethics");
        } else {
            EnrollmentSystem.printBoxLine(" - CS 423: Social Issues and Professional Practice");
            EnrollmentSystem.printBoxLine(" - IT 411: Capstone Project 2");
            EnrollmentSystem.printBoxLine(" - NTT 405: Cybersecurity (Network Track)");
            EnrollmentSystem.printBoxLine(" - ENGG 405: Technopreneurship");
            EnrollmentSystem.printBoxLine(" - IT 413: Advanced Information Assurance and Security");
            EnrollmentSystem.printBoxLine(" - IT 414: System Quality Assurance");
            EnrollmentSystem.printBoxLine(" - IT 412: Platform Technologies");
        }
        System.out.println(EnrollmentSystem.borderLine);
    }

    @Override
    public String chooseBlock(Scanner scanner) {
        System.out.println("\n" + EnrollmentSystem.borderLine);
        EnrollmentSystem.printCenteredLine("Indicate your chosen BLOCK!");
        EnrollmentSystem.printCenteredLine("Here are the available blocks:");
        System.out.println(EnrollmentSystem.borderLine);

        String chosenBlock = "";
        
        if (yearLevel.equals("1st Year 1st Semester")) {
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 101");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     7:00 am - 9:00 am", "IT 111: Introduction to Computing");
            EnrollmentSystem.printBoxLine("     9:30 am - 11:00 am", "GEd 108: Art Appreciation");
            EnrollmentSystem.printBoxLine("   Tuesday (OLC):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "GEd 102: Mathematics in the Modern World");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "FILI 101: Kontekstwalisadong Komunikasyon sa Filipino");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "GEd 103: The Life and Works of Rizal");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 12:00 pm", "GEd 104: The Contemporary World");
            EnrollmentSystem.printBoxLine("   Friday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "PE 101: Physical Fitness, Gymnastics and Aerobics");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "NSTP 111: National Service Training Program 1");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 102");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "GEd 108: Art Appreciation");
            EnrollmentSystem.printBoxLine("     10:30 am - 12:00 pm", "GEd 103: The Life and Works of Rizal");
            EnrollmentSystem.printBoxLine("   Tuesday (F2F):");
            EnrollmentSystem.printBoxLine("     7:00 am - 9:00 am", "IT 111: Introduction to Computing");
            EnrollmentSystem.printBoxLine("     9:30 am - 11:00 am", "GEd 102: Mathematics in the Modern World");
            EnrollmentSystem.printBoxLine("   Wednesday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 11:00 am", "GEd 104: The Contemporary World");
            EnrollmentSystem.printBoxLine("   Thursday (F2F):");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "FILI 101: Kontekstwalisadong Komunikasyon sa Filipino");
            EnrollmentSystem.printBoxLine("     4:00 pm - 6:00 pm", "PE 101: Physical Fitness, Gymnastics and Aerobics");
            EnrollmentSystem.printBoxLine("   Friday (OLC):");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "NSTP 111: National Service Training Program 1");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 103");
            EnrollmentSystem.printBoxLine("   Monday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 12:00 pm", "GEd 102: Mathematics in the Modern World");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "GEd 108: Art Appreciation");
            EnrollmentSystem.printBoxLine("   Tuesday (F2F):");
            EnrollmentSystem.printBoxLine("     9:00 am - 11:00 am", "IT 111: Introduction to Computing");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "GEd 104: The Contemporary World");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     7:00 am - 10:00 am", "FILI 101: Kontekstwalisadong Komunikasyon sa Filipino");
            EnrollmentSystem.printBoxLine("     10:30 am - 12:00 pm", "GEd 103: The Life and Works of Rizal");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "NSTP 111: National Service Training Program 1");
            EnrollmentSystem.printBoxLine("   Friday (F2F):");
            EnrollmentSystem.printBoxLine("     10:00 am - 12:00 pm", "PE 101: Physical Fitness, Gymnastics and Aerobics");
            
            System.out.println(EnrollmentSystem.borderLine);
            while (chosenBlock.isEmpty()) {
                System.out.print("\n  Enter your chosen block number (101, 102, or 103): ");
                String input = scanner.nextLine();
                if (input.equals("101") || input.equals("102") || input.equals("103")) {
                    chosenBlock = input;
                } else { System.out.println("    Error! Please choose from the available options."); }
            }
        } 
        else if (yearLevel.equals("2nd Year 1st Semester")) {
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 201");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "CS 211: Object-Oriented Programming");
            EnrollmentSystem.printBoxLine("     10:00 am - 12:00 pm", "IT 211: Database Management System");
            EnrollmentSystem.printBoxLine("   Tuesday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 11:00 am", "LITR 102: ASEAN Literature");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "CpE 405: Discrete Mathematics");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 121: Advanced Computer Programming");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "PHY 101: Calculus Based Physics");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 12:00 pm", "IT 212: Computer Networking 1");
            EnrollmentSystem.printBoxLine("   Friday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "PE 103: Individual and Dual Sports");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 202");
            EnrollmentSystem.printBoxLine("   Monday (OLC):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "IT 212: Computer Networking 1");
            EnrollmentSystem.printBoxLine("     10:00 am - 12:00 pm", "CpE 405: Discrete Mathematics");
            EnrollmentSystem.printBoxLine("   Tuesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 121: Advanced Computer Programming");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "CS 211: Object-Oriented Programming");
            EnrollmentSystem.printBoxLine("   Wednesday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 11:00 am", "LITR 102: ASEAN Literature");
            EnrollmentSystem.printBoxLine("   Thursday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "IT 211: Database Management System");
            EnrollmentSystem.printBoxLine("     10:00 am - 12:00 pm", "PHY 101: Calculus Based Physics");
            EnrollmentSystem.printBoxLine("   Friday (F2F):");
            EnrollmentSystem.printBoxLine("     10:00 am - 12:00 pm", "PE 103: Individual and Dual Sports");
            
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 203");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     9:00 am - 11:00 am", "PHY 101: Calculus Based Physics");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "CS 211: Object-Oriented Programming");
            EnrollmentSystem.printBoxLine("   Tuesday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 12:00 pm", "LITR 102: ASEAN Literature");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "IT 211: Database Management System");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "CS 121: Advanced Computer Programming");
            EnrollmentSystem.printBoxLine("   Thursday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "PE 103: Individual and Dual Sports");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "CpE 405: Discrete Mathematics");
            EnrollmentSystem.printBoxLine("   Friday (OLC):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "IT 212: Computer Networking 1");

            System.out.println(EnrollmentSystem.borderLine);
            while (chosenBlock.isEmpty()) {
                System.out.print("\n  Enter your chosen block number (201, 202, or 203): ");
                String input = scanner.nextLine();
                if (input.equals("201") || input.equals("202") || input.equals("203")) {
                    chosenBlock = input;
                } else { System.out.println("    Error! Please choose from the available options."); }
            }
        }
        else if (yearLevel.equals("3rd Year 1st Semester")) {
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 301");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "IT 311: Systems Administration and Maintenance");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "GEd 107: Ethics");
            EnrollmentSystem.printBoxLine("   Tuesday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "IT 314: Web Systems and Technologies");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "IT 312: System Integration and Architecture");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "IT 313: System Analysis and Design");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "NTT 401: Computer Networking 3 (Network Track)");
            EnrollmentSystem.printBoxLine("   Friday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "NTT 402: Internet of Things (IoT) (Network Track)");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 302");
            EnrollmentSystem.printBoxLine("   Monday (OLC):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "NTT 401: Computer Networking 3 (Network Track)");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "GEd 107: Ethics");
            EnrollmentSystem.printBoxLine("   Tuesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "IT 313: System Analysis and Design");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "IT 314: Web Systems and Technologies");
            EnrollmentSystem.printBoxLine("   Wednesday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "NTT 402: Internet of Things (IoT) (Network Track)");
            EnrollmentSystem.printBoxLine("   Thursday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "IT 311: Systems Administration and Maintenance");
            EnrollmentSystem.printBoxLine("   Friday (F2F):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "IT 312: System Integration and Architecture");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 303");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "IT 312: System Integration and Architecture");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "IT 314: Web Systems and Technologies");
            EnrollmentSystem.printBoxLine("   Tuesday (F2F):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "IT 311: Systems Administration and Maintenance");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "GEd 107: Ethics");
            EnrollmentSystem.printBoxLine("   Wednesday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "NTT 402: Internet of Things (IoT) (Network Track)");
            EnrollmentSystem.printBoxLine("   Thursday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "IT 313: System Analysis and Design");
            EnrollmentSystem.printBoxLine("   Friday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "NTT 401: Computer Networking 3 (Network Track)");

            System.out.println(EnrollmentSystem.borderLine);
            while (chosenBlock.isEmpty()) {
                System.out.print("\n  Enter your chosen block number (301, 302, or 303): ");
                String input = scanner.nextLine();
                if (input.equals("301") || input.equals("302") || input.equals("303")) {
                    chosenBlock = input;
                } else { System.out.println("    Error! Please choose from the available options."); }
            }
        }
        else if (yearLevel.equals("4th Year 1st Semester")) {
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 401");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "IT 411: Capstone Project 2");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "CS 423: Social Issues and Professional Practice");
            EnrollmentSystem.printBoxLine("   Tuesday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "ENGG 405: Technopreneurship");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "IT 412: Platform Technologies");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "IT 413: Advanced Information Assurance and Security");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "IT 414: System Quality Assurance");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "NTT 405: Cybersecurity (Network Track)");
            EnrollmentSystem.printBoxLine("   Friday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "(Capstone Consultation)");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 402");
            EnrollmentSystem.printBoxLine("   Monday (OLC):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "IT 413: Advanced Information Assurance and Security");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "CS 423: Social Issues and Professional Practice");
            EnrollmentSystem.printBoxLine("   Tuesday (F2F):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "IT 411: Capstone Project 2");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "IT 414: System Quality Assurance");
            EnrollmentSystem.printBoxLine("   Wednesday (OLC):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "ENGG 405: Technopreneurship");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "IT 412: Platform Technologies");
            EnrollmentSystem.printBoxLine("   Thursday (F2F):");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "NTT 405: Cybersecurity (Network Track)");
            EnrollmentSystem.printBoxLine("   Friday (F2F):");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "(Capstone Consultation)");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 403");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "IT 414: System Quality Assurance");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "NTT 405: Cybersecurity (Network Track)");
            EnrollmentSystem.printBoxLine("   Tuesday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "IT 412: Platform Technologies");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "IT 411: Capstone Project 2");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "IT 413: Advanced Information Assurance and Security");
            EnrollmentSystem.printBoxLine("   Thursday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "CS 423: Social Issues and Professional Practice");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "ENGG 405: Technopreneurship");
            EnrollmentSystem.printBoxLine("   Friday (OLC):");
            EnrollmentSystem.printBoxLine("     (Capstone Consultation)");
            
            System.out.println(EnrollmentSystem.borderLine);
            while (chosenBlock.isEmpty()) {
                System.out.print("\n  Enter your chosen block number (401, 402, or 403): ");
                String input = scanner.nextLine();
                if (input.equals("401") || input.equals("402") || input.equals("403")) {
                    chosenBlock = input;
                } else { System.out.println("    Error! Please choose from the available options."); }
            }
        }
        
        return "Blk. " + chosenBlock;
    }
}

class bscsStudent extends Student {

    public bscsStudent(String name, int age, String address, String enrollmentPeriod, String yearLevel) {
        super(name, age, address, enrollmentPeriod, "BSCS", yearLevel);
    }

    @Override
    public void displayCourses() {
        System.out.println("\n" + EnrollmentSystem.borderLine );
        EnrollmentSystem.printBoxLine(" Courses in the program of " + program + " for " + yearLevel+ ":");
        EnrollmentSystem.printBoxLine("");
        
        if (yearLevel.equals("1st Year 1st Semester")) {
            EnrollmentSystem.printBoxLine(" - IT 111: Introduction to Computing");
            EnrollmentSystem.printBoxLine(" - CS 111: Computer Programming");
            EnrollmentSystem.printBoxLine(" - Fili 101: Kontekstwalisadong Komunikasyon sa Filipino");
            EnrollmentSystem.printBoxLine(" - GEd 101: Understanding the Self");
            EnrollmentSystem.printBoxLine(" - GEd 102: Mathematics in the Modern World");
            EnrollmentSystem.printBoxLine(" - Math 111: Linear Algebra");
            EnrollmentSystem.printBoxLine(" - PE 101: Physical Fitness, Gymnastics and Aerobics");
            EnrollmentSystem.printBoxLine(" - NSTP 111: National Service Training Program 1");
        } else if (yearLevel.equals("2nd Year 1st Semester")) {
            EnrollmentSystem.printBoxLine(" - CS 211: Object-Oriented Programming");
            EnrollmentSystem.printBoxLine(" - CS 212: Computer Organization w/ Assembly Language");
            EnrollmentSystem.printBoxLine(" - IT 211: Database Management Systems");
            EnrollmentSystem.printBoxLine(" - IT 212: Computer Networking 1");
            EnrollmentSystem.printBoxLine(" - Phy 101: Calculus-Based Physics");
            EnrollmentSystem.printBoxLine(" - PE 103: Individual and Dual Sports");
        } else if (yearLevel.equals("3rd Year 1st Semester")) {
            EnrollmentSystem.printBoxLine(" - CS 311: Design and Analysis of Algorithms");
            EnrollmentSystem.printBoxLine(" - CS 312: Automata Theory and Formal Languages");
            EnrollmentSystem.printBoxLine(" - CS 313: Programming Languages");
            EnrollmentSystem.printBoxLine(" - CS 314: Web Systems and Technologies");
            EnrollmentSystem.printBoxLine(" - Math 404: Numerical Methods");
            EnrollmentSystem.printBoxLine(" - Math 405: Data Analysis");
        } else { 
            EnrollmentSystem.printBoxLine(" - CS 411: CS Thesis 1");
            EnrollmentSystem.printBoxLine(" - CS 412: Software Engineering");
            EnrollmentSystem.printBoxLine(" - CS 413: Advanced Software Engineering");
            EnrollmentSystem.printBoxLine(" - CS 414: Artificial Intelligence");
            EnrollmentSystem.printBoxLine(" - CS 415: Principles of Operating Systems");
            EnrollmentSystem.printBoxLine(" - CS Professional Elective 2");
        }
        System.out.println(EnrollmentSystem.borderLine );
    }

    @Override
    public String chooseBlock(Scanner scanner) {
        System.out.println("\n" + EnrollmentSystem.borderLine );
        EnrollmentSystem.printCenteredLine("Indicate your chosen BLOCK!");
        EnrollmentSystem.printCenteredLine("Here are the available blocks:");
        System.out.println(EnrollmentSystem.borderLine );

        String chosenBlock = "";
        
        if (yearLevel.equals("1st Year 1st Semester")) {
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 101");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     7:00 am - 10:00 am", "CS 111: Computer Programming (Lab)");
            EnrollmentSystem.printBoxLine("     11:00 am - 12:00 pm", "GEd 101: Understanding the Self");
            EnrollmentSystem.printBoxLine("   Tuesday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "Math 111: Linear Algebra");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "IT 111: Introduction to Computing");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "GEd 102: Mathematics in the Modern World");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "Fili 101: Kontekstwalisadong Komunikasyon sa Filipino");
            EnrollmentSystem.printBoxLine("   Friday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 10:00 am", "PE 101: Physical Fitness, Gymnastics and Aerobics");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "NSTP 111: National Service Training Program 1");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 102");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "Math 111: Linear Algebra");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "IT 111: Introduction to Computing");
            EnrollmentSystem.printBoxLine("   Tuesday (F2F):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "CS 111: Computer Programming (Lab)");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "GEd 101: Understanding the Self");
            EnrollmentSystem.printBoxLine("   Wednesday (OLC):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "GEd 102: Mathematics in the Modern World");
            EnrollmentSystem.printBoxLine("   Thursday (F2F):");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "Fili 101: Kontekstwalisadong Komunikasyon sa Filipino");
            EnrollmentSystem.printBoxLine("     2:00 pm - 4:00 pm", "PE 101: Physical Fitness, Gymnastics and Aerobics");
            EnrollmentSystem.printBoxLine("   Friday (OLC):");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "NSTP 111: National Service Training Program 1");

            System.out.println(EnrollmentSystem.borderLine );
            while (chosenBlock.isEmpty()) {
                System.out.print("\n  Enter your chosen block number (101 or 102): ");
                String input = scanner.nextLine();
                if (input.equals("101") || input.equals("102")) {
                    chosenBlock = input;
                } else { System.out.println("    Error! Please choose from the available options."); }
            }
        }
        else if (yearLevel.equals("2nd Year 1st Semester")) {
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 201");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 211: Object-Oriented Programming");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "IT 211: Database Management Systems");
            EnrollmentSystem.printBoxLine("   Tuesday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "Phy 101: Calculus-Based Physics");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 212: Computer Organization w/ Assembly");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "IT 212: Computer Networking 1");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 12:00 pm", "PE 103: Individual and Dual Sports");
            
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 202");
            EnrollmentSystem.printBoxLine("   Monday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "Phy 101: Calculus-Based Physics");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "IT 212: Computer Networking 1");
            EnrollmentSystem.printBoxLine("   Tuesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 211: Object-Oriented Programming");
            EnrollmentSystem.printBoxLine("     1:00 pm - 3:00 pm", "PE 103: Individual and Dual Sports");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 212: Computer Organization w/ Assembly");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 12:00 pm", "IT 211: Database Management Systems");

            System.out.println(EnrollmentSystem.borderLine);
            while (chosenBlock.isEmpty()) {
                System.out.print("\n  Enter your chosen block number (201 or 202): ");
                String input = scanner.nextLine();
                if (input.equals("201") || input.equals("202")) {
                    chosenBlock = input;
                } else { System.out.println("    Error! Please choose from the available options."); }
            }
        }
        else if (yearLevel.equals("3rd Year 1st Semester")) {
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 301");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 311: Design and Analysis of Algorithms");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "CS 312: Automata Theory and Formal Languages");
            EnrollmentSystem.printBoxLine("   Tuesday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "CS 313: Programming Languages");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "Math 404: Numerical Methods");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 314: Web Systems and Technologies");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "Math 405: Data Analysis");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 302");
            EnrollmentSystem.printBoxLine("   Monday (OLC):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 311: Design and Analysis of Algorithms");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "Math 405: Data Analysis");
            EnrollmentSystem.printBoxLine("   Tuesday (F2F):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "CS 312: Automata Theory and Formal Languages");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 313: Programming Languages");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "CS 314: Web Systems and Technologies");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "Math 404: Numerical Methods");

            System.out.println(EnrollmentSystem.borderLine );
            while (chosenBlock.isEmpty()) {
                System.out.print("\n  Enter your chosen block number (301 or 302): ");
                String input = scanner.nextLine();
                if (input.equals("301") || input.equals("302")) {
                    chosenBlock = input;
                } else { System.out.println("    Error! Please choose from the available options."); }
            }
        }
        else if (yearLevel.equals("4th Year 1st Semester")) {
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 401");
            EnrollmentSystem.printBoxLine("   Monday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 411: CS Thesis 1");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "CS 412: Software Engineering");
            EnrollmentSystem.printBoxLine("   Tuesday (OLC):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "CS 413: Advanced Software Engineering");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "CS 414: Artificial Intelligence");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 415: Principles of Operating Systems");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "CS Professional Elective 2");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 402");
            EnrollmentSystem.printBoxLine("   Monday (OLC):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 411: CS Thesis 1");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "CS 415: Principles of Operating Systems");
            EnrollmentSystem.printBoxLine("   Tuesday (F2F):");
            EnrollmentSystem.printBoxLine("     9:00 am - 12:00 pm", "CS 412: Software Engineering");
            EnrollmentSystem.printBoxLine("   Wednesday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "CS 413: Advanced Software Engineering");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "CS 414: Artificial Intelligence");
            EnrollmentSystem.printBoxLine("   Thursday (OLC):");
            EnrollmentSystem.printBoxLine("     10:00 am - 1:00 pm", "CS Professional Elective 2");

            System.out.println(EnrollmentSystem.borderLine );
            while (chosenBlock.isEmpty()) {
                System.out.print("\n  Enter your chosen block number (401 or 402): ");
                String input = scanner.nextLine();
                if (input.equals("401") || input.equals("402")) {
                    chosenBlock = input;
                } else { System.out.println("    Error! Please choose from the available options."); }
            }
        }
        
        return "Blk. " + chosenBlock;
    }
}

class mscsStudent extends Student {

    public mscsStudent(String name, int age, String address, String enrollmentPeriod, String yearLevel) {
        super(name, age, address, enrollmentPeriod, "MSCS", yearLevel);
    }

    @Override
    public void displayCourses() {
        System.out.println("\n" + EnrollmentSystem.borderLine);
        EnrollmentSystem.printBoxLine(" Courses in the program of " + program + " for " + yearLevel + ":");
        EnrollmentSystem.printBoxLine("");
        
        if (yearLevel.equals("1st Year 1st Semester")) {
            EnrollmentSystem.printBoxLine(" - MSCS111: Advanced Data Structures and Algorithms");
            EnrollmentSystem.printBoxLine(" - MSCS112: Advanced Computer Organization and Operating Systems");
            EnrollmentSystem.printBoxLine(" - MSCS113: Theory of Programming Languages");
        } else if (yearLevel.equals("2nd Year 1st Semester")) {
            EnrollmentSystem.printBoxLine(" - MSCS215: Advanced Data Security");
            EnrollmentSystem.printBoxLine(" - MSCS216: Machine Learning");
            EnrollmentSystem.printBoxLine(" - MSCS311: Thesis 1");
        } else {
            EnrollmentSystem.printBoxLine(" No courses available for this year level in the Graduate School.");
            EnrollmentSystem.printBoxLine(" Please consult your program adviser.");
        }
        System.out.println(EnrollmentSystem.borderLine);
    }

    @Override
    public String chooseBlock(Scanner scanner) {
        if (!yearLevel.equals("1st Year 1st Semester") && !yearLevel.equals("2nd Year 1st Semester")) {
            return "N/A";
        }

        System.out.println("\n" + EnrollmentSystem.borderLine);
        EnrollmentSystem.printCenteredLine("Indicate your chosen BLOCK!");
        EnrollmentSystem.printCenteredLine("Block Available (Graduate School)");
        System.out.println(EnrollmentSystem.borderLine);

        String chosenBlock = "";
        
        if (yearLevel.equals("1st Year 1st Semester")) {
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 501");
            EnrollmentSystem.printBoxLine("   Saturday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "MSCS111: Adv. Data Structures & Algo");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "MSCS112: Adv. Computer Org & OS");
            EnrollmentSystem.printBoxLine("   Sunday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "MSCS113: Theory of Prog. Languages");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 502");
            EnrollmentSystem.printBoxLine("   Saturday (F2F):");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "MSCS111: Adv. Data Structures & Algo");
            EnrollmentSystem.printBoxLine("     4:00 pm - 7:00 pm", "MSCS112: Adv. Computer Org & OS");
            EnrollmentSystem.printBoxLine("   Sunday (F2F):");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "MSCS113: Theory of Prog. Languages");
        } else if (yearLevel.equals("2nd Year 1st Semester")) {
            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 501");
            EnrollmentSystem.printBoxLine("   Saturday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "MSCS215: Advanced Data Security");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "MSCS216: Machine Learning");
            EnrollmentSystem.printBoxLine("   Sunday (F2F):");
            EnrollmentSystem.printBoxLine("     8:00 am - 11:00 am", "MSCS311: Thesis 1");

            EnrollmentSystem.printBoxLine("");
            EnrollmentSystem.printBoxLine(" Blk. 502");
            EnrollmentSystem.printBoxLine("   Saturday (F2F):");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "MSCS215: Advanced Data Security");
            EnrollmentSystem.printBoxLine("     4:00 pm - 7:00 pm", "MSCS216: Machine Learning");
            EnrollmentSystem.printBoxLine("   Sunday (F2F):");
            EnrollmentSystem.printBoxLine("     1:00 pm - 4:00 pm", "MSCS311: Thesis 1");
        }

        System.out.println(EnrollmentSystem.borderLine);
        while (chosenBlock.isEmpty()) {
            System.out.print("\n  Enter your chosen block number (501 or 502): ");
            String input = scanner.nextLine();
            if (input.equals("501") || input.equals("502")) {
                chosenBlock = input;
            } else { System.out.println("    Error! Please choose from the available options."); }
        }
        return "Blk. " + chosenBlock;
    }
}
