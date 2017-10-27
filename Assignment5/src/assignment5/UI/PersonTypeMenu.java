/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.UI;

import assignment5.BLL.GradeInfo;
import assignment5.BLL.Test;
import assignment5.BLL.Student;
import assignment5.BLL.Person;
import assignment5.BLL.Teacher;
import assignment5.BLL.SimplePerson;
import java.util.Scanner;

/**
 *
 * @author sebok
 */
public class PersonTypeMenu extends Menu
{
    Test t;
    
    public PersonTypeMenu(String header, String[] menuItems, Test t)
    {
        super(header, menuItems);
        this.t = t;
    }

    @Override
    protected void doAction(int option)
    {
       
        switch (option)
        {
            case 1:
                t.addPerson(createPerson());
                break;
            case 2:
                t.addPerson(createTeacher());
                break;
            case 3: 
                t.addPerson(createStudent());
                break;
        }
    }

    private Person createPerson()
    {
        String name;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter name: ");
        name = scanner.nextLine();
        
        Person simple = new SimplePerson(t.getNextID(), name);
        return simple;
    }   

    private Person createTeacher()
    {
        String name;
        String main;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter name: ");
        name = scanner.nextLine();
        
        System.out.println("Enter main: ");
        main = scanner.nextLine();
        
        Person teacher = new Teacher(t.getNextID(), name, main);
        
        return teacher;
    }

    private Person createStudent()
    {
        String name;
        String subject;
        String gradeStrings;
        int[] grades;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter name: ");
        name = scanner.nextLine();
        
        System.out.println("Enter subject: ");
        subject = scanner.nextLine();
        
        Student student = new Student(t.getNextID(), name, subject);
        
        System.out.println("Enter grades for this subject (separated with a space)");
        gradeStrings = scanner.nextLine();
        grades = parseGrades(gradeStrings);
        
        for (int grade : grades)
        {
            GradeInfo gi = new GradeInfo(subject, grade);
            student.addGrade(gi);
        }
        
        return student;
    }
    
    private int[] parseGrades(String gradeStrings)
    {
        String[] gradesArray = gradeStrings.split("\\s");
        int[] grades = new int[gradesArray.length];
        
        for (int i = 0; i < grades.length; i++)
        {
            grades[i] = Integer.parseInt(gradesArray[i]);
        }
        
        return grades;
    }
}