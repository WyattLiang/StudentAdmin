package com.hcl.StudentAdmin;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Set<Student> treeset 
		= new TreeSet<>((Student a,Student b) -> a.getAge() - b.getAge());
	
    public static void main( String[] args )
    {
    	
    	while(true) {
    		printUI();
            handleCommand(new Scanner(System.in));
           
    	}
        
        
        
    }
    
    public static void printUI() {
    	System.out.println("\n\tWelcome to Student Administration Center.");
    	System.out.println("\t1.Add new student");
    	System.out.println("\t2.Update student information");
    	System.out.println("\t3.Delete student from database");
    	System.out.println("\t4.Print all students");
    	System.out.println("\t5.Exit");
    	System.out.print("\tPlease enter your command: ");
    }
    
     static void handleCommand(Scanner sc) {
    		
    	try {
    		int command = sc.nextInt();
    		switch(command) {
        	
        	case 1:
        		addStudent(sc);
        		break;
        		
        	case 2:
        		update(sc);
        		break;
        		
        	case 3:
        		delete(sc);
        		break;
        		
        	case 4:
        		printAllStudents();
        		break;
        	
        	case 5:
        		System.out.println("\nGood bye.");
        		System.exit(0);
        		
        	default:
        		System.out.println("Invalid command.");
        		break;
        	}
    		
    	}
    	catch(InputMismatchException e) {
   
    		System.out.println("Wrong input type, please try again.");
    	}
    
    	
    }
    
    private static void addStudent(Scanner sc) {
    	System.out.println("Enter student name: ");
    	String name = sc.next();
    	System.out.println("Enter age: ");
    	int age = sc.nextInt();
    	int id = treeset.size() + 1;
    	Student st = new Student(id, name, age);
    	treeset.add(st);
    	System.out.println("Student added successfully!");
    	System.out.println(name + "'s student id is: "+id);
    }
    
    private static void update(Scanner sc) {
    	System.out.println("\nEnter student id: ");
    	int id = sc.nextInt();
    	boolean found = false;
    	for(Student s: treeset) {
    		if(s.getRollno() == id) {
    			found = true;
    			System.out.println("Found student!");
    			System.out.println("Input the name you want to change: ");
    			s.setName(sc.next());
    			System.out.println("Input his age: ");
    			s.setAge(sc.nextInt());
    			System.out.println("Update completed!");
    			break;
    		}
    	}
    	if(!found) System.out.println("Student not found.");
 
    }
    
    private static boolean delete(Scanner sc) {
    	System.out.println("\nEnter student id: ");
    	int id = sc.nextInt();
    	for(Student s: treeset) {
    		if(s.getRollno() == id) {
    			treeset.remove(s);
    			System.out.println("This student has been removed from the database");
    			return true;
    		}
    	}
    	System.out.println("Student not found.");
    	return false;
    }
    
    private static void printAllStudents() {
    	for(Student s: treeset) {
    		System.out.println(s.toString());
    	}
    }
    
    
    
    
}

class Student {
	private int rollno;
	private String name;
	private int age;

	public Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String toString() {
		return "Student name: "+ name + ", age: "+age+", id: "+rollno;
	} 

}