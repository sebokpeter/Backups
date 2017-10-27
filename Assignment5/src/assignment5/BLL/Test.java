/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.BLL;

import assignment5.UI.PersonManager;

/**
 *
 * @author sebok
 */
public class Test
{
    private PersonManager pm;

    public Test()
    {
        this.pm = new PersonManager();
        addPersons();
    }

    private void addPersons()
    {
        String persons[] = new String[] {"Hans Nielsen", "Niels Hansen", "Ib Boesen"};
        
        Teacher t1 = new Teacher(4, "Bent H. Pedersen");
        t1.addSubject("Programming");
        
        Student s1 = new Student(5, "Bo Ibsen ", "CS");
        s1.addGrade(new GradeInfo("CS", 10));
        s1.addGrade(new GradeInfo("CS", 6));
        
        for (int i = 0; i < persons.length; i++)
        {
            pm.addPerson(new SimplePerson(i, persons[i]));
        }
        
        pm.addPerson(t1);
        pm.addPerson(s1);
    }
    
    public void addPerson(Person p)
    {
        pm.addPerson(p);
    }
    
    public void displayAllPersons()
    {
        displayPersons();
        displayStudents();
        displayTeachers();
    }
    
    public void displayPersons()
    {
        System.out.println("ID\tName\t\tE-mail");
        for (Person p : pm.getSimplePersons())
        {
            System.out.println(p.toString());
        }
        System.out.println();
        
    }
    
    public void displayTeachers()
    {
        System.out.println("ID\tName\t\t\tE-mail\t\tInitials\tMain");
        for (Person p : pm.getTeachers())
        {
            System.out.println(p.toString());
        }
        System.out.println();
    }
    
    public void displayStudents()
    {
        System.out.println("ID\tName\t\tE-mail\t\tEducation\tAVG.GRADE");
        for (Person p : pm.getStudents())
        {
            System.out.println(p.toString());
        }
        System.out.println();
    }
    
    public int getNextID()
    {
        return pm.getNextID();
    }
    
}
