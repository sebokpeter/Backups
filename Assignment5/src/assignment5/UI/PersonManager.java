/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.UI;

import assignment5.BLL.Student;
import assignment5.BLL.Person;
import assignment5.BLL.Teacher;
import assignment5.BLL.SimplePerson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebok
 */
public class PersonManager
{
    private List<Person> persons;

    public PersonManager()
    {
        persons = new ArrayList();
    }
    
    public void addPerson(Person p)
    {
        //If the list already contains a person with this name, do not add that person to the list
        for (Person person : persons)
        {
            if (person.getName().equals(p.getName()))
            {
                return;
            }
        }
        persons.add(p);
    }
    
    public void removePerson(String name)
    {
        for (Person person : persons)
        {
            if(person.getName().equals(name))
            {
                persons.remove(person);
                return;
            }
        }
    }
    
    public Person getPerson(String name)
    {
        for (Person person : persons)
        {
            if(person.getName().equals(name))
            {
                return person;
            }
        }
        
        return null;
    }
    
    public List<Person> getAllPersons()
    {
        return persons;
    }
    
     public List<Person> getSimplePersons()
    {
        List<Person> simple = new ArrayList();
        for (Person person : persons)
        {
            if(SimplePerson.class.isInstance(person))
            {
                simple.add(person);
            }
        }
        
        return simple;
    }
    
    
    public List<Person> getTeachers()
    {
        List<Person> teachers = new ArrayList();
        for (Person person : persons)
        {
            if(Teacher.class.isInstance(person))
            {
                teachers.add(person);
            }
        }
        
        return teachers;
    }
    
    public List<Person> getStudents()
    {
        List<Person> students = new ArrayList();
        for (Person person : persons)
        {
            if(Student.class.isInstance(person))
            {
                students.add(person);
            }
        }
        
        return students;
    }    
    
    public int getNextID()
    {
        return persons.size()+1;
    }
    
}



